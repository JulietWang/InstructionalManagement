package com.guigu.instructional.transaction.services;

import java.util.List;

import com.guigu.instructional.po.ClassInfo;
import com.guigu.instructional.po.ClassTransactionInfo;
import com.guigu.instructional.po.ClassroomInfo;
import com.guigu.instructional.po.StaffInfo;

/**       
 * <p>project_name:InstructionalManagement</p>
 * <p>package_name:com.guigu.instructional.system.service.StaffInfoService</p>
 * <p>description：</p>
 * <p>@author：刘老师<p>   
 * <p> date:2018年1月26日上午8:55:29 </p>
 * <p>comments：    </p>
 * <p>@version  jdk1.8</p>
 * 
 * <p>Copyright (c) 2018, 980991634@qq.com All Rights Reserved. </p>    
 */

public interface ClassroomServices {
    
    /**
     * addStaff:添加员工信息
     * @author 刘老师
     * @param staffInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
    public boolean addClassroomInfo(ClassroomInfo classroomInfo);
    
    /**
     * updateStaff:更新员工数据
     * @author 刘老师
     * @param staffInfo
     * @return  <br/>
     * @since JDK 1.8
     */
    public boolean updateClassroomInfo(ClassroomInfo classroomInfo);
    
    /**
     * getStaffInfo:根据条件查询员工信息
     * @author 刘老师
     * @param staffInfo
     * @return  <br/>
     * @since JDK 1.8
     */
    public List<ClassroomInfo> getClassroomInfoList(ClassroomInfo classroomInfo);
    
    
    
    public List<ClassTransactionInfo> getClasstransInfoList1(ClassTransactionInfo classTransactionInfo);
    
    
    /**
     * getStaffInfo:根据员工编号查询员工信息
     * @author 刘老师
     * @param staffId
     * @return  <br/>
     * @since JDK 1.8
     */
    public ClassroomInfo getClassroomInfo(Integer classroomId);
    
    public ClassTransactionInfo getClassTransactionInfo(Integer classId);
    
    
    public List<ClassroomInfo> findClassMap();
    

    
    public ClassInfo getClassInfo(Integer classroomId);
}


