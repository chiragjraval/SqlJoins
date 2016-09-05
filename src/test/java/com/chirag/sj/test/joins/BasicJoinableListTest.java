package com.chirag.sj.test.joins;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.chirag.sj.exceptions.JoinMethodNotFoundException;
import com.chirag.sj.exceptions.JoinMethodNotMatchingException;
import com.chirag.sj.implementation.BasicJoinableList;
import com.chirag.sj.interfaces.JoinableList;
import com.chirag.sj.test.model.Department;
import com.chirag.sj.test.model.Employee;
import com.chirag.sj.test.model.LoginDetail;
import com.chirag.sj.test.model.result.EmployeeDeptLoginDetail;
import com.chirag.sj.test.model.result.EmployeeLoginDetail;
import com.chirag.sj.test.selector.EmployeeDeptLoginDetailSelector;
import com.chirag.sj.test.selector.EmployeeLoginDetailSelector;

public class BasicJoinableListTest
{
	@Test
	public void test1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("ld01", "chirag", "ad1", "dp01", 1));
		
		List<LoginDetail> loginDetails = new ArrayList<LoginDetail>();
		loginDetails.add(new LoginDetail("ld01", "chirag", "chirag"));
		loginDetails.add(new LoginDetail("ld02", "nikunj", "nikunj"));
		
		List<EmployeeLoginDetail> expectedResult = new ArrayList<EmployeeLoginDetail>();
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "chirag", "chirag"));
		
		JoinableList<Employee> joinableEmployees = new BasicJoinableList<>(employees);
		JoinableList<LoginDetail> joinableLoginDetails = new BasicJoinableList<>(loginDetails);
		JoinableList<EmployeeLoginDetail> joinableResult = joinableEmployees.innerJoin(joinableLoginDetails, new EmployeeLoginDetailSelector());
		List<EmployeeLoginDetail> result = joinableResult.getData();
		
		Assert.assertTrue(expectedResult.equals(result));
	}
	
	@Test
	public void test2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("ld01", "chirag", "ad1", "dp01", 1));
		employees.add(new Employee("ld02", "nikunj", "ad2", "dp02", 1));
		
		List<LoginDetail> loginDetails = new ArrayList<LoginDetail>();
		loginDetails.add(new LoginDetail("ld01", "chirag", "chirag"));
		loginDetails.add(new LoginDetail("ld02", "nikunj", "nikunj"));
		loginDetails.add(new LoginDetail("ld03", "ekta", "ekta"));
		
		List<Department> departments = new ArrayList<Department>();
		departments.add(new Department("dp01", "ICT"));
		
		List<EmployeeDeptLoginDetail> expectedResult = new ArrayList<EmployeeDeptLoginDetail>();
		expectedResult.add(new EmployeeDeptLoginDetail("ld01", "chirag", "dp01", "ICT", "chirag", "chirag"));
		expectedResult.add(new EmployeeDeptLoginDetail("ld02", "nikunj", null, null, "nikunj", "nikunj"));
		
		JoinableList<Employee> joinableEmployees = new BasicJoinableList<>(employees);
		JoinableList<LoginDetail> joinableLoginDetails = new BasicJoinableList<>(loginDetails);
		JoinableList<Department> joinableDepartments = new BasicJoinableList<>(departments);
		
		JoinableList<EmployeeDeptLoginDetail> joinableResult =
				joinableEmployees.innerJoin(joinableLoginDetails, new EmployeeLoginDetailSelector())
				.leftOuterJoin(joinableDepartments, new EmployeeDeptLoginDetailSelector());
		List<EmployeeDeptLoginDetail> result = joinableResult.getData();
		
		Assert.assertTrue(expectedResult.equals(result));
	}
	
}
