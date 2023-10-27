package com.java.ejb;

import java.util.List;

import javax.naming.NamingException;

public class EjbRepoImpl {
	public String addReport(PatientRepo patientrepo) throws NamingException  {
		PatientRepoRemote remote = RemoteHelper.lookupRemoteStatelessEmploy();
		remote.addReport(patientrepo);
		return "Inseted Record";
	}
	public List<PatientRepo> showEmployEjb() throws NamingException {
		PatientRepoRemote remote = RemoteHelper.lookupRemoteStatelessEmploy();
		return remote.showPatientRepo();
	}
}
