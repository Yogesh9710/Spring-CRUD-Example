package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

import org.springframework.stereotype.Repository;

import com.spring.model.Employee;

@Repository
public class EmployeeDAOImpl<JdbcTemplate> implements EmployeeDao
{
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	//JdbcTemplate setter
	public void setDatasource(DataSource dataSource)
	{
		this.dataSource=dataSource;
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	//saving a new Employee
	public void saveEmployee(EmployeeDAOImpl employee)
	{
		String sql="insert into Emp values(?,?,?,?)";
		System.out.println("dao called");
		((Object) jdbcTemplate).update(sql,new Object[]
		{employee.getId(),employee.getName(),employee.getDept(),employee.getAge()});
	}
	
	private Object getAge() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object getDept() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	//Getting a particular Employee
	public Employee getEmployeeById(int id)
	{
		String sql="select * from where id=?";
		Employee employee=(Employee) jdbcTemplate.queryForObject(sql,new Object[]
		{id},new RowMapper<Employee>()
		{
			public Employee mapRow(ResultSet rs,int rowNum) throws SQLException
			{
				Employee employee=new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setDept(rs.getString(3));
				
				employee.setAge(rs.getInt(4));
				return employee;
			}
		});
		return employee;
		}
	
	//Getting all the Employees
	public List<Employee> getAllEmployees()
	{
		String sql ="select * from Emp";
		
		List<Employee>employeeList=((Object) jdbcTemplate).query(sql,new ResultSetExtractor<List<Employee>>()
				{
			public List<Employee> extractData(ResultSet rs) throws SQLException,dataAccessException
			{
				List<Employee> list=new ArrayList<Employee>();
				while (rs.next())
				{
					Employee employee=new Employee();
					employee.setId(rs.getInt(1));
					employee.setName(rs.getString(2));
					employee.setDept(rs.getString(3));
					
					employee.setAge(rs.getInt(4));
					list.add(employee);
				}
				return list;
				}
			
				});
		return employeeList;
			}
	
	//Upadating a particular Employee
	public void updateEmployee(Employee employee)
	{
		String sql="update Emp set name=?,dept=?,age=?,where id=?";
		((Object) jdbcTemplate).update(sql,new Object[])
		{employee.getName(), employee.getDept(), employee.getAge(), employee.getId()});
	}
	
	//Deletion of a particular Employee
	public void deleteEmployee(int id)
	{
		String sql="delete from emp where id=?";
		((Object) jdbcTemplate).update(sql,new Object[]
		{id});
	 }

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}
	

}
