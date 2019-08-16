package com.wuzekai.controller;

import com.wuzekai.dto.UserRoleDTO;
import com.wuzekai.service.MenuInfoService;
import com.wuzekai.service.RoleInfoService;
import com.wuzekai.vo.MenuInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoleInfoController {
    @Autowired
    RoleInfoService roleInfoService;

    @Autowired
    MenuInfoService menuInfoService;

    @RequestMapping("listRoleInfoByUserId")
    @ResponseBody
    public Object listRoleInfoByUserId(@RequestParam int userid){
        return roleInfoService.listRoleByUserId(userid);
    }

    @RequestMapping("insertUserRole")
    @ResponseBody
    public Object insertUserRole(@RequestBody UserRoleDTO userRoleDTO){

            return roleInfoService.addUserRole(userRoleDTO);

    }
    @RequestMapping("removeUserRole")
    @ResponseBody
    public Object removeUserRole(@RequestBody UserRoleDTO userRoleDTO){
        return roleInfoService.removeUserRole(userRoleDTO);
    }
    //根据roleid做获取一个集合，其中包含所有的菜单及被选择的菜单
    @RequestMapping("listMenuByRoleId")
    @ResponseBody
    public Object listMenuByRoleId(@RequestParam int roleId){
        return menuInfoService.listMenuByRoleId(roleId);
    }
}
