package com.redis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

import com.poly.servlet.InitServlet;

public class RedisManager {

	private static JedisPool pool;
	
	private static JedisPool pool2;

	private static JedisPool pool3;
	
	private static int preTomIdx = 0;
	
	private static int timeout=2000;

	// ��̬�����ʼ��������

	static {

		try {

			Properties props = new Properties();
			props.load(RedisManager.class.getClassLoader().getResourceAsStream("redis.properties"));

			// ����jedis������ʵ��
			JedisPoolConfig config = new JedisPoolConfig();
			// ���ó�������ֵ
			config.setMinIdle(Integer.valueOf(props.getProperty("jedis.pool.minIdle")));
			config.setMaxIdle(Integer.valueOf(props.getProperty("jedis.pool.maxIdle")));
			config.setMaxWaitMillis(Long.valueOf(props.getProperty("jedis.pool.maxWaitMillis")));
			config.setTestOnBorrow(Boolean.valueOf(props.getProperty("jedis.pool.testOnBorrow")));
			config.setTestOnReturn(Boolean.valueOf(props.getProperty("jedis.pool.testOnReturn")));
			config.setMaxTotal(Integer.valueOf(props.getProperty("jedis.pool.maxActive")));
			//config.setMaxActive(Boolean.valueOf(props.getProperty("jedis.pool.maxActive")));

			preTomIdx = Integer.valueOf(props.getProperty("prepare.tomcat.index"));
			
			timeout = Integer.valueOf(props.getProperty("jedis.pool.timeout"));

			// ��������ʵ����jedis��
			pool = new JedisPool(config, props.getProperty("redis.ip"),
					Integer.valueOf(props.getProperty("redis.port")), timeout);
			pool2=new JedisPool(config, props.getProperty("redis.ip2"),
					Integer.valueOf(props.getProperty("redis.port2")), timeout);
			pool3=new JedisPool(config, props.getProperty("redis.ip3"),
					Integer.valueOf(props.getProperty("redis.port3")), timeout);
			
			System.out.println(">>> >>> redis is ready");

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	/** ���jedis���� */

	public static Jedis getJedisObject() {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
		} catch (Exception e) {
			if (jedis != null)
				pool.returnBrokenResource(jedis);
			jedis = pool.getResource();
			e.printStackTrace();
		}
		return jedis;
	}

	public static Jedis getJedis2Object() {
		Jedis jedis = null;
		try {
			jedis = pool2.getResource();
		} catch (Exception e) {
			if (jedis != null)
				pool2.returnBrokenResource(jedis);
			jedis = pool2.getResource();
			e.printStackTrace();
		}
		return jedis;
	}
	
	public static Jedis getJedis3Object() {
		Jedis jedis = null;
		try {
			jedis = pool3.getResource();
		} catch (Exception e) {
			if (jedis != null)
				pool3.returnBrokenResource(jedis);
			jedis = pool3.getResource();
			e.printStackTrace();
		}
		return jedis;
	}
	
	/** �黹jedis���� */

	public static void recycleJedis3Ojbect(Jedis jedis) {
		pool3.returnResource(jedis);
	}
	
	public static void recycleJedis2Ojbect(Jedis jedis) {
		pool2.returnResource(jedis);
	}

	public static void recycleJedisOjbect(Jedis jedis) {
		pool.returnResource(jedis);
	}
	
	public static long getIdx(String key) {
		Long idx = -1l;
		Jedis jedis = getJedisObject();// ���jedisʵ��
		idx = jedis.incr(key);
		System.out.println("idx:" + idx);
		recycleJedisOjbect(jedis);
		return idx;
	}

	// ȡΨһ��������redis.properties�����ļ���prepare.tomcat.index��������Ŀ¼tomcat�����֣�Tomcat1��Tomcat2��
	public static long getIdx() {
		String idxStr = "";
		int tom = preTomIdx;
		if (InitServlet.rootPath != null) {
			int begin = InitServlet.rootPath.indexOf("/Tomcat");
			if (begin > 0 && InitServlet.rootPath.length() >= begin + 8) {
				String tomFlag = InitServlet.rootPath.substring(begin + 7, begin + 8);
				tom = Integer.valueOf(tomFlag);
			}
		}
		idxStr = String.valueOf(tom);
		System.out.println("idxStr-----1--->" + idxStr);
		idxStr = idxStr + String.valueOf(System.currentTimeMillis());
		System.out.println("idxStr-----2--->" + idxStr);
		idxStr = idxStr + String.valueOf((int) (10 * Math.random()));
		System.out.println("idxStr-----3--->" + idxStr);
		return Long.valueOf(idxStr);
	}

	/**
	 * 
	 * ����jedis�ط���
	 */
	public static void main(String[] args) {
		Jedis jedis = getJedisObject();// ���jedisʵ��

		// list
		// String key = "tb_car_info:collection:��1null";

		String key = "tb_car_info:collection:����null";
		// List<String> list = new ArrayList<String>();
		// list.add("12");
		// String[] arr = new String[list.size()];
		// arr = list.toArray(arr);
		// jedis.lpush(key, arr);
		//
		// long len = jedis.llen(key);

		long len = jedis.zcount(key, 0, 1);

		// long len = jedis.del(key);
		// jedis.lrange(key, start, end);
		System.out.println("===>" + len);

		// String key = "tb_car_info:index:status:0";
		// long str = jedis.llen(key);
		// // jedis.lrange(key, start, end);
		// System.out.println("===>" + str);

		// set
		// String key = "tb_car_info:index:car_type:��";
		// String key2 = "tb_car_info:index:car_type:��";
		// // Set<String> set = jedis.smembers(key);
		// Set<String> set = jedis.sinter(key, key2);
		// System.out.println("===>" + set.size());
		// //
		// for (String id : set) {
		//
		// String ct = jedis.hget("tb_car_info:" + id, "car_type");
		//
		// System.out.println("===>" + ct);
		// }
		//
		// // ��ȡjedisʵ������Զ�redis�������һϵ�еĲ���
		// // jedis.lpush("123", "ddddd");
		// jedis.set("name", "dongqin");
		// System.out.println(jedis.get("name"));
		//
		// jedis.del("name");
		// System.out.println(jedis.exists("name"));
		// recycleJedisOjbect(jedis); // �� ��ȡ��jedisʵ�����󻹻�pool��
		//
		// String aaa = "/user/local/app/Tomcat6/webapp/zzz";
		// int begin = aaa.indexOf("/Tomcat");
		// String bbb = aaa.substring(begin + 7, begin + 8);
		// System.out.println(System.currentTimeMillis() + "-------->" +
		// getIdx());

	}
}
