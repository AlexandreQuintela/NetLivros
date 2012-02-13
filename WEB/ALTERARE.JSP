<%@ include file="topo.jsp" %>
<%@include file="barraadmin.jsp" %>
<div id="content">
    <h1>Modificar Editora</h1>
    <form name="alterareditora" method="POST" action="ServletEditora?cmd=salvaralteracao">
        <label>Identificação</label><input type="text" name="id" readonly value="${edi.idEditora}"/><br><br>
        <label>Nome Editora:&nbsp;</label><input type="text" name="nomeeditora" value="${edi.nomeEditora}" size="50" /><br><br>
        <br><br><br>
        <input type="submit" value="Enviar" name="btnenvia" />
        <input type="reset" value="Limpar" name="btnlimpa" />
    </form>
</div>
<<%@include file="rodape.jsp" %>