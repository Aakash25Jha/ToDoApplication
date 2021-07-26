<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Users</title>
</head>

<body class="my-login-page">
<jsp:include page="templates/userHeader.jsp"/>
<section class="">
   <div class="container ">
        <div class="row justify-content-md-center">
            <div class="card">
                <div class="card-header">
                    <h4 class="text-center">TO DO List</h4>
                </div>
              <!--   <div class="card card-body table-responsive">
                </div>
             -->
    </div> 
     <div class="card card-body table-responsive">
                   
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Description</th>
                                    <th>Status</th>
                                    <th>Category</th>
                                    <th>Date-Time</th>
                                    <th colspan="2">Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="todo" items="${toDoList}">
                                    <tr>
                                        <%-- <td>
                                            <label>${todo.getName()}</label>
                                        </td> --%>
                                        <<td>
                                            <label id="${todo.getId()}">
                                                    ${todo.getName()}
                                            </label> 
                                        <td>
                                            <label id="${todo.getId()}">
                                                    ${todo.getDescription()}
                                            </label>
                                        </td>
                                        <td>
                                            <label id="lname_${todo.getId()}">
                                                    ${todo.getStatus()}
                                            </label>
                                        </td>
                                        <td>
                                            <label id="lname_${todo.getId()}">
                                                    ${todo.getCategory()}
                                            </label>
                                        </td>
                                        <td>
                                            <label id="lname_${todo.getId()}">
                                                    ${todo.getDate()}
                                            </label>
                                        </td>
                                        <td>
                                            <a href="/update/${todo.getId()}" id="update_${todo.getId()}" class="updateData"
                                               "><i class="fa fa-edit"></i></a>
                                        </td>
                                        <td><a href="/delete-to-do/${todo.getId()}" class="deleteData"><i
                                                class="fa fa-trash"></i></a>
                                        </td> 
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>

                </div>
            </div>
    
</section>
<jsp:include page="templates/footer.jsp"/>
</div>
            <jsp:include page="templates/copyright.jsp"/>
        </div>
</body>
</html>