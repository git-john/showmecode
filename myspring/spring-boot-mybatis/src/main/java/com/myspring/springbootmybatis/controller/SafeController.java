package com.myspring.springbootmybatis.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @Author: kangq
 * @Date: 2019/9/17 10:29
 */

@RestController
public class SafeController {

    private static final String signSecret = "rVEsUafsTV11J1dl";
    private static final String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK50mDdmjyOTa+F1+ExjEUK5uWyzx04BxA7BFh4MW0Upa1zI0ilNmQEWCab+N7wW1E31BKe3nrtPoP86SqGj7VATrsj0NdL44VZhcYWFpNK7WNudrFXSbICQ7EiGhIEwIDWlnaMiUShmUEXqBtlWv8CSEHmk5zyn4Dgf1VdPMO6ZAgMBAAECgYBgIL7/R/P3lnQLeAWpka0hJ1WVIDriMPbnal3VkNl58qjGJ6ImQCve/VW0PsBXU/0IN8qo3/UHIYmFGYmmJ73LRgQ5Do1LpA/nNsIsFQQnuFwQ/hReYOhiNN49HlFkhxglXq2oWdUH0v7DxtVs1AITFEoACslHlykR9SNG4+jWQQJBAPj8uYMcE/huGh8Gv+MvbMaX+bsI1xQVb5KKne7wBp70pVcii3rkdZQAhxN7kO9KfvnYfHJLdQ03J8CjqQZ4AOsCQQCzXnkFTUg8e8aXMT7VuZb69wh9xBK5wVLMssBH2lQOTSmb0K2pfBzRIWuLZD0bsq6qDBAbEEAO6o8UhfvQ1Y2LAkByqcgxFewoe2PyJ+SUllGMv45VUQPjjt+b59RFpioWZ+oAz7rWNIHlT7zk/wHHAVKqcsUUyaU1GdJnx7becMNTAkEAgDahjzak0gcv91cOMTvOPmpiuXN0Zy9XflavtyzLNMXXXjeWSzYaayrWcvcd7zSUQZ0Jzi6Ze5AS4nq7e5WK7QJAKvWudYc5sfB/S4LFy/qcQsysSa8G3LBYCKYJl8WPe7fBmmRxwSdY7F/+hyrYMvV570oZuhD8xsgQ8PBK4baUrg==";
    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCudJg3Zo8jk2vhdfhMYxFCublss8dOAcQOwRYeDFtFKWtcyNIpTZkBFgmm/je8FtRN9QSnt567T6D/Okqho+1QE67I9DXS+OFWYXGFhaTSu1jbnaxV0myAkOxIhoSBMCA1pZ2jIlEoZlBF6gbZVr/AkhB5pOc8p+A4H9VXTzDumQIDAQAB";


    @RequestMapping(value = "/safePost", method = RequestMethod.POST)
    public String safePost(@RequestBody String paramStr) throws Exception{
        System.out.println("======================\n\n" + paramStr + "\n\n===============================");
        paramStr = URLDecoder.decode(paramStr, "UTF-8");
        System.out.println("======================\n\n" + paramStr + "\n\n===============================");
        //RSA私钥解密
        RSA rsa = new RSA(privateKey, null);
        byte[] decrypt = rsa.decrypt(Base64.decode(paramStr, Charset.forName("UTF-8")), KeyType.PrivateKey);

        //验证数字签名
        JSONObject params = new JSONObject(new String(decrypt));
        if(!params.containsKey("sign")){
            return "非法請求";
        }

        if(!validSign(params)){
            return "非法請求";
        }

        return "success";
    }

    private boolean validSign(JSONObject jsonObject){
        List<String> keys = new ArrayList<String>(jsonObject.keySet());
        //排除sign参数
        keys.remove("sign");
        //参数按ASCII排序
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        //拼接参数key1=value1&key2=value2
        for (String key : keys) {
            sb.append(key).append("=").append(jsonObject.get(key)).append("&");
        }
        //直接拼接签名秘钥
        String originStr = sb.toString() + signSecret;
        //md5算法生成数字签名
        String sign = SecureUtil.md5(originStr);
        return sign.equals(jsonObject.get("sign"));
    }
}
