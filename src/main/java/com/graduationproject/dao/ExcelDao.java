package com.graduationproject.dao;

import java.util.List;

import com.graduationproject.domain.Apply;
import com.graduationproject.domain.ItemVO;
import com.graduationproject.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExcelDao {
	
	public List<User> exportUserExcel(@Param("user") User user, @Param("str") String str, @Param("start") int start, @Param("pageSize") int pageSize);

	public int importUserExcel(User user);
	public int importSignlnExcel(User user);

	public List<ItemVO> exportPublicityExcel(@Param("status") String[] status, @Param("apply") Apply apply, @Param("user") User user, @Param("str") String str, @Param("start") int start, @Param("pageSize") int pageSize);


}
