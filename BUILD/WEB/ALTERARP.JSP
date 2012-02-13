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
    <form name="alterarpublicacao" method="POST" onSubmit="return formValidation(this)" action="ServletPublicacao?cmd=salvaralteracao">
        <fieldset>
            <legend>Alteração de publicações</legend>
            <div>
                <label>ISBN :&nbsp;</label>
                <select name="isbn">
                    <c:forEach var="li" items="${listLivro}">
                        <option value="${li.isbn}"<c:if test="${pub.isbn == li.isbn}">selected="true"</c:if>>${li.titulo}</option>
                    </c:forEach>
                </select><br>
                <label>Autor :&nbsp;</label>
                <select name="idAutor">
                    <c:forEach var="au" items="${listAutor}">
                        <option value="${au.idAutor}"<c:if test="${pub.idAutor == au.idAutor}"> selected="true"</c:if>>${au.nome}</option>
                    </c:forEach>
                </select><br>
                <label>Editora :&nbsp;</label>
                <select name="idEditora">
                    <c:forEach var="ed" items="${listEditora}">
                        <option value="${ed.idEditora}"<c:if test="${pub.idEditora == ed.idEditora}"> selected="true"</c:if>>${ed.nomeEditora}</option>
                    </c:forEach>
                </select><br>
                <label>Categoria : </label>
                <select name="idCategoria">
                    <c:forEach var="ca" items="${listCategoria}">
                        <option value="${ca.idCategoria}"<c:if test="${pub.idCategoria == ca.idCategoria}"> selected="true"</c:if>>${ca.categoria}</option>
                    </c:forEach>
                </select><br>
                <label>Valor</label>
                <input type="text" name="preco" value="${pub.preco}" /> 00.00 (use ponto)
            </div>
        </fieldset>
        <br>
        <input type="submit" value="Enviar" name="btnenvia" />
        <input type="reset" value="Limpar" name="btnlimpa" />
    </form>
</div>
<<%@include file="rodape.jsp" %>
