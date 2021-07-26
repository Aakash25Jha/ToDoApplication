<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Create New ToDo</title>
</head>

<body class="my-login-page">
<jsp:include page="templates/header.jsp"/>
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <div class="card fat">
                    <div class="card-body">
                        <h4 class="card-title">Add To DO</h4>
                        <c:if test="${not empty param.error}">
                            <label id="error" class="alert alert-danger">${param.error}</label>
                        </c:if>
                        <form action="/todo" method="POST">

                            <div class="form-group">
                                <label for="name">Name</label>
                                <input id="name" type="text" class="form-control" name="name" required
                                       autofocus>
                            </div>

                            <div class="form-group">
                                <label for="description">Description</label>
                                <input id="description" type="text" class="form-control" name="description" required>
                            </div>
                            <div class="form-group">
                                <label for="status">Status</label>
                                <select id="status" type="text" class="custom-select form-control" name="status" required
                                       autofocus>
                                       <option value="Initial">INITIAL</option>
                                    <option value="Started">STARTED</option>
                                    <option value="Completed">COMPLETED</option>
                                    <option value="Snoozed">SNOOZED</option>
                                    <option value="Overdue">OVERDUE</option>
                                       </select>
                            </div>
                            <div class="form-group">
                                <label for="category">Category</label>
                                <input id="category" type="text" class="form-control" name="category" required>
                            </div>
                            <div class="form-group">
                                <label for="userEmail">User Email</label>
                                <input id="userEmail" type="text" class="form-control" name="userEmail" required
                                       autofocus>
                            </div>

                            <div class="form-group no-margin">
                                <button type="submit" class="btn btn-primary btn-block">
                                   Add ToDo
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
                <jsp:include page="templates/copyright.jsp"/>
            </div>
        </div>
    </div>
</section>
<jsp:include page="templates/footer.jsp"/>
</body>
</html>