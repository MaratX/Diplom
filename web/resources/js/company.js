
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
    var city = $("#cityU").val();
    if(city == ""){
        city = document.getElementById("cityU").getAttribute("placeholder");
    }
    var street = $("#streetU").val();
    if(street == ""){
        street = document.getElementById("streetU").getAttribute("placeholder");
    }
    var home = $("#homeU").val();
    if(home == ""){
        home = document.getElementById("homeU").getAttribute("placeholder");
    }
    var ofis = $("#ofisU").val();
    if(ofis == ""){
        ofis = document.getElementById("ofisU").getAttribute("placeholder");
    }
    $.ajax({
        url:"updateAdresU",
        type: "GET",
        data:{"city": city, "street": street, "home": home, "apart": ofis, "idOrg" : getUrlVars()["idOrganization"]},
        success: parseAdresU,
        datType: "text"
    })
})

$("#Faddress").click(function () {
    var city = $("#cityF").val();
    if(city == ""){
        city = document.getElementById("cityF").getAttribute("placeholder");
    }
    var street = $("#streetF").val();
    if(street == ""){
        street = document.getElementById("streetF").getAttribute("placeholder");
    }
    var home = $("#homeF").val();
    if(home == ""){
        home = document.getElementById("homeF").getAttribute("placeholder");
    }
    var ofis = $("#ofisF").val();
    if(ofis == ""){
        ofis = document.getElementById("ofisF").getAttribute("placeholder");
    }
    $.ajax({
        url:"updateAdresF",
        type: "GET",
        data:{"city": city, "street": street, "home": home, "apart": ofis, "idOrg" : getUrlVars()["idOrganization"]},
        success: parseAdresF,
        datType: "text"
    })
})

$("#periodButton").click(function () {
    $("tr.report").remove();
    $("#workers").append("<tr class='report'><td></td></tr>");
    $.ajax({
        url:"ReportData",
        type: "GET",
        data:{"idOrg" : getUrlVars()["idOrganization"], "start" : $("#startReport").val(), "close" : $("#closeReport").val()},
        success: reportDateWorker,
        dataType: "text"
    })
})

$("#periodKlientButton").click(function () {
    $("tr.reportKlient").remove();
    $("#klientReportBody").append("<tr class='reportKlient'><td></td></tr>")
    $.ajax({
        url:"reportDateKlient",
        type: "GET",
        data:{"idOrg" : getUrlVars()["idOrganization"], "start" : $("#startReportKlient").val(), "close" : $("#closeReportKlient").val()},
        success: reportDateKlient,
        dataType: "text"
    })
})

function reportDateKlient(data) {
    if(data.length > 0){
        var list = data.split("|");
        var result = "";
        for(i = 0; i < list.length -1; i++){
            var inList = list[i].split("_");
            result += "<tr class='klientReport'>" +
                "<td> "+ (1 + i) +"</td>" +
                "<td> "+ inList[0] +"</td>" +
                "<td> "+ inList[1] +"</td>" +
                "<td> "+ inList[2] +"</td>" +
                "<td> "+ inList[3] +"</td>" +
                "</tr>"
        }
        $(".klientReport").replaceWith(result);
    }
}

function reportDateWorker(data) {
    if(data.length > 0){
        var list = data.split("|");
        var result = "";
        for(i = 0; i < list.length -1; i++){
            var inList = list[i].split("_");
            result += "<tr class='report'>" +
                "<td> "+ (1 + i) +"</td>" +
                "<td> "+ inList[0] +"</td>" +
                "<td> "+ inList[1] +"</td>" +
                "<td> "+ inList[2] +"</td>" +
                "<td> "+ inList[3] +"</td>" +
                "</tr>"
        }
        $(".report").replaceWith(result);
    }
}

function parseAdresF(data) {
    if(data > 0){
        document.getElementById("cityF").placeholder = $("#cityF").val();
        document.getElementById("streetF").placeholder = $("#streetF").val();
        document.getElementById("homeF").placeholder = $("#homeF").val();
        document.getElementById("ofisF").placeholder = $("#ofisF").val();
        document.getElementById("cityF").value = "";
        document.getElementById("streetF").value = "";
        document.getElementById("homeF").value = "";
        document.getElementById("ofisF").value = "";
    }
}

