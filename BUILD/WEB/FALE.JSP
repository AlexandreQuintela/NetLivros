<%@include file="topo.jsp" %>
<div id="content"><form name="FaleConosco" action="mailto:contato@netlivros.com.br"  method="post" enctype="text/plain" id="myform">
        <fieldset>
            <p>Fale Conosco</p><br>
            <b> <label for="nome2" class="falelabel">Nome:&nbsp;</label>
                <input name="Nome" id="nome2" type="text" maxlength="30" /><br />
                <label for="email" class="falelabel">*E-mail:&nbsp;</label>
                <input name="Email" id="email" type="text"  maxlength="50" /><br />
                <label for="subject" class="falelabel">Assunto:&nbsp;</label>
                <select name="Assunto" id="assunto">
                    <option value="alterar_dados" selected="selected">Altera��o de dados cadastrais</option>
                    <option value="inform_pedido">Informa��es sobre o pedido</option>
                    <option value="inform_livros">Informa��es sobre livros</option>
                    <option value="inform_pagam">Informa��es sobre pagamento</option>
                    <option value="problem_compra">Problemas durante a compra</option>
                    <option value="solicit_cancel">Solicita��o de canc. de compra</option>
                    <option value="trocas_devolucoes">Trocas e devolu��es</option>
                    <option value="coment_diversos">Coment�rios diversos</option>
                    <option value="outros_assuntos">Outros assuntos</option>
                </select>
                <!--<input id="subject"  type="text"  maxlength="200" />--><br />
                <label for="mensagem" class="labelfale">*Coment&aacute;rios:&nbsp;</label>
                <textarea name="Comentario" id="mensagem" cols="25" rows="7"></textarea><br />
            </b>
            <span class="nota" id="falenota">* Campos de preenchimento obrigat&oacute;rio</span>
            <span id="falebotoes">
            <input alt="" type="submit" value="Enviar" class="botao" />
            <input alt="" type="reset" value="Cancelar" class="botao2" />
            </span>
        </fieldset>
    </form>
</div>
<%@include file="rodape.jsp" %>