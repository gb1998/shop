package com.tools;

public class ChStr {
	/**
	 * 功能：解决中文乱码问题
	 * 
	 * @param str
	 * @return
	 */
	public String chStr(String str) {
		if (str == null) { // 当变量str为null时
			str = ""; // 将变量str赋值为空
		} else {
			try {// 捕捉异常
				str = (new String(str.getBytes("iso-8859-1"), "UTF-8")).trim();// 将字符串转换为UTF-8编码
			} catch (Exception e) {// 处理异常
				e.printStackTrace(System.err); // 输出异常信息
			}
		}
		return str; // 返回转换后的变量str
	}
	/**
	 * 功能：显示文本中的回车换行、空格及保证HTML标记的正常输出
	 * 
	 * @param str1
	 * @return
	 */
	public String convertStr(String str1) {
		if (str1 == null) {
			str1 = "";
		} else {
			try {
				str1 = str1.replaceAll("<", "&lt;");// 替换字符串中的"<"和">"字符，保证HTML标记的正常输出
				str1 = str1.replaceAll(">", "&gt;");
				str1 = str1.replaceAll(" ", "&nbsp;");
				str1 = str1.replaceAll("\r\n", "<br>");
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
		return str1;
	}
}
