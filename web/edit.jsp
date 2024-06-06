<%-- 
    Document   : edit
    Created on : Mar 17, 2024, 10:30:00 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        
            
                <div class="modal-content">
                    <form action="edit" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                             <div class="form-group">
                                <label>ID</label>
                                <input name="pid" type="text" class="form-control" value="${p.pid}" readonly="" required>
                            </div>
                            <div class="form-group">
                                <label>Name</label>
                                <input name="name" type="text" class="form-control" value="${p.pname}" required>
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <input name="image" type="text" class="form-control" value="${p.pimage}" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input name="price" type="text" class="form-control" value="${p.pprice}" required>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <input name="description" class="form-control" value="${p.pdes}" required></input>
                            </div>
                            <div class="form-group">
                                <label>Category</label>
                                <select name="cid" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${listc}" var="o">
                                        <option value="${o.cid}">${o.cname}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>For</label>
                                <select name="for" class="form-select" aria-label="Default select example">
                                        <option value="1">Men</option>
                                        <option value="2">Women</option>
                                        <option value="3">Baby</option>
                                </select>
                            </div>

                        </div>
                             
                        <div class="modal-footer">
                            <input type="submit" class="btn btn-success" value="Edit">
                        </div>
                    </form>
                            <button onclick="location.href='crud'">Cancel</button>
                </div>
           
        
    </body>
</html>
