package com.ggcrm.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggcrm.local.entity.Goods;
import com.ggcrm.local.service.GoodsService;
import com.ggcrm.qc.entity.QcGoods;

@Controller
@RequestMapping("/mobile/app/**")
public class ApiController {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private com.ggcrm.qc.service.QcGoodsService goodsService2;
	
	@RequestMapping(value="test")
	public String test(String barcode){
		List<Goods>list= goodsService.findGoodsByBarcode(barcode);
		List<QcGoods> list1=goodsService2.findGoodsByBarcode(barcode);
		System.out.println("ss");
		return "pages/test";
	}
}
