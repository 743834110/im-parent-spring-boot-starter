package xyz.berby.im.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.json.JSONUtil;
import xyz.berby.im.vo.AccessToken;

public class JwtUtil {


    /**
     * 签发JWT,使用公钥
     *
     * @param subject   可以是JSON数据 尽可能少
     * @param ttlMillis 持续时间
     * @return String
     */
    public static String createJWT(String subject, long ttlMillis, String publicKeyBase64) {
        RSA rsa = SecureUtil.rsa(null, publicKeyBase64);
        long currentTimeMillis = System.currentTimeMillis();
        AccessToken token = AccessToken.builder()
                .subject(subject)
                .issuedAt(currentTimeMillis)
                .expiration(currentTimeMillis + ttlMillis)
                .build();
        return rsa.encryptBase64(JSONUtil.toJsonStr(token), KeyType.PublicKey);
    }

    /**
     * 验证JWT，使用私钥
     * 如token正确，将返回可用对象，否则返回为null
     *
     * @param jwtStrBase64 token字符串
     * @return t
     */
    public static String validateJWT(String jwtStrBase64, String privateKeyBase64) {
        try {
            RSA rsa = SecureUtil.rsa(privateKeyBase64, null);
            String tokenString = new String(rsa.decryptFromBase64(jwtStrBase64, KeyType.PrivateKey));
            AccessToken token = JSONUtil.toBean(tokenString, AccessToken.class);
            long currentTimeMillis = System.currentTimeMillis();
            // 过期，返回null
            if (token.getExpiration() < currentTimeMillis) {
                return null;
            }
            return token.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
