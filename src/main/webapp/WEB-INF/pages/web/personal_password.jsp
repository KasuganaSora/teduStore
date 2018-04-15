<%@page pageEncoding="UTF-8" language="java" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.getContextPath()}"/>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="${ctx}/css/orders.css" rel="Stylesheet"/>
    <link href="${ctx}/css/header.css" rel="Stylesheet"/>
    <link href="${ctx}/css/footer.css" rel="Stylesheet"/>
    <link href="${ctx}/css/personage.css" rel="stylesheet"/>
</head>
<body>
<!-- 页面顶部-->
<c:import url="head.jsp"/>
<!-- nav主导航-->
<nav id="nav">
    <ul>
        <li><a href="index.html" class="acti">首页</a></li>
        <li><a href="index.html#computer">电脑办公</a></li>
        <li><a href="index.html#stationery">办公文具</a></li>
    </ul>
</nav>
<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>个人中心</a></li>
    </ul>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <c:import url="leftNav.jsp"/>
    <!-- 右边栏-->
    <!--个人信息头部-->
    <div class="rightsidebar_box rt">
        <div class="rs_header">
            <span><a href="${ctx}/user/showPersonalInfo.do">我的信息</a></span>
            <span class="rs_header_active"><a href="${ctx}/user/showPersonPassword.do">安全管理</a></span>
        </div>

        <!--安全管理 -->
        <form id="pwd-form">
            <div class="rs_content">
                <p class="change_password_title">更改密码</p>
                <div class="new_password">
                    <span class="word">输入旧密码：</span><input type="password" name="oldPwd" id="oldPwd"/><span
                        class="change_hint" id="oldPwdMsg"></span>
                </div>
                <div class="new_password">
                    <span class="word">输入新密码：</span><input type="password" name="newPwd" id="newPwd"/><span
                        class="change_hint" id="newPwdMsg"></span>
                </div>
                <div class="confirm_password">
                    <span class="word">确认新密码：</span><input type="password" name="confirmPwd" id="confirmPwd"/><span
                        class="confirm_hint" id="confirmPwdMsg"></span>
                </div>
                <div class="save_password" id="savePwd">
                    保存更改
                </div>
                <span id="errorMsg"></span>
            </div>
        </form>

    </div>
</div>

<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="${ctx}/images/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="${ctx}/images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="${ctx}/images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="${ctx}/images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
            <p class="footer1"><img src="${ctx}/images/footer/logo.png" alt="" class=" footLogo"/></p>
            <p class="footer2"><img src="${ctx}/images/footer/footerFont.png" alt=""/></p>
        </div>
        <div class="foot_left lf">
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="${ctx}/images/footer/wechat.png" alt=""/>
                    <img src="${ctx}/images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>学子商城客户端</p>
            <img src="${ctx}/images/footer/ios.png" class="lf">
            <img src="${ctx}/images/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="${ctx}/images/footer/erweima.png">
        </div>
        <!-- 页面底部-备案号 #footer -->
        <div class="record">
            &copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx
        </div>
    </div>

</div>
</body>
<script type="text/javascript" src="${ctx}/js/jquery-3.1.1.min.js"></script>
<script src="${ctx}/js/index.js"></script>
<script src="${ctx}/js/jquery.page.js"></script>
<script type="text/javascript" src="${ctx}/js/orders.js"></script>
<script type="text/javascript">
    function checkPasswordLength(pwd) {
        return pwd.length >= 6 && pwd.length <= 9;
    }

    //验证新密码和确认密码是否一致
    function checkPasswordEquals() {
        var newPwdValue = $("#newPwd").val();
        var confirmPwdValue = $("#confirmPwd").val();
        return newPwdValue == confirmPwdValue;

    }

    $("#oldPwd").blur(function () {
        if (checkPasswordLength($("#oldPwd").val())) {
            $("#oldPwdMsg").html("密码格式正确");
            $("#oldPwdMsg").css("color", "green");
        } else {
            $("#oldPwdMsg").html("密码格式不正确");
            $("#oldPwdMsg").css("color", "red");
        }
    });
    $("#newPwd").blur(function () {
        if (checkPasswordLength($("#newPwd").val())) {
            $("#newPwdMsg").html("密码格式正确");
            $("#newPwdMsg").css("color", "green");
        } else {
            $("#newPwdMsg").html("密码格式不正确");
            $("#newPwdMsg").css("color", "red");
        }
    });
    $("#confirmPwd").blur(function () {
        if (checkPasswordLength($("#confirmPwd").val())) {
            $("#confirmPwdMsg").html("密码格式正确");
            $("#confirmPwdMsg").css("color", "green");
        } else {
            $("#confirmPwdMsg").html("密码格式不正确");
            $("#confirmPwdMsg").css("color", "red");
        }
    });
</script>
<script type="text/javascript">
    /*将表单封装成json*/
    $.fn.serializeObject = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };

    $("#savePwd").click(function () {
        if (!checkPasswordLength($("#oldPwd").val()) &&
            checkPasswordLength($("#newPwd").val()) &&
            checkPasswordLength($("#confirmPwd").val()) &&
            checkPasswordEquals()) {
            return;
        }
        var formInfo = $("#pwd-form").serializeObject();
        var pwdInfo = JSON.stringify(formInfo);
        $.ajax({
            "url":"${ctx}/user/updatePassword.do",
            "data":"pwdInfo="+pwdInfo,
            "type":"POST",
            "dataType":"json",
            "success":function(data){
                if (data.status == "0") {
                    $("#errorMsg").attr("color","red");
                    $("#errorMsg").text(data.message);
                    return;
                } else {
                    alert("将要回到登录界面");
                }
                location.href='${ctx}/user/showLogin.do';
            }
        })
    })
</script>
<script type="text/javascript">
    $(function(){
        //所有的dd隐藏
        $("#leftsidebar_box dd").hide();
        //让账号管理显示
        $("#leftsidebar_box .count_managment dd").show();
        //所有的自定义列表的标题后边的图片 myOrder2.png
        $("#leftsidebar_box dt img").attr("src","${ctx}/images/myOrder/myOrder2.png");
        //设置账号管理的图片和其他的三个不相同
        $("#leftsidebar_box .count_managment").find('img').attr("src","${ctx}/images/myOrder/myOrder1.png");

    });
</script>
</html>