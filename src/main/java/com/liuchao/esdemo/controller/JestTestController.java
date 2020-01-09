package com.liuchao.esdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.liuchao.esdemo.entity.User;
import com.liuchao.esdemo.es.EsSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JestTestController {
    @Autowired
    private EsSearch esSearch;
    @RequestMapping("findallLike")
    public JSONObject findallLike(@RequestParam("key")String key,
                                  @RequestParam("pageSize")int pageSize,
                                  @RequestParam("pageNum")int pageNum){
        JSONObject jsonObject = esSearch.allFind(key, pageSize, pageNum);
        return jsonObject;
    }
}
