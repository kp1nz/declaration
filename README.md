项目申报的流程：
  
--->申报人申报项目
--->对应的系部管理员审核
--->项目管理员分配评审专家(只有审核过了才能分配)
--->评审专家评审
--->项目管理员审批
--->（最后调整系统开关为结束本次工作）

（每到一个阶段，都打开对应的系统流程开关）	

issue：添加项目时，review1_status 没进行设置
						
系部管理员  user_type = 3 ：

		系部人员管理：
			本系用户列表：查询的是user_type=5的本系人员
		系部审核管理：
			本系申报情况：查询的是history_flag=1（正在申报）并且 
						  user_department=当前登录的人员的所属系部（是这个系下面的人员申报）的项目
			当前项目审核：
				待审核的项目：	传的固定参数是review1_status=1（未审核状态）&history_flag=1（正在申报的项目）
									查询：history_flag = 1，
										apply.user_department = 当前登录的user所属的系，
										review1.review1_status IN ( 1 )  
										user.real_name = apply.item_user ，
										apply.item_id = review1.item_id     进行3表联查（apply，user，review1）
									
									sql语句如下：
										SELECT review1.*, apply.*, user.* 
											FROM review1, apply, user 
											WHERE apply.item_id = review1.item_id 
											AND user.real_name = apply.item_user 
											AND review1.review1_status IN ( 1 ) 
											AND apply.user_department = '信息安全系'
											AND history_flag = 1 LIMIT 1,15
				查看本次审核：	传的固定参数是review1_status=2&review1_status=3（已审核）&history_flag=1（正在申报的项目）
									查询：sql语句和上面的一样  只是将review1_status 改为（2,3）
		历史审核查询：
			历史所有审核记录：	传的固定的参数是review1_status=2&review1_status=3（已审核）&history_flag=2（历史申报记录）
									查询：sql语句和上面的一样  只是将review1_status 改为（2,3） history_flag 改为2
			审核通过列表：		传的固定的参数是review1_status=2（已审核 并且 审核通过 ）&history_flag=2（历史申报记录）
									查询：sql语句和上面的一样  只是将review1_status 改为 2 history_flag 改为2
			审核未通过列表：	传的固定的参数是review1_status=3（已审核 并且 审核未通过 ）&history_flag=2（历史申报记录）
									查询：sql语句和上面的一样  只是将review1_status 改为 3 history_flag 改为2
评审专家  user_type = 4：

		我的评审管理：
			（以下查询都会先判断config_flag项目进度是否为专家评审阶段，如果不是则无法获取到数据）
			评审项目列表：  	传的固定参数是history_flag=1
			待评审的项目：		传的固定参数是review2_status=1 & history_flag=1
			
			查看本次评审：		传的固定参数是review2_status=2 & history_flag=1
项目管理员	user_type = 2:

		当前审批管理：				
			待审批的项目：		传的固定参数是publicity_status=1（未审批）& history_flag=1（正在申报的项目）
									
			本次审批结果：		传的固定参数是publicity_status=2&publicity_status=3（已审批）& history_flag=1（正在申报的项目）
			
		历史审批查询：			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			