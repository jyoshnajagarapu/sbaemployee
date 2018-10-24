package com.verizon.sdmd.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.sdmd.model.Employee;
import com.verizon.sdmd.service.ItemService;

@RestController
@CrossOrigin
@RequestMapping("/Employees")
public class ItemApi {
	@Autowired
	private ItemService service;
	@GetMapping
	public ResponseEntity<List<Employee>> getAllItems(){
		ResponseEntity<List<Employee>> resp =null;
		List<Employee> items= service.getItems();
		if(items!=null && items.size()>0)
			resp = new ResponseEntity<List<Employee>>(items, HttpStatus.OK);
		else 
			resp = new ResponseEntity<List<Employee>>(items, HttpStatus.NOT_FOUND);
		return resp;
	}
	@GetMapping("/{eId}")
	public ResponseEntity<Employee> getItem(@PathVariable("eId")int icode){
		ResponseEntity<Employee> resp = null;
		Employee item= service.getItem(icode);
		if(item!=null)
			resp=new ResponseEntity<Employee>(item,HttpStatus.OK);
		else 	
			resp=new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		return resp;
	}
	@PostMapping
	public ResponseEntity<Employee> addItem(@RequestBody Employee item){
		ResponseEntity<Employee> resp = null;
		
		if(item!=null && !service.exists(item.geteId())){
			service.addItem(item);
			
			resp=new ResponseEntity<Employee>(item,HttpStatus.OK);
		}
		else 	
			resp=new ResponseEntity<Employee>(HttpStatus.CONFLICT);
		return resp;
	}
	
	@PutMapping
	public ResponseEntity<Employee> updateItem(@RequestBody Employee item){
		ResponseEntity<Employee> resp = null;
		
		if(item!=null && service.exists(item.geteId())){
			service.updateItem(item);
			resp=new ResponseEntity<Employee>(item,HttpStatus.OK);
		}
		else 	
			resp=new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		return resp;
	}
	
	@DeleteMapping("/{eId}")
	public ResponseEntity<Void> deItem(@PathVariable("eId") int icode){
		ResponseEntity<Void> resp = null;
		
		if( service.exists(icode)){
			service.removeItem(icode);
			resp=new ResponseEntity<>(HttpStatus.OK);
		}
		else 	
			resp=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return resp;
	}
	
	
} 
