<div class="sidebar">
Administra��o
<ul>
        <li><a HREF="formcliente.jsp">Incluir Cliente </a></li>
        <li><a HREF="ServletCliente?cmd=listar">Listar Clientes </a></li>
        <li><a HREF="formeditora.jsp">Incluir Editora </a></li>
        <li><a HREF="ServletEditora?cmd=listar">Listar Editoras </a></li>
        <li><a HREF="formautor.jsp">Incluir Autor </a></li>
        <li><a HREF="ServletAutor?cmd=listar">Listar Autores </a></li>
        <li><a HREF="formlivro.jsp">Incluir Livro </a></li>
        <li><a HREF="ServletLivro?cmd=listar">Listar Livros </a></li>
        <li><a HREF="ServletPublicacao?cmd=publica">Incluir Publica��o </a></li>
        <li><a HREF="ServletPublicacao?cmd=listar">Listar Publica��es </a></li>
        <li><a HREF="formusuario.jsp">Incluir Usu�rio </a></li>
        <li><a HREF="user?cmd=listar">Listar Usu�rio </a></li>
</ul>
Categorias
<ul>
    <c:forEach var="ca" items="${listCategoria}">
    <li>${ca.categoria}</li>
    </c:forEach>
</ul>
</div>