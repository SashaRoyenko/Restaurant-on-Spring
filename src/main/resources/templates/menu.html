<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 29.05.2019
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 29.05.2019
  Time: 8:59
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
    <jsp:include page="parts/link.jsp"/>
    <title><fmt:message key="label.menu.title"/></title>
</head>
<body>
<jsp:include page="parts/nav.jsp"/>
<section class="home-slider owl-carousel">
    <div class="slider-item" style="background-image: url(${pageContext.request.contextPath}/images/bg_1.jpg);"
         data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <div class="row slider-text align-items-center justify-content-center">
                <div class="col-md-10 col-sm-12 ftco-animate text-center">
                    <p class="breadcrumbs"><span class="mr-2"><a
                            href="${pageContext.request.contextPath}/tasty-restaurant/home"><fmt:message
                            key="label.home.title"/></a>
                    </span> <span><fmt:message key="label.menu.title"/></span></p>
                    <h1 class="mb-3"><fmt:message key="label.menu.heading"/></h1>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section bg-light">
    <div class="container">
        <div class="row justify-content-center mb-5 pb-5">
            <div class="col-md-7 text-center heading-section ftco-animate">
                <span class="subheading"><fmt:message key="label.menu.title"/></span>
                <h2><fmt:message key="label.menu.heading"/></h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 dish-menu">

                <div class="nav nav-pills justify-content-center ftco-animate" id="v-pills-tab" role="tablist"
                     aria-orientation="vertical">
                    <a class="nav-link py-3 px-4 active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home"
                       role="tab" aria-controls="v-pills-home" aria-selected="true"><span class="flaticon-meat"></span>
                        <fmt:message key="label.menu.dish"/></a>
                    <a class="nav-link py-3 px-4" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages"
                       role="tab" aria-controls="v-pills-messages" aria-selected="false"><span
                            class="flaticon-cheers"></span><fmt:message key="label.menu.drink"/></a>
                </div>
                <!-- END -->
                <div class="tab-content py-5" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel"
                         aria-labelledby="v-pills-home-tab">
                        <div class="row ">
                            <c:forEach items="${requestScope.dishList}" var="dish">
                                <div class="col-lg-6">
                                    <div class="menus d-flex ftco-animate">
                                        <div class="text d-flex flex-row justify-content-between w-100">
                                            <div class="">
                                                <h3><c:out value="${dish.name}"/></h3>
                                                <p>
                                                    <c:forEach items="${dish.ingredientList}" var="ingredient">
                                                        <span class="mr-1"><c:out
                                                                value="${ingredient.ingredientName}"/></span>
                                                    </c:forEach>
                                                </p>
                                                <p>
                                                    <span class="menu-weight">Weight: </span>
                                                    <span><c:out value="${dish.weight}"/></span>
                                                </p>
                                            </div>
                                            <div class="d-flex flex-column align-items-center">
                                                <span class="price"><c:out value="${dish.price}"/> <fmt:message
                                                        key="label.price"/></span>
                                                <c:if test="${sessionScope.sessionUser.role ne 'ADMIN'}">
                                                <form action="${pageContext.request.contextPath}/tasty-restaurant/basket?action=addDish&id=<c:out value="${dish.id}"/>"
                                                      method="post">
                                                    <input class="menu_btn btn" type="submit"
                                                           value="<fmt:message key="label.btn.add"/>">
                                                </form>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="tab-pane fade" id="v-pills-messages" role="tabpanel"
                         aria-labelledby="v-pills-messages-tab">
                        <div class="row">
                            <c:forEach items="${requestScope.drinkList}" var="drink">
                                <div class="col-lg-6">
                                    <div class="menus d-flex ftco-animate">
                                        <div class="text d-flex justify-content-between w-100">
                                            <div class="">
                                                <h3><c:out value="${drink.name}"/></h3>
                                                <p>
                                                    <span class="menu-weight">Volume: </span>
                                                    <span><c:out value="${drink.volume}"/></span>
                                                </p>
                                            </div>
                                            <div class="d-flex flex-column align-items-center">
                                                <span class="price"><c:out value="${drink.price}"/> <fmt:message
                                                        key="label.price"/></span>
                                                <c:if test="${sessionScope.sessionUser.role ne 'ADMIN'}">
                                                    <form action="${pageContext.request.contextPath}/tasty-restaurant/basket?action=addDrink&id=<c:out value="${drink.id}"/>"
                                                          method="post">
                                                        <input class="menu_btn btn" type="submit"
                                                               value="<fmt:message key="label.btn.add"/>">
                                                    </form>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="parts/footer.jsp"/>
