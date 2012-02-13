<%@ include file="topo.jsp" %>
<%@include file="barraadmin.jsp" %>
<div id="content">
    <h1>Modificar Livro</h1>
    <form name="alterareditora" method="POST" action="ServletLivro?cmd=salvaralteracao">
        <label>ISBN :&nbsp;</label><input type="text" name="isbn" maxlength="13" size="13" value="${liv.isbn}" /><br><br>
        <label>Título :&nbsp;</label><input type="text" name="titulo" maxlength="50" size="50" value="${liv.titulo}" /><br><br>
        <label>Edição :&nbsp;</label><input type="text" name="numeroEdicao" maxlength="2"  size="2" value="${liv.numeroEdicao}" /><br><br>
        <label>Ano :&nbsp;</label><input type="text" name="anoPublicacao" maxlength="4"  size="4" value="${liv.anoPublicacao}"/><br><br>
        <label>Descrição :&nbsp;</label><input type="text" name="descricao" maxlength="50" size="50" value="${liv.descricao}" /><br><br>
        <br><br><br>
        <input type="submit" value="Enviar" name="btnenvia" />
        <input type="reset" value="Limpar" name="btnlimpa" />
    </form>
</div>
<<%@include file="rodape.jsp" %>

