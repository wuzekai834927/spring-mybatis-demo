package com.wuzekai.service.impl;

import com.wuzekai.dao.RoleInfoMapper;
import com.wuzekai.dto.UserRoleDTO;
import com.wuzekai.service.RoleInfoService;
import com.wuzekai.vo.RoleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RoleInfoServiceImpl implements RoleInfoService {
    @Autowired
    RoleInfoMapper roleInfoMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<RoleInfoVO> listRoleByUserId(int userid) {
        return roleInfoMapper.listRoleByUserId(userid);

    }

    @Transactional
    public boolean addUserRole(UserRoleDTO userRoleDTO) {
        return roleInfoMapper.addUserRole(userRoleDTO)>0;
    }
    @Transactional
    public boolean removeUserRole(UserRoleDTO userRoleDTO) {
        return roleInfoMapper.removeUserRole(userRoleDTO)>0;
    }
}
