import com.jinxin.manager.util.ShiroKit;
import org.junit.Test;

/**
 * Created by yezhangyuan on 2017-12-14.
 *
 * @author yezhangyuan
 */
public class ShiroTest {

	@Test
	public void test() {
		String password = ShiroKit.md5("123123", "pwx4m8snj9");
		String password2 = ShiroKit.md5("123123", "pwx4m8snj9");
		System.out.println("p1 :" + password);
		System.out.println("p2 :" + password2);
	}
}
