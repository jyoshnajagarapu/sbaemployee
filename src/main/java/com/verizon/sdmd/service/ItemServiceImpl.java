package com.verizon.sdmd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.verizon.sdmd.dao.ItemMongoRepository;
import com.verizon.sdmd.model.Employee;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMongoRepository itemDao;
	@Override
	public void addItem(Employee item) {
	itemDao.insert(item);

	}
	

	@Override
	public void removeItem(int iCode) {
	itemDao.deleteById(iCode);
	}

	@Override
	public void updateItem(Employee item) {
		itemDao.save(item);

	}

	@Override
	public Employee getItem(int iCode) {
		Optional<Employee> opt =itemDao.findById(iCode);
		return opt.isPresent()?opt.get():null;
	}

	@Override
	public List<Employee> getItems() {
		
		return itemDao.findAll();
	}

	@Override
	public boolean exists(int icode) {
	
		return itemDao.existsById(icode);
	}

}
