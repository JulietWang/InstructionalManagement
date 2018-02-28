package com.guigu.instructional.marketactive.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.marketactive.mapper.ActiveVOMapper;
import com.guigu.instructional.marketactive.service.MarketActiveService;
import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveVO;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.system.mapper.StaffInfoMapper;
import com.guigu.instructional.system.service.StaffInfoService;

@Controller
@RequestMapping("/marketactive/marketactive/")
public class MarketActiveController {
	
	@Resource(name="marketActiveServiceImpl")
	 private MarketActiveService marketActiveService;
	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	
	@RequestMapping("list.action")
	public String activeList(MarketActive marketActive,Model model) {
		List<MarketActive> list=marketActiveService.getActiveStaff(marketActive);
		model.addAttribute("list", list);
		return "marketactive/marketactive/marketactive_list" ;
	}

	@RequestMapping("add.action")
	public String addActive(Model model,@Validated MarketActiveVO marketActiveVO,BindingResult bindingResult) {
		StaffInfo staffInfo= staffInfoService.getStaffInfo(marketActiveVO.getStaffName());
		if(staffInfo!=null) {
			marketActiveVO.setStaffId(staffInfo.getStaffId());
		}else {
			model.addAttribute("error", "该负责人不存在");
		}
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			System.out.println(marketActiveVO.getActiveStart()+""+marketActiveVO.getActiveEnd()+"-------");
			model.addAttribute("marketActiveVO", marketActiveVO);
			return "marketactive/marketactive/marketactive_add";
		}
		boolean flag=marketActiveService.addActive(marketActiveVO);
		if(flag) {
			model.addAttribute("info", "添加成功");
		}else {
			model.addAttribute("info", "添加失败");
		}
		
		return this.activeList(null,model);
	}
	
	@RequestMapping("load.action")
	public String load(Integer activeId,Model model) {
		MarketActiveVO marketActiveVO=marketActiveService.findActiveById(activeId);
		model.addAttribute("active", marketActiveVO);
		return "marketactive/marketactive/marketactive_update";
	}
	
	@RequestMapping("update.action")
	public String update(Model model,@Validated MarketActiveVO marketActiveVO,BindingResult bindingResult) {
		StaffInfo staffInfo= staffInfoService.getStaffInfo(marketActiveVO.getStaffName());
		if(staffInfo!=null) {
			marketActiveVO.setStaffId(staffInfo.getStaffId());
		}else {
			model.addAttribute("error", "该负责人不存在");
		}
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			model.addAttribute("marketActiveVO", marketActiveVO);
			return "marketactive/marketactive/marketactive_update";
		}
		boolean flag=marketActiveService.updateActive(marketActiveVO);
		if(flag) {
			model.addAttribute("info", "修改成功");
		}else {
			model.addAttribute("info", "修改失败");
		}
		
		return this.activeList(null,model);
	}
	
	@RequestMapping("delete.action")
	public String deleteActive(MarketActive marketActive,Model model) {
		boolean flag=marketActiveService.deleteActive(marketActive.getActiveId());
		if(flag) {
			model.addAttribute("info", "刪除成功");
		}else {
			model.addAttribute("info", "刪除失败");
		}
		return this.activeList(null,model);
	}
	
	@RequestMapping("show.action")
	public String show(Integer activeId,Model model) {
		MarketActiveVO marketActiveVO=marketActiveService.findActiveById(activeId);
		model.addAttribute("active", marketActiveVO);
		return "marketactive/marketactive/marketactive_show";
	}
}
