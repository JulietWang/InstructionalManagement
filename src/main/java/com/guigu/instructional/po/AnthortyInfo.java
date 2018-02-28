package com.guigu.instructional.po;

public class AnthortyInfo {
    private Integer anthortyId;

    private Integer anthortyPid;

    private String anthortyNane;

    private String anthortyDesc;

    private String anthortyUrl;

    public Integer getAnthortyId() {
        return anthortyId;
    }

    public void setAnthortyId(Integer anthortyId) {
        this.anthortyId = anthortyId;
    }

    public Integer getAnthortyPid() {
        return anthortyPid;
    }

    public void setAnthortyPid(Integer anthortyPid) {
        this.anthortyPid = anthortyPid;
    }

    public String getAnthortyNane() {
        return anthortyNane;
    }

    public void setAnthortyNane(String anthortyNane) {
        this.anthortyNane = anthortyNane == null ? null : anthortyNane.trim();
    }

    public String getAnthortyDesc() {
        return anthortyDesc;
    }

    public void setAnthortyDesc(String anthortyDesc) {
        this.anthortyDesc = anthortyDesc == null ? null : anthortyDesc.trim();
    }

    public String getAnthortyUrl() {
        return anthortyUrl;
    }

    public void setAnthortyUrl(String anthortyUrl) {
        this.anthortyUrl = anthortyUrl == null ? null : anthortyUrl.trim();
    }
}