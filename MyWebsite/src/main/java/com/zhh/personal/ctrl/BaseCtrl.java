package com.zhh.personal.ctrl;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.zhh.common.ShDateEditer;
import com.zhh.common.exception.BaseException;
import com.zhh.common.exception.InnerException;
import com.zhh.common.exception.ShowException;
import com.zhh.common.pagination.Pagination;
import com.zhh.personal.json.base.JsonBase;

/**
 * @date 2017-2-22 下午5:18:43
 * @author zhaohaihao
 */
public class BaseCtrl {
	protected final static Logger logger = LoggerFactory.getLogger(BaseCtrl.class);
	
	public final static String SUC="S";
	public final static String ERR="E";
	public final static String API_SUC="0000";
	public final static String API_ERR="0001";
	
	public final static String JSON_COM="json/common";
	public final static String JUMP_URL="jumpUrl";
	public final static String JUMP_PAGE_DEF="index.html";
	public final static String JUMP_VIEW="error/autoJump";
	
	/** 统一处理成功结果*/
	protected void handleSuc(ModelMap mm) {
		mm.put("code", SUC);
		mm.put("msg", "操作成功");
	}
	
	/** 统一处理失败结果*/
	protected void handleErr(ModelMap mm,Exception ex) {
		if (ex!=null && mm!=null) {
			if (ex instanceof BaseException) {
				mm.put("code", ((BaseException) ex).getCode());
				mm.put("msg", ((BaseException) ex).getMsg());
				//logger.error(ex.getMessage(), ex);
			}else{
				mm.put("code", ERR);
				mm.put("msg", "网络异常，请稍后再试");
				logger.error(ex.getMessage(), ex);
			}
		}
	}
	
	
	protected void jsonSuc(JsonBase json) {
		json.setCode(SUC);
	}	
	
	/** 统一处理失败结果*/
	protected JsonBase jsonErr(JsonBase json,Exception ex) {
		if (json==null) {
			json = new JsonBase();
		}
		if (ex!=null) {
			if (ex instanceof ShowException) {
				json.setCode(((BaseException) ex).getCode());
				json.setError(((BaseException) ex).getMsg());
				logger.error(ex.getMessage());
			}else if (ex instanceof BaseException
					||ex instanceof InnerException) {
				json.setCode(ERR);
				json.setError("网络异常，请稍后再试");
				logger.error(ex.getMessage());
			}else{
				json.setCode(ERR);
				json.setError("网络异常，请稍后再试");
				logger.error(ex.getMessage(), ex);
			}
		}
		return json;
	}

	/**
	 * 对外api接口成功
	 * @param json
	 * @author Jarry
	 * @createTime 2016年1月22日 下午4:58:39
	 */
	protected void jsonApiSuc(JsonBase json) {
		json.setCode(API_SUC);
	}
	/** 对外api接口统一处理失败结果*/
	protected JsonBase jsonApiErr(JsonBase json,Exception ex) {
		if (json==null) {
			json = new JsonBase();
		}
		if (ex!=null) {
			if (ex instanceof ShowException) {
				json.setCode(((BaseException) ex).getCode());
				json.setError(((BaseException) ex).getMsg());
				logger.error(ex.getMessage());
			}else if (ex instanceof BaseException
					||ex instanceof InnerException) {
				json.setCode(API_ERR);
				json.setError("平台系统错误");
				logger.error(ex.getMessage());
			}else{
				json.setCode(API_ERR);
				json.setError("平台系统错误");
				logger.error(ex.getMessage(), ex);
			}
		}
		return json;
	}
//	/** 获取SESSION中的UserId */
//	protected int getUserId(HttpSession ses) {
//		//return SessionHelper.getSimUser(ses).getUserInfo().getUserId();
//	}
	
	
	/**
	 * 获取request中的String型数据  <br>
	 * 优先使用getAttribute方式,再使用getParameter方式 <br>
	 * @return 如果不存在则返回null
	 */
	protected String reqStr(String paramKey,HttpServletRequest request) {
		String val = (String)request.getAttribute(paramKey);
		if (val==null) {
			val=(String)request.getParameter(paramKey);
		}
		if (val==null) {
			return "";
		}
		return val;
	}
	
	
	/**
	 * 获取request中的String型数据  <br>
	 * 优先使用getAttribute方式,再使用getParameter方式<br>
	 * @return 如果不存在返回"",不返回null
	 */
	protected String reqStrDef(String paramKey,HttpServletRequest request) {
		String res = reqStr(paramKey, request);
		if (res==null) {
			return "";
		}
		return res;
	}
	
	/**
	 * 获取request中的Integer型数据  <br>
	 * 优先使用getAttribute方式,再使用getParameter方式<br>
	 * @return 如果不存在会抛出异常
	 */
	protected int reqInt(String paramKey,HttpServletRequest request) {
		int val = 0;
		String valStr = reqStr(paramKey,request);
		val = Integer.valueOf(valStr);
		return val;
	}
	
