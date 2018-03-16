package com.ggcrm.qc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "goods")
public class QcGoods implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false, name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;//编号
	
	@Column(name = "selfcode" , length = 50)
	private String selfcode;//内码
	
	@Column(name = "barcode" , length = 50)
	private String barcode;//商品条码
	
	@Column(name = "bottle" , length = 20)
	private String bottle;//版别
	
	@Column(name = "edition" , length = 20)
	private String edition;//版次
	
	@Column(name = "cbdate" , length = 20)
	private String cbdate;//出版日期
	
	@Column(name = "presscode" , length = 20)
	private String presscode;//出版社编码
	
	@Column(name = "size" , length = 20)
	private String size;//开本
	
	@Column(name = "spkcode" , length = 20)
	private String spkcode;//商品分类编码
	
	@Column(name = "name" , length = 100)
	private String name;//商品名称
	
	@Column(name = "price")
	private float price;//定价
	
	@Column(name = "rate")
	private float rate;//税率
	
	@Column(name = "writer" , length = 100)
	private String writer;//作者
	
	@Column(name = "binding" , length = 20)
	private String binding;//装帧
	
	@Column(name = "cover" , length = 200)
	private String cover;//封面图
	
	@Column(name = "ckplace" , length = 50)
	private String ckplace;//书架位号

	@Transient
	private String bookrack;//书架位
	
	@Transient
	private String intro;//简介
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSelfcode() {
		return selfcode;
	}

	public void setSelfcode(String selfcode) {
		this.selfcode = selfcode;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getBottle() {
		return bottle;
	}

	public void setBottle(String bottle) {
		this.bottle = bottle;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getCbdate() {
		return cbdate;
	}

	public void setCbdate(String cbdate) {
		this.cbdate = cbdate;
	}

	public String getPresscode() {
		return presscode;
	}

	public void setPresscode(String presscode) {
		this.presscode = presscode;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSpkcode() {
		return spkcode;
	}

	public void setSpkcode(String spkcode) {
		this.spkcode = spkcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}
	
	public String getBookrack() {
		return bookrack;
	}

	public void setBookrack(String bookrack) {
		this.bookrack = bookrack;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getCkplace() {
		return ckplace;
	}

	public void setCkplace(String ckplace) {
		this.ckplace = ckplace;
	}
}
	
