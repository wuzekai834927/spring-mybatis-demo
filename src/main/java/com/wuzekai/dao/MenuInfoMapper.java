package com.wuzekai.dao;

import com.wuzekai.dto.ModifyRoleMenuDTO;
import com.wuzekai.pojo.MenuInfo;
import com.wuzekai.pojo.RoleMenu;
import com.wuzekai.vo.MenuInfoVO;
import com.wuzekai.vo.MenuListVO;

import java.util.List;

public interface MenuInfoMapper {
    public List<MenuInfo> getMenu();

    public List<MenuInfoVO> listMenuByRoleId(int roleId);

    public int removeRoleMenuByMenuId(ModifyRoleMenuDTO modifyRoleMenuDTO);

    public List<RoleMenu> listRoleMenuByRoleId(ModifyRoleMenuDTO modifyRoleMenuDTO);

    public int addRoleMenuByRoleId(ModifyRoleMenuDTO  modifyRoleMenuDTO);

    public List<MenuListVO> listAllMenu();
}
