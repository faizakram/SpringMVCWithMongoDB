package com.MongoDB.DAO;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.MongoDB.DAOInterFace.HomedaoInterFace;
import com.MongoDB.Entity.StudentInfo;

@Repository
public class Homedao implements HomedaoInterFace{
	
	@Autowired
    private MongoTemplate mongoTemplate;
	@Override
	public String add(StudentInfo stud) {
		if (!mongoTemplate.collectionExists(StudentInfo.class)) {
            mongoTemplate.createCollection(StudentInfo.class);
        }
		 try {
			mongoTemplate.insert(stud);
			return "Added New Information";
		} catch (Exception e) {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(stud.getName()));
			StudentInfo userTest1 = mongoTemplate.findOne(query, StudentInfo.class);
			System.out.println("userTest1 - " + userTest1);
			userTest1.setAge(stud.getAge());
			mongoTemplate.save(userTest1);
			return "Updated Old Information";
		}
		
		 
	}
	@Override
	public List<StudentInfo> findall() {
		return mongoTemplate.findAll(StudentInfo.class);
	}
	@Override
	public String delete(String name) {
		try {
			mongoTemplate
			.remove(new Query(Criteria.where("name").is(name)), StudentInfo.class);
			return "Deleted";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No Data Found";
		}
	}
	@Override
	public StudentInfo find(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		StudentInfo userTest1 = mongoTemplate.findOne(query, StudentInfo.class);
		return userTest1;
	}
	
	
	
	
	



		
		
}
