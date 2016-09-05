package com.chirag.sj.test.model;

import com.chirag.sj.annotations.JoinMethod;

public class Employee {
	
	private String loginId;
	private String name;
	private String address;
	private String deptId;
	private int number;
	
	public Employee(String loginId, String name, String address, String deptId, int number) {
		this.loginId = loginId;
		this.name = name;
		this.address = address;
		this.deptId = deptId;
		this.number = number;
	}

	public String getLoginId() {
		return loginId;
	}
	
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String newAddress) {
		address = newAddress;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public int getNumber() {
		return number;
	}

	@JoinMethod(joinClass = LoginDetail.class)
	public String loginDetailJoinMethod() {
		return loginId;
	}
	
	@JoinMethod(joinClass = Department.class)
	public String deptJoinMethod() {
		return deptId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((deptId == null) ? 0 : deptId.hashCode());
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
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
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (deptId == null) {
			if (other.deptId != null)
				return false;
		} else if (!deptId.equals(other.deptId))
			return false;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [loginId=" + loginId + ", name=" + name + ", address=" + address + ", deptId=" + deptId
				+ ", number=" + number + "]";
	}
}
