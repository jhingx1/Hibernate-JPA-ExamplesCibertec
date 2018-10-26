$(function () {
    if ($.trim($(".msg_error").text()) !== "") {
        $(".msg_error").css("visibility", "visible");
    }
});

function autoresIns() {
    window.location = "faces/autoresIns.xhtml";
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
                    $("#form_del\\:ids").val(ids.toString());
                    $("#form_del\\:autoresDel").click();
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
        $("#form_get\\:idautor").val(id);
        $("#form_get\\:autoresGet").click();
    }
}


