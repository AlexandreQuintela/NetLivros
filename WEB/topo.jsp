<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<script>
    function mudaidioma(menuObj)
    {
        var i = menuObj.selectedIndex;

        if(i > 0)
        {
            window.location = menuObj.options[i].value;
        }
    }
</script>

<fmt:setLocale value="pt_br" scope="application" />
<c:choose>
    <c:when test="${param.locale eq 'en_US'}">
        <fmt:setLocale value="en_US" />
    </c:when>
    <c:otherwise>
        <fmt:setLocale value="pt_BR" />
    </c:otherwise>
</c:choose>
<fmt:setBundle basename="internacionalizacao.dicionario"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="charset=ISO-8859-1" />
    <title>NetLivros</title>
    <meta name="generator" content="NetBeans" />
    <link rel="stylesheet" href="resources/css/style.css" type="text/css" media="screen" />
</head>
<body>
<div id="header">
    <div id="headerimg">
        <h1><a href="<?php echo get_settings('home'); ?>/"><?php bloginfo('name'); ?></a></h1>
        <div class="description"><img id="logonet" src="resources/imagens/logonet.jpg" alt="Logo Net"/></div>
        <form method="get" action="Pesquisa" id="pesquisar" onsubmit="submitSearchForm();return document.returnValue">
            <div id="search">
                <fmt:message key="busca" />: <input type="text" name="busca" value="" /><input type="image" id="imageok" class="image" src="imagens/home/ok.gif" name="cmd" value="buscar" alt="ok" /><br>
                <input type="radio" name="tipoBusca" value="titulo" checked="checked" /><fmt:message key="titulo" />
                <input type="radio" name="tipoBusca" value="isbn" />ISBN
                <input type="radio" name="tipoBusca" value="autor" /><fmt:message key="autor" />
                <input type="radio" name="tipoBusca" value="editora" /><fmt:message key="editora" />
                
            </div>
        </form>
    </div>
    <!-- inicio menu de navegação-->
    <div id="navi">
        <ul id="nav">
            <li class="page_item"><a href="index.jsp" title="home"><fmt:message key="principal" /></a></li>
            <li class="page_item"><a href="login.jsp" title=""><fmt:message key="entrar" /></a></li>
            <li class="page_item"><a href="pedidos.jsp" title=""><fmt:message key="meuspedidos" /></a></li>
            <li class="page_item"><a href="carrinho.jsp" title=""><fmt:message key="meucarrinho" /></a></li>
            <li class="page_item"><a href="fale.jsp" title=""><fmt:message key="faleconosco" /></a></li>
            <li class="page_item"><select onChange="javascript:mudaidioma(this)" name="idioma">
                    <option selected><fmt:message key="selecioneidioma" /></option>
                    <option value="?locale=pt_BR"><fmt:message key="portugues" /></option>
                    <option value="?locale=en_US"><fmt:message key="ingles" /></option>
            </select></li>
        </ul>
    </div>
    <!--fim menu de navegação-->
</div>
<!--/header -->
<div id="page">