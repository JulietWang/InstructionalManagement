package com.guigu.instructional.marketactive.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.marketactive.service.TemplateInfoService;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.TemplateInfo;


@Controller
@RequestMapping("/marketactive/template/")
public class TemplateInfoController {
	@Resource(name="templateInfoServiceImpl")
	private TemplateInfoService templateInfoService;
	
	@RequestMapping("add.action")
    public String addTemplate(Model model,@Validated TemplateInfo templateInfo,BindingResult bindingResult) {
       
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			model.addAttribute("temp", templateInfo);
			return "marketactive/template/template_add";
		}
		boolean result= templateInfoService.addTemplate(templateInfo);
       if(result) {
           model.addAttribute("info","添加成功");
       }else {
           model.addAttribute("info","添加失败");
       }
       return this.list(null, model);
       
    }
    
    @RequestMapping("list.action")
    public String list(TemplateInfo templateInfo,Model model) {
        List<TemplateInfo> list =templateInfoService.getTemplateInfoList(templateInfo);
        model.addAttribute("list", list);
        return "marketactive/template/template_list";
    }
    @RequestMapping("load.action")
    public String loadUpate(Integer templateId,Model model) {
    	TemplateInfo templateInfo=templateInfoService.getTemplateInfo(templateId);
        model.addAttribute("templateInfo", templateInfo);
        return "marketactive/template/template_update";
    }
    
    @RequestMapping("update.action")
    public String update(Model model,@Validated TemplateInfo templateInfo,BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			model.addAttribute("temp", templateInfo);
			return "marketactive/template/template_update";
		}
    	boolean result=templateInfoService.updateTemplate(templateInfo);
        if(result) {
            model.addAttribute("info", "修改成功");
        }else {
            model.addAttribute("info", "修改失败");
        }
        return this.list(null, model);
    }
    
    @RequestMapping("delete.action")
    public String delete(Integer templateId,Model model) {
        
        boolean result =templateInfoService.deleteTemplate(templateId);
        if(result) {
            model.addAttribute("info", "删除成功");
        }else {
            model.addAttribute("info", "删除失败");
        }
        return this.list(null, model);
    }

}
