package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import java.io.Serializable;
import java.util.Date;

public class CarPmCustomerCertificationAudit implements Serializable {
    private Integer id;

    private Long mid;

    private Date certificationAuditTime;

    private String certificationAuditUser;

    private String certificationMemo;

    private Integer certificationState;

    private Boolean isDelete;

    private String createUser;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
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

    public Integer getCertificationState() {
        return certificationState;
    }

    public void setCertificationState(Integer certificationState) {
        this.certificationState = certificationState;
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
}