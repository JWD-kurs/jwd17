package jwd.wafepa.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;

@RestController
@RequestMapping(value="/api/activities")
public class ApiActivityController {

	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Activity>> get(){
		System.out.println("get()");
		List<Activity> activities = activityService.findAll();
		
		return new ResponseEntity<>(activities,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public ResponseEntity<Activity> get(@PathVariable Long id){
		System.out.println("get(" + id + ")");
		
		Activity activity = activityService.findOne(id);
		
		if(activity==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(activity, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public ResponseEntity<Activity> remove(@PathVariable Long id){
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@PostConstruct
	private void init(){
		activityService.save(new Activity("Running"));
		activityService.save(new Activity("Swimming"));
	}
}
