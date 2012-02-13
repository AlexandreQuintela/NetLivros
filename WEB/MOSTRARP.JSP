<%@ include file="topo.jsp" %>
<%@include file="barraadmin.jsp" %>
  <div id="content">
        <h1>Listagem das Publicações</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>Identificação</th>
                    <th>Título do Livro</th>
                    <th>Autor</th>
                    <th>Editora</th>
                    <th>Categoria</th>
                    <th>Preço</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="lista" items="${requestScope.publicacaoList}">
                    <tr>
                        <td>${lista.idPublicacao}</td>
                        <td>${lista.titulo}</td>
                        <td>${lista.autor}</td>
                        <td>${lista.nomeEditora}</td>
                        <td>${lista.categoria}</td>
                        <td>${lista.preco}</td>
                        <td>
                            <a href="ServletPublicacao?cmd=excluir&idPublicacao=${lista.idPublicacao}">Excluir</a>
                            <a href="ServletPublicacao?cmd=publica&idPublicacao=${lista.idPublicacao}">Alterar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a HREF="ServletPublicacao?cmd=publica">Incluir nova publicação</a><br><br><a HREF="/index.jsp"> Página principal</a>

  </div>
<%@ include file="rodape.jsp" %>

