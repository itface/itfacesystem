package com.itfacesystem.domain.org;

import java.io.Serializable;

/**
 * Created by wangrongtao on 15/10/13.
 */
public class UserRole implements Serializable{

    private long id;
    private String userid;
    private long roleid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public long getRoleid() {
        return roleid;
    }

    public void setRoleid(long roleid) {
        this.roleid = roleid;
    }
}
