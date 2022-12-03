import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {

    val solution = Day3()

    val sampleInput = """
    vJrwpWtwJgWrhcsFMMfFFhFp
    jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
    PmmdzqPrVvPwwTWBwg
    wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
    ttgJtRGJQctTZtZT
    CrZsJsPPZsGzwwsLwLmpwMDw
""".trimIndent()

    @Test
    fun solve1() {
        val sum = solution.solve(sampleInput.lines())
        assertEquals(157, sum)
        println(solution.solve(realInput.lines()))
    }

    @Test
    fun solve2() {
        val sum = solution.solve2(sampleInput.lines())
        assertEquals(70, sum)
        println(solution.solve2(realInput.lines()))
    }

    val realInput = """
        PcPlnShmrLmBnmcwBhrmcmbHNGFGpwdFFwGNjNbGqNHH
        tzQfRJfWZZztWzVtCTfRzFZjpFjNZjGLHbdHLDdjpb
        CCQTzRLzvQVVfRzJfMPsnBlglgPmBgPmvSrl
        RMfvbbszHTsssFPzDQPggpQJPQ
        NSNcqVtLVGgDlpQBClVB
        hmStGNNLhjNrpWLGSjWrZssbZTMMvTfMnThbRRTs
        fTrTPGTbfftWBBmLjrJL
        DqHwVMqVplDslmlZmpHVwNnShWZFdBBdjWBtWtdtWJSSLS
        MNslpDvVHlwsmpQRgQgCfTTcvcRQ
        pBBhRgDsMsswprBhvgRglZtFGFFRqZtZmRtNqtZPPN
        TdmmzzmdZdqdGFtF
        nmSccCVmSCpDCswMwl
        NptqDsQtDTQzCvlzCpRlRp
        jmZcndmjbZcjrmDvFMFFlwCvzFnF
        jjgLVLrGcdDBNhWQTgHg
        mLVhhfSMSTmMwClHGdpjDHjGdV
        zPrZgJCgbsnrPtZzsCsbpRDjBRHnjGDRldRHppcG
        JJrbsFrZqrgWbbqbrgWzJPNTwhTNCmmvfWCShhhmwwfm
        ftgfljvgfgBTNvtggFDDGLGRDnMDzcQzncGt
        VdbpbVdZwdwrsVVLRrMrDLDBGnBGcM
        wmpWwWsHWBCCCPPvjvmSqlfTTmSNgN
        jSqmzmmSSDRjLMLDwqjNcMMLTTflffWCCsRsTHnHVrfHWTsr
        tdbgZpgBPdgGZGGFTHVpCsCVfVsJpnWl
        FnPQFvbvhFFFbvBwScjhzcqSLLSzSN
        bWdgrWwwFWbgzFWzrmNbdPqttChMSRnmqSPSnqtMRM
        lcPJLDDPPfpMBCRJBtQtMh
        lGDGjTGLLDHPPGjlPTsswsbHNFsNrFNFsrzr
        VmtHfVhBLHVtlhphjZMdnQQZZqZmQDdzQQ
        CPFwPWrvWgrfNgFPCMqZzMDDbznFTqqzDQ
        NNPsfffPCsBLjpVltV
        ssdBBJqJhlTJLsjTJqFFmnmmnnrcmpprmmmPcRlf
        gqtqzSgWQWqmnRPPcNmmQM
        GqbSVtGzvgvgWbZjjBhTdhBsTZBJBZ
        jhNBsPDzLjsVhLSNzgvcvbcwbBWFcgtWCc
        ZQQTTHHnGpMtnpdHpQJfMgrvWWFqbcWWGgrgwCCwwF
        nHpmMnQQMmHpRnHRmMJnnTShPzljzjSNmSDhLsNSPtSh
        GdqnBGFdlqzFnwdSCQZjZLLDZjZRvZLDVvgQ
        PsptsTcftMfcTfhTghVDvvjnRNjVZnvV
        WtPfJTfftJcMTrMnpccFwlCSCGFGCbCwJSbqBl
        GjFLGhjRwFjNSjSdJCBBdQJddbBc
        MVvMMHRzVtHlvlcQBQJHqdpQqCBC
        vDgVztvvmrgrVRrMmsrsmZzZnWhGnNhGWTLfnLwTLhLTjngL
        VljjQJSsrjjrCglsCjsgjVVfDLdZGMdvvGdQMzmvzcDQMc
        HqPBtcpRWwtHbbFwBHZfmfpDfvffDfMfmGvM
        PwHNbcwtqFqnwtNNqPNPPWBTThjhhVTCSJTThssVnSlJJV
        GCccNCrrnCrpnzrnCDPcDDrvHHTBqTPhswqhPTBTTwBhTj
        VfNmRtZgWWHdBdswdjZv
        SmtQfgNmVFgVLVLVmrnMpcDLGCGLGDMpCp
        CrdZdZmPPjrQdRPRDqDLBqBLBSWgWgLDzF
        sQhTNphsVbhhhMJfhNVGqltVSzSllBzStlzFFFWB
        hsMpwQhNMZmPmrwHRj
        cNVpSVRpLHRLsVWWfnfsCshW
        jvqjTgqZPlJZmbPPfbpswsPb
        vlqdTZdtJvqdZjgqZrtRpQFtLFRQczHGzt
        JJQndVQnQgTfNvGf
        ljpbWbmNbDlGTvggGvZf
        mpmRbMmmNDFDmScpzCsdzrnJrsCzrrnM
        tNFtNFFzzjjzjBtVNZVbjZGlpSvTllpWwvnBlWGGBGCC
        fPdcrrgPHrHMMMWlppGJSPwGSnGv
        fmrqrhhfhdRddHrhQqQrfnLZjLtNttZjjRtzjFtRNj
        sphRcpQRhfmnmfpptg
        WVPlGLlSjCjSlGSHJJWZdmbmfvPmmnftbbgDdt
        LJjjqVNjlnCTRcRhhsNcFF
        vwwqttFjwgClRNCCvGNmZZMmJsPJjJpTdMpsZd
        fBLVHHHrFnhHhnrVSTmfdPdPccTTPsMfsJ
        QzVWzznzFbWNGNlt
        vjMddVVmnWpdMndjvhhWfNLpfBsfLLZLBBSqqTZq
        RFlrzQJPSRGzzzzgBZNsgBZTBflfgf
        cQFDRHFDDGCJShCnvwVnnhCn
        hgjlpRRLlPJJhTLJMDnwBndSPBNvMqnN
        FGWVfZsmCbmVzrvtwCSMtMdnDMCw
        VsVmVZfVQDmVFrrmzmGrHHTJgJjhHJcllglLQJRL
        rrTVcTBgsjTffmfWHZTv
        JLdnDlpGlGSLlpwJpHZfFvRZnWzWrHWqFH
        wQDpDrdSlSCblCdwdSLlwQGBthPMsghNsVNVtCNNhNPjhs
        CtCMvNhDMHfDDdffqtDtCflpJlBpvmWWJWwlpwFFvjwB
        rGSbVGZrSsFJjlmBFZWp
        rbbQgzVGrFVSPPGqfhftfqztNtqHtt
        lMGZCGphllZDNshNNmHHND
        PLwjVwJVsHmRrZZw
        ffSdzjfZSjtjSjLtLLFFFGqFzznCpCnCBblQ
        CqRnlzHCRWTlHPTZVQrcQtFsQFTcrQ
        DfJcdBDBcftQjsrsBtjZ
        JDfdGhSvNGhNfffGSfRznPvcRWcqCqmlvlcn
        JPhBBBQCnCJCMhnhMZRrRZgbDgrWrNbglDgR
        jLtSTwtsShwRNpRWrh
        FLLSHsjGLGczvfPfJdfhddnHPC
        BjHBNrWmTjFgJngbJhWd
        vsGttMDtwCMQCJnqqqFJsggqdg
        GFtDSwwMpTrzSSfcfm
        rnWDQvpwWpDDcPjFPPHZjVDZ
        CTJCRmCJcZZZHCCQ
        LdlmdQJNpnLWbrfL
        VdTdcVTZwCRGVGGMVmttlF
        gnrsbngfgQSpBfpMBBBpSgMNNJbmGmlqGDqDNlFFJlGNFz
        gprgQhgpMMMPsrRTCdPZwCwZZCRH
        cHlCVGbbWHWqRNThhcNcmh
        MwQDzpwdJwpBpPDQvrhShfLTTRLfLdjfNRqS
        JwMBBrPsPDwQMDPPBPQJwMrvWHFbHHlgbsGnnWHnFnRGlblF
        PQPjPDjRRQSFLSlgSmLlfh
        zpLdBddbNCdqGbWJGWpJWWlsFsmmFpwfflFgfHwFhgmh
        nJLdLVnzqqbjRctcPDQVTP
        JdztScztPdSWLJLtgMbCjhvlbPRbjbMvCh
        VZrqfQcFQwGVVFqfrTFTNqhljRHDMvMMGhRDRRHGbDhG
        NZQNVQQpQmrZFQQFwQQVVZgBszJJgznstnmtcztdBSgs
        nFHLNJzFbLJGGLMlTTRZbZRhWRTr
        wVmgBBmtmwlqlWTwTM
        sdvmgcPsCPPQQSMz
        SccCqmQmgBmppLQmpSMjjlJzzsNPMDRbPNPlJM
        VHZvwtZwhZHtdTwrVbNsljlRDlJPDhzsbN
        dZwftVRftmcgpBCmBf
        NTTlVlgNSflqbphFFhNbFp
        wmmLmjwzwbWGLjRmtZZdhZLFtQQLQBFh
        RvjbMjjvMzMWbDWwvzPjvmWSfVfsTlVVPVgTgPfVsnnnsJ
        BsBsZHZNdWwsNdrzgCrMMqsjzzMC
        flfhVWFmLrhQzCCh
        fVbmFSpnSSmtnPZvdWbwvdvdHZ
        NsZWWWWLsBZPhfsLmPhcFCCHCMMrqfqcvHMfHH
        nThSllnplGlMpvFRcCqrrr
        DnTwSztgzlDnVGTwztmdZhmLdJdNDshBdsWs
        RBBGTFZGglMHvrtcgSdnNgjg
        DmVcbmbJmwJDJzVVwzJfmfstnztvjnNjvNSpdptvzCnpjj
        DsLcfLmbhVQssQJQscWRPBZZMMRLHFHZBGMG
        FVvhVnhFnFhmvFhVcMBHLgcPClrqqrtqCppldrRRTppldg
        QLWfDNwsQLtlrrCtDdpq
        sJwZwLsGJWGGwzzWZNbWNLjQHSVhvHSnhcMFcbVmnvcchSBS
        jTMNMrHBJWWDffRqfDBqfD
        QmSFphtQqQmVmqVnPnPlpwgfnRnDPl
        VqFmLFbLhmZhGFGmCmGtZLtJWzWHcJrNrHMccjMscMHzMZ
        hGPGmbfPzbPfgdMdWGqBGQcqpp
        nvFTvDrTdNZZlrjnMHHHpBBcppqq
        rNlZZNLvRdRCRFFwZwhgbmSJPSmPfhfwhS
        vjdbFWTtFRRvtvZZvdWJWbGjLhCcnrrrNqLNCPqchShNqc
        QHQVlDsMfmmDMHDBdLdCSLnhNLNNfqCd
        VQHsMDpHlzMBBwlsmMzmmlVwptvTWdvJdbvJtRTWgGFJJGtR
        nSScBcnbbFSQVdBFBtWpwtvtPbTZthtTvT
        pRzHpGjCDGzHGCGsThqqwZwPhCtvhTqZ
        NzlzjDDpNldBFrlfFQ
        qJlDlPPWppgppqPlplpfdvgnbMfGbdgCghMdCM
        QWTWZcSsWbvVvTnhfC
        tRFLwZrcrWzzlJmtBqlm
        HMNMvvzzNcmfNmfbhs
        qVcwCgjCLtWRSLsTPbmPfmTh
        RtWCJgddWRtCJdWWgdBjwWWwpzMFpHGprcBGFFnGHQZHQGpF
        gZgBDgDVGDGjmDZRtgjvVvtQdnLrcRcrdfdfCcnlscsJsn
        WTqzqHqNzpHpwzNhMHNwWPbQCQcCLsnCrLLfcrffNflcNn
        zHTwwpTPzTTwlFTFzwqzPbwZGgGZZBtmGGvGmBGZVFStFZ
        znlSSzfzTcmmfcCt
        PHWWGpqgPShPMwGwqJFTVtwtCVTCmTJcFc
        qHqqSggLrRLBbvDDdndzRQ
        WBddBQWZWWQqqQFMWfmrWsJnmVJJNDDVJGsLmHmLDN
        PTgCjvCCPPPzSZGJVLsVZCHHnH
        pzwtPTvzTjRTPtwSjPSzRgBbWMBfMwwZfbWrMrZFqFFM
        BqDwVqdqlDlblQMf
        ZcCWWcWzvJZjcPjZZZfTHfQJQHThqpMbQQJf
        LPCcZcczZLgCjvPWgvstjsjmRRBdmGrdGdmSFGnFrtGmqr
        CBvgQssVzfCBQSgvvvfmrlGrCtMGwthJlJtbrh
        TpLqLRFpqdRpRTfNPtRmrMMtMlMMmlMJlt
        PZTjqFFTHZZNZpqcVWzVvgzcWnSWfBDD
        SVSTpgpVpdNbpcVdfjcNfbcJnqsltcJPvRJqRwQqlQsJls
        zhWzDLmFHhmrWZmmzHJJQlnswqsvttrstQqs
        zGtZFGGCmZmGGFhLBWBGGFdgVjgppMTSTgMfCNfVVSdj
        CzjNJGcnzQJltPHttcPHTP
        bLVsqLbLmSSVrqmdhVSmsVFFprfrFWrwTTWWWZpFPtlP
        ssDsMqLqhvmvhdmdvzRCnQgRzzBjgnlNCM
        TzTLzzSGRlRSjWzlWRzHGTpNhPhJPmdnNPPbhlbPbdhfPh
        mBCDBVrCqVQvQMBcVcqBrBDsbtJfnZNbJndNNhthZNJfPZPs
        wMCrqVvBzmzHTGLw
        NbfwfZPPdVNPdBdQBcmQzrQz
        nnWqHLWGFMDFDLDjsqnHLsrQGzmJczmQrgJmJGZmQrgJ
        FFWRsHMHCZCWFwRwphpvlfTTpp
        PclPlVZvLDNvVZSLSMvvDttmtfzFtzHqtqtzzccCFc
        jrggQGhjQsTDbrbJjJQqzzCsdtzzFCdHqmBBHz
        WGDgngwrQggZMNvMWPMRRV
        wNgpMdMMcdSscccNcLLTbtQJtQJQltJwFtlBlzBt
        HHGhrLrCvHWHCPhrWDtnBllnQbfQftGnfnBF
        HvLjWCLHPZvHHHZjjrqVTTZVcppMgNNNNSpS
        QQrwQmvWQjgTfvBjfffrSDcrqSqDDVLctqqcVd
        GnHFnGhGplGMlHMNhzBzlLPLVcVNCPDqVNdcqLdqtV
        GnMGpslMhGsRzzHzGsZFZQJTTmWfBbvfgfgJRfbwbW
        MRCtSwMhvjCGtvMZDVWpVZJlVccNDlpb
        gdLQFFwwLfHJWnQlcJJbWc
        rdqdmqHLTLmsswsFHLFtMPRMCSSRtSjTPMPSCR
        jmCCnLCLZjZjRjQTLZQhGPGhhzHhDRGRDzwzwh
        stlJlrlJJcSSfSMMzPfhhGhzpwhpNwhD
        rbrbBcSlWmdZWjDnTm
        PNBRNnnqQRNfVfRtVVzgFLLttpSwgzzzmFFF
        fcWlcbvvCFzLbwLw
        rlrMrhTJhDcTTfhRNqHRQPQRQNQB
        TrprpprRVVfpRpVqTVpzDdvmvbbCchhcttqcthSMdd
        JlnZnFlsMBZnJHlsLsCLbSNtbNhdbbShCScm
        FlZjjsHHsnQFQwTDzMRRpGRR
        wHWzwCTTqJhzzvJhWHWhqJWrFsFQrrrFCfFfgjjgjprfsp
        DBRmZRtZLbnRBGSBmtGSLpjBrrsfrgsTQVrVrrPrgr
        DLnbcbtLtmNNmbRcGbcGmHzlThNNhqJTHdvqvWlHJh
        GSNqjRcqflNLnCTTWrWn
        BmwQtmtJwPwmzMwQtHtVssvrnpWTTnsTTgpVCLCs
        DBBQHJJrzhzQDDfSljRfhccfcdZf
        wtgtChCwzqgLzjggqtHtjFHHFcnPfdRDfZZVcPfVZZfGnfdm
        vBTrRTTWGGmcTDVD
        SJMbbpWslJblSSNzNsztRChzqRCj
        gBHHCtVCSHMQlfFTQqCfmq
        WrpdwjbwbwQGlPqSqblP
        wWDncWrDDNdWNRjScScjpzvHZtBMZtJsvLVgvzssBsvs
        VppWpVfmZPBlnmrGBzhttMzMpctLLcChSh
        FwgLJvRdHcwMzSzjzc
        QvbgdQLQgDvsqvqRHRDdDQDBWmBGBflnVbZmZmmnBBWrmW
        SqShwLFCQGpDHCtZCWpW
        bdHPHjTbJdsMnPHPbdjgtnBlVlBnVgtZpDBpWV
        bdmPcjbjMNMvvHbTcQRNfRwRwLffwwqwNF
        zdRHTpQTQHQnpnnQRHTsNNlJSJWmzJmJllNmSG
        FBbRvLbFRwLqbbVgBVqqLFqJtJNcltsSGmgmGtNtgWmstm
        FLhhfvvVwvjqfLRBqLVqbwqZQrTTpHMHjdrpnnDPDQCdCrpC
        JgjzvbJCWgbjgGbJWjRhgNPGHHBMtqBStZZsHMSsBqtD
        cfQdwQFdQQppnVVnlFLLBsBZMhqPlPMMqBSHDtHM
        wnQhcnVddmdWgjvjmvRjjJ
        QpcRtndvsLcVJtRSzWSlWjzSbjjWBv
        qGZPqCTmGPqgGTCqHgCqZCPFWbbBNBMNBbdBMlWWrbjlMbFl
        qhHDGhCmPhZHgDmDVQthttRchLwLdwcc
        srpPMwlMmsrGFGswvDRhRWRDJJJchJ
        fSgBbCBNnBTTgCNLTCRJhRJVWhTcVVVFFJdR
        SbBnnLNZCLFQCZjnCnZFjPrzqmlMmmsrpzrlsmtt
        BBsfDfsBDSWRwlLqmWCpWcllrl
        nQMgMnnnhdntgMBrCdpNNLNlNqLqLl
        FnQFHzPQJjJGRBGvfR
        lRnVRFFlgMCRVwLgFZRnZQHWdcftHdmcJHmmMdzzfz
        DGBqGQbhhBDbSBpGDBzqdNHJdtmcWdqdmtcm
        bjbsBvjhSlVsPRgLQl
        dDLbRdTMRJMbFRzZBfzNSjtNBzBD
        PmgspqqVrppTVrvrsPhhfQwZBwNjNtNffzqqfwwN
        mCcmsngrPvpVTssCVsvsPLRRJllGFlnRGbMJMWWlJJ
        fGlGZHRRbwgPbZRRNCdcSWpncnQtQWlWcWpW
        JrTLJgVvVLQQvtSvQncQ
        JrrrmMTBVTmjBMrVjrshmJzgCfzRPCRZPGHfbwNPzbZHNH
        qqqlDDZzVVnNqHDDFFFNlQpzjrTvsvzTbgJQQggjJp
        cWPWcCmMfCMWdtPMhMbQQQjGGjpdvjTbjgjr
        WtMSBCtCwchChMfBWtcPnNVNqZZLDRNqTRnnlwHn
        mvQQnhBvhmvBmncmZBclTZTQccRFNFFdqFFgVqSRrgFrppNR
        MjzJPzGPfffMCjVVjfPHLCFRNFStqrdRSdqdNGRqNptq
        HDJHPjDJLfjbzfwPjCzCWWTwlmQhBnsWBvVsvBvZ
        RVjcshhscQhrVjhvzjVfDNnzGtftmDHFttFGGf
        qLcBCCMBJJbTdBDnNtdfnmDG
        WpZgLLclTclRwgjgsrwsvj
        shhhltNPcDtlNcNMcsctNtppLZvWWFLTFFZpTZDQgFLT
        dRgJVzRHbqnLpTWQvLLJfp
        mCVCdzqHndbqHCrVqRrmbwtNBsmPwNmScPgtPhBclw
        bDDZMDrFPsrsMcsrbJZJdMMGpSzpSbwRSSRGpCHCGzlhCC
        BWWNQjBLQVHhlGpSCmwj
        ffwnNwfgtnNgVVwfNWBWnFsMJTJTcPFJcTFDsrJstJ
        vQbQLQBpBvbvpHplHNTHWGZDngntZCQGgZhGhtjG
        rqccPPmcrffRmsmCjVgnrGChChDjgW
        fqRJsJMSlSzSWTbT
        brsjjJPJwrJJsrRRlllNQGWQpwppCtfGGtWzGGMQ
        ncBqqLTDnmLgVDZVnBDmdtVVtMzWWdMCQdpQWdVz
        hDZgTSSnTzNPNFSFPF
        VZVJJtWTsfTVVWsJhPWrCjzSBJlHSmjJCRlNSSlz
        CqMpwccgvvgLnvLbMMRRjBNHzjmGmwNHlmlN
        gLqqvpCDfVDrTfVW
        CNMDGNPPNJCGbLnTffsTLT
        tcBBRlrBdQrtmtWFjjbnrTjjFbjr
        cTQQhcmvcBRcwDMVDZZPPCJh
        mBCdgPLgZmLfGmfvGhtRQJWjtjQGQhtN
        pMwrVwbwHMsqcTWQhQWzggTTWp
        nnSMwrlrsmSZgvvmDd
        WNSzpCzNzqzNdmqrRHrrLHFrJH
        MtPfvnGMPnMcbnRtDHTRFFDrmJRQ
        PcBsfPPHPGGfcSzZjNjpNZZdCs
        mDCZVLDhWVSDCRvGtsGgGRHl
        JjPwPNdcPnjPdcwNltHzzGmgGJzQJJRQ
        dqfjnNmwmbmWrZMbMrThhB
        qtBpNZFpBGFNfZNPmZPmQmHrmPPPTz
        LLwJLvDvlWWLHdwDrVcCRcDVzzVVcV
        sMMwvgjnMvjvnlsvNFBqfGHFqHGjtSpS
        MmZZsFgwJTdTMdgmZdZRgFhDHhPQPPnRPhCrHhnnrPDD
        fBcLlNNpQCDLDJJC
        jSbWWlWpBpclWlWpNWlVBbWVdgwswFJmFJsGtdMggZFGbZwd
        CMVQVMLLMFGRCMWQttnqqwQwhqsm
        pJzlczSpPpPgmsqNhmPGDstq
        gZgTccZGGpzdpjclGRVMVRFRMFvHRLRdLf
        FMWMSBtStZqZWQtFtScWWSZmHPVJJVHwwlTgmgbzQwbwTJ
        jhGLhdjNjsLvLsshzHJPVdVmmbzHzdHJ
        jvDRNjnDNGRCzjLzZZpqnrFBSccWrMcB
        zggmthDDghHvtrdgrVWfSBRwTHLWHwsBWw
        PGGjpCjQnJQGJcJnnQpjFWVSsZWVLRZLBcsWSZBRWS
        FGQlpnJCbqqGGRCjjnlCqGMtdNmmmvdNmmmzvhbrmgMz
        TstvBTdgBhqTsdTcPlfCSrNMrNnrCNNSNNgp
        HwLQwQDZzDjnDbmMhNSnmm
        FZLVzLLQHRRzwWHjdPlJctlJtlsllhRs
        fBtPsMDDswHvBmmVdBlSBRcGGnhVhg
        LWJbrpFqpTLTTjqqNWlhnRGGSnhrcSdlRlsh
        JWNbbpjJzTbNNNJNJMvmvfZHvzDsHDCsZw
        LPGnPNLtwGhFFnJPfsqpVVszzpsP
        TcWdvlrcWddggrDBDDdDMmWzRJqfVQZqmsfZsRQzZfZzQJ
        TldWrMrDdlDCDdMTcwSLVCSShLNSwHjhGF
        JGsWWWQsJmPwQWbBPmccbcbqFfMMpFDVCDFVFVCDqqfFwD
        ZtLnlvLnNtvLndnCmfMVSmVCClfpVp
        zTzZtjnZNLNmZvdtznntHHZJbBRGBRQWcJGbGsbsJRPQWT
        MLmlMTPtQtMNlhbqbbqhflBB
        rcrvjpSvScbRbBvbDBPG
        ZZJzSHpzPrJzHFmMVMFmHCLNtV
    """.trimIndent()

}