<%@ include file="topo.jsp" %>
<%@include file="barraadmin.jsp" %>
  <div id="content">
<table border="1">
<thead>
    <tr>
        <th>ID</th>
        <th>Nome Editora</th>
    </tr>
</thead>
<tbody>
    <c:forEach var="lista" items="${requestScope.editoraList}">
    <tr>
        <td>${lista.idEditora}</td>
        <td>${lista.nomeEditora}</td>
        <td>
            <a href="ServletEditora?cmd=excluir&id=${lista.idEditora}">
                Excluir
            </a>
            <a href="ServletEditora?cmd=alterar&id=${lista.idEditora}">
                Alterar
            </a>
        </td>
    </tr>
    </c:forEach>

</tbody>
</table>
<a HREF="formeditora.jsp"> incluir Editora </a><br><br><a HREF="index.jsp"> Página principal</a>
  </div>
<<%@include file="rodape.jsp" %>