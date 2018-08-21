package com.example.demo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	
	@Autowired
	TaskRepo repo;
	@Autowired
	TestRepo testrepo;

	@PostMapping("/TaskAdding")
	
	String saveTask(@RequestBody Task task) {
		repo.save(task);

		return "task added";

	}
	@PutMapping("/TaskUpdating")
	String saveOrAddTask(@RequestBody Task task) {
		repo.save(task);
		

		return "task updated";

	}
	@GetMapping("/AllTasks")
	List<Task> getTask(){
		return repo.findAll();
		
	}
	@GetMapping("/Task/{taskName}")
	List<Task> getATask(@PathVariable("taskName") String taskName){
		return repo.findAllByTaskName(taskName);
	}
	@GetMapping("/StartDate")
	List<Task> getbyStartDate(@RequestParam("startDate")String startDate){
		System.out.println(startDate);
		Date a=Date.valueOf(startDate);
		return repo.findAllByStartDate(a);
	}
	@GetMapping("/EndDate/{endDate}")
	List<Task> getbyEndDate(Date endDate){
		return repo.findAllByEndDate(endDate);
	}
	@GetMapping("/Status/{status}")
	List<Task> getbystatus(Task task){
		return repo.findAllByStatus(task.status);
	}
	@DeleteMapping("/taskName/{taskName}")
	public String deleteTask(@PathVariable("taskName") String taskName) {
	repo.deleteByTaskName(taskName);	
	return "Task deleted with id" ;
	}
	@GetMapping("/sort/status")
	List<Task> sorting() {
		return repo.findAllByOrderByStatus();
	}
	@GetMapping("/taskname/status/{taskName}/{status}")
	List<Task> andoperation(@PathVariable("taskName") String taskName,@PathVariable("status") String status){
		return repo.findAllByTaskNameAndStatus(taskName,status);
	}
	/*@GetMapping("/taskname/status/{taskName}/{status}")
	List<Task> oroperation(@PathVariable("taskName") String taskName,@PathVariable("status") String status){
		return repo.findAllByTaskNameOrStatus(taskName,status);
	}*/
	@GetMapping("/id/{id}")
	Optional<Task> getTask(@PathVariable("id")int id){
		return repo.findById(id);
	}



@GetMapping("/TaskNamePresent/{taskName}")
public List<Task> getByTasksPresent(@PathVariable("taskName") String taskname){	
return repo.findByTaskNameRegex(taskname);
}
List<Object> show(){
List<Object> a=new ArrayList<>();
String []as=new String[]{"a","as"};
 a=Arrays.asList(as);
 return a;
}

@GetMapping("/TaskNameIn")
public List<Task> getByTaskin(){
	String b="ab";
	List<Object> a=show();
return repo.findByTaskNameIn(b);
}
@GetMapping("/TaskNameNotIn")
public List<Task> getByTaskNotin(){
	List<Object> a=show();
return repo.findByTaskNameNotIn(a);
}
	
@GetMapping("/TaskNameNotPresent/{taskName}")
public List<Task> getByTasksNotPresent(@PathVariable("taskName") String taskname){	
return repo.findByTaskNameNot(taskname);
}
	
}
