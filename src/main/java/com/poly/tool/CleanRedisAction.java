package com.poly.tool;

import com.poly.action.MyActionSupport;
import com.redis.RedisDao;

public class CleanRedisAction extends MyActionSupport {

	public String cleanRedisIndex() {
		setErr("首页redis数据清除：" + RedisDao.cleanCheIndex());
		return ERROR;
	}

}
