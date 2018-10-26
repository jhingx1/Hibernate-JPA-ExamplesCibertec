<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
        <link href="../jq/jquery-ui.min.css" type="text/css" rel="stylesheet"/>
        <link href="../css/main.css" type="text/css" rel="stylesheet"/>
        <link href="../parainfo/table.css" type="text/css" rel="stylesheet"/>
        <link href="../parainfo/message.css" rel="stylesheet" type="text/css"/>

        <script src="../jq/jquery-2.1.4.min.js" type="text/javascript"></script>
        <script src="../jq/jquery-ui.min.js" type="text/javascript"></script>
        <script src="../parainfo/table.js" type="text/javascript"></script>
        <script src="../parainfo/message.js" type="text/javascript"></script>

        <script src="../js/tutoriales.js" type="text/javascript"></script>
    </head>
    <body>
        <fmt:setLocale value="en_US"/>
        <table class="parainfo" style="margin: auto;width: 480px">
            <thead>
                <tr>
                    <th class="crud">
                        <a class="ins" href="tutorialesIns.jsp"
                           title="Nuevo Registro"><span></span></a>
                    </th>
                    <td>Título</td>
                    <td>Precio&nbsp;S/.</td>
                    <td>Tipo</td>
                    <th class="crud">
                        <a class="del" href="#" onclick="tutorialesDel();"
                           title="Retirar Registros"><span></span></a>
                    </th>
                    <th class="crud">
                        <a class="upd" href="#" onclick="tutorialesUpd();"
                           title="Actualizar Registro"><span></span></a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="t" items="${list}">
                    <tr>
                        <td colspan="2">${t.titulo}</td>
                        <td style="text-align: center">
                            <fmt:formatNumber type="number" pattern="#,##0.00"
                                              value="${t.precio}"/>
                        </td>
                        <td>${t.tipo}</td>
                        <th>
                            <input type="checkbox" name="idtutorial_del" 
                                   value="${t.idtutorial}"/>
                        </th>
                        <th>
                            <input type="radio" name="idtutorial_upd" 
                                   value="${t.idtutorial}"/>
                        </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <%-- mensajes del servidor --%>
        <c:if test="${!msg.isEmpty()}">
            <ul class="msg_error ui-state-highlight ui-corner-all">
                <c:forEach var="m" items="${msg}"><li>${m}</li>
                    </c:forEach>
            </ul>
        </c:if>

        <%-- mensajes lado del cliente --%>
        <div style="display: none">
            <div id="dlg_message"><p id="message"></p></div>
        </div>
    </body>
</html>

