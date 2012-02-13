        <script type="text/javascript">
            <!--
            function formValidation(form){
                if(notEmpty(form.nome) && notEmpty(form.email) && notEmpty(form.dataNascimento)){
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
        <form name="formautor" method="POST" onSubmit="return formValidation(this)" action="ServletAutor?cmd=salvar">
            <fieldset>
                <legend>Cadastro do Autor</legend>
                <div>
                    <label for="nome">Nome :</label>
                    <input type="text" id="nome" name="nome" maxlength="100" size="100"  value="" />*<br><br>
                    <label for="email">Email :</label>
                    <input type="text" id="email" name="email" maxlength="100" size="100" value="" />*<br><br>
                    <label for="datanascimento">Data Nascimento :</label>
                    <input type="text" id="dataNascimento" name="dataNascimento" maxlength="10" size="10" value="" />*(dd/mm/aaaa)<br><br>
                </div>
            </fieldset>
            <br>
            <input type="submit" value="Enviar" name="btnenvia" />
            <input type="reset" value="Limpar" name="btnlimpa" />
        </form>
  </div>
<%@ include file="rodape.jsp" %>

