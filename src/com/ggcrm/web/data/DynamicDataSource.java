package com.ggcrm.web.data;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 继承AbstractRoutingDataSource实现determineCurrentLookupKey方法，来实现数据库的动态切换
 * @author Administrator
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		 // 从自定义的位置获取数据源标识  
        return DynamicDataSourceHolder.getDatasource();  
	}

}
