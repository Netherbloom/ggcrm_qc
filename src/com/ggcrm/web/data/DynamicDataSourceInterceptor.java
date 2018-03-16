package com.ggcrm.web.data;

/** 
 *  
* ClassName: DynamicDataSourceInterceptor <br/>  
* Function: 数据源动态切换拦截器. <br/>  
*  
* @version   
* @since JDK 1.6 
 */ 
public class DynamicDataSourceInterceptor {

	 /** 切换到数据源1 */  
    public void setLocalDS1() {  
        DynamicDataSourceHolder.setDatasource("localdataSource");  
    }  
      
    /** 切换到数据源2 */  
  
    public void setQcDS2() {   
      DynamicDataSourceHolder.setDatasource("qcdataSource");   
    }  
	
}
