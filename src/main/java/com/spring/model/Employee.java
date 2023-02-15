package com.spring.model;

import java.io.Serializable;

public class Employee implements Serializable
{
	private static final long serialVersionUID = 1280037900360314186L;
	
	private Integer id;
	private String name;
	private Integer age;
	private String dept;
	public Employee()
	{
		super();
	}
	public Employee (Integer id,String name, Integer age, String dept)
	{
		super();
		this.id=id;
		this.name=name;
		this.age=age;
		this.dept=dept;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
