package com.ggcrm.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.lang.RandomStringUtils;

/**
 * 公共方法。
 */
public class StringUtil {

	//判断是否空值
	public static boolean isEmpty(String str){
		if(null != str && !"".equals(str)){
			return false;
		}else{
			return true;
		}
	}
	
	/** 最大长度字符显示 */
	public static String leftString(String str, int len, boolean showdot) {
		if (str == null)
			return "";
		if (showdot)
			return StringUtil.cutstring(str, len, "...");
		else
			return StringUtil.cutstring(str, len, "");
	}

	/**
	 * 按字节长度截取字符串
	 * 
	 * @param str
	 *            将要截取的字符串参数
	 * @param toCount
	 *            截取的字节长度
	 * @param more
	 *            字符串末尾补上的字符串
	 * @return 返回截取后的字符串
	 */
	public static String cutstring(String str, int toCount, String more) {
		int reInt = 0;
		String reStr = "";

		if (str == null)
			return "";
		char[] tempChar = str.toCharArray();
		byte[] CharLen = str.getBytes();
		byte[] moreLen = more.getBytes();

		if (CharLen.length > toCount) {
			toCount = toCount - moreLen.length;
		}

		for (int kk = 0; (kk < tempChar.length && toCount > reInt); kk++) {
			String s1 = String.valueOf(tempChar[kk]);
			byte[] b = s1.getBytes();
			reInt += b.length;
			reStr += tempChar[kk];
		}

		if (CharLen.length > toCount)
			reStr += more;

		return reStr;
	}

	// 把字符串按照一定字符进行分割
	public static String[] splitString(String szSource, String token) {
		if ((szSource == null) || (token == null))
			return null;
		java.util.StringTokenizer st1 = new java.util.StringTokenizer(szSource,
				token);
		String[] d1 = new String[st1.countTokens()];
		for (int x = 0; x < d1.length; x++)
			if (st1.hasMoreTokens())
				d1[x] = st1.nextToken();
		return d1;
	}

	// 把字符串按照一定字符进行分割 第二种方法
	public static String[] split(String str, String splitsign) {
		int index;
		if (str == null || splitsign == null)
			return null;
		ArrayList<String> al = new ArrayList<String>();
		while ((index = str.indexOf(splitsign)) != -1) {
			al.add(str.substring(0, index));
			str = str.substring(index + splitsign.length());
		}
		al.add(str);
		return (String[]) al.toArray(new String[0]);
	}

	public static byte[] toByte(String szStr) {
		if (szStr == null)
			return null;
		byte[] tmp = szStr.getBytes();
		return tmp;
	}

	public static String toSpace(Object obj) {
		if (obj == null || obj.equals(" "))
			return "&nbsp;";
		return obj.toString();
	}

	public static String toSpace(Date date) {
		if (date == null)
			return "&nbsp;";
		return toString(date);
	}

	public static String toSpace(Date date, String format) {
		if (date == null)
			return "&nbsp;";
		return toString(date, format);
	}

	// 数字数组转换成字符串
	public static String arrayInttoString(int[] ids, String separator) {
		String ret = "";
		for (int i = 0; i < ids.length; i++) {
			if (i < ids.length - 1)
				ret += String.valueOf(ids[i]) + separator;
			else
				ret += String.valueOf(ids[i]);
		}
		return ret;
	}

	// 字符数组转换成字符串
	public static String arrayStrtoString(String[] ids, String separator) {
		String ret = "";
		for (int i = 0; i < ids.length; i++) {
			if (i < ids.length - 1)
				ret += String.valueOf(ids[i]) + separator;
			else
				ret += String.valueOf(ids[i]);
		}
		return ret;
	}

	public static String toString(byte[] byBuf) {
		if (byBuf == null)
			return null;
		return new String(byBuf);
	}

	public static String toString(Object obj) {
		if (obj == null)
			return "";
		return obj.toString().trim();
	}

	public static String toString(String obj) {
		if (obj == null)
			return "";
		return obj;
	}

	public static String toString(Date obj) {
		return toString(obj, "yyyy-MM-dd HH:mm:ss");
	}

	public static String toString(Date obj, String format) {
		if (obj == null)
			return "";
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(format);
		return df.format(obj);
	}

