package com.guigu.instructional.po;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ClassInfo {
    private Integer classId;

    private Integer disciplineId;

    private Integer syllabusId;

    private Integer classroomId;

    private Integer staffId;

    @Size(min=2,max=10,message="{classInfo.className.length.error}")
    @NotEmpty(message="{classInfo.className.isnull}")
    private String className;

    @NotNull(message="{classInfo.classNumber.isnull}")
    private Integer classNumber;

    @Past(message="{classInfo.classNumber.past}")
    private Date classStartTime;

    @Future(message="{classInfo.classNumber.future}")
    private Date classEndTime;

    private String classIsused;

    private String classState;

    @NotEmpty(message="{classInfo.classDesc.isnull}")
    private String classDesc;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Integer disciplineId) {
        this.disciplineId = disciplineId;
    }

    public Integer getSyllabusId() {
        return syllabusId;
    }

    public void setSyllabusId(Integer syllabusId) {
        this.syllabusId = syllabusId;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public Date getClassStartTime() {
        return classStartTime;
    }

    public void setClassStartTime(Date classStartTime) {
        this.classStartTime = classStartTime;
    }

    public Date getClassEndTime() {
        return classEndTime;
    }

    public void setClassEndTime(Date classEndTime) {
        this.classEndTime = classEndTime;
    }

    public String getClassIsused() {
        return classIsused;
    }

    public void setClassIsused(String classIsused) {
        this.classIsused = classIsused == null ? null : classIsused.trim();
    }

    public String getClassState() {
        return classState;
    }

    public void setClassState(String classState) {
        this.classState = classState == null ? null : classState.trim();
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc == null ? null : classDesc.trim();
    }

	@Override
	public String toString() {
		return "ClassInfo [classId=" + classId + ", disciplineId=" + disciplineId + ", syllabusId=" + syllabusId
				+ ", classroomId=" + classroomId + ", staffId=" + staffId + ", className=" + className
				+ ", classNumber=" + classNumber + ", classStartTime=" + classStartTime + ", classEndTime="
				+ classEndTime + ", classIsused=" + classIsused + ", classState=" + classState + ", classDesc="
				+ classDesc + "]";
	}
    
    
}