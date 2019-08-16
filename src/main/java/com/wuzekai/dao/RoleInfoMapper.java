package com.wuzekai.dao;

import com.wuzekai.dto.UserRoleDTO;
import com.wuzekai.pojo.RoleInfo;
import com.wuzekai.vo.RoleInfoVO;

import java.util.List;

public interface RoleInfoMapper {
    public RoleInfo getAll(int id);


    public List<RoleInfoVO> listRoleByUserId(int userid);

    public int addUserRole(UserRoleDTO userRoleDTO);

    public int removeUserRole(UserRoleDTO userRoleDTO);
}
