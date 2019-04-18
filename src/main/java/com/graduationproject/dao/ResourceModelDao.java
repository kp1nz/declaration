package com.graduationproject.dao;

import java.util.List;

import com.graduationproject.domain.ResourceModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResourceModelDao {
	
	public List<ResourceModel> listResourceModel();
	
	public Long count();
	
	public int addResourceModel(ResourceModel ResourceModel);


}
