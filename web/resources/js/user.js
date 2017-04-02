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
    if(data >= 0) {
        document.getElementById("createCompanyName").setAttribute("class", "btn-success");
    }else {
        document.getElementById("createCompanyName").setAttribute("class", "btn-warning");
    }
}

function tsjListPointer(data){
    if(data.length > 0) {

        var list = data.split("_");
        var rezult = "";
        for (i = 0; i < list.length - 1; i++) {
            rezult += "<h5 class=\"text-left\">" + list[i] + "</h5>" + "<hr/>";
        }
        $("#replace").replaceWith(rezult);
    }
};

