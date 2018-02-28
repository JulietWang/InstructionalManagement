package com.guigu.instructional.transaction.services;

import java.util.List;

import com.guigu.instructional.po.AttendanceInfo;





public interface AttendanceInfoService {
    
    /**
     * addStaff:添加员工信息
     * @author 刘老师
     * @param staffInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
    public boolean addAttendance(AttendanceInfo attendanceInfo);
    
    /**
     * updateStaff:更新员工数据
     * @author 刘老师
     * @param staffInfo
     * @return  <br/>
     * @since JDK 1.8
     */
    public boolean updateAttendance(AttendanceInfo attendanceInfo);
    
    /**
     * getStaffInfo:根据条件查询员工信息
     * @author 刘老师
     * @param staffInfo
     * @return  <br/>
     * @since JDK 1.8
     */
    public List<AttendanceInfo> getAttendanceInfoList(AttendanceInfo attendanceInfo);
    
    
    /**
     * getStaffInfo:根据员工编号查询员工信息
     * @author 刘老师
     * @param staffId
     * @return  <br/>
     * @since JDK 1.8
     */
    public AttendanceInfo getAttendanceInfo(Integer attendanceId);
    
    
}


