import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Created by yezhangyuan on 2017-12-11.
 *
 * @author yezhangyuan
 */
public class JedisTest {

	private Jedis jedis = null;

	@Before
	public void init() {
		jedis = new Jedis("192.168.43.3", 6379, 50000);
	}

	public static class Student implements Serializable {
		private String name;
		private Integer age;

		public Student(String name, Integer age) {
			this.name = name;
			this.age = age;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public Integer getAge() {
			return age;
		}

		@Override
		public String toString() {
			return "Student{" +
					"name='" + name + '\'' +
					", age=" + age +
					'}';
		}
	}

	@Test
	public void test() throws JsonProcessingException {
//		System.out.println(jedis.ping());
////		jedis.set("result", "ok");
//		jedis.set("wade","韦德");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		Student stu = new Student("韦德", 37);
		String jsonStr = objectMapper.writer().writeValueAsString(stu);
		System.out.println(jsonStr);
	}

	public static void main(String[] args) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//		Student stu = new Student("韦德", 37);
//		String jsonStr = objectMapper.writeValueAsString(stu);
//
//		BlogArticle blogArticle = objectMapper.readValue(jsonStr2, BlogArticle.class);
//		System.out.println(blogArticle);
		List<String> strList = Collections.singletonList("a");
		System.out.println(strList.size());

	}

}
