var TranslateModule = null;
apiready = function() {
    TranslateModule = api.require('TranslateModule');
};
$(function() {
    $("#form-brief3").baseValidate({
        submitHandler: function () {
            alert("success");
            api.openWin({
                name: '/html/report/report_win.html',
                url: api.wgtRootDir + '/html/report/report_win.html',
                pageParam: {name: 'pageparamname'}
            });
        }
    });
    $(".btn").click(function() {
        $("#form-brief3").submit();
    });
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

//打开模板
$(".icon-add").click(function () {
    api.openWin({
        name: '/html/report/select_win.html',
        url: api.wgtRootDir + '/html/report/select_win.html',
        pageParam: {
            winName: api.winName,
            frameName: api.frameName,
            dataID: $(this).attr("data-id")
        }
    });
});

//获得模板内容
function getTempDetail(dataID, detail) {
    $("#"+dataID).val(detail);
}