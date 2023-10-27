package com.java.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Patient_master")
public class Patient implements Serializable{
	@Id
	@GeneratedValue
	@Column(name = "pid")
	private String pid;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "weight")
	private int weight;
	@Column(name = "gender")
	private String gender;
	@Column(name = "address")
	private String address;
	@Column(name = "phoneno")
	private String phoneno;
	@Column(name = "disease")
	private String disease;
	@Column(name = "doctor_id")
	private String doctorid;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "otp")
	private String otp;
	@Column(name = "status")
	private String status;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

