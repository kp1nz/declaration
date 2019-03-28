package com.graduationproject.service;

import com.graduationproject.domain.Config;

import java.util.Map;


public interface ConfigService {
	
	
	/**
	 * 系统控制开关
	 */
	public void updateConfig(Config config);

	/**
	 * 显示信息
	 * @return
	 */
	public Map<String, Object> show();

	/**
	 * 获得当前状态
	 * @return
	 */
	public String getConfigStatus();

}
