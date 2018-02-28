package com.guigu.instructional.finance.mapper;

import java.util.List;

import org.w3c.dom.ls.LSInput;

import com.guigu.instructional.po.StudentPaymentOrder;

public interface StudentPaymentOrderMapper {
	
	public List<StudentPaymentOrder> findStudentPaymentOrder(StudentPaymentOrder studentPaymentOrder);
	
}
