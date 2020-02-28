package com.factory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.factory.entity.PurchaseStorageDetails;
import com.factory.entity.PurchaseStorageDetailsExample;

public interface PurchaseStorageDetailsMapper {
	
	//1.根据主表编号查询全部（查询）
	public List<PurchaseStorageDetails> queryPSDAll(@Param("psdDocumentNumber") String psdDocumentNumber);
	
	
	
	
	
    int countByExample(PurchaseStorageDetailsExample example);

    int deleteByExample(PurchaseStorageDetailsExample example);

    int deleteByPrimaryKey(Integer psdId);

    int insert(PurchaseStorageDetails record);

    int insertSelective(PurchaseStorageDetails record);

    List<PurchaseStorageDetails> selectByExample(PurchaseStorageDetailsExample example);

    PurchaseStorageDetails selectByPrimaryKey(Integer psdId);

    int updateByExampleSelective(@Param("record") PurchaseStorageDetails record, @Param("example") PurchaseStorageDetailsExample example);

    int updateByExample(@Param("record") PurchaseStorageDetails record, @Param("example") PurchaseStorageDetailsExample example);

    int updateByPrimaryKeySelective(PurchaseStorageDetails record);

    int updateByPrimaryKey(PurchaseStorageDetails record);
}