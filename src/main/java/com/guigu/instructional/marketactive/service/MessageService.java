package com.guigu.instructional.marketactive.service;

import java.util.List;
import com.guigu.instructional.po.MessageInfo;
import com.guigu.instructional.po.MessageVO;

public interface MessageService {
	
	public MessageVO findMsgById(Integer id);
	
	public List<MessageInfo> getMsgStaff(MessageInfo messageInfo);
	
	public boolean addMsg(MessageVO messageVO);
	
	public boolean deleteMsg(Integer msgId);
}
