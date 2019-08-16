package com.wuzekai.service;

import com.wuzekai.dto.SearchUserInfoDTO;
import com.wuzekai.pojo.MenuInfo;
import com.wuzekai.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {

    public boolean deleteUserById(int id);

    public UserInfo login(UserInfo userInfo);
    public boolean add(UserInfo userInfo);

    public List<UserInfo> listAllUser(SearchUserInfoDTO searchUserInfoDTO);

    public boolean updateUser(UserInfo userInfo);

    public UserInfo selectOneById(int id);

    public List<MenuInfo> userLoginInit(UserInfo userInfo);
}
