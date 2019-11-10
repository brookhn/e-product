package com.pp.server.entity;

import java.io.Serializable;
import java.util.Date;

public class UserDo implements Serializable {
    private static final long serialVersionUID = 2383511114972323636L;

    private Integer id;

    private String userAccount;

    private String token;

    private String ykToken;

    private String ip;

    private Integer sex;    // '性别 0：男，1：女'

    private String phone;   // '手机号'

    private String mail;    // '邮箱'

    private Date birthday;  // '生日'

    private Date registerTime; // '注册时间'

    private String appPlt;  // '平台参数'

    private String appId;   // '平台id'

    private Integer isSvip; // 'svip  0：不是，1：是'

    private Date svipValidate; // 'svip有效时间'

    private String nick;    // 昵称

    private String facePic; // 头像

    private Date createTime;

    private Date updateTime;

    /** 用户类型：0普通，1测试，2VIP **/
    private Integer userType;

    private Integer primaryAccount;

    private String otherJson;


    private String uuid;
    private String mac;

    private String launcherVer;

    private String deviceType;

    private String output;

    private String iqiyiToken;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getLauncherVer() {
        return launcherVer;
    }

    public void setLauncherVer(String launcherVer) {
        this.launcherVer = launcherVer;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getYkToken() {
        return ykToken;
    }

    public void setYkToken(String ykToken) {
        this.ykToken = ykToken == null ? null : ykToken.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getAppPlt() {
        return appPlt;
    }

    public void setAppPlt(String appPlt) {
        this.appPlt = appPlt;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Integer getIsSvip() {
        return isSvip;
    }

    public void setIsSvip(Integer isSvip) {
        this.isSvip = isSvip;
    }

    public Date getSvipValidate() {
        return svipValidate;
    }

    public void setSvipValidate(Date svipValidate) {
        this.svipValidate = svipValidate;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getFacePic() {
        return facePic;
    }

    public void setFacePic(String facePic) {
        this.facePic = facePic;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getOtherJson() {
        return otherJson;
    }

    public void setOtherJson(String otherJson) {
        this.otherJson = otherJson;
    }

    public Integer getPrimaryAccount() {
        return primaryAccount;
    }

    public void setPrimaryAccount(Integer primaryAccount) {
        this.primaryAccount = primaryAccount;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getIqiyiToken() {
        return iqiyiToken;
    }

    public void setIqiyiToken(String iqiyiToken) {
        this.iqiyiToken = iqiyiToken;
    }

    @Override
    public String toString() {
        return "UserDo{" +
                "id=" + id +
                ", userAccount='" + userAccount + '\'' +
                ", token='" + token + '\'' +
                ", ykToken='" + ykToken + '\'' +
                ", ip='" + ip + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", birthday=" + birthday +
                ", registerTime=" + registerTime +
                ", appPlt='" + appPlt + '\'' +
                ", appId='" + appId + '\'' +
                ", isSvip=" + isSvip +
                ", svipValidate=" + svipValidate +
                ", nick='" + nick + '\'' +
                ", facePic='" + facePic + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userType=" + userType +
                ", primaryAccount=" + primaryAccount +
                ", otherJson='" + otherJson + '\'' +
                ", uuid='" + uuid + '\'' +
                ", mac='" + mac + '\'' +
                ", launcherVer='" + launcherVer + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", output='" + output + '\'' +
                ", iqiyiToken='" + iqiyiToken + '\'' +
                '}';
    }
}