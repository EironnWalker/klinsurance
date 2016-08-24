var TranslateModule = null;
$(function(){

});

apiready = function() {
    TranslateModule = api.require('TranslateModule');
}
$(".tip-wrap .wrap>div>div").click(function () {
    if($(this).attr("class").indexOf("active") == -1) {
        $(this).addClass("active");
    }
    else {
        $(this).removeClass("active");
    }
});

$(".icon").click(
    function() {
        var tipHeight =  $(".tip-wrap .wrap>div").height();
        if ($(this).attr("class").indexOf("icon-fold") == -1) {
            $(this).prev().animate({maxHeight: tipHeight});
            $(this).removeClass("icon-unfold");
            $(this).addClass("icon-fold");
        }
        else {
            $(this).prev().animate({maxHeight: '33px'});
            $(this).removeClass("icon-fold");
            $(this).addClass("icon-unfold");
        }
    }
);
$(".icon-record").click(
    function() {
        startRecord($(this).attr('data-id'));
    }
);

function startRecord(id){
    TranslateModule.startRecord(function back(ret){
        $('#'+id).val(ret.data);
    });
}