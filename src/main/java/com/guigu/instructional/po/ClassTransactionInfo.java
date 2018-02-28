package com.guigu.instructional.po;

import java.util.Date;

public class ClassTransactionInfo {
    private Integer classTransactionId;

    private Integer classId;

    private String classTransactionTile;

    private String classTransactionContent;

    private String classTransactionPerson;

    private Date classTransactionTime;

    private String classTransactionRemar;

    public Integer getClassTransactionId() {
        return classTransactionId;
    }

    public void setClassTransactionId(Integer classTransactionId) {
        this.classTransactionId = classTransactionId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassTransactionTile() {
        return classTransactionTile;
    }

    public void setClassTransactionTile(String classTransactionTile) {
        this.classTransactionTile = classTransactionTile == null ? null : classTransactionTile.trim();
    }

    public String getClassTransactionContent() {
        return classTransactionContent;
    }

    public void setClassTransactionContent(String classTransactionContent) {
        this.classTransactionContent = classTransactionContent == null ? null : classTransactionContent.trim();
    }

    public String getClassTransactionPerson() {
        return classTransactionPerson;
    }

    public void setClassTransactionPerson(String classTransactionPerson) {
        this.classTransactionPerson = classTransactionPerson == null ? null : classTransactionPerson.trim();
    }

    public Date getClassTransactionTime() {
        return classTransactionTime;
    }

    public void setClassTransactionTime(Date classTransactionTime) {
        this.classTransactionTime = classTransactionTime;
    }

    public String getClassTransactionRemar() {
        return classTransactionRemar;
    }

    public void setClassTransactionRemar(String classTransactionRemar) {
        this.classTransactionRemar = classTransactionRemar == null ? null : classTransactionRemar.trim();
    }
}