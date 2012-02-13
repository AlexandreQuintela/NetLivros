        <script type="text/javascript">
            <!--
            function formValidation(form){
                if(notEmpty(form.nome) && notEmpty(form.endereco) && notEmpty(form.tefefone)){
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
        <form name="formcliente" method="POST" onSubmit="return formValidation(this)" action="ServletCliente?cmd=salvar">
            <fieldset>
                <legend>Cadastro de Clientes</legend>
                <div>
                    <label>Nome :&nbsp;</label><input type="text" name="nome" size="50" maxlength="50" value="" />*<br><br>
                    <label>Endereço :&nbsp;</label><input type="text" name="endereco" size="50" maxlength="50" value="" />*<br><br>
                    <label>Telefone :&nbsp;</label><input type="text" name="telefone" size="50" maxlength="50" value=""  />*<br><br>
                    <label>Estado civil :&nbsp;</label>
                    <select name="estado" >
                        <option>Solteiro(a)</option>
                        <option>Casado(a)</option>
                        <option>Separado(a)</option>
                        <option>Divorciado(a)</option>
                        <option>Viúvo(a)</option>
                        <option>União estável</option>
                    </select>
                    <label>Email</label><input type="text" name="email" size="50" maxlength="50" value="" /><br><br>
                    <label>Senha</label><input type="password" name="senha" size="10" maxlength="10" value="" /><br><br>
                </div>
            </fieldset><br>
            <input type="submit" value="Enviar" name="btnenvia" />
            <input type="reset" value="Limpar" name="btnlimpa" />
        </form>
  </div>
<%@ include file="rodape.jsp" %>

