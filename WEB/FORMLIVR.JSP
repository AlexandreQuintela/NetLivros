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
                <form name="formlivro" method="POST" onSubmit="return formValidation(this)" action="ServletLivro?cmd=salvar">
            <fieldset>
                <legend>Cadastro Livro</legend>
                <div>
                    <label>ISBN :&nbsp;</label><input type="text" name="isbn" maxlength="13" size="13" value="" />*<br><br>
                    <label>Título :&nbsp;</label><input type="text" name="titulo" maxlength="50" size="50" size="50"  value="" />*<br><br>
                    <label>Edição :&nbsp;</label><input type="text" name="numeroEdicao" maxlength="2" size="2" value="" />*<br><br>
                    <label>Ano :&nbsp;</label><input type="text" name="anoPublicacao" size="4" maxlength="4" value="" />*<br><br>
                    <label>Descrição :&nbsp;</label><input type="text" name="descricao" maxlength="50" size="50" value="" />*<br><br>
                </div>
            </fieldset>
            <input type="submit" value="Enviar" name="btnenvia" />
            <input type="reset" value="Limpar" name="btnlimpa" />
        </form>
  </div>
<%@ include file="rodape.jsp" %>

