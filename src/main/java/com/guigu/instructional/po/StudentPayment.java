package com.guigu.instructional.po;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class StudentPayment {
    private Integer paymentId;

    private Integer studentId;

    private Integer staffId;
    
    @Size(min=1,max=500,message="{StudentPayment.paymentSitutation.size}")
    private String paymentSitutation;

    private String paymentMenthod;
    
    @NotNull(message="{StudentPayment.paymentTime.isnull}")
    @Past(message="{StudentPayment.paymentTime.ispast}")
    private Date paymentTime;

    private Double paymentDiscountAmount;

    @NotNull(message="{StudentPayment.paymentShouldAmount.isnull}")
    private Double paymentShouldAmount;

    @NotNull(message="{StudentPayment.paymentRealAmount.isnull}")
    private Double paymentRealAmount;

    private Double paymentDebtAmount;

    private String paymentRemark;

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
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

    public String getPaymentSitutation() {
        return paymentSitutation;
    }

    public void setPaymentSitutation(String paymentSitutation) {
        this.paymentSitutation = paymentSitutation == null ? null : paymentSitutation.trim();
    }

    public String getPaymentMenthod() {
		return paymentMenthod;
	}

	public void setPaymentMenthod(String paymentMenthod) {
		this.paymentMenthod = paymentMenthod;
	}

	public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Double getPaymentDiscountAmount() {
        return paymentDiscountAmount;
    }

    public void setPaymentDiscountAmount(Double paymentDiscountAmount) {
        this.paymentDiscountAmount = paymentDiscountAmount;
    }

    public Double getPaymentShouldAmount() {
        return paymentShouldAmount;
    }

    public void setPaymentShouldAmount(Double paymentShouldAmount) {
        this.paymentShouldAmount = paymentShouldAmount;
    }

    public Double getPaymentRealAmount() {
        return paymentRealAmount;
    }

    public void setPaymentRealAmount(Double paymentRealAmount) {
        this.paymentRealAmount = paymentRealAmount;
    }

    public Double getPaymentDebtAmount() {
        return paymentDebtAmount;
    }

    public void setPaymentDebtAmount(Double paymentDebtAmount) {
        this.paymentDebtAmount = paymentDebtAmount;
    }

    public String getPaymentRemark() {
        return paymentRemark;
    }

    public void setPaymentRemark(String paymentRemark) {
        this.paymentRemark = paymentRemark == null ? null : paymentRemark.trim();
    }
}