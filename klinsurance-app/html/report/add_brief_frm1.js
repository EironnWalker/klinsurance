var BaiduPush = null;
var HTDatePicker = null;
var TranslateModule = null;
var locationJson;
apiready = function() {
    BaiduPush = api.require('LocationModule');
    BaiduPush.initDb();//将模块中的数据库写入手机
    HTDatePicker = api.require('HTDatePicker');
    TranslateModule = api.require('TranslateModule');
    $(".icon-location").click();
};
$(function() {
    $("#form-brief1").baseValidate({
        submitHandler: function () {
            alert("success");
            api.openWin({
                name: '/html/report/add_brief_win2.html',
                url: api.wgtRootDir + '/html/report/add_brief_win2.html',
                pageParam: {name: 'pageparamname'}
            });
        }
    });
    $(".btn").click(function() {
        $("#form-brief1").submit();
    });
});
$(".icon-location").click(function() {
    BaiduPush.startLocation(function (ret,err) {
        locationJson = JSON.parse(ret.data);
        $("#location").val(locationJson.province + locationJson.city + locationJson.district + locationJson.street);
    });
});
$("#time").click(function() {
    HTDatePicker.startCalenderChoice({style: '1'}, function(ret, err){
        $("#time").val(JSON.parse(ret.data).day);
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