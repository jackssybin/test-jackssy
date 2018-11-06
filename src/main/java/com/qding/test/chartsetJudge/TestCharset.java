package com.qding.test.chartsetJudge;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class TestCharset {
    public static void main(String[] args){

        String[] charsetNames={
                "UTF-8",
                "UTF-16",
                "UTF-16BE",
                "UTF-16LE",
                "UTF-32",
                "UTF-32BE",
                "UTF-32LE",
                "UNICODE",
                "GBK",
                "GB2312",
                "GB18030",
                "ISO8859-1",
                "BIG5",
                "ASCII"
        };


        for(int i=0;i<charsetNames.length;i++){
            printByteLength(charsetNames[i]);
        }
        System.out.println("默认编码英文字符所占字节数:"+"a".getBytes().length);
        System.out.println("默认编码中文字符所占字节数:"+"好".getBytes().length);

        String defaultCharsetName= Charset.defaultCharset().displayName();
        System.out.println("defaultCharsetName:"+defaultCharsetName);
    }

    /**
     * String类的不带参数的getBytes()方法会以程序所运行平台的默认编码方式为准来进行转换，
     * 在不同环境下可能会有不同的结果，因此建议使用指定编码方式的getBytes(String charsetName)方法。
     */
    public static void printByteLength(String charsetName){
        //一个英文字符
        String en="a";
        //一个中文字符
        String zh="public static void main(String[] args){\n" +
                " \n" +
                "        String[] charsetNames={    \n" +
                "                                    \"UTF-8\",\n" +
                "                                    \"UTF-16\",\n" +
                "                                    \"UTF-16BE\",\n" +
                "                                    \"UTF-16LE\",\n" +
                "                                    \"UTF-32\",\n" +
                "                                    \"UTF-32BE\",\n" +
                "                                    \"UTF-32LE\",\n" +
                "                                    \"UNICODE\",\n" +
                "                                    \"GBK\",\n" +
                "                                    \"GB2312\",\n" +
                "                                    \"GB18030\",\n" +
                "                                    \"ISO8859-1\",\n" +
                "                                    \"BIG5\",\n" +
                "                                    \"ASCII\"\n" +
                "                               }; \n" +
                " \n" +
                " \n" +
                "        for(int i=0;i<charsetNames.length;i++){\n" +
                "            printByteLength(charsetNames[i]);\n" +
                "        }\n" +
                "        System.out.println(\"默认编码英文字符所占字节数:\"+\"a\".getBytes().length);\n" +
                "        System.out.println(\"默认编码中文字符所占字节数:\"+\"好\".getBytes().length);\n" +
                " \n" +
                "        String defaultCharsetName=Charset.defaultCharset().displayName();   \n" +
                "        System.out.println(\"defaultCharsetName:\"+defaultCharsetName); \n" +
                "    }\n" +
                " \n" +
                "    /**\n" +
                "     * String类的不带参数的getBytes()方法会以程序所运行平台的默认编码方式为准来进行转换，\n" +
                "     * 在不同环境下可能会有不同的结果，因此建议使用指定编码方式的getBytes(String charsetName)方法。\n" +
                "     */\n" +
                "    public static void printByteLength(String charsetName){\n" +
                "        String en=\"a\";    //一个英文字符\n" +
                "        String zh=\"的\";    //一个中文字符\n" +
                "        try {\n" +
                "            System.out.println(charsetName+\"编码英文字符所占字节数:\"+en.getBytes(charsetName).length);\n" +
                "            System.out.println(charsetName+\"编码中文字符所占字节数:\"+zh.getBytes(charsetName).length);\n" +
                "            System.out.println();\n" +
                "        } catch (UnsupportedEncodingException e) {\n" +
                "            System.out.println(\"非法编码格式！\");\n" +
                "        }\n" +
                "       \n" +
                "    }\n" +
                "\n" +
                "--------------------- \n" +
                "作者：隆曦 \n" +
                "来源：CSDN \n" +
                "原文：https://blog.csdn.net/a_long_/article/details/53155432 \n" +
                "版权声明：本文为博主原创文章，转载请附上博文链接！";

        zh="ON01_aV88ov8kXM9xTjm056smDVqdJVtlmK2VY33UkYUuHsh2bs-Yrb36LHRL-aokKKnR18f2ZGBRNXPNCXQLusEL-VRyGmBImnY4ksGE7nm9XxBZfeFVxq8uzFej059ie3HU22q0LBhqXXMkL5MMPCRm0AElygZdFQQqG53WWjRuHiIQSSqdGUkTsFNgp_nreW0Sytbhvz51b1tRUEtfSRpzYUiCgnsZ8Tqza7EXkXnIFvf5afp0WVCPKLiQLjjp9jc4KzTa9Xk9fm-vcfuizTc1bT4oEZ0Cut_JTVFCO5POdFrpE4CKXO41QwxAX1n0KdqcM1xbA5VwXoYEy_TAwqekScwKtAcNFSW6gjhDAU-7nY90OPI4CGMtPRFTE9DjuDX3mj1QBX2-WB54G_7208SOvVR-cBSL8GCnhogTY88ae5XwtIz4vfvADudy9Ps5wnMxheAZPI2p41VF5QCkn5SBQ_lkaOcexccPZHCUN-7itn357ucgNIjEbzux-SW3u5e9DOWlVmja1xt0Q66PBYJQ_xa-qOi7fr5i4N8-frDwIku62YMozsH0UNMAipe6TD9SRVEcav7Vc4BFZKql26UTqDeKK0xftCG0sc-bH0Y9QCvPnz0DA-E-3Mh6HaLek9LNwqxVa0vnvbW8qWnG0BHF4JeTuSoWX5nE3aDVVw9YB8gq28N4e9IP7ZZXgvLNFUWl0vDEaJQRtUH1m-A3i6_wSmHQyKiU4atyzOSn9qui50V-Fef-TdU5njQnaNfS7MT5U3AZqffLkr3NuwyVMYNshbn3KFrI7vyGVJPfdXKzLMAzk7Cd9_wbcNz5IQURqQxvPEu4FyWdumJA__q9ZwMmXRGRi668oM42pILGp9x4qnaA2DFS1g7whe_AhU5Nn5CJsiiNghvG0ZNwkM5QIqoiGFnpNrbpvBb-sgJTlHjKucWWhYm6uC1N8dwoRCDlwqYUWnwR9pasbpUr5eY_Hf9dBrPvFsLpcoJH884H5G18yrHJy4FNQz6pAPGWO4BrtW5ew25rd9ivLtadvPQP0eMzkX19v-h12LuMjpBDlD1kBO0K3wKUycHjkOSZdowCbu5AES9KZo1EI8xBtD6BFB_q0Y9kl0mzF1Bam8ND8OYRc8Pu6OFCVyKUNn1jE5oJ6blnQJ66xuj_dX1X-qgllwqA3TQryLhizxVFkGVCwKtTDM6WUJeZbs6Ku52qWXzc7I9KUIQrbf_QI85ed9EbxBER8vCLnEN_NrolxXrYLzDvpLrJu57k15SYlNRKAwBNeeubVUORLQVceMp1FjyPCQu1GC75O1RgWaqvo6NYyB8lTo4Ae7G6FSiOj4J02wZc9Q3E1oVQhkXgxcZQFr1vbrOHnsr5WnYjG2EQdq6awA1NHY7gA6nYzhWerb9lx0Tbs2MmrznTiFfkR5cxYBuUTfyDr_dHMyc07uFDiDhUzdAT1A6k-11XnyaZCD72t7yH4ThFqghxfcGUSKl-xNLOOs7LJ5IWonS5SWTmuI8nrhA7A8-Q5iuoPw1jUOI5rhl1C6svl5WpScbsuNDfRITzkylGVYqJwsURtnajxJClaXRxbZ_tAsqzNWwWtcgbflZOT2Sz0Dm0KAIvxvayAn0dpydFLa31AL-mLfdLFxGz_z5BK0ZQVDIm7rKstJmVCrDzs4YnvKlxBZJ_Tn3T2OxBEVOh37pBx0bJGDtE-nJx-kFrt6ksmlTHtYonU1ZZBeyqI5PpMEgSNjvhOrye1s4WL9TN3d7uD01WYm6q_zEKoP5Dz7kSC-V-IVAKrNmsdbrPPCthGrseUlerFiDxgYjnevm_kefHFHJO3v0Et4qy8asZewLR6YYBF-Sp57wsJOaHYK4ZqBMz2R-7sWKuascAxotwxzVuw3plwoafkUxzQPfMBxgbOxLWf1kr9pZtGcyKTdxA5zgR0rmxy71S5YbpVtm3N5iZ0mo5QTvkqNF_nJjoLmVkHjr_n4TME6pMx-Nv-tCFxNtfDLa1xCWYYjhJ-SDABnjFEyNEsW0MFGBhV4jtczlKVJQ41SEsMVfzDyJST4745CB6c59qnAsqjBaw8Kh7HXOBJ73ox2_FLvoRLOZyZEg2FREKG0sjEvYuc1dkARc4S7hNkGd_FyLz5S6OK9rwJPi98Nv7hspvkXNHZ0hlcZ-LaD1oWz7s5zoL9ktsAoYnZ6oD43KFfN3e9K_6YgTkptLK_g5_MlynsG_W6MLqiW13lNDH_UmGjxF6LcFlv0WteH6G21nLp9S1hCE_GUsjC8V2AyRcxZfvRGkWRlFyBZPnbzjShpCTZsLMBk37Tn1eNhJ0JL6fo156GBkFXgRokgcswbOqlg87-jBCKcX2qeiKcUvZ8jplotQl559JSEKhA9kWsQ4rD4Am5PGZ4PTj5swlMLgaqFqOGCEtt50wfvyGQNNR9SROC4QNJ24qbnOwuHXa5ySfvV7KQBJIFb6W5Oacr7gBrVC1CIPCUq22_Y4cPKQbFW8hlVDkI_wGEzXJsRuYbrDxgUV01z-ZNLkSbrgrCzLQNcXteBSFd8PREQz4Vfv_2TyPgD-qu_3CGddVisztmWaSO3vWS5xd713sRpVV_yaj0z1ka-AVO6YC5FSZei8DdNnCBqCVrs7dcucf_6ZaETPE3HFI4obcnerZwyCojaBrtg-uWyNGOcbDW4ZTVbhM9JWKEfWG8jUbaUSa0hk2SOmqX_xQ2wQLvmjDe_Xaqk2dpI4yAapNCEs-tqQf4ZItYTF8I2xzjImT7PxxPixkAUZ-B-dYOHmJRZt0Y13IBqnsVgd34jx77OO8iHStaBGUtk36nYnCKOLmsIeV6QdtPD9AdN-vJ8ZH7ocno2ys36RNoaA9_UB27Qt1txGMT5oeDMojovGh11aykI9gnN3tRy5YU-tnyl4qv3sVmhOdzDgseuJXgh_onpc1WcsEb34iuRr3OrEH0g8XJcvJqsq2R6tdiMfsSt-hxKLJo2Mo2HrvZnWxsnjzpRrRs9I7vFSIQ8cnwDf433YCOH2-UGUz2OJoZiNQaSatrinc2X3MZs38F1_F6e097LrwL1L0aYdGDZ6BIbihfjqbAACLCL2qu9y3VEvWSMa4RBPLyXlx-OBG1A_iXqlvr-RsL6N2ARO5zf2opXe4ebr2rV3dwXMlAI2sTa9L0JUtr-uF1VUQajI59RujPMshZLdZrye0yNBj3-r6HxBQrYt0zIU61qOuxxFiu3mD4WiiA-IKRQ_tn3GSAc4oem6P0jbvMOcQGufzzqM6BR2XKNJE-PF5PQO462CmgS252unpN__UlMB9z0ZSu5TBoOA59l8WocoBSEjHB0FkMykp_p7qyUTPFoWS3BatP13wp_PSoCRLa6_rigc9Aj9JQ3lAGimVUPTai9VJPA4otmh17bZXG_pfXMpGAeFurCE9QYNaaUWbmdGncjr_kr4NP7UGEaN7Mlz43HZ4G-6t6v9rxhXbcMj0IUCi44Tl9CvKmQojICi2KVe6obX3Punbk8hA9psWlwDVYyncuMhNIXxO3OsvYZ5HgjayD5xq_hbc2iaOxljXwpsv4csXNy51S0KFFVcn9ZwZEJhB9qhcEZ5nBUPbttF28Lm1lWsuNb2NO0NG82zdnPbp5UYleCah-bq0riHWjd3IiIMTHcpcYhwgTaDc0ZPIrBYiPRFfd6IyWfoTWrJWDvmFarMYzJVbJ3Dou1MKoKRokxMfdkBH4Cn2xXc_cl5-bfaC1q2OUy2alcGD3qcFXqKxb12fcz0zMgo011FptfO3oMjjzZvO2p8S9IajB7kQ5rl7gxXks7m3wjh5zpV9uY-UHSPVvEyuZZTRc8OOW2qTvYMWn5_byaoXOn1VgPkP3BnF2LhONXA6GYkcTV76-2lN6E0qbCuKpZaaYiCfARZmrLZVAr47VIuxFLpJVrXTZP3OMjeATiWqLRg89KvGyDPvcMBsLicUC5bA3Eu-R0_EqEmj5ZKyQGiWxSzhfaTcXWjbVnYgIpm685yHWO3xfcddQO3GWxjET85Y4Q77HEVLU4pZa-HZ3GIlx6NjjSpIxwW30OwNyTMzJtUKY2QHQIfN4YZImJmPQuOkKnnwhyIzbvBdTqZs7-HKXbFwcnc031jeIYuhOVEX_AvuQRR4hRqxcE8Zm2GlnIyquFMVFyICAks1Ak0g-vYTX54DqxFa37Cd3vkwzDmIKWeAlGqiLFuEGHfOk8sE_WFNtSBWO3GC-ExiU1uI9q8MH_Y8FcpZCPlC62x5jp9OOLWtFhjFqvzdvILzxsajHLvAH3Yco2nyZ4cxpZNvoNjzN95P06H-w8hVGrsz2lGpyVxXdIbi4pcBe6XpDgkvDc-x9oPPmnSYxMsxWV1gHe03DbKNH6F3jubHmPzpbA48sufDNLeuK188bIKftKg8smNeInbZ0_Na7gQ2EW_RHfN3s1t2N-xKQaf77wiaKFjO7ak7_Y59vI6mUh-TaFZEcTfU9EI604DFsAYogGYHsTnQIkT24ICEuw8IH8KWharqDqp_cSPVafcU24teps06EeSGnvk51GrB1UfjhPpXDN-iukyf5yPIfiTC860cDikTFxl1USxH7sC2tr7ZSlZQHQQ3QyVSu6n6xkU861CmoWTT8-S2JOiejvPkkx7hPGkt9TfkIixOlmGXaFX5aS6atlJhhAMEP3sS4p9LYdNaNEAXsPdRlGKd46JFzRcjfZScEyDppb_9XEOzYcPIOTKOKWfX0o5AG_2OpU8k9rSG3TLrsz114KnVDfqCSRqdHIiELXEh4O-dE9aG3EcbVY373F3qJWBPjOYzbYx89Lp-IBAaIEjZmQjPJWAYQZkt4aLDcnsBUdDQvKmqloxZMIk8tmRIB7ibsBvVM4u5d8bbgzMSP5aMHa3w2T12i3QdvGpwZDcpt-k3R16-T3X0RViPIsOYxxQKY9fks9CfKC1RGmHVhLH0F0hHVgk1CRiwh37PKm5xPWSV4vMQMRt-X_PUJnHF4ABX4FyuuYA3umb60c7lXxp0ADF5anpE5Zs4NaPXl7aQxym1G4C2G71n2ZrPqDfGUS6EKsMnJOX1kJaVRQAGSYVtIB2smeyyT80FUXry6vwjscpIx6FOWDviAINbD3ozDNtbRH14ueKmdZbmJD-xu_gcfMGKTKJvdqu1S8D-1FoI8mqVPDpwWC6u5WwPoBhAy6o5Sb13oYsDgvi0i0s7IT7IfgdFJt_afRT0Lr-yayl3HeJDgoso4PwA4kHyiN-8J0m4qjYU3Va0YfHXbrNP_ku3VFPlueB_T47Bu6XBlGz1iyu5CXGwSxNL9O85Tt7w4Dwkv1pes1CtQkVKyvfH1jHz2-asDi1QNZvXorpfpozA82lB9WIEw0sxbd3x9keYaAqA99qFK-J7pwxmrIVl5zeT99NsoCUX_ZHXrqAID_f1ZBMvDTTFY8NfW73BWLEDCAkxdC_W1wUljHw4GTBULVS5oDmZV9iiXN6p2AcjXVXeGfmuo6gznKuys6HmS1HGoMxIEUpkpzsxZdpd3ZLp6jWCxo2KehbXkqXl2hVvMX03ibeQ224_r8vKFmROOYl7JCUHQXswioFnl_SMzqurgSCal-3c8o_QYMzq_Ctj7nXfzUPDI7zUH7Lru0oYC-bVEXNK8WJ6eFJ3tKxCfYpECMvGhR6X0alx-eDuJ9fnz-20GSmcZCaEPZ934RBaKDUR2WRbj_gd3VuRvCNHF-66kp_iWf4YGYBGXqwlYDry9FSaCJSgETSU0AkrxaysU8OD7bIUkaqkszbdZLM2edRbLcONLe8vPsQ2AqWuhAspiCW5FAInRiIr-lugEaXysBUDkBXiRp0L-KSy_-7Z_1i_w-BJkAM1bYFVwX5rzTp96BoQKopJecHxucKa5Gp2FU5Rz87KTL2qYSOjWhupp8OhssIV_VS2El_qe4-up4nBTEHVD9IUB4b59sGVp_cbTD9eHnz2JQ2dr5DhcZ5CxSv1q-pGZX3z1KXcC0Pl67ggioJe6HzCowOCxQGQVFQFYZQhEJtYyNPxKsvvzXg1HledwNLD3SGUwWX_6paiOQ1OCH4wbyIn0M3dJEdBNPMd1QzjNPK2bBta28VZBbx8hZ53HO_LnrOxP5qCc3VuMiu8j76JGLAMiqubpHHBL84_2DX56jgAHypFDmxxqTo48zOXeM3WEQpIPlUgH8r2X832trvaINFHfxgbiOFuJIt8HZJNeBrSi9wLUejm2KYpwBdDhQIc4N1Pt1fEiuumrt8i_nX8mfBSy-JL0ajmMzu9Fd_cPUApBYXRy2E1y0yN34_LjBgQPIhjvBrtzxmymHGNNLOopNeZ2K052x_lRggstUU6CQQvdvV44t13NgFNsE9iNrUF7c1RdVIKh_HDtFMoZmJmG-r6ZYZWcWb18TtMLJ9uXBslLQxGjvIMmag_KwWU-KeftdWAJk55vx2mULfDgU6RHKyGxtR4tmhbUI0muzxXVtHnyW72L-GdyN1VYzc9WFjWQ2sAAH1V8fkBAEU8ViClFEMwh3UT1aXsgxg_n-D4BxnuViYKUFM4HXn6qzsBDX6_0pt32WgWyUhfcKwZe67EeHFUB2ef9EegY5PGgVNT6ENV1pmB-wHzSZkpfkWsSGCvVoTfqSbb2-GWNPDCYS7w3y7Wy4YjhsDKhyBy8JdRcY--IpGGKpMweGur4B6JRErTeDnYuxclQeuN-UKrNoLkMVFFV8KC6ZgO9sqzbM08K2GlL-HGsgqq6aAVsItJEHF_DmptvXQ2pcLY95EY7XgvKqNrPLeYK-KKyHF6K6dDC0s6TlX7cZiCBrwVnzTX5jOHSC5UE7j6Rmv-arilSqpXB3O0E1RfJorHszT-VemdpOTP8OtHEfSF515zTDG5Fqj6ajESnlyOfiglphZ0vSlYcbiH7y1jU4_JfTXIdqwa09BYnd1rWFGcYhZX60dWBc7QrQ2O1DJ7PP81p3woNkFESp75xcgFi21ZXpIMA1Y_o8sM8Q2dVUR1l_LWexKEJ8_LEAQE6p8sbL5u028QY4nWuAPRxkXhlXF9aWEP9e1Dh0DHeJJ2sKGvsg4fh4F0Jx5NjuTbK9DMANJnm-KOnOiVTd7X2saW6Ja5WNQJmuD7B6L-mXh38mBdpTaHoFYjusahra2_oAlC0ghkegZlml0zQOFkxKFHdddQRb0jSCkjVN1IfnbDQH7g41-Kz-3pUnf5zsaR4d8kev6xJKwSPv4iA4pbD-7M1RTyRLhZhjJ-3NmAczu1wqrgUF5_sKpe5HkOqsHJ13TCe4tUSNuPg7ZwLUovNd6PKpZPjy2rzIDm6ZORxet1_IA2l7Q_9yvp4xWmu2T1d1Y3WceMaIRa3vRtfQVwiV2y4lecslG_Yr5GTgBSTpw6GNUv2Lwm_DsO4lZQC78O4QBU8eQ_27ovK5bZCDO_5QTmXhGPniJlGrNV88JaMuinQvxy91Nsz0TqFf5vMd9z1yVLGmCANneoWt8AWAjp_waXUEhA_qt1v10rPd33pjINuElndu4n4JChWTI_PE0iGiQ2c0FrEiKZf6i6kNqgSCWELpvNfUz4GyMOfGpfb7toENNxcwEW7lSwE26Xjr1eJdEKwuUy-YaeD62RzbWgzC132Vbrz-Xz821lR3r8M8M7_-Kh05WBLg_P-YP5ePvYw2vsrLthpklNkJjlxcdkrOIctyhPOPYGRW8k6GDfovcOvkoCLYz3JrRaElbY_qQ1qPKT74kngJCPHaCXA64Nz8j2-TlUWXwbaHFyD1MW227XLPiWNk1h2O75_XdVn2347pS1COAK5yARYUkKJy-lSIcXbok3lsF6zckOMkPOkjARUzuLlVKSz7BRQp_AmAPL_Rqi0CmixlaenrdMKHkn8o4tSVh3tjoyOYP2U1Hu0MEP5tR-LU9hSUzxSRH_U--ZRhCW7Ml_cOhwJdcfslOuEyDnqW5tiACYCyGLhhY3U5sUh2qjJsTYVXA8QM0a_Cu7zmo8owX7A8Eh2xMDKzgU-jZzH4m3YCzVlQySzMchq98lTkassSqR13SStpH5NhB6J7eIkcPeANVjVR6duKOi4504LVOX2x4P4edmXsvjhaNaYMPtz6t4RPd3ABqQ5gq2C7Zv_yWFy5AknphprzlK3ZXhX8WErn77CQ51BGLRNSGWFnylz1JBl3z28mh_JtjGW-CCgeYLqveEuGX2u6WuCqRpnRkMQkClR5zU4UC6M6WmSFu89bsbdUymO760ElnnGdumBQebA2akRv474LE8YKihnkTMUPhd7MOpuJrxm2JyG_D6DfvBa7itMGFdmO7RIjNyzp6E9p3XllbnkXFTZZE94bTayjSoRASIQU5QyqZ3UhlxsnZetBzjPYwK74eAxjDzIxI5BuqBgOgjqLEOgs0YZlkXOhtk2is-obiJUaQ2LNsGKeAXTEKPUYbpoto9IAyH9Ckht9QIiMrLNnLreQqRw4DZ4dvU4QtCe9abnDcjs3GKyoDmNcY8w6IM3PD-jplepw7SCA9-7qCk9ctIvU4qsiZZu8Q4MawuixNpREG678rc2ayUw1ooBc2G6ceALIZWaHWgHDxpIW68IHDxSawULp064_iUU1GOnJ6rpbTX_ngkimnPUqkGaMqUdmH-4UcGgUFC7GUyyvoCHmth6r3bQ-OAL4AJZ_fYApDw2zdga8xq0f63gozo6y821EmAGxPvLdMD5JUXHbN-sX4naUqYkIP9ur4grZb5omozoQfQm5GrgeQyfOcIUCcLsoBjjpgnx8KpVFSN3fhwOlrsC0rHNWsW_ghCF3j29uEssS2keqNMmpxRMMrde86BqKszlbPvJ2ieUtLwnVsZURox6Ao9Vt8qAhZlTQ7aDc8MGtQX5mdOu32V0i4qtUYMKrMMPs7HkLkJXSzopvjRh7rJtLuEyWplaLCAiCvpS1DAAGI2yJnG94OIyBIh-eZ1q3lrK0H7us87JGHO6555h-KmZB0X122Kf_-Jph_azuCSruh6at7zKb952l1IJZblEdzDz9Hvd0XsANbqOn3RdQYJkivrt4c1Sp6iBqAX2Y9XkGrSZaOUULpgWVqnlaT_EGYfZr_o2F3V8HBG8Pv7NuNZ6Uajwzd9XtZszw_TQMQ1RPk6YH64PfQU6HVO_lkG0s2kAmbSH_efBiqBLDD_jDaRgozjNW6pkri9KCCmZ9K5eTgnwCU5oQJmo_Tv2jnNT-xgH0iV2VrIADjhlfuleYKy_UK3NuRb92PPxBfFS_RyDq3W47gyAOboc4kGh9yqiOqkeKtk2G-OUhqLsDPB5nLuwI0kqtUaGknT7Q1xdoSKFENU4IFfKYvyXc60Fsqw0vnR2N4ZKa4Q4DfeH6LqRoqZs6oQ1oeVH5GWMjihLN5LQxLeixDUKLNqZUjshSVo5KE-7uVKLgUM6pCnrWZVzNy4Lsd-G-qEAIVLyKiAdkq0qh_wgIycJRGZ68CMd1KlF9MtYyiDkGGO4esadFSkvowR4hmoVLJd-RVAIbWRVgdrr7s2FeBzZ_Cn81mtGAiAetsXg4ZnZRHaApsSajRRbsRSKitQqPu1uznAxNHnq9EtEfOQZ6IEBmku6U8mWk8GY8ZdSoaO8Tg_oi2nIZTXonCjrO_hy68bMyaKDv5r-T4I3ppexd_r8Iti_WPmUA7RPoijJer6eUPZb8_z8HhsJyG6HEAA0rpUHhaYREqhA2EVpgmaCWrXLOu_itrStR9v1DzXqMs-_PUYfsWiwUwUCnzsnW1sxwFWX1b-H9UMkfBVk94GHFMrolExDVfilXUV_CE3RX7AtrK_fJSZUdEYE1f3OVzzgbBt8CkoRZYwkDLLHKjgI5HpOvsoO2fuFKrukhZTrkXoyuFWIigDwevTk11fbwoh-heuI_N-VPqgXpTRlnjXULEhPo7B-7UQxvzYBQFrw1ci2y3ssc_NhDk1MhEjnylGXLSfhZsbJpGw0BD3ayLza0508vFmC0GhqRNzbJcVJKIdXXunSw0DGjg0MgUB4BH9koVnpcGONdxq_OKWaJzdA--cRnGpZwl3nTTq1Rr8Wbu4XPH_YiqklhKCIn7PjI4c1T0ty5SGojaQ4hUt7wV4CASLlx7i3OFLQxzef2pz0V4ngMbZeJNuKJAYsp1k6Uhkf3FgAurPQt3ZV9SAe4S_HP1fV3FtBNJfiEjhwOAs8_fEWLKM5pD0nmXqnmVzoEDk8KAodqpBmjvxGFf337msyUOm1mJH5vJxUbKegBdjbXDDm6Vr-DXMu1WOqDWxe_yssmSU8JoXSPRhpiR8O5tZplY79dylBBSTC439ubvJkVxhMpQYJvEllLO7Rqqk5nveeVakA_Bq4gmq6Di1s--ZefSwXGXrD5-KSR1VrHKcAkarP4qBnj-SSC4ORB2UiqTKL87a2zohX6trp3fOKMrRAITXnXNSMYDilLsFmWsxVTUhUu7o4ALiiWRKOd1i1l1jI8mNJ05XflUygvFrANh1lBSZDTxQin16WtIV1Ysds61_f_hzP2zhXhinqTed3PoUbmogMR33wH0fmrhdkIUN6WS2FEc0-iALsueXZLWtLIFGlKnSRfzSUPvTGIK669WIoXXjlaoVTmIdafPfLIjOa9ThUk9uc54FYldrNFlUSxhd9Ua35JtCayTd83zt9x8QvYPzYe9xGtVFGcoxsH22q_dvxrCzr_nBWxMCQX9RSF0nx3IsD59nYPDbflfESw-weJD5Jdm6XUcXC6tqg-O_P3x4f89Brq6uRsGYY98Egtm0p2Cra02jM--ikIqrFYa3xkBJaEjRh0UDEYtcA6UZTThyMKyfig5ghUt521hbGM9TiTXJa3sjCiMyQNVRs98WPBujlh0TYbWIz8OQ20qwO_F2B6J4StPqZlqZYxWoVSdpSRQlWZxWP5QYIg3846BObmdQWCTo-LRd1KFIjUwoSdWYEqsQBXC1cHus5jTvcFmUjq62mG71C8tJY5fiPUCLSUsMQ4tlhprNIVGtfAtBP7gaDgXHtTGGae4t-ncQiSnTHcw_6XghhDdsU62YaohOE-rgaDof_fhx2CaSVySB5DlWUBif2j1SIVlF7jci5OdI575nJzf3cm7DdIQ0SEv2d_0N1WqwrFYwgC9qjPMew29YrQSypX-igozsIqpBTkY0r-z_NAO9oippI5GxCfFnoFvxr6-7DTH4nld6h_4vZDm-RpQBDntFj6OKkU01hk34sPOnIFXKeydHw5oquOrr2voF2mJPZDlSfH3ajiv1EMy2LBHloI1HZfLcZBQrRxJ72KEx3xPx-_Ck88cLXYBG_-gsOAzep8jRdfPnnwrBiOOB-piza-U0nEZXgXXZCOqIcLeU3MIsJkS6Dib4vSwXAzy0bdlmoItUUOpiENUe3a7K2UlbOFsz9ml1O_slSkAVUcOPb3DMWUx3B_XYjByUn3vvNUfotn5B_J7RMJpJZSEes0QZcP9ALqE2LuCD7sfLLcx2KpvJXfzqmE-9zNsGDItqrTKN26tpmDCuH2VQUci0dSF8TjaRupXiANHYO1Og93x0SHJibQItqtkHfKmAbhQSn8DDQYyVrElE0sahFi3Tvegklp6ndowqe7hmYvVO9Hd1KA0FFrSw-3nDcLUS9yuVX3Xz8AyO4Ezu2uMzngBENUWHtqwpdXnaemLx5uLCx8L-AunOiNIDsQWubDQbsRR5u78dy-H5VWSQrAVCQRwHB0btNzqKJqDH6FdisFEaVx970cJJkBdBNSErms7yFb8CyfsBgTQPjexijO7YV3iifYfMuOzCJRHh39-DC7zd9xZGBa6a7UyFUCWF6s_Z2ttPWtukkN4ULmeFrw-aHSKjbVmxHcHuekzDiMzzQS0FpCyiiPaWAG7ngfACW0QWZgkIKMHfDTsz8B8hcxPtfc1cmJ1hVDgFAf99sB7p2eqwMysr-uPHhMxO5MyfuHwZkxEonsxRKjq0Q3-ARE0AIZayFOhIyXJAYwfo6fJeNn2ms1wZnXHteCYlF2Vpi3fQGoMxm8GMtediJW-gCsV0pAFm5ZDmOfRxNjACt6ani-XGCO2VIWtcAOrsSFkm0N1lytZ5NB6gDeKKkrRWdGyTHO1oS86Fq4oVt90nXogjvk_hwl75xi1aCv80PKve10Qdk4-EqLSm9Cv3atX7Okd3WkJ4DlROqXjnG51awl77ofp9D95DxJPHUIvnVPDFBrLNlShnxtpE1VI13mURzaZz5swS7NOnWzgLA3Y_mokYxm00J-3MxjjporV6opIezLU3UfonhuToA1P7oULEpEsAMFpecGDEDUf37VuA209Q9hPxy7jU4J0tPViqzzAR0PZ-bf1lYZmY4f9bUFMIs44VVsHUs_UP6XqCcjohXWexrtoOYhQA7MEzUj5QyBgBPVNdOzwtVQ_o-MwORZTxhg5If2mKCYUu5--mPVQQfnVysOwxHWqk5pK8dUXIZIZr8YE_8MMO3De6n8e2G-zky0H11mP_f8NJ-CYc6vwCb3TE_L6BypA-mhyH5dwzMXmYAym-Qtx0XmAOK474DQpMRexGi7rCGnYOPAjNZEBGKBmdE6Ho0m7JI1BClwr4Yq2hqWfBa7S0uZ_t0Ay_cMUBzmRDKMRUk1As6U8b9ZCdCNpsem2Co-rlYOomlIs4bRQkQ-fsIocCCJzoAmJy005UrEEMW0wdMMjo6q_JkkfO5bCuW0tFzOdafeC0JiqNgVuRcHq0BDNmJffebZJtqIzHElcWzPuPuS4Izj1NefmAc8fFxFnSiSiTfikBXVWL5axmATc09jhuHDP8Bmclav38Tpbm6iENX3b9GjqjukfzzHoiw96eLiNhhorcyacI414cBIYvotMLhJ-Pv_kWKW8kd5jjCyF7MtD67HAeqQeiAEhcpAdagxHlxAb8Ig6Ok43wNvircMJQLrPdIxsGz5Txvuyc1_Spa0etiv5uZkrYZF_zCrRrgD9NHrbkZ4VkzwKCaSlOD9rUzJdi251yBdcTTBP9LjRS8ijJUHlWGCrNNGNPZY95yEhHF4_ii2eGDti59rmB9ewQSOgygN9qm-trCwkuSrN1zqcJzm0jwCD0CK8glmhcUudXWmChLB_J8ABwjTe2WEQH8Lq5-Y-7mwVO5-ZzBa4LG8oHFVrHuLwXk1aJC_QZrUjEeRNm3R9HLEkguTkrDMG92LdKlphuHFfST8mWyU6-bHKR-AfcX2_3-oBq6RYV3K9pkC-Qk-Pwa04Q7WO60s0Z--pOKcvk7LBnLyyx54Jq0ZWPzOxyNi6WG9nXYeVFO_53iVylbsXyYK9YQ8sdAbTzq8OCIyIp2XH6srTE-rf4gwBJBJqmc2ui1ef_9eOf4JIZP0je7S-XxMnhc_2hHHg2hZWpjncjc1bc9dus5JxR5u_ReAVqnNvtQOj-nwqcbpPjWIy24ImkW1nTIBuU-wP2gOETzxqcI1taIwUGJNDhZqfcghHd1QhHHUw60Kf-ZBm_715d0ZNFkr5EOPkJ9ePhe1hYnRbTJ7x_Ty_0N_xEOBajvJ4GpzDdG0PPmUG-mWEX4DEwzooks__UWltqwPyHnUCyOYPvwKjzfFIBMR-lYP51rQbkVhtOTLZlfOOOxQ0FraP1nB2YfE32RYpZ168P_juHa2ZJ8Aq2HZlu_ydxtw-PklgRTXZEVyVb6YeldLAMbpG1xLaTEI7U0N9BY2H2AzqrItRntPa5qywOyzxI9T_fjkYvjqIWwxIq2MdR-wAEwNIUaEAZCh9i0kK8CZ-_hrOU3bdbhMdw7yCQsDhZeBDtY0r7TwcSOudNqsh8eSqfqZpEJTHNr1-YoZYG91pl2OPO4po5RbaHPD7NS3dKnFf0gmcXsfUrSYMdBk1z1891lr-AtUhirWPxUoSHq-XVBUMXNPIVIxFs74GztMAumZAX-YOTDEcdTPXsPwHUparCXCPetkRKI1ak1lYmX90dirwcXeA2QDk_uXAO3oAamfTxyaD3xiBxDwO4EaWIARnXW_oA6mbW4QdLqPft9Jf-YlaEIfnvO-OdN3clwG_UNUkJIgImm7aNUpohMz0PU1EnB7rhTHk1Glm5DZWwI0K2LkyAC1Pd7AI4EYTP_uz8BPFjkBDqKjh4psbeTDylbZC6uHWvdSI-DtJ0-3DL2T02V4Ru8XD2InF5PWWLTQcsmYcn5iUVpU5difdPgU4HuZzDxEn5poBPqcj1V5TVi8JLg6TNFzFaygacZH5vM3FCB8CVpi_N9vZosyRM8L4cbv0WhUJ_Ng30yzx15HSAek-1hXmiQcTE51deZOluwYhvHyhLcesW1w35WC4C7BSFQehzO5ayuzjPWisSFQayX17q7K1yxvh4v1rmkjh9jaD1QjV6UrMKtLTCQMZUHwCyp7faeZ-vILGAQ7lPUukyKUil2zqDPwYib5nzUCzyzeujbkYYf5zFXXS9WxSNevurOw97IuEw46kU76EpkHj9Do8fdxQgqxDzChrNE_PpFjAFTNvNfByuHi_1A9Jn9nOkM1vb2cyvUwYOg2jz2s3ajfxTUWelwQmUuK6Gc_m8d_ChSuoTXQbEDaT5ZpYWmcLggAVG_lKRD6AjIcdbW5mpy88u6gO5wQioIBuTVrhrYuA7TNT9ZxJdvnlCm7aq_uOnv58OMXSTUB6YfQ-MyiqDQcBQRJt28bQ-6KOODRrd7E56TwgUY5Dqwl3ONh1eFx8RKcixq-7NjD1RktCk9wr-c9kt5HnbbuMgxITO0Yufcrno-xXFpW-a3TEKGehVbpebf8pcnw2JkL2EfsaxsdvNNTrWhMzJjQHFjYivm0MLv6ieKxaDp4wEYuOr6ZgzbjGnD_tuVgFi7GCGSAclFWtqW_ZAY4o7cmaA0xhlJVBE3WgcE2ucaCvyqZnN7dtJ5HoxFEI_GBmYRL7wH6i3dLv99HGIfoSlwVz-GJiBD1Dy_2G7poZynHV5qNpvvy6lC8cD6mC_zN5c5flUmTcAfdVJOwRKDTaCpXOT0QuU8OUHh_43-N85U_hhllvnThsRusAOSODARxYN_5VH4TLymroOnD9CvNBR5XBxXkIIG1o_O9TcRy_I7q39aDalroxUzCNehrZ6HjKGeVLYH_WTMKV5dgE0njL8qJCEMtWfG_ks0nyYtHPhHlCvXGYewrI2dr6i5mwI7TtWqKbeF8EsdBR-fFZC3mi_KQItW_tR8k8TyFR6CqoNYi_izxYHhe5s6oREijOfiVO2Yh9bKgkjm-xqKmozz8LYyyGtfXMepAwPzbkhqwSfskqRjgtuDhIrNKT4Yu4Q9h13HeifU8rWdBmbeifyqr_DsHcA1FE9QeCezozsyiT68QtdyU7X-jRo-xlEySzYOgCfXLFKD0uZX95Bfl6m2lvnOmrA-8_WE3Q49xkPUt08tnfjba8elU1cFo6EDskivHrCr2WOoL45IBU6UE_MIsavHHxqPiF6DsFtUqX2rVYNx48ryHqo6RJUx2Qkr8JMthZ5ls9-UDP6p2R_408Pr24CW7bo2OuwBIJbSrrOxEgkiFWj6-TVAh12Zv-8xZfnfhKKxyyZ98-gkUkvvT53JCG4axlC9TuoBeLM5vLozqs6u4is9bYp71c7BcR8zj-dDGs7kIl9loErDAW2zbwxqD5BKNzAAyyjVyGflIuiQN2BLH1jUkPPffROfRnl7BOX3Alle6n_FNH1EnwiId-e-9N1mkschA6vnImCQ3NXhSoiF-ALxCx-VOrj9nZ7qug4yspWi1-swx9AQCXfRS8mYALzaKQPn2cTSIuAagSHl5rioNz1KUNQvc7CvJKJ6ai5-QndZQ3BVafqdLFiqibzXdy4upjYcSrbouK35jZTuU71DIbfkAcNhR9o_iHaOvshfjGMuROOLcvbdT9rqltBGKAjjRuUpf0-GcBYZ_A_sK7gRAye7eSZw4qiVN2dGkKiM9fM7FYOEOHsT3hsJFlxfCap0rP3JWmLH45uaJu3bq5LzwD3Dy7mH-nh7cFXh4M4Pkr_gcasTwvowq1kxW_CZnla3Cdc_X11tPhQrq0d1ixgBdtjR3insJmTomLP3XvJsWhRwnHL-L0b02SUG1t9086UytNZPVpwNdMu-WQUrb-oRPDgl6VihqTgh8QBkJjEUF7t6zbP8QcWWjrb8ER4k8g6NZWSfS5gbOAhUNtB24ipTcrcuf9kI3nglkb4M8Na1tTLUjkzZVCJD-p5fnbgC13q8DZJMpM9mwXZ-Vv_qPNp1Vj52lNyHQno1N6Pi7Yr9fPfDbLKq4PKLFSCJIEb_rmaLGfBzmUN8JsV53UWTt-NyHy6CIZlWJ_zMDtgSHU5kBqnwu7JWbdai5STrcH0yAPcKRwajh8zdzck-Tgm9IIU41u6U8O0M5C6eEilHXmGvj3HF-eYt8cXk14CEVaaF76usofu49gw_TBK2iVHJ7LU4Z0xT-z7KeXiij74GoiVIy7-_QjeH79Z8v0f2LRzy0F3u3PvWYZEfS5Q2PL8_TFHmaZoezcAD2Ugn1v7QF1GQ1PBW6PgIBmEI1he4iZ4Fuojq8h7swxdmrGfy5iuHTqhp91rr-IOTIMskftvIR54VFeYP2i6sKaiCycDcbDvBTtlo7Uqicl-bjGGIfTHwVbjtQEJiKhnv7E0RwW8_mcxHQqmobDv_8E2gF8c7x_BRCKFCk-ifdDzAp0FT1l-MYSSf6NhCxQ2kxo4kqd_gbStlfyICL7ZrJxOFhBwrvXCKy4YBq7avFT7cFr_RzOSN0srM4pYTBmLyeqheIe2Hnfq_nD-YiF_HbttS7quzHIbugdxrxcfIU07wR2pQ3UAvbGn0mxbTGvKH-WgGgWGZiTWopNV9DI30LLNS-basHwiDpKWYD4fUOnLtk_ew280kK4M0ZKoaKB4p2PicvJlyYMcQVCZ76bx4c-3yjV2izTTDmfzQ7s8Ld_xqguUno1FsyFC4pT5Hm3ylmDOFlvx5YOf15wFZ4MZ5ALUzI3cyGEhVZliNGZ1LlDsM1IiX0k9WXK1q1CWei4jjM-MkM4MegSZr8zpGWBsSiB_eKqYcq8-viKOgFUyHhaLvgMgIBLowexTduiS0mQAxjJCpr2a_r7NMapILLe5wDG4RlIiRmOiH-_cYiMdm6HDT0tl2dS-9L2KtGGTWu5juGtBD3OLwmONverjqy9ijknI55Iz47CvZ7E7MgOQyU.";
        try {
            System.out.println(charsetName+"编码英文字符所占字节数:"+en.getBytes(charsetName).length);
            System.out.println(charsetName+"编码中文字符所占字节数:"+zh.getBytes(charsetName).length);
            System.out.println();
            long byteSize =zh.getBytes(charsetName).length;
//            byteSize =new Byte[10M*10]
            System.out.println(ByteToKbSize.fileSizeConver(byteSize));

        } catch (UnsupportedEncodingException e) {
            System.out.println("非法编码格式！");
        }

    }

}
