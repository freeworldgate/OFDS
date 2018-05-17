/**  
 * Project Name:ofds-data-jpa  
 * File Name:OfdsSingleValueDao.java  
 * Package Name:com.ofds.data.application.dao  
 * Date:2018年5月16日下午9:36:59  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.ofds.data.application.dao;  
/**  
 * ClassName:OfdsSingleValueDao <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2018年5月16日 下午9:36:59 <br/>  
 * @author   root  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.annotations.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OfdsMulptiValueDao {

	@PersistenceContext
	private EntityManager em;
	
	
	@Transactional
	public <T> boolean save(T t) {
		try {
			em.persist(t);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	@Transactional
	public <T> boolean update(T t) {
		try {
			em.merge(t);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	@Transactional
	public <T> boolean delete(Class<T> clazz,Object entity) {
		try {
			em.remove(entity);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	

	
	@SuppressWarnings("unchecked")
	@Transactional
	public <T> List<T> findPageSorted(Class<T> clazz,String id,int page,String sortedName,Direction direc){
		StringBuffer sb = new StringBuffer();		
		sb.append("select c from ")
		  .append(clazz.getSimpleName())
		  .append(" c")
		  .append(" where c.objectId=?1")
		  .append(" order by ")
		  .append("c.")
		  .append(sortedName)
		  .append(" ")
		  .append(direc.name());
		return (List<T>)em.createQuery(sb.toString()).setParameter(1, id).setFirstResult((page-1)*20).setMaxResults(20).getResultList();
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
  
