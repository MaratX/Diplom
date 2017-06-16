
$("#workerLink").click(function (){
    $("#coworker").show();
    $("#report").hide();
    $("#settingsCompany").hide();

});

$("#reportLink").click(function (){
    $("#coworker").hide();
    $("#report").show();
    $("#settingsCompany").hide();
});

$("#Organization").click(function () {
    $("#coworker").hide();
    $("#report").hide();
    $("#settingsCompany").show();
});

$("#updateWorker").click(function () {
    var idUser = document.getElementById("loginWork").name;
    var idOrg = $("#Organization").text();
    $.ajax({
        url: "updateworker",
        type: "GET",
        data:{"idUser": idUser, "idOrg" : getUrlVars()["idOrganization"], "role" : $("#roleWork").val()},
        success: parseWorkerUpdate,
        dataType: "text"
    })
})

$("#delWorker").click(function () {
    $.ajax({
        url:"deleteworker",
        type: "GET",
        data: {"idU": document.getElementById("loginWork").name, "idO" : getUrlVars()["idOrganization"]},
        success: parseDeleteWorker,
        dataType: "text"
    })
})

$("#addWorker").click(function () {
    $.ajax({
        url: "addworker",
        type: "GET",
        data: {"login" : $("#loginWorker").val(), "role" : $("#roleWorker").val(), "loginO": getUrlVars()["idOrganization"]},
        success: parseaddworker,
        dataType: "text"
    })
})

$("#Uaddress").click(function () {
    $.ajax({
        url:"updateAdresU",
        type: "GET",
        data:{"city": $("#cityU").val(), "street": $("#streetU").val(), "home": $("#homeU").val(), "apart": $("#ofisU").val(), "idOrg" : getUrlVars()["idOrganization"]},
        success: parseAdresU,
        datType: "text"
    })
})
$("#Faddress").click(function () {
    $.ajax({
        url:"updateAdresF",
        type: "GET",
        data:{"city": $("#cityF").val(), "street": $("#streetF").val(), "home": $("#homeF").val(), "apart": $("#ofisF").val(), "idOrg" : getUrlVars()["idOrganization"]},
        success: parseAdresF,
        datType: "text"
    })
})

function parseAdresF(data) {
    if(data > 0){
        document.getElementById("Faddress").setAttribute("class", "btn btn-success");
    }
}

function parseAdresU(data) {
    if(data > 0){
        document.getElementById("Uaddress").setAttribute("class", "btn btn-success");
    }
}

function parseaddworker(data) {
    if(data > 0){
        document.getElementById("addWorker").setAttribute("class", "btn btn-success");
    }
}

function parseDeleteWorker(data) {
    if(data > 0){
        document.getElementById("delWorker").setAttribute("class", "btn btn-success");
    }
}

function parseWorkerUpdate(data) {
    if(data > 0){
        document.getElementById("updateWorker").setAttribute("class", "btn btn-success");
    }
}

$(function () {
    $.ajax({
        url: "getListWorker",
        type: "GET",
        data: {"organization" : $("#Organization").text()},
        success: parseListWorker,
        dataType: "text"
    })
    $.ajax({
        url:"getAdressUir",
        type:"GET",
        data:{"idOrg" : getUrlVars()["idOrganization"]},
        success: parseURaddress,
        dataType: "text"
    })
    $.ajax({
        url:"getAdressF",
        data:{"idOrg" : getUrlVars()["idOrganization"]},
        success: parseFaddress,
        dataType: "text"
    })
})

function parseFaddress(data) {
    if(data.length > 0){
        var list = data.split("_");
        if(list[0] != "null"){
            document.getElementById("cityF").value = list[0];
        }
        if(list[1] != "null"){
            document.getElementById("streetF").value = list[1];
        }
        if(list[2] != "null"){
            document.getElementById("homeF").value = list[2];
        }
        if(list[3] != "null"){
            document.getElementById("ofisF").value = list[3];
        }
    }
}

function parseURaddress(data) {
    if(data.length > 0){
        var list = data.split("_");
        if(list[0] != "null"){
            document.getElementById("cityU").value = list[0];
        }
        if(list[1] != "null"){
            document.getElementById("streetU").value = list[1];
        }
        if(list[2] != "null"){
            document.getElementById("homeU").value = list[2];
        }
        if(list[3] != "null"){
            document.getElementById("ofisU").value = list[3];
        }
    }
}


$(document).on("click", 'tr', function () {
    var atr = $(this).attr("class");
    if(atr == "worker"){
        $("#workerModal").modal("show");
        var id = $(this).attr("name");
        $.ajax({
            url:"getworker",
            type: "GET",
            data: {"idworker": id, "organization" : getUrlVars()["idOrganization"]},
            success: parseworker,
            dataType: "text"
        })
    }
})

function parseworker(data) {
    if(data.length > 0){
        var list = data.split("_");
        $("#loginWork").val(list[1]);
        document.getElementById("loginWork").name = list[0];
        $("#fioWork").val(list[2]);
        $("#roleWork").val(list[3]);
    }
}

function parseListWorker(data) {
    if(data.length > 0){
        var list = data.split("|");
        var result = "";
        for(i = 0; i < list.length - 1; i++){
            var inList = list[i].split("_");
            result += "<tr class='worker' name='" + inList[0] +
                "'>" +
                "<td>"+ inList[0] +"</td>" +
                "<td>"+ inList[1] +"</td>" +
                "<td>"+ inList[2] +"</td>" +
                "<td>"+ inList[3] +"</td>" +
                "<td>"+ inList[4] +"</td>" +
                "<td>"+ inList[5] +"</td>" +
                "</tr>"
        }
        $("#workerList").replaceWith(result);
    }
}

function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}