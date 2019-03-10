package xyz.berby.im.security;

/**
 * @author LTF
 * 加解密
 * Created on 2019/2/10
 */
public interface Security {

    String decryptMessage(String cipher);

    String encryptMessage(String plain);

    void refresh();
}
