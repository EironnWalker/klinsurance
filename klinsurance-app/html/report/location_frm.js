var location_id = null;
var location_detail = null;
$(function() {
    $("li .flex-1").each(function(){
        if ($(this).height() > 20) {
            $(this).removeClass("text-right");
        }
    });
    $(".ul-select").first().click();
});
$(".ul-select").click(function() {
    $(this).find("input[type='radio']")[0].checked = true;
    location_id = $(this).find(".id").html();
    location_detail = $(this).find(".location").html();
});

function selectLocation() {
    api.execScript({
        name: '/html/report/add_brief_win2.html',
        frameName: '/html/report/add_brief_frm2.html',
        script: 'doAddLocation("' + location_id + '","'+ location_detail + '");'
    });
}