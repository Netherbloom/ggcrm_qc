package com.ggcrm.qc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import com.ggcrm.core.dao.BaseDaoWithQuery;
import com.ggcrm.core.dao.MapQuery;
import com.ggcrm.core.page.Page;
import com.ggcrm.core.page.Pageable;
import com.ggcrm.qc.entity.QcGoods;
import com.ggcrm.util.NumberUtil;
import com.ggcrm.util.SqlHelper;


@Repository
public class QcGoodsDao extends BaseDaoWithQuery<QcGoods, Integer> {

	@PersistenceContext
	EntityManager em;
	
	protected QcGoodsDao() {
		super(QcGoods.class);
	}

	protected EntityManager getEntityManager() {
		return em;
	}
	
	/**
	 * 根据书名查询
	 * @param keyword
	 * @param pageable
	 * @return
	 */
	public Page<QcGoods> findPageByName(String keyword,Pageable pageable) {
		StringBuffer sb = new StringBuffer();
		sb.append(" from qc_book_kc q inner join goods a on q.self_code=a.selfcode and q.kcqty>0 ");
		sb.append(" and a.spkcode is not null");
		sb.append(" and left(a.spkcode,1) in ('Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N')");
		sb.append(" where 1=1 ");
		if(!StringUtils.isBlank(keyword)){
			keyword=SqlHelper.toSqlLike(keyword);
			sb.append(" and a.name like "+keyword);
			sb.append(" or a.writer like "+keyword);
		}

		String sqlTotal = "select count(*)"+sb.toString();
		int intTotal = 0;
		Object object = em.createNativeQuery(sqlTotal).getSingleResult();
		if(null != object){
			intTotal = NumberUtil.toInt(object.toString());
		}
		StringBuffer sql = new StringBuffer(); 
		sql.append("select a.id,");
		sql.append("(select (select d.intro from gggoodsintro d where d.goodsid = c.goodsid) as intro from gggoodsisbn c where c.isbn = a.barcode) as intro,");
		sql.append("(select (select b.imgpath from gggoodsimage b where b.goodsid = c.goodsid) as imgpath from gggoodsisbn c where c.isbn = a.barcode) as cover,");
		sql.append("a.name,a.writer,a.price,a.cbdate,a.selfcode");
		sql.append(sb.toString());
		Query query = em.createNativeQuery(sql.toString());
		query.setMaxResults(pageable.getPageSize());
		query.setFirstResult(pageable.getOffset());
		MapQuery<QcGoods> mq = new MapQuery<QcGoods>(QcGoods.class);
		return new Page<QcGoods>(mq.getResultList(query), pageable, intTotal);
	}
	
	/**
	 * 按条码查询
	 * @param barcode
	 * @return
	 */
	public List<QcGoods> getByBarcode(String barcode){
		String sql = "select a.id,a.name,a.writer,a.price,a.cbdate,a.barcode from goods a where 1=1";
		StringBuffer buffer = new StringBuffer(sql);
		buffer.append(" and a.barcode like ").append(SqlHelper.toSql(barcode+"%"));
		buffer.append(" and spkcode is not null");
		buffer.append(" and left(spkcode,1) in ('Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N')");
		buffer.append(" order by a.cbdate desc");
		Query query = em.createNativeQuery(buffer.toString());
		MapQuery<QcGoods> mq = new MapQuery<QcGoods>(QcGoods.class);
		List<QcGoods> list = mq.getResultList(query);
		if(null != list && list.size() > 0){
			return list;
		}else{
			return null;
		}
	}
	
}
