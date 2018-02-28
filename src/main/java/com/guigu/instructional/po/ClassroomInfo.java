package com.guigu.instructional.po;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ClassroomInfo {
   

	private Integer classroomId;

    @Size(min=4,max=10,message="{classroomInfo.classroomName.length.error}")
    @NotEmpty(message="{classroomInfo.classroomName.isnull}")
    private String classroomName;

    @NotNull(message="{classroomInfo.classroomMax.isnull}")
    private Integer classroomMax;

    @NotEmpty(message="{classroomInfo.classroomInfo.isnull}")
    private String classroomInfo;

    @NotEmpty(message="{classroomInfo.classroomRemark.isnull}")
    private String classroomRemark;

    private String classroomMark;

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName == null ? null : classroomName.trim();
    }

    public Integer getClassroomMax() {
        return classroomMax;
    }

    public void setClassroomMax(Integer classroomMax) {
        this.classroomMax = classroomMax;
    }

    public String getClassroomInfo() {
        return classroomInfo;
    }

    public void setClassroomInfo(String classroomInfo) {
        this.classroomInfo = classroomInfo == null ? null : classroomInfo.trim();
    }

    public String getClassroomRemark() {
        return classroomRemark;
    }

    public void setClassroomRemark(String classroomRemark) {
        this.classroomRemark = classroomRemark == null ? null : classroomRemark.trim();
    }

    public String getClassroomMark() {
        return classroomMark;
    }

    public void setClassroomMark(String classroomMark) {
        this.classroomMark = classroomMark == null ? null : classroomMark.trim();
    }
}