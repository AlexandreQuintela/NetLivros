<%@ include file="topo.jsp" %>
<%@include file="barraadmin.jsp" %>
  <div id="content">
        <h1>Lista de Livros</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ISBN</th>
                    <th>Título</th>
                    <th>Edição</th>
                    <th>Ano</th>
                    <th>Descrição</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="lista" items="${requestScope.livrosList}">
                    <tr>
                        <td>${lista.isbn}</td>
                        <td>${lista.titulo}</td>
                        <td>${lista.numeroEdicao}</td>
                        <td>${lista.anoPublicacao}</td>
                        <td>${lista.descricao}</td>
                        <td>
                            <a href="ServletLivro?cmd=excluir&isbn=${lista.isbn}">Excluir</a>
                            <a href="ServletLivro?cmd=alterar&isbn=${lista.isbn}">Alterar</a>
                            <a href="ServletCarrinho?cmd=incluir=${lista.isbn}">Comprar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a HREF="formlivro.jsp">Incluir Novo Livro </a><br><br><a HREF="index.jsp"> Página principal</a>

  </div>
<%@ include file="rodape.jsp" %>

