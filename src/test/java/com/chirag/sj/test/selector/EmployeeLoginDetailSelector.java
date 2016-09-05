package com.chirag.sj.test.selector;

import com.chirag.sj.interfaces.Selector;
import com.chirag.sj.test.model.Employee;
import com.chirag.sj.test.model.LoginDetail;
import com.chirag.sj.test.model.result.EmployeeLoginDetail;

public class EmployeeLoginDetailSelector implements Selector<Employee, LoginDetail, EmployeeLoginDetail>
{
	@Override
	public EmployeeLoginDetail select(Employee emp, LoginDetail ld)
	{
		EmployeeLoginDetail employeeLoginDetail = new EmployeeLoginDetail();
		
		if(ld!=null)
		{
			employeeLoginDetail.setUsername(ld.getUsername());
			employeeLoginDetail.setPassword(ld.getPassword());
		}
		
		if(emp!=null)
		{
			employeeLoginDetail.setLoginId(emp.getLoginId());
			employeeLoginDetail.setName(emp.getName());
			employeeLoginDetail.setDeptId(emp.getDeptId());
		}
		
		return employeeLoginDetail;
	}
}
