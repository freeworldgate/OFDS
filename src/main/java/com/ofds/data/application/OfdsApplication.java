package com.ofds.data.application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofds.data.application.dao.OfdsMulptiValueDao;
import com.ofds.data.application.dao.OfdsSingleValueDao;
import com.ofds.data.application.entity.SchoolInfo;
import com.ofds.data.application.entity.User;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class OfdsApplication {

	@Autowired
	OfdsSingleValueDao dao;
	
	@Autowired
	OfdsMulptiValueDao mdao;
	
    public static void main(String[] args) {
        SpringApplication.run(OfdsApplication.class, args);
    }
    
    @RequestMapping("/hello")
    public String hello() {
		
    	for(int i =0;i<100;i++) {
    		dao.save(new SchoolInfo(UUID.randomUUID().toString(),UUID.randomUUID().toString(), UUID.randomUUID().toString()));
    	}
    	
    	
		List<String> list1 = new ArrayList<String>();

		list1.add("00d2aff2-b86e-43ba-9bfc-bede8de086ec");
		list1.add("21c2c7c3-520e-4916-8c91-24d58a24aec8");
		list1.add("033df34b-c6cb-47e2-884d-3bdff872f61d");
		
    	
		List<SchoolInfo> schools = mdao.findPageSorted(SchoolInfo.class, "00d2aff2-b86e-43ba-9bfc-bede8de086ec",1, "username", Direction.ASC);
		

		for(SchoolInfo info:schools) {
			System.out.println(info.toString());
		}
		
		
		
		
		
    	return "Hello";
    }
    
    
}