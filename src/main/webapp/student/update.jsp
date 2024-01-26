<%--
  Created by IntelliJ IDEA.
  User: ngomanhson
  Date: 25/01/2024
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
    <jsp:include page="/layout/css.jsp"/>
</head>
<body>
<jsp:include page="/layout/header.jsp"/>

<section class="mt-5 pt-4">
    <div class="container">
        <h1 class="text-danger text-center mb-4">Update Student</h1>

        <div class="row">
            <div class="col-4 mx-auto">
                <form method="post" action="update">
                    <input type="hidden" name="id" value="${id}">
                    <div class="mb-3">
                        <label for="name" class="form-label">Full Name</label>
                        <input type="text" name="name" class="form-control" id="name" value="${name}">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" name="email" class="form-control" id="email" value="${email}">
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">Address</label>
                        <input type="text" name="address" class="form-control" id="address" value="${address}">
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Save Change</button>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>
ceate .jsp
@Override
public boolean update(Student student) {
String sql = "UPDATE students SET name=?, email=?, address=? WHERE id=?";
try {
Database db = Database.getInstance();
PreparedStatement prst = db.getPreparedStatement(sql);
prst.setString(1, student.name);
prst.setString(2, student.email);
prst.setString(3, student.address);
prst.setInt(4, student.id);

prst.executeUpdate();
return true;
} catch (SQLException e) {
System.out.println(e.getMessage());
}
return false;
}


@Override
public boolean delete(Student student) {
String sql = "DELETE FROM students WHERE id = ?";
try {
Database db = Database.getInstance();
PreparedStatement prst = db.getPreparedStatement(sql);
prst.setInt(1, student.id);
int rowsAffected = prst.executeUpdate();
return rowsAffected > 0;
} catch (SQLException e) {
System.out.println(e.getMessage());
}
return false;
}