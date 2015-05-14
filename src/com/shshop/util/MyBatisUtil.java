package com.shshop.util;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;

	private MyBatisUtil() {
	}

	static {
		Reader reader = null;
		String resource = "com/shshop/util/MyBatisConfig.xml";
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}

		factory = new SqlSessionFactoryBuilder().build(reader);
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return factory;
	}
}