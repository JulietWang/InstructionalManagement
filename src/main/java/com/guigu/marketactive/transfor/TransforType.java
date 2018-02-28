package com.guigu.marketactive.transfor;

import org.displaytag.decorator.ColumnDecorator;
import org.displaytag.exception.DecoratorException;
public class TransforType implements ColumnDecorator{

	@Override
	public String decorate(Object state) throws DecoratorException {
		Integer st=(Integer) state;
		if(st==0) {
			return "现场交流";
		}
		else if(st==1) {
			return "会议";
		}
		else {
			return "其他";
		}
	}

}
