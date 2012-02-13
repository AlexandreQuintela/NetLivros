<table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tbody><tr>
            <td class="peqbrancolight" style="border-left: 1px dashed rgb(204, 204, 204); background-repeat: repeat-x;" background="imagens/home/dashedlin.gif" valign="middle"></td>
        </tr>
    </tbody>
</table>
<table cellpadding="0" cellspacing="0" width="100%">
<tbody>
    <%-- Inicia a linha da tabela
    --%>
    <tr>
        <%-- Inicia a coluna da tabela --%>
        <%! int conta = 1;%>
        <c:forEach var="lista" items="${requestScope.publicacaoList}">
        <td width="25%">
            <table align="center" cellpadding="3" width="90%">
                <tbody>
                    <tr>
                        <td class="normal" align="center" height="110" valign="middle">
                            <div align="center">
                                <a href="Publicacao?cmd=detalhe&idPublicacao=${lista.idPublicacao}"><img src="imagens/home/imagem${lista.idPublicacao}.jpg" align="center" border="0"></a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="normal" valign="top">
                            <div align="center">
                                <a href="Publicacao/detalhe?id=${lista.idPublicacao};ID=<%=s%>">${lista.titulo}<br></a>
                                ${lista.autor}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="normal" valign="top">
                            <div align="center">
                                <font class="normal">R$&nbsp;${lista.preco}</font><br>
                            </div>
                        </td>
                    </tr>
                    <tr><td class="normal" valign="top">
                            <div align="center"><a href="Carrinho/inclui?id=${lista.idPublicacao};ID=<%=s%>"><img src="imagens/home/comp0301.gif" border="0" vspace="3"></a></div>
                    </td></tr>
                </tbody>
            </table>
        </td>
    <% if (conta == 4) {%></tr><tr><td colspan="7" background="imagens/home/dashedlin.gif" height="1"></td></tr>
    <% }
        conta += 1;%>
    </c:forEach>
    <tr><td colspan="7" background="imagens/home/dashedlin.gif" height="1"></td></tr>
</tbody>
</table>
<%conta = 1;%>
<br>