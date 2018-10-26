function tutorialesIns() {
    window.location = "tutorialesIns.jsp";
}

function tutorialesDel() {
    var ids = [];

    $("input[name='idtutorial_del']:checked").each(function () {
        ids.push($(this).val());
    });

    if (ids.length === 0) {
        message("Advertencia", "Seleccione fila(s) a Retirar");
    } else {
        $("#message").html("¿Retirar registro(s)?");
        $("#dlg_message").dialog({
            modal: true,
            title: "Advertencia",
            width: 340,
            buttons: {
                "No": function () {
                    $(this).dialog("close");
                },
                "Si": function () {
                    $(this).dialog("close");
                    window.location = "Tutoriales?accion=DEL&ids=" + ids.toString();
                }
            }
        });
    }
}

function tutorialesUpd() {
    var id = $("input[name='idtutorial_upd']:checked").val();

    if (isNaN(id)) {
        message("Advertencia", "Seleccione Fila para Actualizar Datos");
    } else {
        window.location = "Tutoriales?accion=GET&idtutorial=" + id;
    }
}
