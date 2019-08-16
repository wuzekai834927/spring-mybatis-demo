package com.wuzekai.vo;

import lombok.Data;

@Data
public class MenuListVO {

    int mid;
    String menuname;
    String menuicon;
    String menu_url;
    int parentid;
    boolean isParentMenu;
}
