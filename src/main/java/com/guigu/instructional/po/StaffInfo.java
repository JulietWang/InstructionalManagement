package com.guigu.instructional.po;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Primary;


public class StaffInfo {
    @Override
	public String toString() {
		return "StaffInfo [staffId=" + staffId + ", roleId=" + roleId + ", staffName=" + staffName + ", staffSex="
				+ staffSex + ", staffAge=" + staffAge + ", staffNativePlace=" + staffNativePlace + ", staffIdcard="
				+ staffIdcard + ", staffBirthday=" + staffBirthday + ", staffOfficePhone=" + staffOfficePhone
				+ ", staffMobilePhone=" + staffMobilePhone + ", staffEmail=" + staffEmail + ", staffAddr=" + staffAddr
				+ ", staffQq=" + staffQq + ", staffEntryTime=" + staffEntryTime + ", staffEducationLevel="
				+ staffEducationLevel + ", staffRemark=" + staffRemark + ", staffState=" + staffState + ", staffNumber="
				+ staffNumber + ", staffPassword=" + staffPassword + "]";
	}

	private Integer staffId;

    private Integer roleId;

    @NotEmpty(message="{StaffInfo.staffName.empty}")
    @Size(min=1,max=10,message="{StaffInfo.staffName.size}")
    private String staffName;

    private String staffSex;
    
    @Min(value=18,message="{StaffInfo.staffAge.min}")
    @Max(value=70,message="{StaffInfo.staffAge.max}")
    @NotNull(message="{StaffInfo.staffAge.isnull}")
    private Integer staffAge;

    private String staffNativePlace;

    @NotEmpty(message="{StaffInfo.staffIdcard.isnull}")
    @Pattern(regexp="[0-9]{17}[0-9xX]{1}",message="{StaffInfo.staffIdcard.regexp}")
    private String staffIdcard;

    private Date staffBirthday;

    private String staffOfficePhone;

    private String staffMobilePhone;
    
    @NotEmpty(message="{StaffInfo.staffEmail.isnull}")
    @NotBlank(message="{StaffInfo.staffEmail.isuse}")
    private String staffEmail;
    
    @Size(max=100,message="{StaffInfo.staffEntryTime.size}")
    private String staffAddr;

    private String staffQq;
    
    @NotNull(message="{StaffInfo.staffEntryTime.isnull}")
    private Date staffEntryTime;

    private String staffEducationLevel;

    private String staffRemark;

    private String staffState;
    
    @Size(min=8,max=15,message="{StaffInfo.staffNumber.isuse}")
    @Pattern(regexp="[A-Z]+[a-zA-Z0-9]*",message="{StaffInfo.staffNumber.isuse}")
    @NotEmpty(message="{StaffInfo.staffNumber.isnull}")
    private String staffNumber;
    
    
    @NotEmpty(message="{StaffInfo.staffPassword.isnull}")
    @Pattern(regexp="[a-zA-Z0-9]{8,20}",message="{StaffInfo.staffPassword.isuse}")
    private String staffPassword;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex == null ? null : staffSex.trim();
    }

    public Integer getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(Integer staffAge) {
        this.staffAge = staffAge;
    }

    public String getStaffNativePlace() {
        return staffNativePlace;
    }

    public void setStaffNativePlace(String staffNativePlace) {
        this.staffNativePlace = staffNativePlace == null ? null : staffNativePlace.trim();
    }

    public String getStaffIdcard() {
        return staffIdcard;
    }

    public void setStaffIdcard(String staffIdcard) {
        this.staffIdcard = staffIdcard == null ? null : staffIdcard.trim();
    }

    public Date getStaffBirthday() {
        return staffBirthday;
    }

    public void setStaffBirthday(Date staffBirthday) {
        this.staffBirthday = staffBirthday;
    }

    public String getStaffOfficePhone() {
        return staffOfficePhone;
    }

    public void setStaffOfficePhone(String staffOfficePhone) {
        this.staffOfficePhone = staffOfficePhone == null ? null : staffOfficePhone.trim();
    }

    public String getStaffMobilePhone() {
        return staffMobilePhone;
    }

    public void setStaffMobilePhone(String staffMobilePhone) {
        this.staffMobilePhone = staffMobilePhone == null ? null : staffMobilePhone.trim();
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail == null ? null : staffEmail.trim();
    }

    public String getStaffAddr() {
        return staffAddr;
    }

    public void setStaffAddr(String staffAddr) {
        this.staffAddr = staffAddr == null ? null : staffAddr.trim();
    }

    public String getStaffQq() {
        return staffQq;
    }

    public void setStaffQq(String staffQq) {
        this.staffQq = staffQq == null ? null : staffQq.trim();
    }

    public Date getStaffEntryTime() {
        return staffEntryTime;
    }

    public void setStaffEntryTime(Date staffEntryTime) {
        this.staffEntryTime = staffEntryTime;
    }

    public String getStaffEducationLevel() {
        return staffEducationLevel;
    }

    public void setStaffEducationLevel(String staffEducationLevel) {
        this.staffEducationLevel = staffEducationLevel == null ? null : staffEducationLevel.trim();
    }

    public String getStaffRemark() {
        return staffRemark;
    }

    public void setStaffRemark(String staffRemark) {
        this.staffRemark = staffRemark == null ? null : staffRemark.trim();
    }

    public String getStaffState() {
        return staffState;
    }

    public void setStaffState(String staffState) {
        this.staffState = staffState == null ? null : staffState.trim();
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber == null ? null : staffNumber.trim();
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword == null ? null : staffPassword.trim();
    }
}