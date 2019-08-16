package com.wuzekai.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuInfoVO {
    int id;
    int pid;
    int seqno;
    String name;
    String url;
    String icon;
    boolean open = true;
    boolean checked = true;
    List<MenuInfoVO> children = new ArrayList<MenuInfoVO>();

    public void appendChild(MenuInfoVO menuInfoVO){
        this.children.add(menuInfoVO);
    }

}
