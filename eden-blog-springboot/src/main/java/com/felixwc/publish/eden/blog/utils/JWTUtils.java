package com.felixwc.publish.eden.blog.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * in order to learn java!
 * created at 2022/6/17 21:08
 *
 * @author felixwc
 */
public class JWTUtils {

    /**
     * 获取token中的参数
     *
     * @param token - 用户携带的token
     * @return 用户的封装的信息
     */
    public static Claims parseToken(String token, String key) {
        if ("".equals(token)) {
            return null;
        }
        try {
            return Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(key))
                    .parseClaimsJws(token).getBody();
        } catch (Exception ex) {
            return null;
        }
    }

    public static String createToken(Map<String, String> map, String key, int expireMinutes) {
        // 设置签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder();
        // 设置载荷信息
        map.forEach((mapKey,str)->builder.claim(mapKey,str));
        builder.setExpiration(new Date(new Date().getTime() +(long) expireMinutes * 60 * 1000))// 设置超时时间
                .signWith(signatureAlgorithm, signingKey);

        //生成JWT
        return builder.compact();
    }

}
