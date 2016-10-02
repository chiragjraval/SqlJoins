package com.chirag.sj.test.joins;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.chirag.sj.exceptions.JoinMethodNotFoundException;
import com.chirag.sj.exceptions.JoinMethodNotMatchingException;
import com.chirag.sj.test.model.Department;
import com.chirag.sj.test.model.Employee;
import com.chirag.sj.test.model.LoginDetail;
import com.chirag.sj.test.model.result.EmployeeDeptLoginDetail;
import com.chirag.sj.test.model.result.EmployeeLoginDetail;
import com.chirag.sj.test.selector.EmployeeDeptLoginDetailSelector;
import com.chirag.sj.test.selector.EmployeeLoginDetailSelector;
import com.chirag.sj.util.JoinType;
import com.chirag.sj.util.JoinerUtil;

public class BasicJoinerUtilTest
{	
	@Before
	public void setUp()
	{
		// Nothing required
	}
	
	@Test
	public void innerJoinTest1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<LoginDetail> loginDetails = new ArrayList<LoginDetail>();
		loginDetails.add(new LoginDetail("ld01", "chirag", "chirag"));
		loginDetails.add(new LoginDetail("ld02", "nikunj", "nikunj"));
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("ld01", "chirag", "ad1", "dp01", 1));

		List<EmployeeLoginDetail> expectedResult = new ArrayList<EmployeeLoginDetail>();
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "chirag", "chirag"));
		
		List<EmployeeLoginDetail> result = JoinerUtil.join(employees, loginDetails, JoinType.INNER_JOIN, new EmployeeLoginDetailSelector(), EmployeeLoginDetail.class);
		
		Assert.assertTrue(expectedResult.equals(result));
	}
	
	@Test
	public void innerJoinTest2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<LoginDetail> loginDetails = new ArrayList<LoginDetail>();
		loginDetails.add(new LoginDetail("ld01", "chirag", "chirag"));
		loginDetails.add(new LoginDetail("ld02", "nikunj", "nikunj"));
		loginDetails.add(new LoginDetail("ld03", "ekta", "ekta"));
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("ld01", "chirag", "ad1", "dp01", 1));
		employees.add(new Employee("ld03", "ekta", "ad2", "dp03", 1));

		List<EmployeeLoginDetail> expectedResult = new ArrayList<EmployeeLoginDetail>();
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "chirag", "chirag"));
		expectedResult.add(new EmployeeLoginDetail("ld03", "ekta", "dp03", "ekta", "ekta"));
		
		List<EmployeeLoginDetail> result = JoinerUtil.join(employees, loginDetails, JoinType.INNER_JOIN, new EmployeeLoginDetailSelector(), EmployeeLoginDetail.class);
		
		Assert.assertTrue(expectedResult.equals(result));
	}
	
	@Test
	public void leftJoinTest1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<LoginDetail> loginDetails = new ArrayList<LoginDetail>();
		loginDetails.add(new LoginDetail("ld01", "chirag", "chirag"));
		loginDetails.add(new LoginDetail("ld02", "nikunj", "nikunj"));
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("ld01", "chirag", "ad1", "dp01", 1));

		List<EmployeeLoginDetail> expectedResult = new ArrayList<EmployeeLoginDetail>();
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "chirag", "chirag"));
		
		List<EmployeeLoginDetail> result = JoinerUtil.join(employees, loginDetails, JoinType.LEFT_OUTER_JOIN, new EmployeeLoginDetailSelector(), EmployeeLoginDetail.class);
		
		Assert.assertTrue(expectedResult.equals(result));
	}
	
	@Test
	public void leftJoinTest2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("ld01", "chirag", "ad1", "dp01", 1));
		employees.add(new Employee("ld03", "ekta", "ad2", "dp03", 2));

		List<LoginDetail> loginDetails = new ArrayList<LoginDetail>();
		loginDetails.add(new LoginDetail("ld01", "chirag", "chirag"));

		List<EmployeeLoginDetail> expectedResult = new ArrayList<EmployeeLoginDetail>();
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "chirag", "chirag"));
		expectedResult.add(new EmployeeLoginDetail("ld03", "ekta", "dp03", null, null));
		
		List<EmployeeLoginDetail> result = JoinerUtil.join(employees, loginDetails, JoinType.LEFT_OUTER_JOIN, new EmployeeLoginDetailSelector(), EmployeeLoginDetail.class);
		
		Assert.assertTrue(expectedResult.equals(result));
	}
	
	@Test
	public void leftJoinTest3() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("ld01", "chirag", "ad1", "dp01", 1));
		employees.add(new Employee("ld03", "ekta", "ad2", "dp03", 2));

		List<EmployeeLoginDetail> expectedResult = new ArrayList<EmployeeLoginDetail>();
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", null, null));
		expectedResult.add(new EmployeeLoginDetail("ld03", "ekta", "dp03", null, null));
		
		List<EmployeeLoginDetail> result = JoinerUtil.join(employees, null, JoinType.LEFT_OUTER_JOIN, new EmployeeLoginDetailSelector(), EmployeeLoginDetail.class);
		
		Assert.assertTrue(expectedResult.equals(result));
	}
	
	@Test
	public void leftJoinTest4() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<LoginDetail> loginDetails = new ArrayList<LoginDetail>();
		loginDetails.add(new LoginDetail("ld01", "chirag", "chirag"));
		loginDetails.add(new LoginDetail("ld01", "nikunj", "nikunj"));
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("ld01", "chirag", "ad1", "dp01", 1));

		List<EmployeeLoginDetail> expectedResult = new ArrayList<EmployeeLoginDetail>();
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "chirag", "chirag"));
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "nikunj", "nikunj"));
		
		List<EmployeeLoginDetail> result = JoinerUtil.join(employees, loginDetails, JoinType.LEFT_OUTER_JOIN, new EmployeeLoginDetailSelector(), EmployeeLoginDetail.class);
		
		Assert.assertTrue(expectedResult.equals(result));
	}
	
	@Test
	public void leftJoinTest5() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<LoginDetail> loginDetails = new ArrayList<LoginDetail>();
		loginDetails.add(new LoginDetail("ld01", "chirag", "chirag"));
		loginDetails.add(new LoginDetail("ld01", "nikunj", "nikunj"));
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("ld01", "chirag", "ad1", "dp01", 1));

		List<EmployeeLoginDetail> expectedResult = new ArrayList<EmployeeLoginDetail>();
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "chirag", "chirag"));
		expectedResult.add(new EmployeeLoginDetail("ld01", "chirag", "dp01", "nikunj", "nikunj"));
		
		List<EmployeeLoginDetail> result = JoinerUtil.join(employees, loginDetails, JoinType.LEFT_OUTER_JOIN, new EmployeeLoginDetailSelector(), EmployeeLoginDetail.class);
		
		Assert.assertTrue(expectedResult.equals(result));
	}
	
	
	@Test
	public void leftJoinTest6() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
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
		
		List<EmployeeLoginDetail> result = JoinerUtil.join(employees, loginDetails, JoinType.LEFT_OUTER_JOIN, new EmployeeLoginDetailSelector(), EmployeeLoginDetail.class);
		
		Assert.assertTrue(expectedResult.equals(result));
	}
	
	@Test
	public void multipleJoinTest1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
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
			JoinerUtil.join(
				JoinerUtil.join(employees, loginDetails, JoinType.INNER_JOIN, new EmployeeLoginDetailSelector(), EmployeeLoginDetail.class), 
				departments, JoinType.LEFT_OUTER_JOIN, new EmployeeDeptLoginDetailSelector(), EmployeeDeptLoginDetail.class
			);
		
		Assert.assertTrue(expectedResult.equals(result));
	}
}
