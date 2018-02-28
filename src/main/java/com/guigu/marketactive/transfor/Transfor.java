package com.guigu.marketactive.transfor;

import org.displaytag.decorator.ColumnDecorator;
import org.displaytag.exception.DecoratorException;
public class Transfor implements ColumnDecorator{

	@Override
	public String decorate(Object state) throws DecoratorException {
		Integer st=(Integer) state;
		if(st==0) {
			return "准备中";
		}
		if (st==1) {
			return "开始";
		}
		if (st==2) {
			return "进行中";
		}else {
			return "已结束";
		}
		
	}

}
