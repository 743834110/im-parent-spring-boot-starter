package xyz.berby.im.vo;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * http响应对象
 * @author litianfeng
 * Created on 2018/11/4
 */
public class RespBody {


    /**
     * http状态码
     */
    private int status;
    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private Object data;

    public RespBody(Object data, HttpServletResponse response) {
        this.data = data;
        this.status = HttpStatus.OK.value();
        if (response != null) {
            response.setStatus(this.status);
        }
    }

    public RespBody(String message, HttpServletResponse response) {
        this.message = message;
        this.status = HttpStatus.NOT_FOUND.value();
        if (response != null) {
            response.setStatus(this.status);
        }
    }

    public RespBody(int status, String message, HttpServletResponse response) {
        this.message = message;
        this.status = status;
        if (response != null) {
            response.setStatus(this.status);
        }
    }

    public RespBody(int status, HttpServletResponse response) {
        this.status = status;
        if (response != null) {
            response.setStatus(status);
        }
    }







    public Object getData() {
        return data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "RespBody{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