	/** 最大长度字符显示 */
	public static String subString(String str, int len) {
		if (str == null)
			return "";
		if (str.length() <= len)
			return str;
		return str.substring(0, len);
	}

	public static String subString(String str, int len, String expandstr) {
		if (str == null)
			return "";
		if (str.length() <= len)
			return str;
		return str.substring(0, len) + expandstr;
	}
	
	/**
	 * 
	 * @param str
	 * @param len
	 * @param expandstr
	 * @return
	 */
	public static String subStringFile(String str) {
		if (str == null)
			return "";
		return str.substring(str.lastIndexOf(".") + 1);
	}

	/**
	 * 字符串转为list
	 * 
	 * @param urlStr
	 * @return
	 */
	public static List<String> str2List(String urlStr) {
		final String URL_SPLIT_PATTERN = "[, ;\r\n]";// 逗号 空格 分号 换行
		if (urlStr == null) {
			return null;
		}
		String[] urlArray = urlStr.split(URL_SPLIT_PATTERN);
		List<String> urlList = new ArrayList<String>();
		for (String url : urlArray) {
			url = url.trim();
			if (url.length() == 0) {
				continue;
			}
			urlList.add(url);
		}
		return urlList;
	}
	
	//list转字符","
	public static String list2Str(List<Integer> args) {  
	    String str = "";  
	    if (args != null && args.size() > 0) {  
	        for (int i : args) {  
	            str += i + ",";  
	        }  
	    }  
	    str = str.substring(0, str.length() - 1);  
	    return str;  
	} 
	
	//list转字符","
	public static String stringList2Str(List<String> args) {  
	    String str = "";  
	    if (args != null && args.size() > 0) {  
	        for (String i : args) {  
	            str += i + ",";  
	        }  
	    }  
	    if(null != str && str.length() > 0){
	    	str = str.substring(0, str.length() - 1);  
	    }
	    return str;  
	} 
		
	// 数字显示格式的处理
	public static String toPrice(double d) {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return df.format(d);
	}

	public static String toPrice(float d) {
		DecimalFormat df = new DecimalFormat("##0.00");
		return df.format(d);
	}

	// 数字显示格式的处理
	public static String toPrice_Fin(double d) {
		DecimalFormat df = new DecimalFormat("###0.00");
		return df.format(d);
	}
	
	/**
	 * <p>方法名: defaultString	</p>
	 * <p>描述:	null 或者 "" 返回默认字符串</p>
	 * <p>参数:	</p>
	 * @return		
	 * <p>return	String</p>
	 */
	public static String defaultString(String originalString,String defaultString){
		if(null == originalString || "".equals(originalString.trim())){
			return defaultString;
		}
		return originalString;
	}
	
	/**
	 * 
	 * 方法名: findDiff <br />  
	 * 描述:返回oriStr中有的，但str上没有的词 <br /> 
	 * 参数：<br /> 
	 * @param oriStr
	 * @param str
	 * @return <br />    
	 * @return String <br />    
	 * @throws
	 */
	public static String findDiff(String oriStr, String str, String token){
		if(null == token) token = ",";
			String ret = "";
			if(null == oriStr || 0 == oriStr.length()){
				return "";
			}else if(null == str || 0 == str.length()){
				return oriStr;
			}else{
				String[] arr = oriStr.split(token);
				str += token;
				for(String val : arr){
					if(str.indexOf(val + token) == -1){
						ret += val + ",";
					}
				}
				if(ret.length() > 0)
					ret = ret.substring(0, ret.length() - 1);
				return ret;
			}
	}

	// 过滤特殊字符  
    public static  String StringFilter(String str)throws PatternSyntaxException   {     
          // 只允许字母和数字       
          // String   regEx  =  "[^a-zA-Z0-9]";                     
          // 清除掉所有特殊字符  
          String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";  
          Pattern   p   =   Pattern.compile(regEx);     
          Matcher   m   =   p.matcher(str);     
          return   m.replaceAll("").trim();     
   } 
	
	/**
	 * 替换字符串
	 * @param text
	 * @param repl
	 * @param with
	 * @return
	 */
	public static String replace(String text, String repl, String with) {
		
		return replace(text, repl, with, -1);
	}

