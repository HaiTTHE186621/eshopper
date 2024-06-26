<%-- 
    Document   : navigation
    Created on : Mar 15, 2024, 2:10:01 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
    <a href="" class="text-decoration-none d-block d-lg-none">
        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
    </a>
    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
        <div class="navbar-nav mr-auto py-0">
            <a href="home" class="nav-item nav-link active">Home</a>
            <a href="shop" class="nav-item nav-link">Shop</a>
            <a href="detail?pid=1" class="nav-item nav-link">Shop Detail</a>
            <c:if test="${sessionScope.acc.roleid == 1}">
                <a href="crud" class="nav-item nav-link">Manage Products</a>
            </c:if>
            <c:if test="${sessionScope.acc != null}">
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
                    <div class="dropdown-menu rounded-0 m-0">
                        <a href="cart" class="dropdown-item">Shopping Cart</a>
                        <a href="checkout.jsp" class="dropdown-item">Checkout</a>
                    </div>
                </div>
            </c:if>
            <a href="contact.jsp" class="nav-item nav-link">Contact</a>
        </div>
        <c:if test="${sessionScope.acc == null}">
            <div class="navbar-nav ml-auto py-0">
                <a href="login.jsp" class="nav-item nav-link">Login</a>
            </div>
        </c:if>
        <c:if test="${sessionScope.acc != null}">
            <div class="navbar-nav ml-auto py-0">
                <p class="nav-item nav-link">Hello, ${sessionScope.acc.username}</p>
                <a href="logout" class="nav-item nav-link">Logout</a>
            </div>
        </c:if>

    </div>
</nav>