/**  
 * Project Name:ofds-data-jpa  
 * File Name:User.java  
 * Package Name:com.ofds.data.application  
 * Date:2018年5月15日下午11:04:18  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.ofds.data.application.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Primary;

@Entity
@Table(name = "schools")
public class SchoolInfo implements Serializable{

    public SchoolInfo() {
    
    }

	private String objectId;
    
    private String username;
    
    private String userpwd;

    
    
    
    
    
    public SchoolInfo(String objectId, String username, String userpwd) {
		super();
		this.objectId = objectId;
		this.username = username;
		this.userpwd = userpwd;
	}

	@Id
	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

 

    @Column(name="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "userpwd")
    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

	@Override
	public String toString() {
		return "SchoolInfo [objectId=" + objectId + ", username=" + username
				+ ", userpwd=" + userpwd + "]";
	}





}