function parseAdresU(data) {
    if(data > 0){
        document.getElementById("cityU").placeholder = $("#cityU").val();
        document.getElementById("streetU").placeholder = $("#streetU").val();
        document.getElementById("homeU").placeholder = $("#homeU").val();
        document.getElementById("ofisU").placeholder = $("#ofisU").val();
        document.getElementById("cityU").value = "";
        document.getElementById("streetU").value = "";
        document.getElementById("homeU").value = "";
        document.getElementById("ofisU").value = "";
    }
}

function parseaddworker(data) {
    if(data > 0){
        document.getElementById("addWorker").setAttribute("class", "btn btn-success");
        $("tr.workerList").remove();
        $.ajax({
            url: "getListWorker",
            type: "GET",
            data: {"organization" : $("#Organization").text()},
            success: getWorker,
            dataType: "text"
        })
    }
}

function getWorker(data) {
    if(data.length > 0){
        var list = data.split("|");
        var result = "";
        for(i = 0; i < list.length - 1; i++){
            var inList = list[i].split("_");
            result += "<tr class='workerList' name='" + inList[0] +
                "'>" +
                "<td>"+ inList[0] +"</td>" +
                "<td>"+ inList[1] +"</td>" +
                "<td>"+ inList[2] +"</td>" +
                "<td>"+ inList[3] +"</td>" +
                "<td>"+ inList[4] +"</td>" +
                "<td>"+ inList[5] +"</td>" +
                "</tr>"
        }
        $("#MyWorker").append(result);
    }
}

function parseDeleteWorker(data) {
    if(data > 0){
        document.getElementById("delWorker").setAttribute("class", "btn btn-success");
        $("tr[name= "+ document.getElementById("loginWork").name +"]").remove();
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
        type: "GET",
        data:{"idOrg" : getUrlVars()["idOrganization"]},
        success: parseFaddress,
        dataType: "text"
    })
    $.ajax({
        url: "reportWorker",
        type: "GET",
        data: {"idOrg" : getUrlVars()["idOrganization"]},
        success: parseReportWorker,
        dataType: "text"
    })
    $.ajax({
        url:"reportKlient",
        type: "GET",
        data: {"idOrg" : getUrlVars()["idOrganization"]},
        success: parseReportKlient,
        dataType: "text"
    })
})

function parseReportKlient(data) {
    if(data.length > 0){
        var list = data.split("|");
        var result = "";
        for(i = 0; i < list.length -1; i++){
            var inList = list[i].split("_");
            result += "<tr class='klientReport'>" +
                "<td> "+ (1 + i) +"</td>" +
                "<td> "+ inList[0] +"</td>" +
                "<td> "+ inList[1] +"</td>" +
                "<td> "+ inList[2] +"</td>" +
                "<td> "+ inList[3] +"</td>" +
                "</tr>"
        }
        $("#klientReport").replaceWith(result);
    }
}

function parseReportWorker(data) {
    if(data.length > 0){
        var list = data.split("|");
        var result = "";
        for(i = 0; i < list.length -1; i++){
            var inList = list[i].split("_");
            result += "<tr class='report'>" +
                "<td> "+ (1 + i) +"</td>" +
                "<td> "+ inList[0] +"</td>" +
                "<td> "+ inList[1] +"</td>" +
                "<td> "+ inList[2] +"</td>" +
                "<td> "+ inList[3] +"</td>" +
                "</tr>"
        }
        $("#reportWorkerList").replaceWith(result);
    }
}

function parseFaddress(data) {
    if(data.length > 0){
        var list = data.split("_");
        if(list[0] != "null"){
            document.getElementById("cityF").placeholder = list[0];
        }
        if(list[1] != "null"){
            document.getElementById("streetF").placeholder = list[1];
        }
        if(list[2] != "null"){
            document.getElementById("homeF").placeholder = list[2];
        }
        if(list[3] != "null"){
            document.getElementById("ofisF").placeholder = list[3];
        }
    }
}

function parseURaddress(data) {
    if(data.length > 0){
        var list = data.split("_");
        if(list[0] != "null"){
            document.getElementById("cityU").placeholder = list[0];
        }
        if(list[1] != "null"){
            document.getElementById("streetU").placeholder = list[1];
        }
        if(list[2] != "null"){
            document.getElementById("homeU").placeholder = list[2];
        }
        if(list[3] != "null"){
            document.getElementById("ofisU").placeholder = list[3];
        }
    }
}


$(document).on("click", 'tr', function () {
    var atr = $(this).attr("class");
    if(atr == "workerList"){
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
            result += "<tr class='workerList' name='" + inList[0] +
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