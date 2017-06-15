
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

$(function () {
    $.ajax({
        url: "getListWorker",
        type: "GET",
        data: {"organization" : $("#Organization").text()},
        success: parseListWorker,
        dataType: "text"
    })
})
function parseListWorker(data) {
    if(data.length > 0){
        var list = data.split("|");
        var result = "";
        for(i = 0; i < list.length - 1; i++){
            var inList = list[i].split("_");
            result += "<tr>" +
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