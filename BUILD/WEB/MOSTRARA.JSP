<%@ include file="topo.jsp" %>
<%@include file="barraadmin.jsp" %>
  <div id="content">
<h1>Tabela de Autor</h1>

<table border="1">
<thead>
    <tr>
        <th>IDAutor</th>
        <th>Nome Autor</th>
        <th>Email</th>
        <th>Data Nascimento</th>
    </tr>
</thead>
<tbody>
    <c:forEach var="lista" items="${requestScope.autoresList}">
    <tr>
        <td>${lista.idAutor}</td>
        <td>${lista.nome}</td>
        <td>${lista.email}</td>
        <td>${lista.dataNascimento}</td>
        <td>
            <a href="ServletAutor?cmd=excluir&idAutor=${lista.idAutor}">
                Excluir
            </a>
            <a href="ServletAutor?cmd=alterar&idAutor=${lista.idAutor}">
                Alterar
            </a>
        </td>
    </tr>
    </c:forEach>

</tbody>
</table>
<a HREF="formautor.jsp"> incluir Autor </a><br><br><a HREF="index.jsp"> Página principal</a>

  </div>
<%@ include file="rodape.jsp" %>

