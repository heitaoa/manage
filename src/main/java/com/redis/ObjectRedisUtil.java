package com.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import redis.clients.jedis.Jedis;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ObjectRedisUtil {
	public static final int timeout = 120;

	public static void saveDataObject(String key, Object object)
			throws IOException {
		saveDataObject(key, object, timeout);
	}

	public static void saveDataObject(String key, Object object, int timeout)
			throws IOException {
		// System.out.println("save " + key + " ...");
		Jedis jedis = null;
		try {
			jedis = RedisManager.getJedisObject();
			jedis.set(key, encode(serialize(object)));
			jedis.expire(key, timeout);
		} finally {
			if (jedis != null) {
				RedisManager.recycleJedisOjbect(jedis);
			}
		}
	}

	public static String encode(byte[] bytes) {
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(bytes);
	}

	public static byte[] decode(String value) {
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			return decoder.decodeBuffer(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object getDataObject(String key)
			throws ClassNotFoundException, IOException {
		return getDataObject(key, true);
	}

	public static Object getDataObject(String key, boolean getNewTime)
			throws ClassNotFoundException, IOException {
		// System.out.println("get " + key + " ...");
		Object result = null;
		Jedis jedis = null;
		try {
			jedis = RedisManager.getJedisObject();
			String value = jedis.get(key);

			if (value != null) {
				byte[] data = decode(value);
				if (getNewTime) {
					jedis.expire(key, timeout);
				}
				result = unSerialize(data);
			}
		} finally {
			if (jedis != null) {
				RedisManager.recycleJedisOjbect(jedis);
			}
		}
		return result;
	}

	public static byte[] serialize(Object object) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(object);
		return baos.toByteArray();
	}

	public static Object unSerialize(byte[] bytes)
			throws ClassNotFoundException, IOException {
		ByteArrayInputStream bios = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bios);
		return ois.readObject();
	}
}
