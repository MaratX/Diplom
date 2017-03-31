$("#openn").click(function () {
    $("#log").show("slow");
});

$("#close").click(function(){
        $("#log").hide('slow');
    }
);
$("#auto").click(function() {
    $.ajax({
        url: "userOpen",
        type: "GET",
        data: {"name": "marat","pass" : "root"},
        cache:false,
        dataType: "html",
        success: lolo(data)
    })
});
function lolo (data){
    $('#body').append(data);
}
