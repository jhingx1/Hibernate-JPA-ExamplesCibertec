$(function () {
    if ($.trim($(".msg_error").text()) !== "") {
        $(".msg_error").css("visibility", "visible");
    }
});

function examenesQry() {
    window.location = "faces/examenesQry.xhtml";
}


function preguntasIns() {
    window.location = "faces/preguntasIns.xhtml";
}

function preguntasDel() {
    var ids = [];

    $("input[name='idpregunta_del']:checked").each(function () {
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
                    $("#form_del\\:preguntasDel").click();
                }
            }
        });
    }
}

function preguntasUpd() {
    var id = $("input[name='idpregunta_upd']:checked").val();

    if (isNaN(id)) {
        message("Advertencia", "Seleccione Fila para Actualizar Datos");
    } else {
        $("#form_get\\:idpregunta").val(id);
        $("#form_get\\:preguntasGet").click();
    }
}


