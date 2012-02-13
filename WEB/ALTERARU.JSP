<%@ include file="topo.jsp" %>
<%@include file="barraadmin.jsp" %>
<div id="content">
    <h1>Alteração dos Dados Pessoais</h1>
    <form name="alterarusuario" method="POST" action="user?cmd=salvaralteracao">
        <label>Usuario: </label><input type="text" name="usuario" value="${usr.usuario}"/><br><br>
        <label>Senha :&nbsp;</label><input type="text" name="senha" value="${usr.senha}" size="50" /><br><br>
        <input type="submit" value="Enviar" name="btnenvia" />
        <input type="reset" value="Limpar" name="btnlimpa" />
    </form>
</div>
<<%@include file="rodape.jsp" %>

