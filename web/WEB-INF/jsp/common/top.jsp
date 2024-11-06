<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!DOCTYPE html>

<html>

<head>
    <link rel="StyleSheet" href="css/MyPetStore.css" type="text/css"
          media="screen" />
    <title>MyPetStore</title>
</head>

<body>
    <div id="Header">

        <div id="Logo">
            <div id="LogoContent">
                <a href="mainForm"><img src="images/logo-topbar.gif" /></a>
            </div>
        </div>

        <div id="Menu">
            <div id="MenuContent">
                <a href="cartForm"><img align="middle" name="img_cart" src="images/cart.gif" /></a>
                <img align="middle" src="images/separator.gif" />
                <c:if test="${sessionScope.loginAccount==null}">
                    <a href="signonForm">Sign In</a>
                    <img align="middle" src="images/separator.gif" />
                </c:if>

                <c:if test="${sessionScope.loginAccount!=null}">
                    <a href="signOut">Sign Out</a>
                    <img align="middle" src="images/separator.gif" />
                    <a href="editAccount">My Account</a>
                    <img align="middle" src="images/separator.gif" />
                </c:if>

                <a href="help.html">?</a>
            </div>
        </div>

        <div id="Search">
            <div id="SearchContent">
                <form action="" method="post">
                    <input type="text" name="keyword" size="14">
                    <input type="submit" value="Search">
                </form>
            </div>
        </div>

        <div id="QuickLinks">
            <a href=""><img src="images/sm_fish.gif" /></a>
            <img src="images/separator.gif" />
            <A href=""><img src="images/sm_dogs.gif" /></A>
            <img src="images/separator.gif" />
            <a href=""><img src="images/sm_reptiles.gif" /></a>
            <img src="images/separator.gif" />
            <a href=""><img src="images/sm_cats.gif" /></a>
            <img src="images/separator.gif" />
            <A href=""><img src="images/sm_birds.gif" /></A>
            <img src="images/separator.gif" />
        </div>

    </div>

<div id="Content"><stripes:messages />

