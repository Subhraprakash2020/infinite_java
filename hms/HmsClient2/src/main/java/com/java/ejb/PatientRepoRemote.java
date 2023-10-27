package com.java.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface PatientRepoRemote {
	String addReport(PatientRepo patientrepo);
	List<PatientRepo> showPatientRepo();

}
