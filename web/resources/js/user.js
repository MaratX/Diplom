$("#smsLink").click(function(){
    $("#sms").show();
    $("#requestUser").hide();
    $("#tsj").hide();
    $("#settings").hide();

    $.ajax({
        url: "getUserListJurnalOff",
        type: "GET",
        data: {"login" : $("#loginPublic").text()},
        success: parseListJurnalOff,
        dataType: "text"
    })

});
$("#requestUserLink").click(function(){
    $("#sms").hide();
    $("#requestUser").show();
    $("#tsj").hide();
    $("#settings").hide();

    $.ajax({
        url: "getListUserProposal",
        type: "GET",
        data: {"login": $("#loginPublic").text()},
        success: parseListPropasal,
        dataType: "text"
    })
});
$("#zayavkaBotton").click(function () {
    $.ajax({
        url:"getNameOrganization",
        type:"GET",
        data:{"login" : $("#loginPublic").text()},
        success: parseListNameOrg,
        dataType: "text"
    })
});
$("#tsjLink").click(function(){
    $("#sms").hide();
    $("#requestUser").hide();
    $("#tsj").show();
    $("#settings").hide();

    $.ajax({
        url:"getListMyCompany",
        type:"GET",
        data: {'login' : $("#loginPublic").text()},
        success: tsjListPointer,
        dataType: "text"
    })

});
$("#loginPublic").click(function () {
    $("#sms").hide();
    $("#requestUser").hide();
    $("#tsj").hide();
    $("#settings").show();
})
$("#testCompanyName").click(function () {
        $.ajax({
            url:"addCompany",
            type:"GET",
            data: { 'loginA' : $("#companyN").val()},
            success: ordine,
            dataType:"text"
        })
    });
