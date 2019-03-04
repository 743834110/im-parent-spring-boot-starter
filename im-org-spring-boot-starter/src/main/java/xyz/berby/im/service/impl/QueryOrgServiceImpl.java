package xyz.berby.im.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import xyz.berby.im.annotation.Validate;
import xyz.berby.im.entity.ServerConfig;
import xyz.berby.im.entity.User;

import java.util.List;
import java.util.Map;

@Service("queryOrgService")
@Slf4j
public class QueryOrgServiceImpl {

    public void queryServerConfig(List<ServerConfig> configs) {
       System.out.println(configs);
    }

    @Validate("I'm zero")
    public Object upload(Map<String, String[]> map, MultipartFile[] files, User user) {

        return "I am zero";
    }
}
