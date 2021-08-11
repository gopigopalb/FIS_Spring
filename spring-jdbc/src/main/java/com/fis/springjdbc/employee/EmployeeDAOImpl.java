package com.fis.springjdbc.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

public class EmployeeDAOImpl extends JdbcDaoSupport implements IEmployee {

	public List<Employee> getAllProducts() {
		String sql = "select * from employee";
		List<Employee> employees = getJdbcTemplate().query(sql, new EmployeeMapper());
		return employees;
	}

	public void insertProduct(Employee employee) {

		String sql = "insert into employee values(?,?)";
		Object[] args = { employee.getId(), employee.getName() };
		int insertedRows = getJdbcTemplate().update(sql, args);
		System.out.println("Rows Inserted: " + insertedRows);

	}

	@Override
	public void deleteProduct(int id) {

		String sql = "delete from employee where id=?";
		Object[] args = { id };
		int deletedRows = getJdbcTemplate().update(sql, args);
		System.out.println("Rows Deleted: " + deletedRows);
	}

	@Override
	public void updateProduct(Employee employee) {
		String sql = "update employee set name=? where id=?";
		Object[] args = { employee.getName(), employee.getId() };
		int updatedRows = getJdbcTemplate().update(sql, args);
		System.out.println("Rows Updated: " + updatedRows);

	}

	@Override
	public Employee getProductById(int id) {
		String sql = "select * from employee where id=?";
		Object[] args = { id };
		Employee employeeById = getJdbcTemplate().queryForObject(sql, args, new EmployeeMapper());
		return employeeById;
	}

	@Override
	public void insertProduct(IEmployee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(IEmployee employee) {
		// TODO Auto-generated method stub
		
	}

}
