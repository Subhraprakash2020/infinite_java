//package com.java.ejb;
//
//import java.util.regex.Pattern;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
//import javax.naming.NamingException;
//
//
//public class EjbController {
//	private PatientRepo patientrepo;
//	private EjbRepoImpl daoImpl;
//
//	
//	
//	public PatientRepo getPatientrepo() {
//		return patientrepo;
//	}
//
//	public void setPatientrepo(PatientRepo patientrepo) {
//		this.patientrepo = patientrepo;
//	}
//
//	public EjbRepoImpl getDaoImpl() {
//		return daoImpl;
//	}
//
//	public void setDaoImpl(EjbRepoImpl daoImpl) {
//		this.daoImpl = daoImpl;
//	}
//
//	public String addReport() throws NamingException {
//		if(addValid()) {
//			return daoImpl.addReport(patientrepo);
//		}
//		return "";
//	}
//	
//	public boolean addValid() {
//		FacesContext context = FacesContext.getCurrentInstance();
//		String testCode = "^T.*$";
//		
//		
//		  if (!Pattern.matches(testCode,patientrepo.getTestCode())) {
//			    // sessionMap.put("nameError", "Invalid Name. Only letters are allowed.");
//					context.addMessage("form:name", new FacesMessage("Test code start with T letter"));
//			        return false;
//			    }
//		return true;
//	}
//}
//;

package com.java.ejb;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;

public class EjbController {
    private PatientRepo patientrepo;
    private EjbRepoImpl daoImpl;
    

    // Getters and setters...

    public PatientRepo getPatientrepo() {
		return patientrepo;
	}

	public void setPatientrepo(PatientRepo patientrepo) {
		this.patientrepo = patientrepo;
	}

	public EjbRepoImpl getDaoImpl() {
		return daoImpl;
	}

	public void setDaoImpl(EjbRepoImpl daoImpl) {
		this.daoImpl = daoImpl;
	}

	public String addReport() throws NamingException {
        if (addValid()) {
            return daoImpl.addReport(patientrepo);
        }
        return "";
    }

	public boolean addValid() {
	    FacesContext context = FacesContext.getCurrentInstance();
	    String testCodePattern = "^T.*$"; // Test code pattern
	    String testNamePattern = "^.{5,}$"; // Test name pattern

	    // Regular expression for cost greater than or equal to 50
	    String costPattern = "^(5[0-9]+\\.\\d+|([6-9]\\d*|100)(\\.\\d+)?)$";

	    Pattern patternTestCode = Pattern.compile(testCodePattern);
	    Matcher matcherTestCode = patternTestCode.matcher(patientrepo.getTestCode());

	    Pattern patternTestName = Pattern.compile(testNamePattern);
	    Matcher matcherTestName = patternTestName.matcher(patientrepo.getTestName());

	    Pattern patternCost = Pattern.compile(costPattern);
	    Matcher matcherCost = patternCost.matcher(String.valueOf(patientrepo.getCost()));

	    if (!matcherTestCode.matches()) {
	        context.addMessage("form:testCode", new FacesMessage("Test code must start with 'T'"));
	        return false;
	    }
	    if (!matcherTestName.matches()) {
	        context.addMessage("form:testName", new FacesMessage("Test name must contain at least 5 characters"));
	        return false;
	    }
	    if (!matcherCost.matches()) {
	        context.addMessage("form:cost", new FacesMessage("Cost must be a number greater than or equal to 50"));
	        return false;
	    }

	    return true;
	}

}
