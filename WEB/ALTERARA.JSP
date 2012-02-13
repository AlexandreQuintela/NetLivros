<%@ include file="topo.jsp" %>
<%@include file="barraadmin.jsp" %>
<div id="content">
    <form name="formautor" method="POST" action="ServletAutor?cmd=salvaralteracao">
        <fieldset>
            <legend>Alteração Autor</legend>
            <div>
                <label for="id">Identificação</label><br>
                <input type="text" id="idAutor" name="idAutor" readonly value="${aut.idAutor}" size="10"/><br>
                <label for="nome">Nome</label><br>
                <input type="text" id="nome" name="nome" value="${aut.nome}" size="100" /><br>
                <label for="email">Email</label><br>
                <input type="text" id="email" name="email" value="${aut.email}" size="100" /><br>
                <label for="datanascimento">Data Nascimento</label><br>
                <input type="text" id="dataNascimento" name="dataNascimento" value="${aut.dataNascimento}" size="10" /><br>
            </div>
        </fieldset>
        <input type="submit" value="Enviar" name="btnenvia" />
        <input type="reset" value="Limpar" name="btnlimpa" />
    </form>
</div>
<<%@include file="rodape.jsp" %>