	/**
	 * 替换字符串
	 * @param text
	 * @param repl
	 * @param with
	 * @param max
	 * @return
	 */
	public static String replace(String text, String repl, String with, int max) {
		
		if ((text == null) || (repl == null) || (with == null)
				|| (repl.length() == 0) || (max == 0)) {
			return text;
		}

		StringBuffer buf = new StringBuffer(text.length());
		int start = 0;
		int end = 0;
		while ((end = text.indexOf(repl, start)) != -1) {
			buf.append(text.substring(start, end)).append(with);
			start = end + repl.length();

			max--;
			if (max == 0) {
				break;
			}
		}
		buf.append(text.substring(start));
		return buf.toString();
	}
	
	// 过滤怪字符
	public static String filterBadChar(String szText) {
		String tmp = szText;

		String result = "";
		for (int i = 0; i < tmp.length(); i++) {
			char ch = tmp.charAt(i);
			if (ch < ' ' || (ch > '~' && ch < 255))
				continue;
			result += ch;
		}
		return result;
	}
	
	/**
	 * 获取随机密码 一个字母一个数字的形式 如 A1b2C3d4
	 * 
	 * @param l
	 *            密码长度
	 * @return
	 */
	public static String getPasswd(int l) {
		boolean iOpnType = true; // 判断为数字还是字母
		boolean iOpnCaps = true; // 判断为大写还是小写字母
		String sPassword = new String(); // 密码变量
		for (int i = 0; i < l; i++) {
			if (iOpnType) { // 生产字母
				char c = (char) (Math.random() * 26 + 'a'); // 生产一个小写的字母
				String c_temp = "";
				if (iOpnCaps) { // 需要大写字母
					c_temp = String.valueOf(c).toUpperCase();
					iOpnCaps = false; //
				} else { // 需要小写字母
					c_temp = String.valueOf(c).toLowerCase();
					iOpnCaps = true; //
				}
				sPassword = sPassword + c_temp;
				iOpnType = false;
			} else { // 生产数字
				int i_temp = (int) (Math.random() * 10); // 生成一个0-9的数字
				sPassword = sPassword + String.valueOf(i_temp);
				iOpnType = true; //
			}
		}
		return sPassword;
	}
	
    /** 
     * @param htmlStr 
     * @return 
     *  删除Html标签 
     */  
    public static String delHTMLTag(String htmlStr) {  
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);  
        Matcher m_script = p_script.matcher(htmlStr);  
        htmlStr = m_script.replaceAll(""); // 过滤script标签  
  
        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);  
        Matcher m_style = p_style.matcher(htmlStr);  
        htmlStr = m_style.replaceAll(""); // 过滤style标签  
  
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);  
        Matcher m_html = p_html.matcher(htmlStr);  
        htmlStr = m_html.replaceAll(""); // 过滤html标签  
  
        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);  
        Matcher m_space = p_space.matcher(htmlStr);  
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签  
        return htmlStr.trim(); // 返回文本字符串  
    }  
    
    public static String getTextFromHtml(String htmlStr){  
        htmlStr = delHTMLTag(htmlStr);  
        htmlStr = htmlStr.replaceAll("&nbsp;", "");  
        //htmlStr = htmlStr.substring(0, htmlStr.indexOf("。")+1);  
        return htmlStr;  
    }
    
    public static String getRandomStr(int len){
    	char[] chars = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
		return RandomStringUtils.random(len, chars);
    }
    
    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式  
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式  
    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式  
    private static final String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符  
    
    public static void main(String[] args) {
		System.out.println(StringUtil.getTextFromHtml("本书是著名儿童文学作家孙幼军的系列童话作品。<br>作品的主人公亭亭是一个充满幻想的小女孩儿，她不仅喜欢看童话，还自己写童话，于是她的生活也变得妙趣横生——亭亭给动物园的小猴子写信，于是小猴子真的带着礼物出现在亭亭的生日聚会上，可是亭亭的妈妈却不太欢迎小猴子，亭亭该怎么办呢？夜深了，是谁在偷吃亭亭的生日蛋糕？竟然是一个住在喇叭花里的小人儿！亭亭和爸爸去看木偶表演，散场后偷偷穿上了演员的戏服，结果大老虎的戏服脱不下来，亭亭被送到了动物园，她要怎样才能脱身呢？<br>作者将一个聪明活泼的小女孩儿身边发生的奇异故事娓娓道来，作品充满了想象力和童真童趣，适合小学低年级读者阅读。"));
	}
}