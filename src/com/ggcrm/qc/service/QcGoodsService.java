package com.ggcrm.qc.service;

import java.util.List;
import com.ggcrm.core.page.Page;
import com.ggcrm.core.page.Pageable;
import com.ggcrm.qc.entity.QcGoods;
/**
 * 商品service
 * @author zhliang
 *
 */
public interface QcGoodsService {

	
	/**
	 * 保存编辑
	 * @param feedback
	 */
	void update(QcGoods goods);
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	QcGoods getById(int id);
	/**
	 * 根据书名查询商品
	 * @param keyword
	 * @param pageable
	 * @return
	 */
	Page<QcGoods> findPageByName(String keyword,Pageable pageable);
	
	
	
	/**
	 * 根据条形码获取书籍
	 * @param barcode
	 * @return
	 */
	List<QcGoods> findGoodsByBarcode(String barcode);
	
}
