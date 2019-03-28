package xyz.berby.im.util;

/**
 * 判断请求发起者应用工具类
 * @author LTF
 * Created on 2019/3/24
 */
public class RequestDeviceUtil {

    /**
     * android : 所有android设备
     * mac os : iphone ipad
     * windows phone:Nokia等windows系统的手机
     * @param  requestHeader
     * 当请求头为空时表示不是移动设备
     * 当请求头包含android mac os 或 windows phone时则为移动端应用请求
     */
    public static boolean  isMobileDevice(String requestHeader) {
        String[] deviceArray = new String[]{"android", "mac os", "windows phone"};
        if (requestHeader == null)
            return false;
        requestHeader = requestHeader.toLowerCase();
        for (int i = 0; i < deviceArray.length; i++) {
            if (requestHeader.indexOf(deviceArray[i]) > 0) {
                return true;
            }
        }
        return false;
    }
}
