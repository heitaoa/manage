package com.redis;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import redis.clients.jedis.Jedis;

/**
 * redis 数据操作工具类，
 * @author niuhaidong
 * redisKey 规范如下
 * 
 * 1. 列表集合类的数据
 * 数据库表名:list:表的主键:主键值
 * 如：dbo_key_answer:list:questionid:41664
 * 
 * 2. 单条表数据
 * 数据库表名:表的主键:主键值
 * 如：dbo_key_answer:id:123
 */
public class RedisUtil {

	/**
	 * 将每一页的数据id集合保存到 redisKey 内 
	 * @param redisKey 分页保存id集合的key
	 * @param scoreMembers Map<String, Double>
	 * 		                key = 表主键的值
	 * 						value = 权重值（用于排序用，通常用id主键）    
	 */
	public static void insertList(String redisKey, Map<String, Double> scoreMembers ) {
		Jedis jedis = RedisManager.getJedisObject();
		try { 
			jedis.zadd(redisKey, scoreMembers);
		} finally { 
			RedisManager.recycleJedisOjbect(jedis);
		}	
	}
	
	/**
	 * 保存数据库一条记录到 redisKey 内 
	 * @param redisKey 
	 * @param entity 表的javaBean，或者其他Bean
	 * @throws Exception 
	 */
	public static void insertMap(String redisKey, Object entity) throws Exception {
		Jedis jedis = RedisManager.getJedisObject();
		Map<String, String> destMap = beanToMap(entity);
		try { 
			jedis.hmset(redisKey, destMap);
		} finally { 
			RedisManager.recycleJedisOjbect(jedis);
		}	
	}

	/**
	 * 根据key查出总记录数
	 * @param listKey  redisKey
	 * @return
	 */
	public static int queryCount(String redisKey) {
		Jedis jedis = RedisManager.getJedisObject();
		int count = 0;
		try {
			count = jedis.zcount(redisKey, "-inf", "+inf").intValue();
		} finally { 
			RedisManager.recycleJedisOjbect(jedis);
		}
		return count;
	}

	/**
	 * 分页查询
	 * @param listKey 		 分页储存的 id 集合的 redisKey
	 * @param mapKeyPrefix  每一条具体记录在redis内的 redisKey前缀
	 * @param page  		 第几页 从 0 开始
	 * @param size  		 每页显示多少条记录
	 * @param sort  		 排序   asc  或 desc
	 * @param clazz 		 需要转换的javaBean对象类型   如：AnswerEntity.class
	 * @return
	 * @throws  			 Exception  
	 */
	public static List queryPage(String redisKey, String mapKeyPrefix, int page, int size, String sort, Class clazz) throws Exception {
		Jedis jedis = RedisManager.getJedisObject();
		// 循环每个id，查询的每个id对应的明细数据
		List resultList = new ArrayList();
		int from = (page - 1) * size;
		int end = page * size - 1; 
		Set<String> idlist = null;
		try {
			// 查询某一页的所有 id 集合
			if ("asc".equals(sort))
				idlist = jedis.zrange(redisKey, from, end);
			else
				idlist = jedis.zrevrange(redisKey, from, end);
			
			for (int i = 0; i < idlist.size(); i++) {
				Map<String, String> origMap = jedis.hgetAll(mapKeyPrefix + idlist.toArray()[i]);
				Object dest = clazz.newInstance();
				BeanUtils.copyProperties(dest, origMap);
				resultList.add(dest);
			}
		} finally { 
			RedisManager.recycleJedisOjbect(jedis);
		}
		return resultList;
	}

	public static Map<String, String> beanToMap(Object obj) {
		 if(obj == null){  
	            return null;  
	        }          
	        Map<String, String> map = new HashMap<String, String>();  
	        try {  
	            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
	            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
	            for (PropertyDescriptor property : propertyDescriptors) {  
	                String key = property.getName();  
	  
	                // 过滤class属性  
	                if (!key.equals("class")) {  
	                    // 得到property对应的getter方法  
	                    Method getter = property.getReadMethod();  
	                    Object value = getter.invoke(obj);  
	                    if(value == null) {
	                    	map.put(key, ""); 
	                    } else {
	                    	map.put(key, value.toString()); 
	                    }
	                     
	                }  
	  
	            }  
	        } catch (Exception e) {               
	            System.out.println("transBean2Map Error " + e);  
	        }  
	  
	        return map;  
	}
	
	public static void main(String[] args) throws Exception{
		
	}
}
