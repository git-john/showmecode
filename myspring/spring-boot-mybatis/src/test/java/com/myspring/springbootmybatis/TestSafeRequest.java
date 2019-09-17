package com.myspring.springbootmybatis;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mysql.cj.util.StringUtils;
import org.junit.Test;
import org.mockito.internal.util.StringUtil;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.KeyPair;
import java.util.*;

/**
 * @Author: kangq
 * @Date: 2019/9/17 9:48
 */
public class TestSafeRequest {

    private static final String signSecret = "rVEsUafsTV11J1dl";
    private static final String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK50mDdmjyOTa+F1+ExjEUK5uWyzx04BxA7BFh4MW0Upa1zI0ilNmQEWCab+N7wW1E31BKe3nrtPoP86SqGj7VATrsj0NdL44VZhcYWFpNK7WNudrFXSbICQ7EiGhIEwIDWlnaMiUShmUEXqBtlWv8CSEHmk5zyn4Dgf1VdPMO6ZAgMBAAECgYBgIL7/R/P3lnQLeAWpka0hJ1WVIDriMPbnal3VkNl58qjGJ6ImQCve/VW0PsBXU/0IN8qo3/UHIYmFGYmmJ73LRgQ5Do1LpA/nNsIsFQQnuFwQ/hReYOhiNN49HlFkhxglXq2oWdUH0v7DxtVs1AITFEoACslHlykR9SNG4+jWQQJBAPj8uYMcE/huGh8Gv+MvbMaX+bsI1xQVb5KKne7wBp70pVcii3rkdZQAhxN7kO9KfvnYfHJLdQ03J8CjqQZ4AOsCQQCzXnkFTUg8e8aXMT7VuZb69wh9xBK5wVLMssBH2lQOTSmb0K2pfBzRIWuLZD0bsq6qDBAbEEAO6o8UhfvQ1Y2LAkByqcgxFewoe2PyJ+SUllGMv45VUQPjjt+b59RFpioWZ+oAz7rWNIHlT7zk/wHHAVKqcsUUyaU1GdJnx7becMNTAkEAgDahjzak0gcv91cOMTvOPmpiuXN0Zy9XflavtyzLNMXXXjeWSzYaayrWcvcd7zSUQZ0Jzi6Ze5AS4nq7e5WK7QJAKvWudYc5sfB/S4LFy/qcQsysSa8G3LBYCKYJl8WPe7fBmmRxwSdY7F/+hyrYMvV570oZuhD8xsgQ8PBK4baUrg==";
    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCudJg3Zo8jk2vhdfhMYxFCublss8dOAcQOwRYeDFtFKWtcyNIpTZkBFgmm/je8FtRN9QSnt567T6D/Okqho+1QE67I9DXS+OFWYXGFhaTSu1jbnaxV0myAkOxIhoSBMCA1pZ2jIlEoZlBF6gbZVr/AkhB5pOc8p+A4H9VXTzDumQIDAQAB";

    @Test
    public void testSafeRequest() throws Exception{
//        Map<String, String> params = new HashMap();
        JSONObject params = new JSONObject();
        params.put("azdm", "1001");
        params.put("xtlb", "1001");
        params.put("sjkip", "172.100.0.101");

        //生成签名
        String sign = genSign(params);
        params.put("sign", sign);

        //RSA使用公钥加密请求参数json字符串
        RSA rsa = new RSA(null, publicKey);
        System.out.println(params.toString());
        byte[] enc = rsa.encrypt(params.toString().getBytes("UTF-8"), KeyType.PublicKey);
        String requestBody = Base64.encode(enc, Charset.forName("UTF-8"));

        System.out.println("=============================\n\n"+requestBody +"\n\n==========================");
        requestBody = URLEncoder.encode(requestBody, "utf-8");
        System.out.println("=============================\n\n"+requestBody +"\n\n==========================");

        String response = HttpUtil.createPost("http://localhost:8080/safePost").body(requestBody).execute().body();
        System.out.println(response);
    }

    @Test
    public void testEncDec() throws Exception{
        RSA rsa = new RSA(null, publicKey);
        byte[] enc = rsa.encrypt("test".getBytes("UTF-8"), KeyType.PublicKey);
        String encStr = Base64.encode(enc, Charset.forName("UTF-8"));
        System.out.println(encStr+"\n\n===========");

        RSA rsa2 = new RSA(privateKey, null);
        byte[] dec = rsa2.decrypt(Base64.decode(encStr, Charset.forName("UTF-8")), KeyType.PrivateKey);
        System.out.println(new String(dec));
    }

    @Test
    public void testDecode() throws Exception{
        String params = "ap0dAhvAwcaAP%2F4J%2Fhzt3FGD9xmLYS5WavGcFGqjSgZ4wvsiAyhIr+p56an0437OkRaM+Hm1xy7xgvl07sVWZg3hqWMmNrXw%2FIgohYAXVTGNgzrIV6xgpI1yAbKO8LUPQlDHQEiqznM%2F3fS7HV42HfFXqgJGZDWxK2lszO0nngY=";
        String result = URLDecoder.decode(params, "UTF-8");
        System.out.println(result);
    }

    private String genSign(JSONObject params){
        List<String> keys = new ArrayList<String>(params.keySet());
        //参数按ASCII排序
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        //拼接参数key1=value1&key2=value2
        for (String key : keys) {
            sb.append(key).append("=").append(params.get(key)).append("&");//拼接字符串
        }
        //直接拼接签名秘钥
        String originStr = sb.toString() + signSecret;
        //md5算法生成数字签名
        String sign = SecureUtil.md5(originStr);
        return sign;
    }

    @Test
    public void genRsaKey(){
        KeyPair pair = SecureUtil.generateKeyPair("RSA", 1024);
        String privateKey = Base64.encode(pair.getPrivate().getEncoded());
        System.out.println(privateKey);
        String publicKey = Base64.encode(pair.getPublic().getEncoded());
        System.out.println("========================\n\n"+publicKey);
    }
}
