package com.guigu.instructional.finance.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.finance.mapper.StaffSalaryMapper;
import com.guigu.instructional.finance.mapper.StaffSalaryOrderMapper;
import com.guigu.instructional.finance.service.SalaryService;
import com.guigu.instructional.po.StaffSalary;
import com.guigu.instructional.po.StaffSalaryOrder;

@Service("salaryServiceImpl")
public class SalaryServiceImpl implements SalaryService{
	
	@Resource(name="staffSalaryMapper")
	private StaffSalaryMapper staffSalaryMapper;
	@Resource(name="staffSalaryOrderMapper")
	private StaffSalaryOrderMapper staffSalaryOrderMapper;
	@Override
	public boolean addSalary(StaffSalary staffSalary) {
		int i=staffSalaryMapper.insertSelective(staffSalary);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateSalary(StaffSalary staffSalary) {
		int i=staffSalaryMapper.updateByPrimaryKeySelective(staffSalary);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<StaffSalaryOrder> findSalaryForList(StaffSalaryOrder staffSalaryOrder) {
		return staffSalaryOrderMapper.findStudentPaymentOrder(staffSalaryOrder);
	}

	@Override
	public StaffSalaryOrder findSalaryOrderById(Integer staffSalaryId) {
		return staffSalaryOrderMapper.findStudentPaymentOrderById(staffSalaryId);
	}

	@Override
	public StaffSalary findSalaryById(Integer staffSalaryId) {
		return staffSalaryMapper.selectByPrimaryKey(staffSalaryId);
	}

	@Override
	public boolean deleteSalary(Integer staffSalaryId) {
		int i=staffSalaryMapper.deleteByPrimaryKey(staffSalaryId);
		if(i>0) {
			return true;
		}
		return false;
	}

	
	
}
