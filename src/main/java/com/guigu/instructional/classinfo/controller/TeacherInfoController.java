package com.guigu.instructional.classinfo.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.classinfo.service.TeacherInfoService;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.system.service.StaffInfoService;

/**       
 * <p>project_name:InstructionalManagement</p>
 * <p>package_name:com.guigu.instructional.system.controller.StaffInfoController</p>
 * <p>description：</p>
 * <p>@author：刘老师<p>   
 * <p> date:2018年1月26日上午9:15:58 </p>
 * <p>comments：    </p>
 * <p>@version  jdk1.8</p>
 * 
 * <p>Copyright (c) 2018, 980991634@qq.com All Rights Reserved. </p>    
 */
@Controller
@RequestMapping("/classinfo/teacher/")
public class TeacherInfoController {

    @Resource(name = "teacherInfoServiceImpl")
    private  TeacherInfoService teacherInfoService;

    // 进行数据校验  你们的功能
    @RequestMapping("add.action")
    public String addStaffInfo( Model model,@Validated StaffInfo staffInfo,BindingResult bindingResult) {
    	if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			return "classinfo/teacher/teacher_add";
		}
       staffInfo.setStaffState("1");
       staffInfo.setRoleId(2);
       boolean result= teacherInfoService.addStaff(staffInfo);
       System.out.println(result);
       if(result) {
           model.addAttribute("info","添加成功");
       }else {
           model.addAttribute("info","添加失败");
       }
       return this.list(null, model);
       
    }
    
    @RequestMapping("list.action")
    public String list(StaffInfo staffInfo,Model model) {
        List<StaffInfo> list =teacherInfoService.getStaffInfoList(staffInfo);
        model.addAttribute("list", list);
        
        return "classinfo/teacher/teacher_list";
    }
    
    @RequestMapping("show.action")
    public String showStaffInfo(Integer staffId,Model model) {
        StaffInfo staffInfo =teacherInfoService.getStaffInfo(staffId);
        model.addAttribute("staffInfo", staffInfo);
        return "classinfo/teacher/teacher_show";
        
    }
    
    @RequestMapping("load.action")
    public String loadUpate(Integer staffId,Model model) {
        StaffInfo staffInfo =teacherInfoService.getStaffInfo(staffId);
        model.addAttribute("staffInfo", staffInfo);
        return "classinfo/teacher/teacher_update";
    }
    
    @RequestMapping("update.action")
    public String updateStaffInfo(StaffInfo staffInfo,Model model) {
        boolean result=teacherInfoService.updateStaff(staffInfo);
        if(result) {
            model.addAttribute("info", "修改成功");
        }else {
            model.addAttribute("info", "修改失败");
        }
        return this.list(null, model);
    }
    
    @RequestMapping("delete.action")
    public String deleteStaffInfo(StaffInfo staffInfo,Model model) {
        
        //设置员工为 0   代表无效
        staffInfo.setStaffState("0");
        
        boolean result =teacherInfoService.updateStaff(staffInfo);
        if(result) {
            model.addAttribute("info", "删除成功");
        }else {
            model.addAttribute("info", "删除失败");
        }
        return this.list(null, model);
    }
    

}
