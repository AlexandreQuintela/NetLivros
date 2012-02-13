<%@ include file="topo.jsp" %>
<div id="content">
    <h1>Alteração cadastro de Cliente</h1>
        <form name="alterarcliente" method="POST" action="ServletCliente?cmd=salvaralteracao">
            <label>Identificação :</label><input type="text" name="idCliente" readonly value="${cli.idCliente}"/><br><br>
            <label>Nome :</label><input type="text" name="nome" value="${cli.nome}" size="50" /><br><br>
            <label>Endereço :</label><input type="text" name="endereco" value="${cli.endereco}" size="50" /><br><br>
            <label>Telefone :</label><input type="text" name="telefone" value="${cli.telefone}" size="50" /><br><br>
            <label>Estado civil :</label><input type="text" name="estado" value="${cli.estado}" size="50" /><br><br>
            <input type="submit" value="Enviar" name="btnenvia" />
            <input type="reset" value="Limpar" name="btnlimpa" />
        </form>
</div>
<<%@include file="rodape.jsp" %>