package com.wuzekai.service.impl;

import com.wuzekai.dao.UserInfoMapper;
import com.wuzekai.dto.SearchUserInfoDTO;
import com.wuzekai.pojo.MenuInfo;
import com.wuzekai.pojo.UserInfo;
import com.wuzekai.service.UserInfoService;
import com.wuzekai.toolkit.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//声明这是一个服务，同时是一个组件
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    public List<UserInfo> listAllUser(SearchUserInfoDTO searchUserInfoDTO) {
        List<UserInfo> userInfos = userInfoMapper.listAllUser(searchUserInfoDTO);
        return userInfos;
    }

    public boolean updateUser(UserInfo userInfo) {
        return this.userInfoMapper.updateUser(userInfo)>0;
    }

    public UserInfo selectOneById(int id) {
        UserInfo userInfo1 = this.userInfoMapper.selectOneById(id);
        return userInfo1;
    }

    //对该方法执行事务处理，传播级别为REQUIRED
    //@Transactional(propagation= Propagation.REQUIRED)


    public boolean deleteUserById(int id) {
        int i = userInfoMapper.deleteUserById(id);
        return i>0;
    }

    public UserInfo login(UserInfo userInfo) {
//        String newPassword = Md5.encodePassword(userInfo.getPassword());
//        userInfo.setPassword(newPassword);
        UserInfo userInfo1 = userInfoMapper.login(userInfo);
        return userInfo1;
    }

    public boolean add(UserInfo userInfo) {
//        String newPassword = Md5.encodePassword(userInfo.getPassword());
//        userInfo.setPassword(newPassword);

        return userInfoMapper.add(userInfo)>0;
    }

    public List<MenuInfo> userLoginInit(UserInfo userInfo) {
        return this.userInfoMapper.userLoginInit(userInfo);
    }
}
