package com.ggcrm.local.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggcrm.core.dao.QueryWhere;
import com.ggcrm.core.page.Page;
import com.ggcrm.core.page.Pageable;
import com.ggcrm.local.dao.GoodsDao;
import com.ggcrm.local.entity.Goods;
import com.ggcrm.local.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public String save(Goods goods) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goods getById(int id) {
		return goodsDao.getById(id);
	}

	@Override
	public Page<Goods> findPageByName(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}



	
	@Override
	public List<Goods> findGoodsByBarcode(String barcode) {
		// TODO Auto-generated method stub
		return goodsDao.getByBarcode(barcode);
	}

}
