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
});

$("#testCompanyName").click(function () {
        $.ajax({
            url:"company",
            type:"GET",
            data: { 'loginA' : $("#companyN").val()},
            success: ordine,
            dataType:"text"
        })
    }
);
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
        url:"addOrganization",
        type:"GET",
        data:{'nameOrganization' : $("#companyN").val()},
        success: createOrganizationFunction,
        dataType:"text"
    })
});
function createOrganizationFunction(data) {
    if(data >= 0) {
        document.getElementById("createCompanyName").setAttribute("class", "btn-success");
    }else {
        document.getElementById("createCompanyName").setAttribute("class", "btn-warning");
    }
}

