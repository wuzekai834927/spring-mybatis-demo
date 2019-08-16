package com.wuzekai.service;

import com.wuzekai.dto.ModifyRoleMenuDTO;
import com.wuzekai.vo.MenuInfoVO;
import com.wuzekai.vo.MenuListVO;

import java.util.List;

public interface MenuInfoService {
    public List<MenuInfoVO> listMenuByRoleId(int roleId);

    public boolean updateRoleMenu(ModifyRoleMenuDTO modifyRoleMenuDTO);

    public List<MenuListVO> listAllMenu();
}
