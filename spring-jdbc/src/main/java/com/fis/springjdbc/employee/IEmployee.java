package com.fis.springjdbc.employee;

import java.util.List;

public interface IEmployee {

	public void insertProduct(IEmployee employee);

	public List<Employee> getAllProducts();

	public void updateProduct(IEmployee employee);

	public void deleteProduct(int id);

	public Employee getProductById(int id);

	void updateProduct(Employee employee);

}
