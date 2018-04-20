import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * Created by yezhangyuan on 2018-04-20.
 *
 * @author yezhangyuan
 */
public class SecretUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecretUtil.class);

	private static final String ALGORITHM_SHA256 = "SHA-256";

//	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//		byte[] data = "appId=a5949221470c4059b9b0b45a90c81527&nonceStr=Wm3WZYTPz0wzccnW&secret= 388f9cb4a0df474883a32bec19da747f&timestamp=1414587457".getBytes();
//		System.out.println(sha256_new(data));
////		System.out.println(new String(sha256("hello".getBytes())));
//	}

	/**
	 * sha256计算.
	 *
	 * @param
	 * @return 计算结果
	 */
	private static byte[] sha256(byte[] data) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(ALGORITHM_SHA256);
			md.reset();
			md.update(data);
			return md.digest();
		} catch (Exception e) {
			LOGGER.error("error", e);
			return null;
		}
	}

	public static String sha256_new(byte[] data) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			return bytesToHex(md.digest(data));
		} catch (Exception ex) {
//			logger.info("Never happen.", ex);
			return null;
		}
	}


	/**
	 * 将byte数组转换成16进制字符串
	 *
	 * @param bytes
	 * @return 16进制字符串
	 */
	public static String bytesToHex(byte[] bytes) {
		String hexArray = "0123456789abcdef";
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		for (byte b : bytes) {
			int bi = b & 0xff;
			sb.append(hexArray.charAt(bi >> 4));
			sb.append(hexArray.charAt(bi & 0xf));
		}
		return sb.toString();
	}


	/*
	 *
	 *字节数组转16进制字符串
	 */
	public static String bytes2HexString(byte[] b) {
		String r = "";

		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			r += hex.toUpperCase();
		}
		return r;
	}


	public static void main(String[] args) {
		String str = "china";
		System.out.println(bytesToHex(str.getBytes()));
		System.out.println(bytes2HexString(str.getBytes()));
	}


}
