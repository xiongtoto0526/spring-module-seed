package com.seasun.myseed.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.seasun.myseed.web.vo.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/apis/auth/wf/user/login",method = RequestMethod.POST)
    public ResponseEntity<?> testLogin(HttpServletRequest request, @RequestBody JSONObject body){
        logger.info("login successfull...");
        String userName = body.getString("username");
        String password = body.getString("password");
        JSONObject data = new JSONObject();
        data.put("id","9999");
        data.put("token","xh48sl33is");
        CommonResponse resp = new CommonResponse("0","success");
        resp.setData(data);
        return ResponseEntity.ok(resp);
    }

    @RequestMapping(value = "/apis/auth/wf/user/verify",method = RequestMethod.GET)
    public ResponseEntity<?> verifyUser(HttpServletRequest request){
        logger.info("begin verifyUser ...");
        return ResponseEntity.ok(new CommonResponse("0","success"));
    }

    @RequestMapping(value = "/apis/testGet",method = RequestMethod.GET)
    public ResponseEntity<?> testGet(HttpServletRequest request,  @RequestParam String a,@RequestParam String b){
        logger.info("begin testGet ...",a,b);
        return ResponseEntity.ok(new CommonResponse("0","success"));
    }

    @RequestMapping(value = "/apis/broadcast/hot-videos",method = RequestMethod.GET)
    public ResponseEntity<?> getHotVideos(HttpServletRequest request){
        logger.info("begin getHotVideos ...");
        JSONObject result = new JSONObject();
        result.put("code","success");
        JSONArray data = new JSONArray();
        for(int i=0;i<5;i++){
            JSONObject t1 = new JSONObject();
            t1.put("title","C++游戏引擎入门");
            t1.put("author","magojiro");
            t1.put("number","56万");
            t1.put("isLive",false);
            t1.put("source","https://facebook.github.io/react/img/logo_og.png");
            t1.put("url","www.baidu.com");
            data.add(t1);
            JSONObject t2 = new JSONObject();
            t2.put("title","Java入门");
            t2.put("author","magojiro");
            t1.put("number","40.5万");
            t2.put("isLive",false);
            t2.put("source","https://facebook.github.io/react/img/logo_og.png");
            t2.put("url","www.baidu.com");
            data.add(t2);
        }
        result.put("data",data);
        return ResponseEntity.ok(result);
    }


    @RequestMapping(value = "/apis/testPost",method = RequestMethod.POST)
    public ResponseEntity<?> testPost(HttpServletRequest request,  @RequestBody JSONObject body){
        logger.info("begin testPost ...",body);
        return ResponseEntity.ok(new CommonResponse("0","success"));
    }

}
