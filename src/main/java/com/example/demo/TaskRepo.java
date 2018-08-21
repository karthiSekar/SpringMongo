package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepo extends MongoRepository<Task,Integer>{

	//a=(Arrays.asList(as));
	List<Task> findAllByTaskName(String taskName);
	List<Task> findAllByStartDate(Date startDate);

	List<Task> findAllByEndDate(Date endDate);

	List<Task> findAllByStatus(String status);
	


	List<Task> findAllByOrderByStatus();
	List<Task> findAllByTaskNameOrStatus(String taskName, String status);
	List<Task> findAllByTaskNameAndStatus(String taskName, String status);
	void deleteByTaskName(String taskName);
	List<Task> findByTaskNameIn(String b);
	List<Task> findByTaskNameRegex(String taskname);
	List<Task> findByTaskNameNot(String taskname);
	List<Task> findByTaskNameNotIn(List<Object> a);
}
