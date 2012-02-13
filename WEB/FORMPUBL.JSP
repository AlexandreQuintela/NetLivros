<script type="text/javascript">
            <!--
            function formValidation(form){
                if(notEmpty(form.isbn) && notEmpty(form.titulo) && notEmpty(form.numeroEdicao) && notEmpty(form.anoPublicacao) && notEmpty(form.descricao)){
                    return true;
                }
                return false;
            }

            function notEmpty(elem){
                var str = elem.value;
                if(str.length == 0){
                    alert("Algum campo obrigatório não foi preenchido! (*)");
                    return false;
                } else {
                    return true;
                }
            }
            //-->
        </script>
<%@ include file="topo.jsp" %>
<%@include file="barraadmin.jsp" %>
  <div id="content">
        <form name="formpublicacao" method="POST" onSubmit="return formValidation(this)" action="ServletPublicacao?cmd=salvar">
            <fieldset>
                <legend>Cadastro de publicações</legend>
                <div>
                    <label>ISBN :&nbsp;</label>
                    <select name="isbn">
                        <c:forEach var="li" items="${listLivro}">
                            <option value="${li.isbn}">${li.isbn} - ${li.titulo}</option>
                        </c:forEach>
                    </select><br>
                    <label>Autor :&nbsp;</label>
                    <select name="idAutor">
                        <c:forEach var="au" items="${listAutor}">
                            <option value="${au.idAutor}">${au.nome}</option>
                        </c:forEach>
                    </select><br>
                    <label>Editora :&nbsp;</label>
                    <select name="idEditora">
                        <c:forEach var="ed" items="${listEditora}">
                            <option value="${ed.idEditora}">${ed.nomeEditora}</option>
                        </c:forEach>
                    </select><br>
                    <label>Categoria :&nbsp;</label>
                    <select name="idCategoria">
                        <c:forEach var="ca" items="${listCategoria}">
                            <option value="${ca.idCategoria}">${ca.categoria}</option>
                        </c:forEach>
                    </select><br>
                    <label>Valor</label>
                    <input type="text" name="preco" value="" /> 00.00 (use ponto)
                </div>
            </fieldset>
            <br>
            <input type="submit" value="Enviar" name="btnenvia" />
            <input type="reset" value="Limpar" name="btnlimpa" />
        </form>
  </div>
<%@ include file="rodape.jsp" %>

