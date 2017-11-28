package com.scbrl.util;

import java.security.MessageDigest;

public class MD5Util {

	public static final String SignKey = "64AEC2B1E61174A635D19B8E98AB9FAB";

	public static void main(String[] args) {
		//System.out.println(md5("ee3784a2ae5a71c94ca5b14e51ccb5cc&AppID=7f680dea5ac3dd3284f5c1043035f062&Face=30&Number=18850551510&Timestamp=20161031180622&Version=1.0&ee3784a2ae5a71c94ca5b14e51ccb5cc"));
		//System.out.println(MD5Encode("ee3784a2ae5a71c94ca5b14e51ccb5cc&AppID=7f680dea5ac3dd3284f5c1043035f062&Face=30&Number=18850551510&Timestamp=20161031180622&Version=1.0&ee3784a2ae5a71c94ca5b14e51ccb5cc","gbk"));
		System.out.println(MD5Util.Pwd("45728", "123456"));
		
		//System.out.println(md5("123"));
	}
	
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * 验证Restful签名
	 * @param t 时间轴
	 * @param ip 服务器IP
     * @return md5
     */
	public static String RestfulSign(String t , String ip){
		System.err.println("加密前:"+t+SignKey+ip);
		return md5(t+SignKey+ip).toUpperCase();
	}


	/**
	 * @：>> 本方法禁止修改 <<
	 * @：MD5密码加密规则
	 * @: 加密前需要加上用户Key避免用户被撞库破解
	 * @param k 用户的唯一标识(USER_ID)
	 * @param v 加密串字符串(明文密码)
	 * @return md5
	 */
	public static String Pwd(String k,String v){
		return md5(k + md5(v));//用户ID加上+加密后的MD5密码再进行第二次MD5加密
	}
	
	public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}
	
	
	
	
}
