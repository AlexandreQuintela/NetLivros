<div class="sidebar">
<h2>Categorias</h2>
<ul>
    <c:forEach var="ca" items="${listCategoria}">
    <li>
    <a href="Pesquisa?cmd=pesquisa&idCategoria=${ca.idCategoria}"><font color="#318e42">${ca.categoria}</font></a><br></li>
   </c:forEach>
</ul>
</div>