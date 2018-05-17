/**  
 * Project Name:ofds-data-jpa  
 * File Name:OfdsSingleValueController.java  
 * Package Name:com.ofds.data.application.ofdsapi  
 * Date:2018年5月17日下午1:19:14  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.ofds.data.application.ofdsapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**  
 * ClassName:OfdsSingleValueController <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2018年5月17日 下午1:19:14 <br/>  
 * @author   root  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@RestController
@RequestMapping("/ofds/mulpti")
public class OfdsMupltiValueController {

	@RequestMapping("/find")
	public List<ArrayList<String>> find(String objectType,String objectId,String featureType,int page,int direction) {
		return null;
	}
	
	@RequestMapping("/insert")   //该接口永远只能调用一次，就是在用户注册时。   后续需要支持分布式会话
	public OfdsResponse save(String objectType,String objectId,String featureType,Map<String,String> params) {
		
		return null;
	}
	
	@RequestMapping("/delete")  //联合主键
	public OfdsResponse delete(String objectType,String objectId,String secondObjectId) {
		
		return null;
	}
	
	
}
  
