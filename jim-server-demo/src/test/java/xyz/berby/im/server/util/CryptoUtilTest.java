package xyz.berby.im.server.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.AsymmetricAlgorithm;
import cn.hutool.crypto.asymmetric.AsymmetricCrypto;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.AES;
import com.jfinal.kit.AesKit;
import com.jfinal.kit.Base64Kit;
import com.jfinal.kit.HashKit;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.rsa.RSAPrivateCrtKeyImpl;
import sun.security.rsa.RSAPrivateKeyImpl;
import sun.security.util.DerValue;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;

/**
 * Created by Administrator on 2018/10/27.
 */
public class CryptoUtilTest {


    private String cipher = "gU7W7sr5ut53eoXq3hBCguI0DY/LCLccs62PJMMOvz7bNfo1FdwNDlJefWSgEAJZx3rzaAgh8fnA06ndsWKFih0uyWpItkBiQt+L4oAiqwla0xC+fgYb5hFCdZ7EwyE8dCTvaD/JO/6vgEb7Bkq4J0SFEAOfBQF3Ftkba/00LXk=";
    private String privateKeyBase64 = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJPXkskscU1DLB8u00nngR1gNmA5wy7pAhcPDVWFdgj2Zojde6o3q+auGOnSmhYY3vIyaRhIdv6SGLgFBwEBs/oRnFmMy9YcFNWAvPrqV6qf0RotUyZ11JR6HDqD1lvpjEJGqVsiKxSNwPodFY4zzor6pZBaavT7Xv6436jG0B8vAgMBAAECgYAntuAqhHLHQ4Ult0lw7+yCPKc+wCWLg3JZSWTWlWx4yeAPYhfnSN83r4rnvPhBeVriiuIqcMTua8aSIF+aSJ/U418ihFcWBJpO2wviZO4IosR42GjgZrZPPTpKdkffxJ2XoZcOslMif2lV5XTbjx0qHgR8WEFP/8cWv+Y/HxAhaQJBANQRpCiUKZrKQ4+/1jYYf7P7Q0i7bkvaUrqm5WacJnY2JnJYyxno/r5+UbmSuOuil21NbNsAdguYXo0iC0iSMEMCQQCyd+ERE3I6Wp32PfZR6X8alYdeP9lS/QF/GvK4IZbxZ4aPXUDGx/DO/Iywxc9sFAcMpRJQSuTTjMXKGINBjqylAkB7ypB434Qpx0gI8YKpsUNaXKG6Iy8PODJyolnmu9/3wURQG2Tziv6pVDOAkBVB93dNZpTUgkBmJFuNJwJPKobhAkAUZjV4oTNmTiNOGSkFld3saPkPIdcycC7ym17xAw3gzAeKbYtQ7VuuHRnrvsCFxwhDPr8IJHdhYu7cuc6O+MLtAkEAnrxh+KXs1026gNk7/TDduYmBNdf0ZfBwSDo38y9oMi9atlrCAsNj2LjJNsjnnOGRbomGuvJeU73Czlk10nNKkg==";
    private String publicKeyBase64 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCT15LJLHFNQywfLtNJ54EdYDZgOcMu6QIXDw1VhXYI9maI3XuqN6vmrhjp0poWGN7yMmkYSHb+khi4BQcBAbP6EZxZjMvWHBTVgLz66leqn9EaLVMmddSUehw6g9Zb6YxCRqlbIisUjcD6HRWOM86K+qWQWmr0+17+uN+oxtAfLwIDAQAB";

    @Test
    public void testCrypto() throws InvalidKeyException, IOException {
        RSA rsa = SecureUtil.rsa();
        System.out.println(rsa.getPrivateKeyBase64());
        System.out.println(rsa.getPublicKeyBase64());
    }

    @Test
    public void testDecrypt() {

        RSA rsa = SecureUtil.rsa(privateKeyBase64, publicKeyBase64);
        String cipher = "UueBpmjJbkaHhfeSCOeOOPG8V4eQuHb8UbvndFrUQvGEev/dwDMh7MBNDJsixjWaU5NYOE3lWyR8ovTtoK3f5UsFE8zrk1P/vM4d/eje8Pau7oE0oXvhoIjQJV9tWQjKZC4/xkRCd5bGfjiCybTgLvOM+VLwfZZBFnsFmF1LHXk=";
        long a = System.currentTimeMillis();
        byte[] messageBytes = rsa.decryptFromBase64(cipher, KeyType.PrivateKey);
        System.out.println(System.currentTimeMillis() - a);
    }
}
