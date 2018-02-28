package com.guigu.instructional.po;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class StaffSalary {
    private Integer staffSalaryId;

    private Integer staffId;

    private Integer staStaffId;
    
    @Min(value=1,message="{StaffSalary.staffSalaryTotal.min}")
    @NotNull(message="{StaffSalary.staffSalaryTotal.isnull}")
    private Double staffSalaryTotal;
    
    @DecimalMin(value="0",message="{StaffSalary.staffSalaryDeduct.min}")
    @NotNull(message="{StaffSalary.staffSalaryDeduct.isnull}")
    private Double staffSalaryDeduct;

    @Min(value=1,message="{StaffSalary.staffSalaryReal.min}")
    @NotNull(message="{StaffSalary.staffSalaryReal.isnull}")
    private Double staffSalaryReal;

    private String staffSalaryIsused;

    @Past(message="{StaffSalary.staffSalaryTime.past}")
    @NotNull(message="{StaffSalary.staffSalaryTime.isnull}")
    private Date staffSalaryTime;

    private String remark;

    public Integer getStaffSalaryId() {
        return staffSalaryId;
    }

    public void setStaffSalaryId(Integer staffSalaryId) {
        this.staffSalaryId = staffSalaryId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getStaStaffId() {
        return staStaffId;
    }

    public void setStaStaffId(Integer staStaffId) {
        this.staStaffId = staStaffId;
    }

    public Double getStaffSalaryTotal() {
        return staffSalaryTotal;
    }

    public void setStaffSalaryTotal(Double staffSalaryTotal) {
        this.staffSalaryTotal = staffSalaryTotal;
    }

    public Double getStaffSalaryDeduct() {
        return staffSalaryDeduct;
    }

    public void setStaffSalaryDeduct(Double staffSalaryDeduct) {
        this.staffSalaryDeduct = staffSalaryDeduct;
    }

    public Double getStaffSalaryReal() {
        return staffSalaryReal;
    }

    public void setStaffSalaryReal(Double staffSalaryReal) {
        this.staffSalaryReal = staffSalaryReal;
    }

    public String getStaffSalaryIsused() {
        return staffSalaryIsused;
    }

    public void setStaffSalaryIsused(String staffSalaryIsused) {
        this.staffSalaryIsused = staffSalaryIsused == null ? null : staffSalaryIsused.trim();
    }

    public Date getStaffSalaryTime() {
        return staffSalaryTime;
    }

    public void setStaffSalaryTime(Date staffSalaryTime) {
        this.staffSalaryTime = staffSalaryTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}