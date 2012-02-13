<%@ include file="topo.jsp" %>
<div id="content">
    <form method="post" action="Login">
        <center><b>Já sou cadastrado</b>
            <table border="0">
                <tr><td><b>E-mail:</b></td>
                <td><input type="text" name="email" size="50" maxlength="50"></td></tr>
                <tr><td><b>Senha:</b></td>
                <td><input type="password" name="senha" size="10" maxlength="10"></td></tr>
        </table></center>
        <center><br>
            <input type="submit" name="botao" value="Enviar">
        </center>
    </form>
</div>
<%@ include file="rodape.jsp" %>
