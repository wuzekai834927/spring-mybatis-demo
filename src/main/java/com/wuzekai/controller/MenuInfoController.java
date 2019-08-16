package com.wuzekai.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wuzekai.dto.ModifyRoleMenuDTO;
import com.wuzekai.service.MenuInfoService;
import com.wuzekai.vo.MenuListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menuinfo")
public class MenuInfoController {
    @Autowired
    MenuInfoService menuInfoService;

    @RequestMapping("/listMenuByRoleId")
    public Object listMenuByRoleId(@RequestParam int roleId){

        return menuInfoService.listMenuByRoleId(roleId);

    }
    @RequestMapping("/modifyRoleMenu")
    public Object modifyRoleMenu(@RequestBody ModifyRoleMenuDTO modifyRoleMenuDTO){

        return menuInfoService.updateRoleMenu(modifyRoleMenuDTO);
    }

    /**
     * 分页
     * @param pageNum
     * @return
     */
    @RequestMapping("/listAllMenu")
    public Object listAllMenu(@RequestParam(required = true,defaultValue = "1",value = "pageNum")Integer pageNum){
        //一页有多少条
        int defaultPageSize = 4;
        //初始化pageHelper对象
        PageHelper.startPage(pageNum,defaultPageSize);
        List<MenuListVO> menuListVOS = menuInfoService.listAllMenu();
        PageInfo<MenuListVO> menuListVOPageInfo = new PageInfo<MenuListVO>(menuListVOS);
        return menuListVOPageInfo;
    }




}
