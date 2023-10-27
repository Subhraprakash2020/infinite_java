package com.java.ejb;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patient_Report")
public class PatientRepo implements Serializable {
	@Id
//	@GeneratedValue
	@Column(name = "report_id")
	private String reportId;
	@Column(name = "patient_id")
	private String patientId;
	@Column(name = "testCode")
	private String testCode;
	@Column(name = "testName")
	private String testName;
	@Column(name = "testDescription")
	private String testDescription;
	@Column(name = "cost")
	private double cost;
	@Column(name = "comments")
	private String comments;
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getTestCode() {
		return testCode;
	}
	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestDescription() {
		return testDescription;
	}
	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public PatientRepo(String reportId, String patientId, String testCode, String testName, String testDescription,
			double cost, String comments) {
		super();
		this.reportId = reportId;
		this.patientId = patientId;
		this.testCode = testCode;
		this.testName = testName;
		this.testDescription = testDescription;
		this.cost = cost;
		this.comments = comments;
	}
	public PatientRepo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
