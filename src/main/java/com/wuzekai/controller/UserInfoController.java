package com.wuzekai.controller;


import com.wuzekai.dto.SearchUserInfoDTO;
import com.wuzekai.pojo.MenuInfo;
import com.wuzekai.pojo.UserInfo;
import com.wuzekai.service.UserInfoService;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by DELL on 2019/7/30.
 */
//@RestController
//RestController不但是一个控制器,还是一个符合restful风格的网络接口
//声明这个类是一个控制器 同时因为扒皮喊了@Component注解,这个类也是一个组件,能被spring扫描并加载到容器中
@Controller
public class UserInfoController {
    //自动注入
    @Autowired
    UserInfoService userInfoService;
    //请求映射
    @RequestMapping("loginUserInfo")
    @ResponseBody
    public Object loginUserInfo(@RequestBody UserInfo userInfo , HttpSession session){
        UserInfo userInfo1 = userInfoService.login(userInfo);
        //登录成功
        if(userInfo1!=null){
            session.setAttribute("userInfo",userInfo1);
            //缓存
            List<MenuInfo> menuInfoList = userInfoService.userLoginInit(userInfo);
            session.setAttribute("menuInfoList",menuInfoList);
        }else{
            //登录失败
        }

        return userInfo1!=null;
    }

    @RequestMapping("registerUserInfo")
    @ResponseBody
    public Object registerUserInfo(@RequestBody UserInfo userInfo){
        boolean add= userInfoService.add(userInfo);
        return add;
    }
                                        //只接受post请求
    @RequestMapping(value = "listAllUser",method = RequestMethod.POST)
    @ResponseBody
    public Object listAllUser(@RequestBody SearchUserInfoDTO searchUserInfoDTO){
        return this.userInfoService.listAllUser(searchUserInfoDTO);
    }

    @RequestMapping("removeById")
    @ResponseBody
   public Object removeById(@RequestParam int userid){
       boolean b = userInfoService.deleteUserById(userid);
       return b;
   }

   @RequestMapping("updateUser")
   @ResponseBody
   public Object updateUser(@RequestBody UserInfo userInfo){
       boolean b = userInfoService.updateUser(userInfo);
       return b;
   }
    @RequestMapping("selectOneById")
    @ResponseBody
   public Object selectOneById(@RequestParam int userid){
       UserInfo userInfo1 = userInfoService.selectOneById(userid);
       return userInfo1;
   }

    @RequestMapping("initMenuList")
    @ResponseBody
    public Object initMenuList(@RequestBody(required = false) UserInfo userInfo, HttpSession session){
        if(session.getAttribute("menuInfoList")==null){
            if(userInfo!=null){
                return userInfoService.userLoginInit(userInfo);
            }else {
                return null;
            }
        }else{
            return session.getAttribute("menuInfoList");
        }
    }

    @RequestMapping("pathVariableTest/{uname}-{password}")
    public Object pathVariableTest(@PathVariable("uname") String uname,@PathVariable("password") String password){
        System.out.println(uname+":"+password);
        return uname+":"+password;
    }

    @RequestMapping("getCookieValue")
    public Object getCookieValue(@CookieValue(name="name", required = false) String username){
        return username;
    }

}
