$(function () {
    if ($.trim($(".msg_error").text()) !== "") {
        $(".msg_error").css("visibility", "visible");
    }
});

function autoresQry() {
    window.location = "faces/autoresQry.xhtml";
}

function frasesIns() {
    window.location = "faces/frasesIns.xhtml";
}

function frasesDel() {
    var ids = [];

    $("input[name='idfrase_del']:checked").each(function () {
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
                    $("#form_del\\:frasesDel").click();
                }
            }
        });
    }
}

function frasesUpd() {
    var id = $("input[name='idfrase_upd']:checked").val();

    if (isNaN(id)) {
        message("Advertencia", "Seleccione Fila para Actualizar Datos");
    } else {
        $("#form_get\\:idfrase").val(id);
        $("#form_get\\:frasesGet").click();
    }
}


