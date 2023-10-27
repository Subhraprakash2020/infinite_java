package com.java.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
@Remote(PatientRepoRemote.class)

public class PatientRemoteBeen implements PatientRepoRemote{
	
	@PersistenceContext(unitName = "EmpMgmtPU")
	private EntityManager entityManager;
	
	public PatientRemoteBeen() {
		
	}
	
	@Override
	public String addReport(PatientRepo patientrepo) {
		entityManager.merge(patientrepo);
		return "Patient Report Record Inserted...";
	}

	@Override
	public List<PatientRepo> showPatientRepo() {
		System.out.println("Entit Manager is "+entityManager);
		Query query = entityManager.createQuery("SELECT e FROM PatientRepo e");
		return (List<PatientRepo>) query.getResultList();
	}

}
