package com.example.springboot1.controller;


import com.example.springboot1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

//当前类型注册实例到容器中，并指定为Web请求的处理
@Controller
//@RequestMapping可以定义请求相关的配置：如路径，请求方法等等
@RequestMapping("/user")
public class UserController {
//    @Autowired
//    private Map<Integer,Integer> test1;
//
//    @RequestMapping("test8")
//    @ResponseBody
//    public Object test8() {
//        throw new RuntimeException("数据库报错了");
//    }



//    @RequestMapping("test7")
//    @ResponseBody
//    public Object test7(@RequestBody User user) {// 请求数据类型为json时，解析请求体中的json字符串为java对象
//        System.out.println(user);  //User(username=abc, password=123)
//        return null;
//    }

    /*
    web 开发经常存在需求：
    （1）统一的处理异常
    （2）统一返回数据格式
    （3）统一会话管理（登录的敏感资源权限控制）
     */




//    @RequestMapping("test6")
//    @ResponseBody
//    //  http 请求是基于 Servlet 的，Spring 已经生成了 request 和 response对象，可以直接在参数中使用
//    public Object test6(HttpServletRequest req, HttpServletResponse res) {// Spring自动的将对象注入到参数
//        System.out.println(req.getParameter("username"));
//        System.out.println(req.getParameter("password"));
//        return null;
//    }



//    @Autowired
//    private Map<Integer,Integer> test1;
//    @RequestMapping("/test3")  // 默认是GET请求
//    @ResponseBody
//    public Object test3(User user){ // 请求数据自动映射到参数类型的属性中：username=xxx&password=xxx
//        System.out.println(user);
//        return test1;
//    }


//    @Autowired
//    private Map<Integer,Integer> test1;
//    // 请求GET /user/test2?k1=v1&k2=v2&k3=v3
//    @RequestMapping(value = "/test2",method = {RequestMethod.GET,RequestMethod.POST})
//    @ResponseBody
//    public Object test1(@RequestParam("k1") String k1,@RequestParam String k2,String k3){
//        System.out.println("*****" + k1+"****" +k2+"****" +k3);
//        return test1;
//    }



//    @Autowired
//    private Map<Integer,Integer> test1;
//    @RequestMapping("/test/{key}")  // 路径中使用变量占位符
//    @ResponseBody
//    public Object test1(@PathVariable("key") Integer k){
//        System.out.println("*****" + test1.get(k)+"****");
//        return test1;
//    }


//    @Autowired
//    private Map<Integer,Integer> test1;
//    @RequestMapping("/test/1")
//    @ResponseBody
//    public Object test1(){
//        return test1;
//    }
//


    // @Autowired 和 @Resource都可以装配 Bean
//    @Autowired
//    @Resource
//    private User user1;    // 变量名和 bean 的名称要一致，否则会报错

//    @Autowired
//    @Qualifier("user1")
//    private User user;  // // 变量名和 bean 的名称不一致，@Autowired要和 @Qualifier指定的bean名字搭配

    @Resource(name = "user1")  // 变量名和bean的名称不一致， @Resource要指定name为bean的名称
    private User user;
    @RequestMapping("/login")
    @ResponseBody
    public Object login(User user,HttpServletRequest req) {
        // 模拟用户登录，在数据库中校验密码
        if(!"abc".equals(user.getUsername())) {
            throw new RuntimeException("用户登录失败");
        }
        HttpSession session = req.getSession();
        session.setAttribute("user",user);
        return user;
    }
    @RequestMapping("/m")
    public String m() {
        return "/main.html";
    }


    @RequestMapping("/tt1")
    public String tt1() {
        return "forward:/user/login";   // 路径的转发
    }
    @RequestMapping("/tt2")
    public String tt2() {
        return "redirect:/user/login";   // 路径的重定向
    }

    @Autowired
    private Map<Integer,Integer> test1;
    @RequestMapping("/test4")
    @ResponseBody
    public Object test4(){
        // 配置 ControllerAdvice 时，不会进入重写响应体的方法
        return null;   //响应体为空
    }
    @RequestMapping("/test5")
    @ResponseBody
    public Object test5(){
        return "ok";  // 返回字符串 ok，响应体不是返回 json格式，而是字符串内容
    }




}
