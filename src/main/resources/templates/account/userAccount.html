<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 29.05.2019
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html lang="${locale}">
<head>
    <title><fmt:message key="label.user.title"/> </title>
    <jsp:include page="../parts/link.jsp"/>

</head>
<body style = "background-color: #eaeaea;">
<jsp:include page="../parts/nav.jsp"/>
<section class="home-slider owl-carousel">
    <div class="slider-item" style="background-image: url(${pageContext.request.contextPath}/images/bg_1.jpg);" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <div class="row slider-text align-items-center justify-content-center">
                <div class="col-md-10 col-sm-12 ftco-animate text-center">
                    <p class="breadcrumbs"><span class="mr-2"><a href="${pageContext.request.contextPath}/tasty-restaurant/home">
                        <fmt:message key="label.home.title"/></a></span> <span><fmt:message key="label.user.title"/></span></p>
                    <h1 class="mb-3"><fmt:message key="label.user.title"/></h1>
                </div>
            </div>
        </div>
    </div>
</section>

<h5 class="text-center mt-5 account_title"><fmt:message key="label.user.heading"/></h5>

<section class="user_account__section container mt-5">
    <div class="user_account__wrap d-flex flex-row">
        <div class="nav flex-column nav-pills col-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
            <a class="nav-link my_nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home"
               role="tab" aria-controls="v-pills-home" aria-selected="true"><fmt:message key="label.user.cabinet"/></a>
            <a class="nav-link my_nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile"
               role="tab" aria-controls="v-pills-profile" aria-selected="false"><fmt:message key="label.user.unpaid"/></a>
        </div>

        <div class="tab-content col-9" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                <div class="user_cabinet offset-1">
                    <ul class="user_cabinet__list d-flex flex-column">
                        <li class="user_cabinet__list-item d-flex flex-row align-items-baseline">
                            <h6 class="user_cabinet__title">${sessionScope.sessionUser.firstName}</h6><i
                                class="user_cabinet__edit fas fa-edit" id="editname"></i>
                            <form class="form-group slide" action="" method="post" id="slidename">
                                <input class="form-control" type="text" placeholder="First Name">
                            </form>
                        </li>
                        <li class="user_cabinet__list-item d-flex flex-row align-items-baseline">
                            <h6 class="user_cabinet__title">${sessionScope.sessionUser.lastName}</h6><i
                                class="user_cabinet__edit fas fa-edit" id="editsurname"></i>
                            <form class="form-group" action="" method="post" id="slidesurname">
                                <input class="form-control" type="text" placeholder="Last Name">
                            </form>
                        </li>
                        <li class="user_cabinet__list-item d-flex flex-row align-items-baseline">
                            <h6 class="user_cabinet__title">${sessionScope.sessionUser.email}</h6><i
                                class="user_cabinet__edit fas fa-edit" id="editemail"></i>
                            <form class="form-group" action="" method="post" id="slideemail">
                                <input class="form-control" type="email" placeholder="Email">
                            </form>
                        </li>
                        <li class="user_cabinet__list-item d-flex flex-row align-items-baseline">
                            <h6 class="user_cabinet__title">${sessionScope.sessionUser.phone}</h6><i
                                class="user_cabinet__edit fas fa-edit" id="editphone"></i>
                            <form class="form-group" action="" method="post" id="slidephone">
                                <input class="form-control" type="text" placeholder="Phone">
                            </form>
                        </li>
                        <li class="user_cabinet__list-item d-flex flex-row align-items-baseline">
                            <h6 class="user_cabinet__title">********</h6><i class="user_cabinet__edit fas fa-edit"
                                                                            id="editpassword"></i>
                            <form class="form-group d-flex flex-row user_account__form" action="" method="post">
                                <div id="slidepassword">
                                    <input class="form-control mr-4" type="password" placeholder="Password">
                                    <input class="form-control" type="password" placeholder="Confirm Password">
                                </div>
                            </form>
                        </li>
                    </ul>
                    <form action="${pageContext.request.contextPath}/tasty-restaurant/logOut">
                        <button type="submit" class="logout btn"><fmt:message key="label.btn.logout"/></button>
                    </form>
                </div>
            </div>
            <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                <ul class="d-flex flex-column">
                    <c:forEach items="${requestScope.unPaidOrders}" var="unpaid">
                        <li class="order_item d-flex flex-row justify-content-between align-items-center">
                            <p><c:out value="${unpaid.date}"/></p>
                            <p><c:out value="${unpaid.bill}"/></p>
                            <p><c:out value="${unpaid.address}"/></p>
                            <p><c:out value="${unpaid.user.firstName}"/></p>
                            <p><c:out value="${unpaid.user.phone}"/></p>
                            <form action="${pageContext.request.contextPath}/tasty-restaurant/order?action=payOrder&id=<c:out value="${unpaid.id}"/>" method="post">
                                <input class="btn menu_btn" type="submit" value="<fmt:message key="label.btn.pay"/>">
                            </form>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../parts/footer.jsp"/>
</body>
</html>