$("#createCompanyName").click(function () {
    $.ajax({
        url: "addCompany",
        type:"GET",
        data:{'nameOrganization' : $("#companyN").val(), 'nameUser' : $("#loginPublic").text()},
        success: createCompanyFunction,
        dataType:"text"
    })
});
$("#addZyavka").click(function () {
    $.ajax({
        url: "addProposal",
        type: "GET",
        data: {"option" : $("#sel1 :selected").text(),
            "user" : $("#loginPublic").text(), "description" : $("#comment").val()},
        success: parseZyavka,
        dataType: "text"
    })
})
$("#fio").click(function () {
    $.ajax({
        url:"addfio",
        type:"GET",
        data:{"login" : $("#loginPublic").text(), "name" : $("#nameUser").val(), "lastName" : $("#lastNameUser").val()},
        success: parseAddFio,
        dataType: "text"
    })
})
$("#phoneBotton").click(function () {
    $.ajax({
        url:"addPhone",
        type: "GET",
        data:{"login":$("#loginPublic").text(), "phone" : $("#phone").val()},
        success: parsePhone,
        dataType: "text"
    })
})
$("#adressUser").click(function () {
    var city = $("#city").val();
    if(city == ""){
        city = document.getElementById("city").getAttribute("placeholder");
    }
    var street = $("#street").val();
    if(street == ""){
        street = document.getElementById("street").getAttribute("placeholder");
    }
    var home = $("#home").val();
    if(home == ""){
        home = document.getElementById("home").getAttribute("placeholder");
    }
    var apart = $("#apart").val();
    if(apart == ""){
        apart = document.getElementById("apart").getAttribute("placeholder");
    }
    $.ajax({
        url: "addaddress",
        type:"GET",
        data: {"login" : $("#loginPublic").text(),"city" : city, "street" : street, "home": home, "apart" : apart},
        success: parseAdressS,
        dataType: "text"
    })

})
$("#pass").click(function () {
    var pass = $("#password").val();
    if(pass != ""){
        $.ajax({
            url:"updatePass",
            type:"GET",
            data:{"login" : $("#loginPublic").text(), "pass" : pass},
            success: parsePass,
            dataType: "text"
        })
    }
})
function parsePass(data) {
    if(data.length > 0){
        document.getElementById("password").value = "";
        document.getElementById("password").placeholder = "обнавлено";
    }
}
function parseAdressS(data) {
    if(data.length > 0){
        document.getElementById("city").value = "";
        document.getElementById("street").value = "";
        document.getElementById("home").value = "";
        document.getElementById("apart").value = "";
    }
    $.ajax({
        url:"getAddress",
        type:"GET",
        data:{"login" : $("#loginPublic").text()},
        success: parseAddress,
        dataType:"text"
    })

}
function parsePhone(data) {
    if(data.length > 0){
        document.getElementById("phone").value = "";
    }
    $.ajax({
        url:"getfio",
        type:"GET",
        data:{"login" : $("#loginPublic").text()},
        success: parsefio,
        dataType: "text"
    })
}
function parseAddFio(data) {
    if(data.length > 0){
        document.getElementById("nameUser").value = "";
        document.getElementById("lastNameUser").value = "";

    }
    $.ajax({
        url:"getfio",
        type:"GET",
        data:{"login" : $("#loginPublic").text()},
        success: parsefio,
        dataType: "text"
    })

}
$(function () {
    $.ajax({
        url: "getUserListJurnalOff",
        type: "GET",
        data: {"login" : $("#loginPublic").text()},
        success: parseListJurnalOff,
        dataType: "text"
    })
    $.ajax({
        url:"getAddress",
        type:"GET",
        data:{"login" : $("#loginPublic").text()},
        success: parseAddress,
        dataType:"text"
    })
    $.ajax({
        url:"getfio",
        type:"GET",
        data:{"login" : $("#loginPublic").text()},
        success: parsefio,
        dataType: "text"
    })
    $.ajax({
        url: "getListUserProposal",
        type: "GET",
        data: {"login": $("#loginPublic").text()},
        success: parseListPropasal,
        dataType: "text"
    })

});
function parsefio(data) {
    if(data.length > 0){
        var list = data.split("_");
        document.getElementById("nameUser").placeholder = list[0];
        document.getElementById("lastNameUser").placeholder = list[1];
        document.getElementById("phone").placeholder = list[2];
    }
}
function parseAddress(data) {
    if(data.length > 0){
        var list = data.split("_");
        document.getElementById("city").placeholder = list[0];
        document.getElementById("street").placeholder = list[1];
        document.getElementById("home").placeholder = list[2];
        document.getElementById("apart").placeholder = list[3];

    }
}
function parseZyavka(data) {
    if(data == "ok"){
        document.getElementById("addZyavka").className = "btn btn-success";
        $.ajax({
            url: "getListUserProposal",
            type: "GET",
            data: {"login": $("#loginPublic").text()},
            success: parseListPropasal,
            dataType: "text"
        })
    }
}
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
        $(".replace").remove();
        var list = data.split("|");
        var result ="";
        result = "<tr class='replace'><td>"+ list[0] +"</td><td>"+ list[1] +"</td><td>"+ list[2] +"</td></tr>";
        $("#MyCompany").append(result);
    }
}
function parseListJurnalOff(data) {
    if(data.length > 0){
        var list = data.split("|");
        var result = "";
        for( i = 0; i < list.length - 1; i++){
            var inList = list[i].split("_");
            result += "<tr>" +
                "<td>"+ inList[0] +"</td>" +
                "<td>"+ inList[1] +"</td>" +
                "<td>"+ inList[2] +"</td>" +
                "<td>"+ inList[3] +"</td>" +
                "<td>"+ inList[4] +"</td>" +
                "</tr>";
        }
        $("#JurnalOffList").replaceWith(result);
    }
}
function parseListPropasal(data){
    if(data.length > 0){
        $("tr.proposal").remove();
        var list = data.split("|");
        var result = "";
        for(i = 0; i < list.length - 1; i++){
            var inList = list[i].split("_");
            result += "<tr class='proposal'>" +
                "<td>" + inList[0] +"</td>" +
                "<td>" + inList[1] +"</td>" +
                "<td>" + inList[2] +"</td>" +
                "<td>" + inList[3] +"</td>" +
                "<td>" + inList[4] +"</td>" +
                "<td>" + inList[5] +"</td>" +
                "</tr>"
        }
        $("#MyZyavki").append(result);
    }
}
function ordine(data) {
    if(data == "false"){
        document.getElementById("testCompanyName").setAttribute("class", "btn-success");
    }else if(data == "true"){
        document.getElementById("testCompanyName").setAttribute("class", "btn-danger");
    }else {
        document.getElementById("testCompanyName").setAttribute("class", "btn-warning");
    }
}
function parseListNameOrg (data){
    if(data.length > 0){
        var list = data.split("_");
        var result = "";
        for(i = 0; i < list.length - 1; i++){
            result += "<option>" + list[i] + "</option>"
        }
        $("#optOrg").replaceWith(result);
    }
}

