package com.tieshan.api.po.tieshanpaiPo;

import java.io.Serializable;
import java.util.Date;

public class CarPmCustomerInfo implements Serializable {
    private Long id;

    private String nickname;

    private String phone;

    private String password;

    private String avatar;

    private String realname;

    private String idCard;

    private Long validity;

    private Integer frontIdcard;

    private Integer backIdcard;

    private Integer handIdcard;

    private Date certificationSubmitTime;

    private Integer certificationState;

    private Date certificationAuditTime;

    private String certificationAuditUser;

    private String certificationMemo;

    private Integer province;

    private Integer city;

    private Integer verifymember;

    private Integer status;

    private Boolean isDelete;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public Long getValidity() {
        return validity;
    }

    public void setValidity(Long validity) {
        this.validity = validity;
    }

    public Integer getFrontIdcard() {
        return frontIdcard;
    }

    public void setFrontIdcard(Integer frontIdcard) {
        this.frontIdcard = frontIdcard;
    }

    public Integer getBackIdcard() {
        return backIdcard;
    }

    public void setBackIdcard(Integer backIdcard) {
        this.backIdcard = backIdcard;
    }

    public Integer getHandIdcard() {
        return handIdcard;
    }

    public void setHandIdcard(Integer handIdcard) {
        this.handIdcard = handIdcard;
    }

    public Date getCertificationSubmitTime() {
        return certificationSubmitTime;
    }

    public void setCertificationSubmitTime(Date certificationSubmitTime) {
        this.certificationSubmitTime = certificationSubmitTime;
    }

    public Integer getCertificationState() {
        return certificationState;
    }

    public void setCertificationState(Integer certificationState) {
        this.certificationState = certificationState;
    }

    public Date getCertificationAuditTime() {
        return certificationAuditTime;
    }

    public void setCertificationAuditTime(Date certificationAuditTime) {
        this.certificationAuditTime = certificationAuditTime;
    }

    public String getCertificationAuditUser() {
        return certificationAuditUser;
    }

    public void setCertificationAuditUser(String certificationAuditUser) {
        this.certificationAuditUser = certificationAuditUser == null ? null : certificationAuditUser.trim();
    }

    public String getCertificationMemo() {
        return certificationMemo;
    }

    public void setCertificationMemo(String certificationMemo) {
        this.certificationMemo = certificationMemo == null ? null : certificationMemo.trim();
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getVerifymember() {
        return verifymember;
    }

    public void setVerifymember(Integer verifymember) {
        this.verifymember = verifymember;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}