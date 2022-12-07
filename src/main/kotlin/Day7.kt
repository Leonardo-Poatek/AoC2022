import Day7.FSItem.File
import Day7.FSItem.Folder
import java.util.Stack

class Day7 {

    sealed class FSItem(val name: String) {

        abstract val size: Long

        abstract fun toTree(level: Int): String

        class File(name: String, override val size: Long) : FSItem(name) {
            override fun toString(): String {
                return "File $name ($size)"
            }

            override fun toTree(level: Int): String = "|  ".repeat(level) + "$name"
        }

        class Folder(name: String, val contents: HashMap<String, FSItem> = HashMap()) : FSItem(name) {

            private var _size: Long? = null
            override val size: Long
                get() = _size ?: calculateSize()

            private fun calculateSize(): Long {
                return contents.values.sumOf { it.size }.apply { _size = this }
            }

            fun addItem(item: FSItem) {
                _size = null
                contents[item.name] = item
            }

            fun getOrCreateFolder(name: String): Folder = contents.getOrPut(name) { Folder(name) } as Folder

            override fun toString(): String {
                return "Folder $name ($size)"
            }

            override fun toTree(level: Int): String {
                return buildString {
                    appendLine("|  ".repeat(level) + "$name ($size)")
                    contents.forEach {
                        appendLine(it.value.toTree(level + 1))
                    }
                }
            }
        }
    }

    private fun handleItemInstruction(pointer: Folder, instruction: String) {
        instruction.split(" ").let {
            if (it.first() == "dir") {
                pointer.addItem(Folder(it.last()))
            } else {
                pointer.addItem(File(it.last(), it.first().toLong()))
            }
        }
    }

    private fun handleCmdInstruction(stack: Stack<Folder>, instruction: String) {
        val split = instruction.split(" ")

        //We don't do anything on ls
        if (split[1] != "cd") return

        when (split[2]) {
            "/" -> {
                val root = stack[0]
                stack.clear()
                stack.push(root)
            }

            ".." -> {
                stack.pop()
            }

            else -> {
                //Get or add folder
                stack.push(stack.peek().getOrCreateFolder(split[2]))
            }
        }
    }

    companion object {
        const val totalSize = 70_000_000L
        const val targetFreeSpace = 30_000_000L
    }

    private fun parseFileSystem(instructions: List<String>): Folder {
        val root = Folder("/")
        val pointer = Stack<Folder>()
        pointer.push(root)

        instructions.forEach { instruction ->
            if (instruction.first() == '$') {
                handleCmdInstruction(pointer, instruction)
            } else {
                handleItemInstruction(pointer.peek(), instruction)
            }
        }
        return root
    }

    private fun findSmallDirs(dir: Folder, maxSize: Long): List<Folder> {
        val folders = dir.contents.values.filterIsInstance<Folder>()
        val foundDirs = folders.filter { it.size <= maxSize }
        val next = folders.flatMap { findSmallDirs(it, maxSize) }
        return foundDirs + next
    }

    private fun findBigDirs(dir: Folder, minSize: Long): List<Folder> {
        val folders = dir.contents.values.filterIsInstance<Folder>()
        val foundDirs = folders.filter { it.size >= minSize }
        val next = folders.flatMap { findBigDirs(it, minSize) }
        return foundDirs + next
    }

    fun solve(instructions: List<String>): Long {
        val root = parseFileSystem(instructions)
        val smallFolders = findSmallDirs(root, 100_000)
        return smallFolders.sumOf { it.size }
    }

    fun solve2(instructions: List<String>): Long {
        val root = parseFileSystem(instructions)
        val minDeleteSize = targetFreeSpace - (totalSize - root.size)
        val bigFolders = findBigDirs(root, minDeleteSize).sortedBy { it.size }
        return bigFolders.first().size
    }

}