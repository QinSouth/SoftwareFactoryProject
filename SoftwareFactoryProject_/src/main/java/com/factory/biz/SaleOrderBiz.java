package com.factory.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.entity.SaleOrder;
import com.factory.entity.SaleOrderDetail;
import com.factory.mapper.SaleOrderMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SaleOrderBiz {
		
	@Autowired
	private SaleOrderMapper dao;
	@Autowired
	private SaleOrderDetailBiz DetailBiz;
	
	//分页查询---销售订单
	public PageInfo<SaleOrder> PageQueryAll(SaleOrder secord){
		System.out.println(secord.getPageNum());
		PageHelper.startPage(secord.getPageNum(), 1);
		List<SaleOrder> list=dao.PageQueryAll();//主表信息
		System.out.println("显示主表编号"+list.get(0).getSoId());
		List<SaleOrderDetail> detail=DetailBiz.queryAlldetail(list.get(0).getSoId());
		System.out.println("显示详表查询结果"+detail.get(0).getMatterId());
		PageInfo<SaleOrder> page=new PageInfo<SaleOrder>(list);
		page.getList().get(0).setSodList(detail);
		return page;
	}
	
	
	//新增销售订单
    public boolean insertSaleOrder(SaleOrder record) {
    	return dao.insert(record) > 0;
    };
    
  //修改销售订单
    public boolean updateSaleOrder(SaleOrder record) {
    	boolean bool=false;
    	boolean b=dao.updateAll(record)>0;
    	boolean b2=DetailBiz.deleteAll();
    	if(b2) {
    		System.out.println("删除详表成功！");
    	}
    	boolean b3=DetailBiz.insertSelective(record.getSodList());
    	if(b3) {
    		System.out.println("新增详表成功！");
    	}
    	if(b&&b2&&b3) {
    		bool=true;
    	}
    	return bool;
    };
    
    //根据id删除销售订单
    public boolean deleteById(int id) {
    	boolean b=false;
    	if(DetailBiz.deleteByIddetail(id)) {
    		 if(dao.deleteById(id)>0) {
    			 b=true;
    		 }
    	}
    	return b;
    }
	
}
