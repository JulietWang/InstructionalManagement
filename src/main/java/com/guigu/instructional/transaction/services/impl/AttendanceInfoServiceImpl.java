package com.guigu.instructional.transaction.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.po.AttendanceInfo;
import com.guigu.instructional.po.AttendanceInfoExample;
import com.guigu.instructional.po.AttendanceInfoExample.Criteria;
import com.guigu.instructional.transaction.mapper.AttendanceInfoMapper;
import com.guigu.instructional.transaction.services.AttendanceInfoService;

/**       
 * <p>project_name:InstructionalManagement</p>
 * <p>package_name:com.guigu.instructional.system.service.impl.StaffInfoServiceImpl</p>
 * <p>description：</p>
 * <p>@author：刘老师<p>   
 * <p> date:2018年1月26日上午8:59:08 </p>
 * <p>comments：    </p>
 * <p>@version  jdk1.8</p>
 * 
 * <p>Copyright (c) 2018, 980991634@qq.com All Rights Reserved. </p>    
 */

@Service("attendanceInfoServiceImpl")
public class AttendanceInfoServiceImpl implements AttendanceInfoService {

    // @Autowired
    // @Qualifier
    @Resource(name = "attendanceInfoMapper")
    private AttendanceInfoMapper attendanceInfoMapper;

    @Override
    public boolean addAttendance(AttendanceInfo attendanceInfo) {
        try {
            int i = attendanceInfoMapper.insertSelective(attendanceInfo);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {

        }

        return false;
    }

    @Override
    public boolean updateAttendance(AttendanceInfo attendanceInfo) {
        try {
            int i = attendanceInfoMapper.updateByPrimaryKeySelective(attendanceInfo);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {

        }

        return false;
    }

    @Override
    public List<AttendanceInfo> getAttendanceInfoList(AttendanceInfo attendanceInfo) {
    	AttendanceInfoExample attendanceInfoExample =new AttendanceInfoExample();
        
        Criteria criteria =attendanceInfoExample.createCriteria();
        if(attendanceInfo!=null) {
            //根据id查询
            if(attendanceInfo.getAttendanceId()!=null) {
                criteria.andAttendanceIdEqualTo(attendanceInfo.getAttendanceId());
            }
//            //根据name查询
//            if(attendanceInfo.getStaffName()!=null) {
//                staffInfo.setStaffName("%"+staffInfo.getStaffName()+"%");
//                criteria.andStaffNameLike(staffInfo.getStaffName());
//            }
//            //根据电话号码查询
//            if(staffInfo.getStaffMobilePhone()!=null) {
//                criteria.andStaffMobilePhoneEqualTo(staffInfo.getStaffMobilePhone());
//            }
            //1代表正常  0代表删除
     //       查询所有正常的员工的数据
    //        attendanceInfo.setAttendanceState("1");
            
        }
        criteria.andAttendanceStateEqualTo("1");
       
        
        return attendanceInfoMapper.selectByExample(attendanceInfoExample);
    }

    @Override
    public AttendanceInfo getAttendanceInfo(Integer attendanceId) {
        
        return attendanceInfoMapper.selectByPrimaryKey(attendanceId);
    }

}
