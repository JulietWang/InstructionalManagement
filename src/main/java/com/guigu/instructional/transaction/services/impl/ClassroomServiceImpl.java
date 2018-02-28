package com.guigu.instructional.transaction.services.impl;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.guigu.instructional.po.ClassInfo;
import com.guigu.instructional.po.ClassTransactionInfo;
import com.guigu.instructional.po.ClassTransactionInfoExample;

import com.guigu.instructional.po.ClassroomInfo;
import com.guigu.instructional.po.ClassroomInfoExample;
import com.guigu.instructional.po.ClassroomInfoExample.Criteria;
import com.guigu.instructional.transaction.mapper.ClassInfoMapper;
import com.guigu.instructional.transaction.mapper.ClassMapper;
import com.guigu.instructional.transaction.mapper.ClassTransactionInfoMapper;
import com.guigu.instructional.transaction.mapper.ClassroomInfoMapper;
import com.guigu.instructional.transaction.services.ClassroomServices;

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

@Service("classroomServiceImpl")
public class ClassroomServiceImpl implements ClassroomServices {

    // @Autowired
    // @Qualifier
    @Resource(name = "classroomInfoMapper")
    private ClassroomInfoMapper classroomInfoMapper;
    
    @Resource(name = "classTransactionInfoMapper")
    private ClassTransactionInfoMapper classTransactionInfoMapper;
    
    
    @Resource(name = "classInfoMapper")
    private ClassInfoMapper classInfoMapper;
    
    @Resource(name="")
    private ClassMapper classMapper;
    
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public boolean addClassroomInfo(ClassroomInfo classroomInfo) {
    	if(classroomInfo!=null) {
    		classroomInfo.setClassroomMark("1");
		}
        try {
            int i = classroomInfoMapper.insertSelective(classroomInfo);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {

        }

        return false;
    }

    @Override
    public boolean updateClassroomInfo(ClassroomInfo classroomInfo) {
        try {
            int i = classroomInfoMapper.updateByPrimaryKeySelective(classroomInfo);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {

        }

        return false;
    }

    @Override
    public List<ClassroomInfo> getClassroomInfoList(ClassroomInfo classroomInfo) {
    	ClassroomInfoExample classroomInfoExample =new ClassroomInfoExample();
        
        Criteria criteria =classroomInfoExample.createCriteria();
        if(classroomInfo!=null) {
            //根据id查询
            if(classroomInfo.getClassroomId()!=null) {
                criteria.andClassroomIdEqualTo(classroomInfo.getClassroomId());
            }
            //根据name查询
            if(classroomInfo.getClassroomName()!=null) {
            	classroomInfo.setClassroomName("%"+classroomInfo.getClassroomName()+"%");
                criteria.andClassroomNameLike(classroomInfo.getClassroomName());
            }
            //1代表正常  0代表删除
            //查询所有正常的员工的数据
//            staffInfo.setStaffState("1");
            
        }
//        criteria..andStaffStateEqualTo("1");
       
        criteria.andClassroomMarkEqualTo("1");
        return classroomInfoMapper.selectByExample(classroomInfoExample);
    }

    @Override
    public ClassroomInfo getClassroomInfo(Integer classroomId) {
        
        return classroomInfoMapper.selectByPrimaryKey(classroomId);
    }

	@Override
	public List<ClassroomInfo> findClassMap()  {
//		 String resource = "ClassMapper.xml";
//         InputStream inputStream = Resources.getResourceAsStream(resource);
//         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//         SqlSession sqlSession = sqlSessionFactory.openSession();
//
//         // 创建代理对象
//         ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);

         List<ClassroomInfo> list = classMapper.findClassMap();
        
         return list;
	}

	@Override
	public ClassInfo getClassInfo(Integer classroomId) {
		
		return classInfoMapper.selectByID(classroomId);
	}

	@Override
	public List<ClassTransactionInfo> getClasstransInfoList1(ClassTransactionInfo classTransactionInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassTransactionInfo getClassTransactionInfo(Integer classId) {
		return classTransactionInfoMapper.selectById(classId);
	}



	

}
