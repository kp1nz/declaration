package com.graduationproject.service;

import java.util.Map;

import com.graduationproject.domain.ResourceModel;

public interface ResourceModelService {
	
	public Map<String, Object> listResourceModel();

	public void addResourceModel(ResourceModel resourceModel);

}
