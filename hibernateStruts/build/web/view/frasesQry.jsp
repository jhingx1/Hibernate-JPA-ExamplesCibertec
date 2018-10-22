<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
        <link href="jq/jquery-ui.min.css" type="text/css" rel="stylesheet"/>
        <link href="css/main.css" type="text/css" rel="stylesheet"/>
        <link href="parainfo/table.css" type="text/css" rel="stylesheet"/>
        <link href="parainfo/message.css" rel="stylesheet" type="text/css"/>

        <script src="jq/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="jq/jquery-ui.min.js" type="text/javascript"></script>
        <script src="parainfo/table.js" type="text/javascript"></script>
        <script src="parainfo/message.js" type="text/javascript"></script>

        <script src="js/frases.js" type="text/javascript"></script>
    </head>
    <body>
        <table class="parainfo" style="margin: auto;width: 600px">
            <thead>
                <tr>
                    <th class="crud">
                        <a class="qry" href="#" onclick="autoresQry();"
                           title="Lista de Autores"><span></span></a>
                    </th>
                    <td>Autor</td>
                    <td>Frase</td>
                    <th class="crud">
                        <a class="ins" href="#" onclick="frasesIns();"
                           title="Nuevo Registro"><span></span></a>
                    </th>
                    <th class="crud">
                        <a class="del" href="#" onclick="frasesDel();"
                           title="Retirar Registros"><span></span></a>
                    </th>
                    <th class="crud">
                        <a class="upd" href="#" onclick="frasesUpd();"
                           title="Actualizar Registro"><span></span></a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="list" var="r">
                    <tr>
                        <td colspan="2"><s:property value="#r[1]"/></td>
                        <td colspan="2"><s:property value="#r[2]"/></td>
                        <th>
                            <input type="checkbox" name="idfrase_del" 
                                   value="${r[0]}"/>
                        </th>
                        <th>
                            <input type="radio" name="idfrase_upd" 
                                   value="${r[0]}"/>
                        </th>
                    </tr>
                </s:iterator>
            </tbody>
        </table>

        <%-- mensajes del servidor --%>
        <h3 class="msg_error ui-state-highlight ui-corner-all">${msg}</h3>

        <%-- mensajes lado del cliente --%>
        <div style="display: none">
            <div id="dlg_message"><p id="message"></p></div>
        </div>
    </body>
</html>

