<%@ include file="topo.jsp" %>
<%@include file="barraadmin.jsp" %>
  <div id="content">
        <h1>Lista de Usuários</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Usuário</th>
                    <th>Senha</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="lista" items="${requestScope.usuariosList}">
                    <tr>
                        <td>${lista.usuario}</td>
                        <td>${lista.senha}</td>
                        <td>
                            <a href="user?cmd=excluir&usuario=${lista.usuario}">Excluir</a>
                            <a href="user?cmd=alterar&usuario=${lista.usuario}">Alterar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a HREF="formusuario.jsp">Incluir Novo Usuário </a><br><br><a HREF="/index.jsp"> Página principal</a>

  </div>
<%@ include file="rodape.jsp" %>

