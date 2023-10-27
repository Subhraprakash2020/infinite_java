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
            <h2 style="text-align: center" class="col-sm-4">Add Your Report Record</h2>
            <hr />
            Report Id
            <h:inputText id="repoid" value="#{patientrepo.reportId}" />
            <br />
            Patient Id
            <h:inputText id="patientId" value="#{patientrepo.patientId}" />
            <br />
            TestCode 
            <h:inputText id="testCode" value="#{patientrepo.testCode}" />
            <br />
            Test Name
            <h:inputText id="testName" value="#{patientrepo.testName}" />
            <h:message for="form:testCode"></h:message>
            <br />
            Test Description
            <h:inputText id="desc" value="#{patientrepo.testDescription}" />
            <br />
            Cost
            <h:inputText id="cost" value="#{patientrepo.cost}" />
            <h:message for="form:cost"></h:message>
            
            <br />
            Comments
            <h:inputText id="comments" value="#{patientrepo.comments}" />
            <br />
            <h:commandButton value="Insert" action="#{customerController.addReport()}" />
        </h:form>
    </body>
    </html>
</f:view>
