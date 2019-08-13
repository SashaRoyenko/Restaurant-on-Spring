<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 09.06.2019
  Time: 15:39
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
    <title><fmt:message key="label.basket.title"/></title>
</head>
<body>
<jsp:include page="parts/nav.jsp"/>
<section class="home-slider owl-carousel">
    <div class="slider-item" style="background-image: url(${pageContext.request.contextPath}/images/bg_1.jpg);" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <div class="row slider-text align-items-center justify-content-center">
                <div class="col-md-10 col-sm-12 ftco-animate text-center">
                    <p class="breadcrumbs"><span class="mr-2"><a href="${pageContext.request.contextPath}/tasty-restaurant/home">
                        <fmt:message key="label.home.title"/></a></span> <span><fmt:message key="label.basket.title"/></span></p>
                    <h1 class="mb-3"><fmt:message key="label.basket.title"/></h1>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="ftco-section bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-12 dish-menu">
                <!-- END -->
                <div class="tab-content py-5" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel"
                         aria-labelledby="v-pills-home-tab">
                        <div class="row ">
                            <c:forEach items="${sessionScope.userDishes}" var="dish">
                                <div class="col-lg-6">
                                    <div class="menus d-flex ftco-animate">
                                        <div class="menu-img"
                                             style="background-image: url(${pageContext.request.contextPath}/images/dish-3.jpg);"></div>
                                        <div class="text d-flex">
                                            <div class="one-half">
                                                <h3><c:out value="${dish.name}"/></h3>
                                                <p>
                                                    <span class="menu-weight">Weight: </span>
                                                    <span><c:out value="${dish.weight}"/></span>
                                                </p>
                                            </div>
                                            <div class="one-forth pr-1 d-flex flex-column align-items-center">
                                                <span class="price"><c:out value="${dish.price}"/> <fmt:message key="label.price"/></span>
                                                <form action="${pageContext.request.contextPath}/tasty-restaurant/basket?action=deleteDish&id=<c:out value="${dish.id}"/>"
                                                      method="post">
                                                    <input class="menu_btn btn" type="submit" value="<fmt:message key="label.btn.delete"/>">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                        <div class="row">
                            <c:forEach items="${sessionScope.userDrinks}" var="drink">
                                <div class="col-lg-6">
                                    <div class="menus d-flex ftco-animate">
                                        <div class="menu-img"
                                             style="background-image: url(${pageContext.request.contextPath}/images/drink-1.jpg);"></div>
                                        <div class="text d-flex">
                                            <div class="one-half">
                                                <h3><c:out value="${drink.name}"/></h3>
                                                <p>
                                                    <span class="menu-weight">Volume: </span>
                                                    <span><c:out value="${drink.volume}"/></span>
                                                </p>
                                            </div>
                                            <div class="one-forth pr-1 d-flex flex-column align-items-center">
                                                <span class="price"><c:out value="${drink.price}"/> <fmt:message key="label.price"/></span>
                                                <form action="${pageContext.request.contextPath}/tasty-restaurant/basket?action=deleteDrink&id=<c:out value="${drink.id}"/>"
                                                      method="post">
                                                    <input class="menu_btn btn" type="submit" value="<fmt:message key="label.btn.delete"/>">
                                                </form>
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
<section class="container d-flex justify-content-center align-items-center">
    <div>
        <h5 class="mr-5">
            Total price: <c:out value="${sessionScope.totalPrice}"/> <fmt:message key="label.price"/>
        </h5>
    </div>
    <c:if test="${sessionScope.totalPrice ne 0}">
        <input id="address_btn" class="btn btn-primary pl-5 pr-5" type="submit" value="<fmt:message key="label.btn.buy"/>">
    </c:if>
</section>
<div id="address_wrapper">
    <div class="address_form">
        <form action="${pageContext.request.contextPath}/tasty-restaurant/order?action=buy" method="post"
              class="d-flex flex-column align-items-center justify-content-center ">

            <input type="text" placeholder="Your Address" required class="form-control" name="address">
            <input type="submit" class="mt-4 btn btn-primary pl-5 pr-5" value="<fmt:message key="label.btn.confirm"/>">

        </form>
    </div>
</div>
<jsp:include page="parts/footer.jsp"/>
</body>
</html>
