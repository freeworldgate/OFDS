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

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OfdsSingleValueDao {

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
	public <T> T find(Class<T> clazz,Object primaryKey)
	{
		return em.find(clazz, primaryKey);
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public <T> List<T> find(Class<T> clazz,List<String> objectIds){
		StringBuffer sb = new StringBuffer();		
		sb.append("select c from ").append(clazz.getSimpleName()).append(" c");
		sb.append(" where c.objectId in (?1)");
		return (List<T>)em.createQuery(sb.toString()).setParameter(1, objectIds).getResultList();
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
  
