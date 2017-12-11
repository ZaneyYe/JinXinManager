import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jinxin.manager.po.BlogArticle;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.Serializable;

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

		String jsonStr2 = "\"{\\\"id\\\":4,\\\"title\\\":\\\"\\xe6\\xb9\\x96\\xe5\\xb7\\x9e\\xe7\\x9b\\x9b\\xe4\\xbc\\x9a\\\",\\\"summary\\\":\\\"hello world\\\",\\\"articleType\\\":2,\\\"article\\\":\\\"&lt;p&gt;\\xe7\\xa5\\x9e\\xe5\\xa5\\x87\\xe7\\x9a\\x84\\xe4\\xba\\x8b\\xe6\\x83\\x85\\xef\\xbc\\x8cbug\\xe8\\xa7\\xa3\\xe5\\x86\\xb3\\xe4\\xba\\x86&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://localhost/1512722103037_7.\\xe5\\xbe\\xae\\xe4\\xbf\\xa1\\xe5\\x9b\\xbe\\xe7\\x89\\x87_20170912084710.jpg&quot; title=&quot;&quot; alt=&quot;1512722103037_7.\\xe5\\xbe\\xae\\xe4\\xbf\\xa1\\xe5\\x9b\\xbe\\xe7\\x89\\x87_20170912084710.jpg&quot;/&gt;&lt;/p&gt;\\\",\\\"support\\\":0,\\\"secret\\\":0,\\\"creattime\\\":1512722110000,\\\"updatetime\\\":1512722110000}\"\n";
		BlogArticle blogArticle = objectMapper.readValue(jsonStr2, BlogArticle.class);
		System.out.println(blogArticle);
	}

}
