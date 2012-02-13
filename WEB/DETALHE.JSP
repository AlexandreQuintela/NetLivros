<%@include file="topo.jsp" %>
<table width="98%" cellspacing="0" cellpadding="0" align="center">
    <tbody><tr>
            <td align="center"><img src="/imgc/dinamica/det0301.gif"/></td><td colspan="2"/>
        </tr>
        <tr>
            <td align="center"><img src="/imgc/icones/down0301.gif"/></td><td colspan="2"/>
        </tr>
        <tr>
            <!-- imagem do produto -->
            <td width="160" align="center" class="normal" style="border: 1px dashed rgb(204, 204, 204);">
                <br/>
                <a class="linklight"> <img src="imagens/home/imagem${pub.idPublicacao}.jpg" align="center" border="0"></a>
                <br/> 
            </td>
            <td style="border-top: 1px dashed rgb(204, 204, 204); border-right: 1px dashed rgb(204, 204, 204); border-bottom: 1px dashed rgb(204, 204, 204);">
                <table width="100%" cellspacing="0" cellpadding="4">
                    <!-- título e características básicas -->
                    <tbody><tr>
                            <td width="10%" class="detalhebold">Título:</td>
                            <td width="65%" class="normal"><b>${pub.titulo} </b></td>
                        </tr>
                        <tr>
                            <td class="detalhebold">Autor:</td>
                            <td class="normal">${pub.autor} </td>
                        </tr>
                        <tr>
                            <td class="detalhebold">Editora:</td>
                            <td class="normal"> ${pub.nomeEditora}</td>
                        </tr>
                        <tr>
                            <td class="detalhebold">Edição:</td>
                            <td class="normal"> ${pub.edicao}</td>
                        </tr>
                        <tr>
                            <td class="detalhebold">Publicação:</td>
                            <td class="normal"> ${pub.ano}</td>
                        </tr>
                        <!-- previsão + preço -->
                        <tr>
                            <td class="normal" colspan="2">
                                <font class="detalhebold">Disponibilidade:</font>
                                <div style="padding-left: 10px;">Produto em estoque.</div>
                                <br/>
                                <font class="detalhebold">Previsão de Entrega:</font>
                                <div style="padding-left: 10px;">
                                    Até 1 dia útil para Juiz de Fora
                                </div>
                                <br/>
                                <table width="90%" cellspacing="3" cellpadding="3">
                                    <tbody><tr bgcolor="#e6e6e6">
                                            <td width="100%" class="grande">R$ ${pub.preco} <br/></td>

                                            <td valign="bottom" bgcolor="#ffffff" align="right">
                                                   <a href="/cesta/cesta.dll/inclui?pro_id=2594519&amp;ID=C90775C87D80C0B0A0E191045"><img border="0" src="imagens/home/comp0301.gif"/></a>

                                        <br/></td></tr>
                                        <tr>
                                            <td width="100%"><b>Descrição: </b>
                                            ${pub.descricao}</td>
                                        </tr>
                                </tbody></table>
                            </td>
                        </tr>
                </tbody></table>
            </td>
        </tr>
</tbody></table>
<%@include file="rodape.jsp" %>