package com.wuzekai.dao;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.wuzekai.dto.SearchUserInfoDTO;
import com.wuzekai.pojo.MenuInfo;
import com.wuzekai.pojo.UserInfo;

import java.util.List;

public interface UserInfoMapper {

    public List<MenuInfo> userLoginInit(UserInfo userInfo);
    //删除
    public int deleteUserById(int id);

    public int selectByName(String username);
    //注册
    public int add(UserInfo userInfo);
    //登录
    public UserInfo login(UserInfo userInfo);
    //查询所有
    public List<UserInfo> listAllUser(SearchUserInfoDTO searchUserInfoDTO);

    //修改
    public int updateUser(UserInfo userInfo);

    //查询一个用户
    public UserInfo selectOneById(int id);
}
