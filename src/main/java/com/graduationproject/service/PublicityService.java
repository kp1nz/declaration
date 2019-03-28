package com.graduationproject.service;
import java.util.Map;

import com.graduationproject.domain.Apply;
import com.graduationproject.domain.Publicity;
import com.graduationproject.domain.User;

public interface PublicityService {
	
	/**
	 * 显示立项列表
	 * @param publicity_status
	 * @param apply
	 * @param user
	 * @param str
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> listPublicity(String publicity_status, Apply apply, User user, String str, int currentPage, int pageSize);

	/**
	 * 添加立项项目
	 * @param item_id
	 */
	public void addPublicity(Integer item_id);

	/**
	 * 更新立项项目信息
	 * @param publicity
	 */
	public void updatePublicity(Publicity publicity);

}
