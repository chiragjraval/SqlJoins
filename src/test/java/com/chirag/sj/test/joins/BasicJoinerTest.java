package com.chirag.sj.test.joins;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.chirag.sj.exceptions.JoinMethodNotFoundException;
import com.chirag.sj.exceptions.JoinMethodNotMatchingException;
import com.chirag.sj.implementation.BasicInnerJoiner;
import com.chirag.sj.implementation.BasicLeftOuterJoiner;
import com.chirag.sj.test.model.Department;
import com.chirag.sj.test.model.Employee;
import com.chirag.sj.test.model.LoginDetail;
import com.chirag.sj.test.model.result.EmployeeDeptLoginDetail;
import com.chirag.sj.test.selector.EmployeeDeptLoginDetailSelector;
import com.chirag.sj.test.selector.EmployeeLoginDetailSelector;

public class BasicJoinerTest
{
	private BasicInnerJoiner innerJoiner;
	private BasicLeftOuterJoiner leftOuterJoiner;
	
	@Before
	public void setUp()
	{
		innerJoiner = new BasicInnerJoiner();
		leftOuterJoiner = new BasicLeftOuterJoiner();
	}
	
	@Test
	public void test1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
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
		
		List<EmployeeDeptLoginDetail> result =
				leftOuterJoiner.join(
						innerJoiner.join(employees, loginDetails, new EmployeeLoginDetailSelector()), 
						departments, 
						new EmployeeDeptLoginDetailSelector());
		
		Assert.assertTrue(expectedResult.equals(result));
	}
}
