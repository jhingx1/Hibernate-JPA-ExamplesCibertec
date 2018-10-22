$(function () {
    if ($.trim($(".msg_error").text()) !== "") {
        $(".msg_error").css("visibility", "visible");
    }
});

function autoresIns() {
    window.location = "autoresInsForm";
}

function autoresDel() {
    var ids = [];

    $("input[name='idautor_del']:checked").each(function () {
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
                    window.location = "autoresDel?ids=" + ids.toString();
                }
            }
        });
    }
}

function autoresUpd() {
    var id = $("input[name='idautor_upd']:checked").val();

    if (isNaN(id)) {
        message("Advertencia", "Seleccione Fila para Actualizar Datos");
    } else {
        window.location = "autoresGet?idautor=" + id;
    }
}
