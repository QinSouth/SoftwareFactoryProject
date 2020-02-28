package com.factory.mapper;

import com.factory.entity.PurchaseStorage;
import com.factory.entity.PurchaseStorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseStorageMapper {
	
	//0.根据当前日期查询单据号码
	public Integer queryPSDocumentNumber(@Param("documentdate") String psDocumentDate);
	
	//1.查询全部（查询、分页）
	public List<PurchaseStorage> queryPSAll();
	
	
	
	
    int countByExample(PurchaseStorageExample example);

    int deleteByExample(PurchaseStorageExample example);

    int deleteByPrimaryKey(String psDocumentNumber);

    int insert(PurchaseStorage record);

    int insertSelective(PurchaseStorage record);

    List<PurchaseStorage> selectByExample(PurchaseStorageExample example);

    PurchaseStorage selectByPrimaryKey(String psDocumentNumber);

    int updateByExampleSelective(@Param("record") PurchaseStorage record, @Param("example") PurchaseStorageExample example);

    int updateByExample(@Param("record") PurchaseStorage record, @Param("example") PurchaseStorageExample example);

    int updateByPrimaryKeySelective(PurchaseStorage record);

    int updateByPrimaryKey(PurchaseStorage record);
    
}