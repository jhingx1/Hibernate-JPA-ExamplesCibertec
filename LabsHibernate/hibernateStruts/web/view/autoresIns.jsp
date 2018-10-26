<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
        <link href="jq/jquery-ui.min.css" type="text/css" rel="stylesheet"/>
        <link href="css/main.css" type="text/css" rel="stylesheet"/>
        <link href="parainfo/a.css" type="text/css" rel="stylesheet"/>
        <link href="parainfo/form.css" type="text/css" rel="stylesheet"/>

        <script src="jq/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="jq/jquery-ui.min.js" type="text/javascript"></script>
        <script src="parainfo/form.js" type="text/javascript"></script>

        <script src="js/autores.js" type="text/javascript"></script>
    </head>
    <body>
        <s:form action="autoresIns" theme="simple" method="post" 
                cssStyle="margin: auto;display: table" cssClass="parainfo">

            <fieldset>
                <legend>Nuevo Autor</legend>

                <table class="tabla">
                    <tr>
                        <td>Autor</td>
                        <td>
                            <s:textfield name="autores.autor" 
                                         maxlength="200" 
                                         cssStyle="width:300px"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <s:submit value="Enviar Datos"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </s:form>

        <%-- para errores en INS --%>
        <div class="msg_error ui-state-highlight ui-corner-all">
            ${msg} <%-- para errores por DAO --%>

            <ul> <%-- para errores por validacion --%>
                <s:if test="fieldErrors.get('autores.autor').size() > 0">
                    <li><s:property value="fieldErrors.get('autores.autor').get(0)" /></li>
                </s:if>
            </ul>
        </div>

        <p style="text-align: center">
            <a class="parainfo" href="autoresQry">Cancelar</a>
        </p>
    </body>
</html>
