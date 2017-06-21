
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

});

$("#closes").click(function () {
    clear();
})

$("#clos").click(function () {
    clear();
})

$(".clo").click(function () {
    document.getElementById("klientZ").value = "";
    document.getElementById("descriptionZ").value = "";
    document.getElementById("inStatus").value = "";
    document.getElementById("inAnswer").value = "";
    $.ajax({
        url: "getListZyavki",
        type: "GET",
        data: {'idOrganization' : getUrlVars()["idOrganization"]},
        success: zyavkiList,
        dataType: "text"
    })

})

$("#updatejurnal").click(function () {
    $.ajax({
        url: "updatejurnal",
        type: "GET",
        data: {"city": $("#city").val(), "street": $("#street").val(), "home": $("#home").val(),
            "start" : $("#start").val(), "close" : $("#close").val(), "desc" : $("#protection").val(), "idjurnal": document.getElementById("city").name},
        success: pasreUpdateJurnal,
        dataType: "text"
    })
})

$("#updateZyavka").click(function () {
    $.ajax({
        url: "updatezyavka",
        type: "GET",
        data: {"idz" : document.getElementById("klientZ").name, "status" : $("#inStatus").val(),
            "answer" : $("#inAnswer").val(), "worker" : $("#loginPublic").text()},
        success: parseUpdateZ,
        dataType: "text"
    })
})

$("#deleteKlient").click(function () {
    $.ajax({
        url: "deleteklient",
        type: "GET",
        data: {"klient": $("#loginKlientDelete").val(), "nameo" : getUrlVars()["idOrganization"]},
        success: parseKlientD,
        dataType: "text"
    })
    $("tr.klient").remove();
    $.ajax({
        url: "getKlientList",
        type: "GET",
        data: {"organization" : $("#Organization").text()},
        success: parseKlientL,
        dataType: "text"
    })
})

$("#addklient").click(function () {
    $.ajax({
        url: "addklient",
        type: "GET",
        data: {"login": $("#loginKlient").val(), "organization" : getUrlVars()["idOrganization"]},
        success: parseklientAdd,
        datType: "text"
    })
    $("tr.klient").remove();
    $.ajax({
        url: "getKlientList",
        type: "GET",
        data: {"organization" : $("#Organization").text()},
        success: parseKlientL,
        dataType: "text"
    })
})

function parseKlientL(data) {
    if(data.length > 0){
        var list = data.split("|");
        var result = "";
        for(i = 0; i < list.length -1; i++){
            var inList = list[i].split("_");
            result += "<tr class='klient' name='" + inList[0] +
                "'>" +
                "<td>"+ inList[0] +"</td>" +
                "<td>"+ inList[1] +"</td>" +
                "<td>"+ inList[2] +"</td>" +
                "<td>"+ inList[3] +"</td>" +
                "<td>"+ inList[4] +"</td>" +
                "</tr>"
        }
        $("#MyKlient").append(result);
    }
}

function parseklientAdd(data) {
    if(data > 0){
        $("#addklient").attr("class", "btn btn-success");
        $("#loginKlient").val("");
    }
}

function parseKlientD(data) {
    if(data.length > 0){
        if(data > 0){
            $("#deleteKlient").attr("class", "btn btn-success");
        }
    }
}

function parseUpdateZ(data) {
    if(data.length > 0){
        if(data > 0){
            $("#updateZyavka").attr("class", "btn btn-success");
        }
    }
}

function pasreUpdateJurnal(data) {
    if(data.length > 0){
        if(data == "ok"){
            document.getElementById("updatejurnal").class = "btn btn-success";
        }
        if(data == "bad"){
            document.getElementById("updatejurnal").class = "btn btn-danger";
        }
    }
}

$(document).on("click", 'tr', function () {
    var atr = $(this).attr("class");
    if(atr == "smska"){
        $("#smsModal").modal("show");
        var id = $(this).attr("name");
        $.ajax({
            url:"getjurnal",
            type: "GET",
            data: {"idjurnal": id},
            success: parseJurnal,
            dataType: "text"
        })

    }
    if(atr == "zyavka"){
        $("#zyavkiModal").modal('show');
        var idz = $(this).attr("name");
        $.ajax({
            url: "getzyavka",
            type: "GET",
            data: {"idz": idz},
            success: parseZyavka,
            dataType: "text"
        })
    }
    if(atr == "klient"){
        $("#deleteKlientModal").modal('show');
        var idk = $(this).attr("name");
        $.ajax({
            url: "getklient",
            type: "GET",
            data: {"idk" : idk},
            success: parseklient,
            dataType: "text"
        })
    }
});

function parseklient(data) {
    if(data.length > 0){
        var list = data.split("_");
        document.getElementById("loginKlientDelete").value = list[0];
    }
}

function parseZyavka(data) {
    if(data.length > 0){
        var list = data.split("_");
        document.getElementById("klientZ").value = list[1];
        document.getElementById("klientZ").name = list[6]
        document.getElementById("descriptionZ").value = list[0];
        document.getElementById("inStatus").value = list[4];
        document.getElementById("inAnswer").value = list[5];
        document.getElementById("addressZ").value = list[2];
        document.getElementById("phoneZ").value = list[3];

    }
}

function clear() {
    document.getElementById("city").value = "";
    document.getElementById("street").value = "";
    document.getElementById("home").value = "";
    document.getElementById("start").value = "";
    document.getElementById("close").value = "";
    document.getElementById("protection").value = "";
}

function parseJurnal(data) {
    if(data.length > 0){
        var list = data.split("_");
        document.getElementById("city").name = list [0];
        document.getElementById("city").value = list [1];
        document.getElementById("street").value = list [2];
        document.getElementById("home").value = list [3];
        document.getElementById("start").value = list [4];
        document.getElementById("close").value = list [5];
        document.getElementById("protection").value = list [6];
    }
}

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
            var answer = " ";
            if(inList[5] != "null"){
                answer = inList[5];
            }
            result += "<tr class='zyavka'name = '" + inList[0] +
                "'>" +
                "<td>" + inList[0] + "</td>"+
                "<td>" + inList[1] + "</td>" +
                "<td>" + inList[2] + "</td>" +
                "<td>" + inList[6] + "</td>" +
                "<td>" + inList[3] + "</td>" +
                "<td>" + inList[4] + "</td>" +
                "<td>" + answer + "</td>" +
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
            result += "<tr class='smska' name = '" + inList[0] +
                "'>" +
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
            result += "<tr class='klient' name='" + inList[0] +
                "'>" +
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
