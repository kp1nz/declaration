package com.graduationproject.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.graduationproject.dao.ConfigDao;
import com.graduationproject.dao.SignlnDao;
import com.graduationproject.domain.Signln;
import com.graduationproject.domain.User;
import com.graduationproject.service.SignlnService;
import org.springframework.stereotype.Service;


@Service
public class SignlnServiceImpl implements SignlnService {
	
	@Resource(name="signlnDao")
	private SignlnDao signlnDao;
	
	@Resource(name="configDao")
	private ConfigDao configDao;

	@Override
	public Signln login(Signln signln) {
		Signln si = signlnDao.login(signln);
		return si;
	}

	@Override
	public List<Signln> show() {
		List<Signln> list = signlnDao.show();
		return list;
	}

	@Override
	public User getUserByName(String user_name) {
		User user = signlnDao.getUserByName(user_name);
		return user;
	}

	@Override
	public String getConfigStatus() {
		String config_flag = configDao.getConfigStatus();
		return config_flag;
	}

}
