<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<h:form>
		<center>
			<h2>
				<h:outputText value="Doctors Records" />
			</h2>
		</center>
		<h:dataTable value="#{reportEjb.showEmployEjb()}" var="e" border="3">
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Doctors Id" />
				</f:facet>
				<h:outputText value="#{e.patientId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Agent N
					ame" />
				</f:facet>
				<h:outputText value="#{e.reportId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="City" />
				</f:facet>
				<h:outputText value="#{e.testCode}" />
			</h:column>
			
		</h:dataTable>

	</h:form>
</body>
	</html>
</f:view>