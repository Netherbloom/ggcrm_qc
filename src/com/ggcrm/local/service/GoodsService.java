package com.ggcrm.local.service;

import java.util.List;
import java.util.Map;

import com.ggcrm.core.page.Page;
import com.ggcrm.core.page.Pageable;
import com.ggcrm.local.entity.Goods;
/**
 * 商品service
 * @author zhliang
 *
 */
public interface GoodsService {

	
	/**
	 * 保存编辑
	 * @param feedback
	 */
	String save(Goods goods);
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	Goods getById(int id);
	/**
	 * 根据书名查询商品
	 * @param keyword
	 * @param pageable
	 * @return
	 */
	Page<Goods> findPageByName(String keyword,Pageable pageable);
	
	
	
	/**
	 * 根据条形码获取书籍
	 * @param barcode
	 * @return
	 */
	List<Goods> findGoodsByBarcode(String barcode);
	
}
