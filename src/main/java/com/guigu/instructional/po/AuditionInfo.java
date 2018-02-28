package com.guigu.instructional.po;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class AuditionInfo {
	
private Integer auditionId;
    
    @NotNull(message="{auditionInfo.studentId.isnull}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class})
    private Integer studentId;
    
    @NotNull(message="{auditionInfo.auditionTime.isnull}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class})
    @Past(message="{auditionInfo.auditionTime.past}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class})
    private Date auditionTime;

    private String auditionAddr; 
    
    @NotNull(message="{auditionInfo.auditionCourse.isnull}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class})
    private Integer auditionCourse;

    private String auditionDesc;

    public Integer getAuditionId() {
        return auditionId;
    }

    public void setAuditionId(Integer auditionId) {
        this.auditionId = auditionId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getAuditionTime() {
        return auditionTime;
    }

    public void setAuditionTime(Date auditionTime) {
        this.auditionTime = auditionTime;
    }

    public String getAuditionAddr() {
        return auditionAddr;
    }

    public void setAuditionAddr(String auditionAddr) {
        this.auditionAddr = auditionAddr == null ? null : auditionAddr.trim();
    }

    public Integer getAuditionCourse() {
        return auditionCourse;
    }

    public void setAuditionCourse(Integer auditionCourse) {
        this.auditionCourse = auditionCourse;
    }

    public String getAuditionDesc() {
        return auditionDesc;
    }

    public void setAuditionDesc(String auditionDesc) {
        this.auditionDesc = auditionDesc == null ? null : auditionDesc.trim();
    }
}