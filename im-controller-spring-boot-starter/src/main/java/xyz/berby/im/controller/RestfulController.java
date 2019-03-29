package xyz.berby.im.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author litianfeng
 * Created on 2018/11/5
 * 这里要返回json字符串，而不能直接返回对象
 * 主要的原因为去掉了jackjson的依赖了
 */
@RestController
@RequestMapping("/rest")
public class RestfulController extends AbstractRestfulController{

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/te", method = {RequestMethod.POST})
    public Object handleHttpRequest(HttpServletRequest httpServletRequest) {
        httpServletRequest.getParameterMap();
        return "fdfdfdfdfffd";
    }

    @RequestMapping(
            value = "/{service}/{operate}",
            produces = "application/json; charset=utf-8"
    )
    @CrossOrigin(origins = {"localhost:3000", "*"})
    public Object getCommonDeal(@PathVariable String service
            , @PathVariable String operate
            , HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse
            , @RequestBody(required = false) String string, MultipartFile[] files) throws Exception {
        long a = System.currentTimeMillis();
        Object body = super.getCommandDeal(service, operate
                , httpServletRequest, httpServletResponse
                , string, files);
        System.out.println("耗时：" + (System.currentTimeMillis() - a) + "ms");
        return JSON.toJSONString(body);
    }

    /**
     * <pre>
     *          解析方式二：
     *         for (String key: object.keySet()) {
     *             Object value = object.get(key);
     *             // jsonArray类型处理
     *             if (value instanceof JSONArray) {
     *                 JSONArray array = (JSONArray) value;
     *                 String[] strings = new String[array.size()];
     *                 for (int i = 0; i < strings.length; i++) {
     *                     strings[i] = array.getString(i);
     *                 }
     *                 map.put(key, strings);
     *             }
     *             // JSONObject类型处理
     *             else if (value instanceof JSONObject) {
     *                 map.put(key, new String[] {object.getString(key)});
     *             }
     *         }
     * </pre>
     * @param string 未解析的数据
     * @return
     */
    @Override
    Map<String, String[]> handleString(String string) {
        Map<String, String[]> map = new HashMap<>();
        JSONObject object = JSON.parseObject(string);
        // 解析方式一：
        for (String key: object.keySet()) {
            map.put(key, new String[] {object.getString(key)});
        }

        return map;
    }

}
