<%@ include file="topo.jsp" %>
<%@include file="barraadmin.jsp" %>
<div id="content">
    <h1>Tabela de Clientes</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Endereço</th>
                <th>Telefone</th>
                <th>Estado</th>
                <th>Email</th>
                <th>Senha</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="lista" items="${requestScope.clientesList}">
                <tr>
                    <td>${lista.idCliente}</td>
                    <td>${lista.nome}</td>
                    <td>${lista.endereco}</td>
                    <td>${lista.telefone}</td>
                    <td>${lista.estado}</td>
                    <td>${lista.email}</td>
                    <td>${lista.senha}</td>
                    <td>
                        <a href="ServletCliente?cmd=excluir&idCliente=${lista.idCliente}">Excluir</a>
                        <a href="ServletCliente?cmd=alterar&idCliente=${lista.idCliente}">Alterar</a>
                    </td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
</div>
<%@ include file="rodape.jsp" %>
