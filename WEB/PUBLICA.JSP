<table cellpadding="0" cellspacing="0" width="100%">
    <c:forEach var="lista" items="${requestScope.publicacaoList}">
        <tbody>
            <tr><td style="width: 97px; height: 105px;" colspan="1" rowspan="4">
                    <img style="width: 70px; height: 102px;" alt="${lista.titulo}"
                         src="imagens/home/imagem${lista.idPublicacao}.jpg">
                </td>
                <td>Publicação:<a href="Publicacao/detalhe?id=${lista.idPublicacao};ID=<%=s%>"">${lista.titulo}</a></td>
                <td colspan="1" rowspan="4"><a href="Carrinho/inclui?id=${lista.idPublicacao};ID=<%=s%>"><img src="imagens/home/comp0301.gif" border="0" vspace="3"></a></td>
            </tr>
            <tr><td>Autor:${lista.autor}</td></tr>
            <tr><td>Editora:${lista.nomeEditora}</td></tr>
            <tr><td>Valor:R$ ${lista.preco}</td></tr>
            <tr><td colspan="7" background="imagens/home/dashedlin.gif" height="1"></td></tr>
        </tbody>
    </c:forEach>
</table>