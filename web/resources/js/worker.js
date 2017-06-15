
$("#smsLinkWorker").click(function () {
    $("#sms").show();
    $("#zyavki").hide();
    $("#klient").hide();

    $.ajax({
        url:"getListJurnal",
        type:"GET",
        data:{'idOrganization' : getUrlVars()["idOrganization"]},
        success: smsListJurnal,
        dataType: "text"
    })
});

$("#zyavkitLinkWorker").click(function () {
    $("#sms").hide();
    $("#zyavki").show();
    $("#klient").hide();

    $.ajax({
        url: "getListZyavki",
        type: "GET",
        data: {'idOrganization' : getUrlVars()["idOrganization"]},
        success: zyavkiList,
        dataType: "text"
    })
});

$("#klientLinkWorker").click(function () {
    $("#sms").hide();
    $("#zyavki").hide();
    $("#klient").show();

    $.ajax({
        url: "getKlientList",
        type: "GET",
        data: {"organization" : $("#Organization").text()},
        success: parseKlientList,
        dataType: "text"
    })

});

$("#addJurnal").click(function () {
    var page = getUrlVars()["idOrganization"];
    $.ajax({
        url:"addJurnalOff",
        type:"GET",
        data: {'address' : $("#city").val() + "_" + $("#street").val() + "_" + $("#home").val(), 'offStart' : $("#start").val(), 'offClose' : $("#close").val(), 'protection' : $("#protection").val(), 'idOrganization' : page},
        success: addJurnalFunction,
        dataType: "text"
    })

})

$(document).on("click", 'tr', function () {
    var atr = $(this).attr("class");
    if(atr == "smska"){
        $("#smsModal").modal("show");
    }
    if(atr == "zyavka"){
        $("#zyavkiModal").modal('show');
    }
    if(atr == "klient"){
        $("#klientModal").modal('show');
    }
})
function addJurnalFunction(data) {
    if(data >= 0 ){
        document.getElementById("addJurnal").setAttribute("class", "btn-success");
    }else{
        document.getElementById("addJurnal").setAttribute("class", "btn-danger");
    }
}

function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}

function zyavkiList(data) {
    if(data.length > 0){
        var list = data.split("|");
        var result = "";
        for(i = 0; i < list.length -1; i++){
            var inList = list[i].split("_");
            result += "<tr class='zyavka'>" +
                "<td>" + inList[0] + "</td>"+
                "<td>" + inList[1] + "</td>" +
                "<td>" + inList[2] + "</td>" +
                "<td>" + inList[3] + "</td>" +
                "</tr>"
        }
        $("#replaceZ").replaceWith(result);
    }
}

$(function () {
    $.ajax({
        url:"getListJurnal",
        type:"GET",
        data:{'idOrganization' : getUrlVars()["idOrganization"]},
        success: smsListJurnal,
        dataType: "text"
    })
    $.ajax({
        url: "getListZyavki",
        type: "GET",
        data: {'idOrganization' : getUrlVars()["idOrganization"]},
        success: zyavkiList,
        dataType: "text"
    })
    $.ajax({
        url: "getKlientList",
        type: "GET",
        data: {"organization" : $("#Organization").text()},
        success: parseKlientList,
        dataType: "text"
    })
})

function smsListJurnal(data){
    if(data.length > 0){
        var list = data.split("|");
        var result = "";
        for(i = 0; i < list.length -1; i++){
            var inList = list[i].split("_");
            result += "<tr class='smska'>" +
                "<td> "+ inList[0] +"</td>" +
                "<td> "+ inList[1] +"</td>" +
                "<td> "+ inList[2] +"</td>" +
                "<td> "+ inList[3] +"</td>" +
                "<td> "+ inList[4] +"</td>" +
                "</tr>";
        }
        $("#replaceC").replaceWith(result);
    }
}

function parseKlientList(data) {
    if(data.length > 0){
        var list = data.split("|");
        var result = "";
        for(i = 0; i < list.length -1; i++){
            var inList = list[i].split("_");
            result += "<tr class='klient'>" +
            "<td>"+ inList[0] +"</td>" +
            "<td>"+ inList[1] +"</td>" +
            "<td>"+ inList[2] +"</td>" +
            "<td>"+ inList[3] +"</td>" +
            "<td>"+ inList[4] +"</td>" +
            "</tr>"
        }
        $("#klientList").replaceWith(result);
    }
}
