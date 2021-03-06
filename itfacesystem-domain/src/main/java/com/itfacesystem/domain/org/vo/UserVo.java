package com.itfacesystem.domain.org.vo;


import com.itfacesystem.domain.common.BaseDomain;

/**
 * Created by wangrongtao on 15/10/18.
 */
public class UserVo extends BaseDomain {
    private long id;
    private String name;
    /**
     * 手机号
     */
    private String userid;
    /**
     * 帐号状态,预留，0是正常，-1锁定
     */
    private int status;
    private String roleids;
    private String rolenames;
    private Long orgid;
    private String orgname;
    /**
     * 0代表密码验证，1代码短信验证
     */
    private int logintype;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRoleids() {
        return roleids;
    }

    public void setRoleids(String roleids) {
        this.roleids = roleids;
    }

    public String getRolenames() {
        return rolenames;
    }

    public void setRolenames(String rolenames) {
        this.rolenames = rolenames;
    }

    public Long getOrgid() {
        return orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }

    public int getLogintype() {
        return logintype;
    }

    public void setLogintype(int logintype) {
        this.logintype = logintype;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }
}
