<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
	</head>
	<body>
        <h2>Add Employee Data</h2>
        <form method="POST" action="/dispatcher/save.html">
             <table>
                <tr>
                  <td><form:label path="empId">Employee ID</form:label></td>
                  <td><form:input path="empId" value="${employee.empId}" readonly="true"/></td>
                </tr>
                
                <tr>
                  <td><form:label path="name">Employee Name</form:label></td>
                  <td><form:input path="name" value="${employee.name}"/></td>
                </tr>
                
                <tr>
                  <td><form:label path="age">Employee Age</form:label></td>
                  <td><form:input path="age" value="${employee.age}"/></td>
                </tr>
                
                <tr>
                  <td><form:label path="salary">Employee Salary</form:label></td>
                  <td><form:input path="salary" value="${employee.salary}"/></td>
                </tr>
                
                <tr>
                  <td><form:label path="address">Employee Address</form:label></td>
                  <td><form:input path="address" value="${employee.address}"/></td>
                </tr>
                
                </tr>  
          		<tr>  
         		   <td colspan="2"><input type="submit" value="Submit"/></td>  
        		</tr>  
             </table>
        </form>
        
        <c:if test="${! empty employees}">
          <table align="left" border="1">
            <tr bgcolor="pink">
              <th align="center">EMP ID</th>
              <th align="center">EMP NAME</th>
              <th align="center">EMP AGE</th>
              <th align="center">EMP SALARY</th>
              <th align="center">ADDRESS</th>
            </tr>
            <c:forEach items="${employees}" var="employee">
               <tr>
                 <td>${employee.empId}</td>
                 <td>${employee.name}</td>
                 <td>${employee.age}</td>
                 <td>${employee.salary}</td>
                 <td>${employee.address}</td>
                 <td align="center"><a href="edit.html?empId={employee.empId}">Edit</a>|<a href="delete.html?empId={employee.empId}">Delete</a></td>
               </tr>
            </c:forEach>
          </table>
         
        </c:if>
	</body>
</html>