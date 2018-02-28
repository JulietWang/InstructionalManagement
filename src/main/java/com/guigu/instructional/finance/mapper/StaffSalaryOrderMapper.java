package com.guigu.instructional.finance.mapper;

import java.util.List;

import com.guigu.instructional.po.StaffSalaryOrder;

public interface StaffSalaryOrderMapper {
	
	public List<StaffSalaryOrder> findStudentPaymentOrder(StaffSalaryOrder staffSalaryOrder);
	
	public StaffSalaryOrder findStudentPaymentOrderById(int staffSalaryOrderId);
}
