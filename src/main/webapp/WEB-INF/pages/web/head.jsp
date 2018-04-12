<%@page pageEncoding="UTF-8" language="java" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.getContextPath()}"/>
<header id="top" class="fixed_nav">
    <div id="logo" class="lf">
        <img class="animated jello" src="${ctx}/images/header/logo.png" alt="logo"/>
    </div>
    <div id="top_input" class="lf">
        <input id="input" type="text" placeholder="请输入您要搜索的内容"/>
        <a href="search.html" class="rt"><img id="search" src="${ctx}/images/header/search.png" alt="搜索"/></a>
    </div>
    <div class="rt">
        <ul class="lf">
            <li><a href="${ctx}/user/showPersonalInfo.do">${user.username}</a><b>|</b></li>
            <li><a href="favorites.html" title="我的收藏"><img class="care" src="${ctx}/images/header/care.png" alt=""/></a><b>|</b></li>
            <li><a href="orders.html" title="我的订单"><img class="order" src="${ctx}/images/header/order.png" alt=""/></a><b>|</b></li>
            <li><a href="cart.html" title="我的购物车"><img class="shopcar" src="${ctx}/images/header/shop_car.png" alt=""/></a><b>|</b></li>
            <li><a href="help.html">帮助</a><b>|</b></li>
            <li>
                <c:if test="${user == null}"><a href="${ctx}/user/showLogin.do">登录</a></c:if>
                <c:if test="${user != null}"><a href="${ctx}/main/exit.do">退出</a></c:if>
            </li>
        </ul>
    </div>
</header>