        <script type="text/javascript">
            <!--
            function formValidation(form){
                if(notEmpty(form.usuario) && notEmpty(form.senha)){
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
            <form name="formusuario" method="POST" onSubmit="return formValidation(this)" action="user?cmd=salvar">
            <fieldset>
                <legend>Cadastro de Usuário do Sistema</legend>
                <div>
                    <label>Nome :&nbsp;</label><input type="text" name="usuario" size="50" maxlength="50" value="" />*<br><br>
                    <label>Senha :&nbsp;</label><input type="text" name="senha" size="50" maxlength="50" value="" />*<br><br>
                </div>
            </fieldset>
            <br>
        <input type="submit" value="Enviar" name="btnenvia" />
        <input type="reset" value="Limpar" name="btnlimpa" />
        </form>
  </div>
<%@ include file="rodape.jsp" %>