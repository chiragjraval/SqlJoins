package com.chirag.sj.test.model;

import com.chirag.sj.annotations.JoinMethod;
import com.chirag.sj.test.model.result.EmployeeLoginDetail;

public class Department
{
	private String deptId;
	private String name;
	
	/**
	 * @param deptId
	 * @param name
	 */
	public Department(String deptId, String name) {
		super();
		this.deptId = deptId;
		this.name = name;
	}
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@JoinMethod(joinClass=Employee.class)
	public String empJoinMethod()
	{
		return deptId;
	}
	
	@JoinMethod(joinClass=EmployeeLoginDetail.class)
	public String empLoginDetailJoinMethod()
	{
		return deptId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptId == null) ? 0 : deptId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (deptId == null) {
			if (other.deptId != null)
				return false;
		} else if (!deptId.equals(other.deptId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", name=" + name + "]";
	}
}
