package com.wuzekai.pojo;

import lombok.Data;


public class RoleMenu {

    int rmid;
    int roleid;
    int mid;

    public int getRmid() {
        return rmid;
    }

    public void setRmid(int rmid) {
        this.rmid = rmid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "rmid=" + rmid +
                ", roleid=" + roleid +
                ", mid=" + mid +
                '}';
    }
}
