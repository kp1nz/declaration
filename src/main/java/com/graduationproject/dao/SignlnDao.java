package com.graduationproject.dao;

import com.graduationproject.domain.Signln;
import com.graduationproject.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SignlnDao {
	
	/**
	 * 用户登录
	 * @param signln
	 * @return
	 */
	public Signln login(Signln signln);

	/**
	 * 显示登录账户
	 * @return
	 */
	public List<Signln> show();

	/**
	 * 通过用户名获取对应的User对象
	 * @param user_name
	 * @return
	 */
	public User getUserByName(String user_name);

}
