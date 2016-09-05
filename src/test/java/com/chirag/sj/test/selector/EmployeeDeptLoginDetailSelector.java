package com.chirag.sj.test.selector;

import com.chirag.sj.interfaces.Selector;
import com.chirag.sj.test.model.Department;
import com.chirag.sj.test.model.result.EmployeeDeptLoginDetail;
import com.chirag.sj.test.model.result.EmployeeLoginDetail;

public class EmployeeDeptLoginDetailSelector implements Selector<EmployeeLoginDetail, Department, EmployeeDeptLoginDetail>
{
	@Override
	public EmployeeDeptLoginDetail select(EmployeeLoginDetail empLd, Department dept)
	{
		EmployeeDeptLoginDetail employeeDeptLoginDetail = new EmployeeDeptLoginDetail();
		
		if(empLd!=null)
		{
			employeeDeptLoginDetail.setLoginId(empLd.getLoginId());
			employeeDeptLoginDetail.setName(empLd.getName());
			employeeDeptLoginDetail.setUsername(empLd.getUsername());
			employeeDeptLoginDetail.setPassword(empLd.getPassword());
		}
		
		if(dept!=null)
		{
			employeeDeptLoginDetail.setDeptId(dept.getDeptId());
			employeeDeptLoginDetail.setDeptName(dept.getName());
		}
		
		return employeeDeptLoginDetail;
	}
}
