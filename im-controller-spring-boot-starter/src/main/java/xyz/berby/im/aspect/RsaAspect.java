package xyz.berby.im.aspect;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import xyz.berby.im.constant.Constant;
import xyz.berby.im.property.DefaultSettingProperty;
import xyz.berby.im.security.Security;

import java.util.Map;

@Component
@Lazy
@ConditionalOnProperty(prefix = "default.server.setting", name = "securityAlgorithm", havingValue = "RSA")
public class RsaAspect implements Security {

    private Map<String, Object> setting;

    private RSA rsa;


    @Autowired
    public RsaAspect(DefaultSettingProperty defaultSetting) {
        this.setting = defaultSetting.getSetting();
    }

    /**
     * 使用私钥进行解密操作
     * @param cipher 密文
     * @return
     */
    @Override
    public String decryptMessage(String cipher) {
        if (cipher == null)
            return null;
        return new String(this.rsa.decryptFromBase64(cipher, KeyType.PrivateKey));
    }

    /**
     * 使用私钥进行加密操作（数字签名）
     * @param plain 明文
     * @return
     */
    @Override
    public String encryptMessage(String plain) {
        if (plain == null)
            return null;
        return this.rsa.encryptBase64(plain, KeyType.PrivateKey);
    }

    @Override
    public void refresh() {
        String privateKey = (String) setting.get(Constant.PRIVATE_KEY);
        String publicKey = (String) setting.get(Constant.PUBLIC_KEY);
        this.rsa = SecureUtil.rsa(privateKey, publicKey);
    }
}