	/**
	 * 获取request中的Integer型数据  <br>
	 * 优先使用getAttribute方式,再使用getParameter方式<br>
	 * @return 如果不存在则返回0
	 */
	protected int reqIntDef(String paramKey,HttpServletRequest request) {
		try {
			return reqInt(paramKey, request);
		} catch (Exception e) {
			return 0;
		}
	}
	
	/**
	 * 获取request中的Boolean型数据  <br>
	 * 优先使用getAttribute方式,再使用getParameter方式<br>
	 * @return 如果不存在则返回false
	 */
	protected boolean reqBool(String paramKey,HttpServletRequest request) {
		String valStr = reqStrDef(paramKey,request);
		if (valStr.trim().toLowerCase().equals("on")||valStr.trim().toLowerCase().equals("yes")||valStr.trim().toLowerCase().equals("true")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 生成分页对象,并直接放入ModelMap中,key为"page"
	 * @param maxItem 每页最大显示值
	 */
	protected Pagination pageList(int maxItem,HttpServletRequest req,ModelMap mm){
		Pagination page = new Pagination();
		
		int currentPage = reqIntDef("currentPage", req);
		int seqType=reqIntDef("seqType", req);
		String seqName=reqStrDef("seqName", req);
		page.setCurrentPage(currentPage);
		page.setSeqType(seqType);
		page.setSeqName(seqName);
		page.setShowCount(maxItem);
		page.getItems().clear();
		mm.put("page", page);
		return page;
	}
	
	/**
	 * 生成分页对象,并直接放入ModelMap中,key为"page"
	 * @param maxItem 每页最大显示值
	 */
	protected Pagination pageList(HttpServletRequest req,ModelMap mm){
		return pageList(60, req, mm);
	}
	
	/**
	 * 页面先提示消息,再n秒后自动跳转
	 * @param page 自动跳转的页面
	 */
	protected String jumpPage(String page,ModelMap mm) {
		mm.put(JUMP_URL, page);
		return JUMP_VIEW;
	}
	/**
	 * 页面先提示消息,再n秒后自动跳转默认页面
	 */
	protected String jumpPage(ModelMap mm) {
		return jumpPage(JUMP_PAGE_DEF, mm);
	}
	
	
//	protected void initShDates(Object obj) throws Exception{
////		Class c = obj.getClass();
////		Field[] fields=c.getDeclaredFields();
////		for (int i = 0; i < fields.length; i++) {
////			if (fields[i].getType().equals(ShDate.class)) {
////				Object value = ReflectHelper.getValueByFieldName(obj, fields[i].getName());
////				if (value==null) {
////					ReflectHelper.setValueByFieldName(obj, fields[i].getName(), new ShDate());
////				}
//////			}else if (fields[i].getType().equals(Date.class)) {
//////					Object value = ReflectHelper.getValueByFieldName(obj, fields[i].getName());
//////					if (value!=null && !(value instanceof ShDate)) {
//////						ReflectHelper.setValueByFieldName(obj, fields[i].getName(), new ShDate((Date)value));
//////					}else if (value==null) {
//////						ReflectHelper.setValueByFieldName(obj, fields[i].getName(), new ShDate());
//////					}
////			}else if (fields[i].getType().equals(Integer.class)) {
////				Object value = ReflectHelper.getValueByFieldName(obj, fields[i].getName());
////				if (value==null) {
////					ReflectHelper.setValueByFieldName(obj, fields[i].getName(), new Integer(0));
////				}
////			}
////		}
//	}
	
    @InitBinder
    protected void initBinder(WebDataBinder binder) throws ServletException {
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new ShDateEditer(dateFormat,dateFormat2, false));
        
        
        
    }

    /**
     * 将requestParamters转换成TreeMap
     * @param request
     * @return TreeMap
     */
	protected Map<String,String> getParam(String encode, HttpServletRequest request){
	      Map<String,String> reqMap = new TreeMap<>();
	      Enumeration<?> names = request.getParameterNames();
//	      String os = System.getProperty("os.name");
			
	      while (names.hasMoreElements()) {
	        String name = (String)names.nextElement();
	        String values = null;
	        if (encode != null) {// && os!=null && os.toLowerCase().startsWith("windows")
	        	try {
					values = new String(request.getParameter(name).getBytes("iso-8859-1"), encode);
				} catch (UnsupportedEncodingException e) {
					logger.error("读取参数异常", e);
				}
			} else {
				values = request.getParameter(name);
			}
	        
	        if (null != values) values = values.trim();
	        reqMap.put(name, values);
	      }
	      return reqMap;
	}
    
    public String getRemortIP(HttpServletRequest request) {
	       String ip = request.getHeader("x-forwarded-for"); 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getHeader("Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getHeader("WL-Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getRemoteAddr(); 
	       } 
	       return ip; 
	}
 
}
