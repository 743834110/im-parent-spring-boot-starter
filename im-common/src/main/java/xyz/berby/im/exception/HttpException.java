package xyz.berby.im.exception;

/**
 * @author LTF
 * 带有http状态号码
 * Created on 2019/
 */
public class HttpException extends RuntimeException {
    /**
     * http状态码
     */
    private int status;

    public HttpException(String s, int status) {
        super(s);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
