<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
        <link href="../jq/jquery-ui.min.css" type="text/css" rel="stylesheet"/>
        <link href="../css/main.css" type="text/css" rel="stylesheet"/>
        <link href="../parainfo/a.css" type="text/css" rel="stylesheet"/>
        <link href="../parainfo/form.css" type="text/css" rel="stylesheet"/>

        <script src="../jq/jquery-2.1.4.min.js" type="text/javascript"></script>
        <script src="../jq/jquery-ui.min.js" type="text/javascript"></script>
        <script src="../parainfo/form.js" type="text/javascript"></script>

        <script src="../js/tutoriales.js" type="text/javascript"></script>
    </head>
    <body>
        <form class="parainfo" action="Tutoriales" method="post"
              style="margin: auto;display: table">
            <input type="hidden" name="accion" value="UPD"/>
            <input type="hidden" name="idtutorial" value="${tutoriales.idtutorial}"/>

            <fieldset>
                <legend>Actualizar datos de Tutorial</legend>

                <table class="tabla">
                    <tr>
                        <td><label for="titulo">Tutorial</label></td>
                        <td>
                            <input type="text" name="titulo" maxlength="200" id="titulo"
                                   value="${tutoriales.titulo}" style="width: 300px"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="tipo">Tipo</label></td>
                        <td>
                            <select name="tipo" id="tipo" style="width: 310px">
                                <c:choose>
                                    <c:when test="${tutoriales.tipo eq 'Video'}">
                                        <option value="Separata">Separata</option>
                                        <option value="Video" selected="selected">Video</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="Separata">Separata</option>
                                        <option value="Video">Video</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="precio">Precio&nbsp;S/.</label></td>
                        <td>
                            <input type="text" name="precio" maxlength="6" 
                                   value="${tutoriales.precio}" id="precio" 
                                   style="width: 100px;text-align: right"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <input type="submit" value="Enviar Datos"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>

        <%-- para errores en UPD  --%>
        <c:if test="${!msg.isEmpty()}">
            <ul class="msg_error ui-state-highlight ui-corner-all">
                <c:forEach var="m" items="${msg}"><li>${m}</li>
                    </c:forEach>
            </ul>
        </c:if>

        <p style="text-align: center">
            <a class="parainfo" href="../index.jsp">Cancelar</a>
        </p>
    </body>
</html>
