package com.MongoDB.DAOInterFace;

import java.util.List;

import com.MongoDB.Entity.StudentInfo;

public interface HomedaoInterFace {
	public List<StudentInfo> findall();
	public String add(StudentInfo stud);
	public String delete(String name);
	public StudentInfo find(String name);

}
