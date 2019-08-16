package com.wuzekai.service;

import com.wuzekai.dto.UserRoleDTO;
import com.wuzekai.vo.RoleInfoVO;

import java.util.List;

public interface RoleInfoService {
    public List<RoleInfoVO> listRoleByUserId(int userid);

    public boolean addUserRole(UserRoleDTO userRoleDTO);
    public boolean removeUserRole(UserRoleDTO userRoleDTO);
}
