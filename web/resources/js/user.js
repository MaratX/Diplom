$("#smsLink").click(function(){
    $("#sms").show();
    $("#requestUser").hide();
    $("#tsj").hide();
});
$("#requestUserLink").click(function(){
    $("#sms").hide();
    $("#requestUser").show();
    $("#tsj").hide();
});


$("#tsjLink").click(function(){
    $("#sms").hide();
    $("#requestUser").hide();
    $("#tsj").show();

    $.ajax({
        url:"getListMyCompany",
        type:"GET",
        data: {'login' : $("#loginPublic").text()},
        success: tsjListPointer,
        dataType: "text"
    })

});

$("#testCompanyName").click(function () {
        $.ajax({
            url:"addCompany",
            type:"GET",
            data: { 'loginA' : $("#companyN").val()},
            success: ordine,
            dataType:"text"
        })
    });
function ordine(data) {
    if(data == "false"){
        document.getElementById("testCompanyName").setAttribute("class", "btn-success");
    }else if(data == "true"){
        document.getElementById("testCompanyName").setAttribute("class", "btn-danger");
    }else {
        document.getElementById("testCompanyName").setAttribute("class", "btn-warning");
    }
}

$("#createCompanyName").click(function () {
    $.ajax({
        url: "addCompany",
        type:"GET",
        data:{'nameOrganization' : $("#companyN").val(), 'nameUser' : $("#loginPublic").text()},
        success: createCompanyFunction,
        dataType:"text"
    })
});
function createCompanyFunction(data) {
    var result = "";
    if(data >= 0) {
        document.getElementById("createCompanyName").setAttribute("class", "btn-success");
    }else {
        document.getElementById("createCompanyName").setAttribute("class", "btn-warning");
    }
    $.ajax({
        url: "getOrganization",
        type: "GET",
        data: {'idOrganization' : data},
        success: myCompanyAddList,
        dataType: "text"
    })
}

function tsjListPointer(data){
    if(data.length > 0) {
        var list = data.split("_");
        var rezult = "";
        for (i = 0; i < list.length - 1; i++) {
            var inputList = list[i].split("|");
            rezult += "<tr ><td>" + inputList[0] +
                "</td><td>" +
                inputList[1] + "</td><td>" +
                inputList[2] + "</td><td>" +
                "<a class='btn btn-danger' href=\"company?nameUser=" + $('#loginPublic').text() + "&idOrganization=" + inputList[0] + "\" " + ">Войти</a>"+
                "</td></tr>;"
        }
        $("#replace").replaceWith(rezult);
    }
}

function role(nameUser, idOrg){
    console.log("role");
    $.ajax({
        url:"company",
        type:"GET",
        data: {'nameUser' : nameUser, 'idOrganization' : idOrg},
        success: roleR,
        dataType: "html"
    })
}
function roleR(data) {
    console.log("roleR");
    $("#htmlR").html(data);
}

function myCompanyAddList(data){
    if(data.length > 0){
        var list = data.split("|");
        var result ="";
        result = "<tr><td>"+ list[0] +"</td><td>"+ list[1] +"</td><td>"+ list[2] +"</td></tr>";
        $("#MyCompany").append(result);
    }
}


// ----------

$("#smsLinkWorker").click(function () {
    $("#sms").show();
    $("#zyavki").hide();
    $("#klient").hide();
});
$("#zyavkiLinkWorker").click(function () {
    $("#sms").hide();
    $("#zyavki").show();
    $("#klient").hide();
});
$("#klientLinkWorker").click(function () {
    $("#sms").hide();
    $("#zyavki").hide();
    $("#klient").show();
});