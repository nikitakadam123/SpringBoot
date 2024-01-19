package com.spring.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

	@Entity
	public class Employee {

		
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int empId;
		@Column
		private String empName;
		@Column
		private int empSal;
		
		
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Employee(int empId, String empName, int empSal) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.empSal = empSal;
		}
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		public int getEmpSal() {
			return empSal;
		}
		public void setEmpSal(int empSal) {
			this.empSal = empSal;
		}
		
		
	}

