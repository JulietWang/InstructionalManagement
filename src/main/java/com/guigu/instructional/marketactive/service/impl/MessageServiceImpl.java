package com.guigu.instructional.marketactive.service.impl;

import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.guigu.instructional.marketactive.mapper.MessageInfoMapper;
import com.guigu.instructional.marketactive.mapper.MessageVOMapper;
import com.guigu.instructional.marketactive.service.MessageService;
import com.guigu.instructional.po.EmailInfoExample;
import com.guigu.instructional.po.MessageInfo;
import com.guigu.instructional.po.MessageInfoExample;
import com.guigu.instructional.po.MessageInfoExample.Criteria;
import com.guigu.instructional.po.MessageVO;
import com.guigu.instructional.po.StaffInfo;

import com.guigu.instructional.system.mapper.StaffInfoMapper;
@Service("messageServiceImpl")
public class MessageServiceImpl implements MessageService{
	@Resource(name="messageInfoMapper")
	private MessageInfoMapper messageInfoMapper;
	
	@Resource(name="staffInfoMapper")
	private StaffInfoMapper staffInfoMapper;
	
	@Resource(name="messageVOMapper")
	private MessageVOMapper messageVOMapper;
	
	@Override
	public MessageVO findMsgById(Integer id) {
		String staffName="";
		MessageInfo messageInfo=messageInfoMapper.selectByPrimaryKey(id);
		StaffInfo staffInfo=staffInfoMapper.selectByPrimaryKey(messageInfo.getStaffId());
		if(staffInfo!=null) {
			staffName=staffInfo.getStaffName();
		}
		MessageVO messageVO=new MessageVO();
		try {
			BeanUtils.copyProperties(messageVO,messageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		messageVO.setStaffName(staffName);
		return messageVO;
	}

	@Override
	public List<MessageInfo> getMsgStaff(MessageInfo messageInfo) {
		MessageInfoExample messageInfoExample=new MessageInfoExample();
		Criteria criteria=messageInfoExample.createCriteria();
		if(messageInfo!=null) {
			if(messageInfo.getMessagePhone()!=null) {
				messageInfo.setMessagePhone("%"+messageInfo.getMessagePhone()+"%");
				criteria.andMessagePhoneLike(messageInfo.getMessagePhone());
			}
		}
		return messageInfoMapper.selectByExample(messageInfoExample);
	}

	@Override
	public boolean addMsg(MessageVO messageVO) {
		try {
            int i =messageVOMapper.addMessage(messageVO);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {

        }

        return false;
	}

	@Override
	public boolean deleteMsg(Integer msgId) {
		int i=messageInfoMapper.deleteByPrimaryKey(msgId);
		if (i>0) {
			return true;
		}
		return false;
	}

}
