package xyz.berby.im.service.impl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.berby.im.entity.ServerConfig;

import java.util.List;

@Service("queryOrgService")
public class QueryOrgServiceImpl {

    public void queryServerConfig(List<ServerConfig> configs) {
       System.out.println(configs);
    }
}
