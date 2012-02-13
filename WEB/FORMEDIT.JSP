        <script type="text/javascript">
            <!--
            function formValidation(form){
                if(notEmpty(form.nomeeditora)){
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
<form name="formeditora" method="POST" onSubmit="return formValidation(this)" action="ServletEditora?cmd=salvar">
            <fieldset>
                <legend>Cadastro de Editoras</legend>
                <div>
                    <label>Nome Editora :&nbsp;</label><input type="text" name="nomeeditora" size="100" maxlength="100" value=""  />*
                    <br>
                </div>
            </fieldset>
            <br>
            <input type="submit" value="Enviar" name="btnenvia" />
            <input type="reset" value="Limpar" name="btnlimpa" />
        </form>
  </div>
<%@ include file="rodape.jsp" %>

