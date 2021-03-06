package com.graduationproject.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.graduationproject.domain.Apply;
import com.graduationproject.domain.Review2;
import com.graduationproject.domain.User;
import com.graduationproject.service.Review2Service;
import com.graduationproject.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/review2")
public class Review2Controller {
	
	@Resource
	private Review2Service review2Service;
	
	@RequestMapping("/expert/review2Manage")
	public String review2Manage(HttpServletRequest request, Review2 review2,
			@RequestParam(value = "history_flag", required = false) String history_flag) {
		/**
		 * 传入的review2对象主要包括review2_user（user.getReal_name()）、review2_status字段
		 */
		request.setAttribute("history_flag", history_flag);
		User user = (User)request.getSession().getAttribute("user");
		if("4".equals(user.getUser_type())) {
			String review2_user = user.getReal_name();
			review2.setReview2_user(review2_user);
		}
		request.setAttribute("review2", review2);
		return "expert/review2Manage";
	}
	
	@RequestMapping("/listReview2")
	@ResponseBody
	public Map<String, Object> listReview2(
			//page第几页，rows每页多少行
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "str", required = false) String str,
			Apply apply, Review2 review2, User user) {
		/**
		 * 传入的review2对象主要包括review2_user、review2_status字段
		 * 传入的apply对象主要包括history_flag、item_type字段
		 */
		//System.out.println("apply:" + apply);
		//System.out.println("review2:" + review2);
		int currentPage = Integer.parseInt(page);
		int pageSize = Integer.parseInt(rows);
		Map<String, Object> map = review2Service.listReview2(review2, apply, user, str, currentPage, pageSize);
		return map;
	}

	/**
	 * 分配评审专家  调用的接口
	 */
	@RequestMapping("/addReview2")
	@ResponseBody
	public JsonResult addReview2(Integer item_id, String review2_user) {
		//System.out.println("1:" + item_id);
		//System.out.println("2:" + review2_user);
		review2Service.addReview2(item_id, review2_user);
		return new JsonResult();
	}
	
	@RequestMapping("/updateReview2")
	@ResponseBody
	public JsonResult updateReview2(Review2 review2) {
		//System.out.println(review2);
		review2Service.updateReview2(review2);
		return new JsonResult();
	}

}
