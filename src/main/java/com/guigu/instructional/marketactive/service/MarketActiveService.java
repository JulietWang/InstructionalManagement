package com.guigu.instructional.marketactive.service;

import java.util.List;

import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveVO;

public interface MarketActiveService {

	public boolean updateActive(MarketActiveVO marketActiveVO);

	public MarketActiveVO findActiveById(Integer id);

	public List<MarketActive> getActiveStaff(MarketActive marketActive);
	
	
	/**
	 * getActiveList:根据条件编号查询市场营销信息
	 * 
	 * @author 王珠玲
	 * @param marketActive
	 * @return <br/>
	 * @since JDK 1.8
	 */
	public List<MarketActive> getActiveList(MarketActive marketActive);

	public boolean addActive(MarketActiveVO marketActiveVO);

	/**
	 * getMarketActive:根据条件编号查询市场营销信息
	 * 
	 * @author 王珠玲
	 * @param marketActive
	 * @return <br/>
	 * @since JDK 1.8
	 */
	public List<MarketActive> getMarketActive(Integer staffId);

	public boolean deleteActive(Integer activeId);

}