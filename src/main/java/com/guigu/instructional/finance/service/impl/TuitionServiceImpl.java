package com.guigu.instructional.finance.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.finance.mapper.StudentPaymentMapper;
import com.guigu.instructional.finance.mapper.StudentPaymentOrderMapper;
import com.guigu.instructional.finance.service.TuitionService;
import com.guigu.instructional.po.StudentPayment;
import com.guigu.instructional.po.StudentPaymentExample;
import com.guigu.instructional.po.StudentPaymentOrder;
@Service(value = "tuitionServiceImpl")
public class TuitionServiceImpl implements TuitionService{

	@Resource(name="studentPaymentMapper")
	private StudentPaymentMapper StudentPaymentMapper;
	@Resource(name="studentPaymentOrderMapper")
	private StudentPaymentOrderMapper StudentPaymentOrderMapper;
	@Override
	public boolean addTuition(StudentPayment studentPayment) {
		int i=StudentPaymentMapper.insertSelective(studentPayment);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateTuition(StudentPayment studentPayment) {
		try {
			int i=StudentPaymentMapper.updateByPrimaryKeySelective(studentPayment);
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("出现了异常");
		}
		return false;
	}

	@Override
	public List<StudentPaymentOrder> findTuitionForList(StudentPaymentOrder studentPaymentOrder) {
		return StudentPaymentOrderMapper.findStudentPaymentOrder(studentPaymentOrder);
	}

	@Override
	public StudentPayment findTuitionForId(Integer studentPaymentId) {
		return StudentPaymentMapper.selectByPrimaryKey(studentPaymentId);
	}

	@Override
	public boolean deleteTuition(Integer paymentId) {
		try {
			int i=StudentPaymentMapper.deleteByPrimaryKey(paymentId);
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}
}
