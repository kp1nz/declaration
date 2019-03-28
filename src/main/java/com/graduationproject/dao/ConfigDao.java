package com.graduationproject.dao;

import java.util.List;

import com.graduationproject.domain.Config;

import javax.annotation.Resource;

@Resource
public interface ConfigDao {
	
	/**
	 * 系统控制开关
	 * @return
	 */
	public int updateConfig(Config config);

	/**
	 * 显示信息
	 * @return
	 */
	public List<Config> show();

	/**
	 * 总记录数
	 * @return
	 */
	public Long count();

	/**
	 * 获得当前状态
	 * @return
	 */
	public String getConfigStatus();

}
