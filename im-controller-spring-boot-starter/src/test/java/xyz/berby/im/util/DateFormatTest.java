package xyz.berby.im.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DateFormatTest {

    /**
     * 测试json时间格式的转换
     */
    @Test
    public void testJsonDateFormat() {
        Map<String, Object> map = new HashMap<>();
        map.put("AA", new Date());
        String jsonString = JSON.toJSONString(map);
        map  = (Map<String, Object>) JSON.parse(jsonString);
        log.info(jsonString);
        System.out.println(map);
    }
}
