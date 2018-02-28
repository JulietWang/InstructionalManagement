package com.guigu.instructional.transaction.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.AttendanceInfo;

import com.guigu.instructional.transaction.services.AttendanceInfoService;

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
@RequestMapping("/transaction/transaction/")
public class AttendenceController {

    @Resource(name = "attendanceInfoServiceImpl")
    private AttendanceInfoService attendanceInfoService;
    
    private SqlSessionFactory sqlSessionFactory;
//    @RequestMapping("showStudent.action")
//    public String showStudent(Integer studentId,Model model) throws Exception {
//        String resource = "SqlMapConfig.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        
//        
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        AttendanceInfo attendanceInfo =attendanceInfoService.getAttendanceInfo(attendanceId);
//        model.addAttribute("attendanceInfo", attendanceInfo);
//        return "transaction/transaction/transaction_show";
////         创建代理对象
//        AttendanceQueryVO attendanceQueryVO = sqlSession.getMapper(AttendanceQueryVO.class);
//
//        AttendanceQueryVO attendanceQueryVO2 = attendanceQueryVO.findAttendanceInfo(studentId);
//        
//        model.addAttribute("attendanceQueryVO", attendanceQueryVO2);
//        sqlSession.close();
//        return "transaction/transaction/transaction_show";
//
//        
//    }
    
    
    
    // 进行数据校验  你们的功能
    @RequestMapping("add.action")
    public String addAttendanceInfo(AttendanceInfo attendanceInfo,Model model) {
    	attendanceInfo.setAttendanceState("1");;
       boolean result= attendanceInfoService.addAttendance(attendanceInfo);
       if(result) {
           model.addAttribute("info","添加成功");
       }else {
           model.addAttribute("info","添加失败");
       }
       return this.list(null, model);
       
    }
    
    @RequestMapping("list.action")
    public String list(AttendanceInfo attendanceInfo,Model model) {
    	
        List<AttendanceInfo> list =attendanceInfoService.getAttendanceInfoList(attendanceInfo);
        model.addAttribute("list", list);
        
        return "transaction/transaction/transaction_list";
    }
    
    @RequestMapping("show.action")
    public String showAttendanceInfo(Integer attendanceId,Model model) {
    	AttendanceInfo attendanceInfo =attendanceInfoService.getAttendanceInfo(attendanceId);
        model.addAttribute("attendanceInfo", attendanceInfo);
        return "transaction/transaction/transaction_show";
        
    }
  

    
    @RequestMapping("load.action")
    public String loadUpate(Integer attendanceId,Model model) {
    	AttendanceInfo attendanceInfo =attendanceInfoService.getAttendanceInfo(attendanceId);
        model.addAttribute("attendanceInfo", attendanceInfo);
        return "transaction/transaction/transaction_update";
    }
    
    @RequestMapping("update.action")
    public String updateAttendanceInfo(AttendanceInfo attendanceInfo,Model model) {
        boolean result=attendanceInfoService.updateAttendance(attendanceInfo);
        if(result) {
            model.addAttribute("info", "修改成功");
        }else {
            model.addAttribute("info", "修改失败");
        }
        return this.list(null, model);
    }
    
    @RequestMapping("delete.action")
    public String deleteAttendanceInfo(AttendanceInfo attendanceInfo,Model model) {
        
        //设置员工为 0   代表无效
    	attendanceInfo.setAttendanceState("0");
        
        boolean result =attendanceInfoService.updateAttendance(attendanceInfo);
        if(result) {
            model.addAttribute("info", "删除成功");
        }else {
            model.addAttribute("info", "删除失败");
        }
        return this.list(null, model);
    }
    

}
