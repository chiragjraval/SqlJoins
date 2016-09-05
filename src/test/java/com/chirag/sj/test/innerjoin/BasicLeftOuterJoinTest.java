package com.chirag.sj.test.innerjoin;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.chirag.sj.exceptions.JoinMethodNotFoundException;
import com.chirag.sj.exceptions.JoinMethodNotMatchingException;
import com.chirag.sj.implementation.BasicLeftOuterJoiner;
import com.chirag.sj.test.model.Employee;
import com.chirag.sj.test.model.LoginDetail;
import com.chirag.sj.test.model.result.EmployeeLoginDetail;
import com.chirag.sj.test.selector.EmployeeLoginDetailSelector;

public class BasicLeftOuterJoinTest
{
	private BasicLeftOuterJoiner joiner;
	
	@Before
	public void setUp()
	{
		joiner = new BasicLeftOuterJoiner();
	}
	
	@Test
	public void test1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<LoginDetail> loginDetails = new ArrayList<LoginDetail>();
		loginDetails.add(new LoginDetail("ld01", "chirag", "chirag"));
		loginDetails.add(new LoginDetail("ld02", "nikunj", "nikunj"));
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("ld01", "chirag", "ad1", "dp01", 1));

		List<EmployeeLoginDetail> expectedResult = new ArrayList<EmployeeLoginDetail>();
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "chirag", "chirag"));
		
		List<EmployeeLoginDetail> result = joiner.join(employees, loginDetails, new EmployeeLoginDetailSelector());
		
		Assert.assertTrue(expectedResult.equals(result));
	}
	
	@Test
	public void test2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("ld01", "chirag", "ad1", "dp01", 1));
		employees.add(new Employee("ld03", "ekta", "ad2", "dp03", 2));

		List<LoginDetail> loginDetails = new ArrayList<LoginDetail>();
		loginDetails.add(new LoginDetail("ld01", "chirag", "chirag"));

		List<EmployeeLoginDetail> expectedResult = new ArrayList<EmployeeLoginDetail>();
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "chirag", "chirag"));
		expectedResult.add(new EmployeeLoginDetail("ld03", "ekta", "dp03", null, null));
		
		List<EmployeeLoginDetail> result = joiner.join(employees, loginDetails, new EmployeeLoginDetailSelector());
		
		Assert.assertTrue(expectedResult.equals(result));
	}
	
	@Test
	public void test3() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("ld01", "chirag", "ad1", "dp01", 1));
		employees.add(new Employee("ld03", "ekta", "ad2", "dp03", 2));

		List<EmployeeLoginDetail> expectedResult = new ArrayList<EmployeeLoginDetail>();
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", null, null));
		expectedResult.add(new EmployeeLoginDetail("ld03", "ekta", "dp03", null, null));
		
		List<EmployeeLoginDetail> result = joiner.join(employees, null, new EmployeeLoginDetailSelector());
		
		Assert.assertTrue(expectedResult.equals(result));
	}
	
	@Test
	public void test4() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<LoginDetail> loginDetails = new ArrayList<LoginDetail>();
		loginDetails.add(new LoginDetail("ld01", "chirag", "chirag"));
		loginDetails.add(new LoginDetail("ld01", "nikunj", "nikunj"));
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("ld01", "chirag", "ad1", "dp01", 1));

		List<EmployeeLoginDetail> expectedResult = new ArrayList<EmployeeLoginDetail>();
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "chirag", "chirag"));
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "nikunj", "nikunj"));
		
		List<EmployeeLoginDetail> result = joiner.join(employees, loginDetails, new EmployeeLoginDetailSelector());
		
		Assert.assertTrue(expectedResult.equals(result));
	}
	
	@Test
	public void test5() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<LoginDetail> loginDetails = new ArrayList<LoginDetail>();
		loginDetails.add(new LoginDetail("ld01", "chirag", "chirag"));
		loginDetails.add(new LoginDetail("ld01", "nikunj", "nikunj"));
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("ld01", "chirag", "ad1", "dp01", 1));

		List<EmployeeLoginDetail> expectedResult = new ArrayList<EmployeeLoginDetail>();
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "chirag", "chirag"));
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "nikunj", "nikunj"));
		
		List<EmployeeLoginDetail> result = joiner.join(employees, loginDetails, new EmployeeLoginDetailSelector());
		
		Assert.assertTrue(expectedResult.equals(result));
	}
	
	
	@Test
	public void test6() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<LoginDetail> loginDetails = new ArrayList<LoginDetail>();
		loginDetails.add(new LoginDetail("ld01", "chirag", "chirag"));
		loginDetails.add(new LoginDetail("ld01", "nikunj", "nikunj"));
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(null, "shlok", "ad3", "dp04", 1));
		employees.add(new Employee("ld01", "chirag", "ad1", "dp01", 1));

		List<EmployeeLoginDetail> expectedResult = new ArrayList<EmployeeLoginDetail>();
		expectedResult.add(new EmployeeLoginDetail(null, "shlok", "dp04", null, null));
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "chirag", "chirag"));
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "nikunj", "nikunj"));
		
		List<EmployeeLoginDetail> result = joiner.join(employees, loginDetails, new EmployeeLoginDetailSelector());
		
		Assert.assertTrue(expectedResult.equals(result));
	}
}
