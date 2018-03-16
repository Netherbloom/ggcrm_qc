package com.ggcrm.qc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggcrm.core.page.Page;
import com.ggcrm.core.page.Pageable;
import com.ggcrm.qc.dao.QcGoodsDao;
import com.ggcrm.qc.entity.QcGoods;
import com.ggcrm.qc.service.QcGoodsService;

@Service
public class QcGoodsServiceImpl implements QcGoodsService{

	@Autowired
	private QcGoodsDao goodsDao;
	
	@Transactional
	@Override
	public void update(QcGoods goods) {
		goodsDao.update(goods);
	}

	@Override
	public QcGoods getById(int id) {
		return goodsDao.getById(id);
	}

	@Override
	public Page<QcGoods> findPageByName(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}



	
	@Override
	public List<QcGoods> findGoodsByBarcode(String barcode) {
		// TODO Auto-generated method stub
		return goodsDao.getByBarcode(barcode);
	}

}
