package com.guigu.instructional.finance.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.finance.service.SalaryService;
import com.guigu.instructional.finance.service.TuitionService;
import com.guigu.instructional.finance.service.impl.TuitionServiceImpl;
import com.guigu.instructional.po.DataDictionary;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StaffSalary;
import com.guigu.instructional.po.StudentPayment;
import com.guigu.instructional.po.StudentPaymentOrder;
import com.guigu.instructional.system.service.DataDictionaryService;

@Controller
@RequestMapping("/finance/tuition")
public class TuitionController {
	
	@Resource(name="tuitionServiceImpl")
	private TuitionService tuitionService;
	@Resource(name="dataDictionaryServiceImpl")
	private DataDictionaryService dataDictionaryService;
	@RequestMapping("list.action")
	public String findTuitionForList(StudentPaymentOrder studentPaymentOrder,Model model) {
		List<StudentPaymentOrder> list =tuitionService.findTuitionForList(studentPaymentOrder);
		for (StudentPaymentOrder studentPaymentOrder2 : list) {
			System.out.println(studentPaymentOrder2);
		}
        model.addAttribute("list", list);
        
        return "finance/tuition/Tuition_list";
	}
	@RequestMapping("show.action")
	public String showTuition(Integer studentPaymentId,Model model){
		StudentPayment studentPayment=tuitionService.findTuitionForId(studentPaymentId);
		model.addAttribute("studentPayment", studentPayment);
        return "finance/tuition/Tuition_show";
	}
	
	@RequestMapping("beforeAdd.action")
	public  String beforeAddTuition(Model model){
		List<DataDictionary> list=this.findDataDictionaryIsUser();
		model.addAttribute("dataList",list);
		return "finance/tuition/Tuition_add";
	}
	@RequestMapping("add.action")
	public String addTuition(Model model,@Validated StudentPayment studentPayment,BindingResult bindingResult){
		this.tuitionValidation(studentPayment, bindingResult);
		if(bindingResult.hasErrors()) {
			List<ObjectError> Errors=bindingResult.getAllErrors();
			model.addAttribute("allErrors",Errors);
			List<DataDictionary> data=this.findDataDictionaryIsUser();
			model.addAttribute("dataList",data);
			return "finance/tuition/Tuition_add";
		}
		boolean result=tuitionService.addTuition(studentPayment);
		
		if(result) {
	           model.addAttribute("info","添加成功");
	       }else {
	           model.addAttribute("info","添加失败");
	       }
	       return this.findTuitionForList(new StudentPaymentOrder(), model);
	}
	@RequestMapping("update.action")
	public String updateTuition(Model model,@Validated StudentPayment studentPayment,BindingResult bindingResult) {
		this.tuitionValidation(studentPayment, bindingResult);
		if(bindingResult.hasErrors()) {
			List<ObjectError> Errors=bindingResult.getAllErrors();
			for (ObjectError objectError : Errors) {
			}
			model.addAttribute("allErrors",Errors);
			List<DataDictionary> data=this.findDataDictionaryIsUser();
			model.addAttribute("dataList",data);
			return "finance/tuition/Tuition_update";
		}
		boolean result=tuitionService.updateTuition(studentPayment);
		if(result) {
	           model.addAttribute("info","修改成功");
	       }else {
	           model.addAttribute("info","修改失败");
	       }
	     return this.findTuitionForList(new StudentPaymentOrder(), model);
	}
	@RequestMapping("load.action")
	public String loadTuition(Integer studentPaymentId,Model model) {
		StudentPayment studentPayment=tuitionService.findTuitionForId(studentPaymentId);
		List<DataDictionary> data=this.findDataDictionaryIsUser();
		model.addAttribute("dataList",data);
		model.addAttribute("studentPayment",studentPayment);
		return "finance/tuition/Tuition_update";
	}
	
	
	@RequestMapping("delete.action")
	public String deleteTuition(Integer studentPaymentId,Model model) {
		boolean result=tuitionService.deleteTuition(studentPaymentId);
		if(result) {
	           model.addAttribute("info","删除成功");
	       }else {
	           model.addAttribute("info","删除失败");
	       }
	     return this.findTuitionForList(new StudentPaymentOrder(), model);
	}
	public void tuitionValidation( StudentPayment studentPayment,BindingResult bindingResult){
		Double ShouldAmount=studentPayment.getPaymentShouldAmount();
		Double RealAmount=studentPayment.getPaymentRealAmount();
		Double DebtAmount=studentPayment.getPaymentDebtAmount();
		Double DiscountAmount=studentPayment.getPaymentDiscountAmount();
		if(ShouldAmount!=null&&RealAmount!=null&&DebtAmount!=null&&DiscountAmount!=null) {
			if(ShouldAmount!=RealAmount+DiscountAmount+DebtAmount) {
				bindingResult.addError(new ObjectError("studentPayment","应缴学费应该是其他项目的总和"));
				//list.add(new ObjectError(objectName, defaultMessage));
			}
		}
		
	}
	public List<DataDictionary> findDataDictionaryIsUser(){
		DataDictionary dataDictionary=new DataDictionary();
		dataDictionary.setDataType("支付方式");
		return dataDictionaryService.findDataDictionaryList(dataDictionary);
	}
}
