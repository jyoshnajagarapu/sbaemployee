package com.verizon.sdmd.service;

import java.util.List;

import com.verizon.sdmd.model.Employee;

	public interface ItemService {
		public void addItem(Employee item);
		public void removeItem(int eid);
		public void updateItem(Employee item);
		public Employee getItem(int eid);
		public List<Employee> getItems();
		public boolean exists(int eid);
}
