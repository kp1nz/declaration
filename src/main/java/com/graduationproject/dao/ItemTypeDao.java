package com.graduationproject.dao;

import java.util.List;

import com.graduationproject.domain.ItemType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;

@Mapper
public interface ItemTypeDao {
	
	public List<ItemType> list();
	
	public List<ItemType> listItemType(@Param("itemType_name") String itemType_name, @Param("start") int start, @Param("pageSize") int pageSize);

	public Long count(@Param("itemType_name") String itemType_name);
	
	public int updateItemType(ItemType itemType);

	public int addItemType(ItemType itemType);

	public int deleteItemType(Integer itemType_id);

	public int deleteItemTypeBatchs(@Param("ids") Integer[] ids);

	public int addCount(Integer item_id);

	public int addCountBatchs(@Param("ids") Integer[] ids);


}
