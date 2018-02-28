package com.guigu.instructional.finance.service;

import java.util.List;

import com.guigu.instructional.po.StudentPayment;
import com.guigu.instructional.po.StudentPaymentOrder;

public interface TuitionService {

	public boolean addTuition(StudentPayment studentPayment);

	public boolean updateTuition(StudentPayment studentPayment);

	public List<StudentPaymentOrder> findTuitionForList(StudentPaymentOrder studentPaymentOrder);
	
	public StudentPayment findTuitionForId(Integer studentPaymentId);
	
	public boolean deleteTuition(Integer studentPaymentId);
}
