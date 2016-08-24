var tipValue = "";
var TranslateModule = null;
$(function(){
    $("#form-manage").baseValidate({
        submitHandler: function() {
            api.closeWin({name: '/html/temp/manage_win.html'});
        }
    });
});
apiready = function() {
    TranslateModule = api.require('TranslateModule');
};
$(".tip-wrap .wrap>div>div").click(function () {
    if($(this).attr("class").indexOf("active") == -1) {
        $(this).addClass("active");
        tipValue += $(this).text() + " ";
    }
    else {
        $(this).removeClass("active");
        tipValue = tipValue.replace($(this).text() + " ","")
    }
    $("textarea[name='tip']").val(tipValue);
});

$(".btn").click(function () {
    $("#form-manage").submit();
});

$(".icon-record").click(
    function() {
         startRecord($(this).attr('data-id'));
    }
);

function startRecord(id){
    TranslateModule.startRecord(function back(ret){
        $('#' + id).val(ret.data);
    });
}