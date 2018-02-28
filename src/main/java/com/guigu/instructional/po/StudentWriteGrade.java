package com.guigu.instructional.po;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class StudentWriteGrade {
    private Integer writeGradeId;

    private Integer studentId;

    private Integer staffId;
    
    @NotEmpty(message="{items.writeGradeSubject.isEmpty}")
    private String writeGradeSubject;
    
    
    @Min(value=0,message="{items.writeGrade.valueerror}")
    private String writeGrade;
    
    @NotNull(message="{items.writeGradeTime.isNULL}")
    @Past(message="{items.writeGradeTime.dateError}")
    private Date writeGradeTime;

    private String writeGradeNote;

    public Integer getWriteGradeId() {
        return writeGradeId;
    }

    public void setWriteGradeId(Integer writeGradeId) {
        this.writeGradeId = writeGradeId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getWriteGradeSubject() {
        return writeGradeSubject;
    }

    public void setWriteGradeSubject(String writeGradeSubject) {
        this.writeGradeSubject = writeGradeSubject == null ? null : writeGradeSubject.trim();
    }

    public String getWriteGrade() {
        return writeGrade;
    }

    public void setWriteGrade(String writeGrade) {
        this.writeGrade = writeGrade == null ? null : writeGrade.trim();
    }

    public Date getWriteGradeTime() {
        return writeGradeTime;
    }

    public void setWriteGradeTime(Date writeGradeTime) {
        this.writeGradeTime = writeGradeTime;
    }

    public String getWriteGradeNote() {
        return writeGradeNote;
    }

    public void setWriteGradeNote(String writeGradeNote) {
        this.writeGradeNote = writeGradeNote == null ? null : writeGradeNote.trim();
    }
}