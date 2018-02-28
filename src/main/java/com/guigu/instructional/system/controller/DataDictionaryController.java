package com.guigu.instructional.system.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.DataDictionary;
import com.guigu.instructional.po.StudentPayment;
import com.guigu.instructional.system.service.DataDictionaryService;

@Controller
@RequestMapping("/system/datadictionary")
public class DataDictionaryController {
	
	@Resource(name="dataDictionaryServiceImpl")
	private DataDictionaryService dataDictionaryService;
	
	@RequestMapping("list.action")
	public String findDataDictionaryForList(Model model,DataDictionary dataDictionary) {
		List<DataDictionary> list=dataDictionaryService.findDataDictionaryList(dataDictionary);
		model.addAttribute("list",list);
		return "system/datadictionary/datadictionary_list";
	}
	
	@RequestMapping("delete.action")
	public String deleteDataDictionary(Model model,Integer dataId) {
		boolean result=dataDictionaryService.deleteDataDictionary(dataId);
		if(result) {
			model.addAttribute("info","删除成功");
		}else {
			model.addAttribute("info","删除失败");
		}
		return this.findDataDictionaryForList(model,null);
	}
	
	@RequestMapping("add.action")
	public String addDataDictionary(Model model,DataDictionary dataDictionary) {
		boolean result=dataDictionaryService.addDataDictionary(dataDictionary);
		if(result) {
			model.addAttribute("info","添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.findDataDictionaryForList(model,null);
	}
	
	@RequestMapping("load.action")
	public String loadDataDictionary(Integer dataId,Model model) {
		System.out.println("1"+dataId);
		DataDictionary dataDictionary=dataDictionaryService.findDataDictionaryById(dataId);
		System.out.println(dataDictionary);
		model.addAttribute("dataDictionary",dataDictionary);
		return "/system/datadictionary/datadictionary_update";
	}
	
	@RequestMapping("update.action")
	public String updateDataDictionary(Model model,DataDictionary dataDictionary) {
		boolean result=dataDictionaryService.uppateDataDictionary(dataDictionary);
		if(result) {
			model.addAttribute("info","修改成功");
		}else {
			model.addAttribute("info","修改失败");
		}
		return this.findDataDictionaryForList(model,null);
	}
	
	
}
