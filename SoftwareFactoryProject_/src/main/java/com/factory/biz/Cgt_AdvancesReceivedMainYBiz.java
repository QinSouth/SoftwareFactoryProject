package com.factory.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.entity.AdvancesReceivedMainY;
import com.factory.mapper.AdvancesReceivedMainYMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class Cgt_AdvancesReceivedMainYBiz {

	@Autowired
	private AdvancesReceivedMainYMapper dao;

	// 根据当前日期查询单据号码
	public String gt_select_payablestime(String payablestime) {
		int count = dao.gt_select_payablestime("%" + payablestime + "%")+1;
		
		String ptimecount = String.valueOf(count);
		String [] str = payablestime.split("-");
		String ptime = "";
		for (int i = 0; i < str.length; i++) {
			ptime += str[i];
		}
		if (count < 10) {
			ptime += "0" + ptimecount;
		}else if (count < 100) {
			ptime += ptimecount;
		}
		return ptime;
	}
	
	public PageInfo<AdvancesReceivedMainY> queryAdvancesReceivedMainYAllDESC(AdvancesReceivedMainY record){
    	PageHelper.startPage(record.getPageNum(), record.getPageSize());
    	List<AdvancesReceivedMainY> adrmyList = dao.selectAdvancesReceivedMainYAllDESC();
    	PageInfo<AdvancesReceivedMainY> page = new PageInfo<AdvancesReceivedMainY>(adrmyList); 
    	return page;
    }
	
}
