var BaiduPush = null;
var HTDatePicker = null;
var TranslateModule = null;
var locationJson;
var projectId;
var userId;
var db;
var isAdd;
var briefingId;
apiready = function () {
    db = api.require('db');
    BaiduPush = api.require('LocationModule');
    BaiduPush.initDb();//将模块中的数据库写入手机
    HTDatePicker = api.require('HTDatePicker');
    TranslateModule = api.require('TranslateModule');
    $(".icon-location").click();
    projectId = api.pageParam.projectId;
    isAdd = api.pageParam.isAdd;
    userId = ht.storage.getLocalStorage(ht.constants.userId);
    if (isAdd == 1) {
        $("#userId").val(userId);
        var myDate = new Date();//时间实例
        $("#briefingNo").val(myDate.pattern("yyyyMMddHHmmss") + myDate.getMilliseconds());
        $("#projectId").val(projectId);
        $("#surveyTime").val(myDate.pattern("yyyy-MM-dd HH:mm:ss"));
    } else {
        briefingId = api.pageParam.briefingId;
    }
    $("form").baseValidate(function () {
        var uuid = ht.uuid();
        var data = form2json('form');
        var sql;
        if (isAdd == 1) {
            sql = 'INSERT INTO briefing (briefingId, briefingNo, userId, projectId, wordTemplateId, surveyTime, surveyPlace,' +
                ' surveyLat, surveyLng, insurer, insurerName, insurerPhone, surveyor, accidentDescription, lossDescription, ' +
                'nextWork, mainSurveyor, subSurveyor, manager, briefingFile, remark, createTime, isSync) VALUES ('
                + formatData(uuid) + ','
                + formatData(data.briefingNo) + ','
                + formatData(data.userId) + ','
                + formatData(data.projectId) + ','
                + formatData(data.wordTemplateId) + ','
                + formatData(data.surveyTime) + ','
                + formatData(data.surveyPlace) + ','
                + formatData(data.surveyLat) + ','
                + formatData(data.surveyLng) + ','
                + formatData(data.insurer) + ','
                + formatData(data.insurerName) + ','
                + formatData(data.insurerPhone) + ','
                + formatData(data.surveyor) + ','
                + formatData(data.accidentDescription) + ','
                + formatData(data.lossDescription) + ','
                + formatData(data.nextWork) + ','
                + formatData(data.mainSurveyor) + ','
                + formatData(data.subSurveyor) + ','
                + formatData(data.manager) + ','
                + formatData(data.briefingFile) + ','
                + formatData(data.remark) + ','
                + formatData(new Date().pattern("yyyy-MM-dd HH:mm:ss")) + ','
                + formatData(1) + ')';
        } else {
            sql = 'UPDATE "briefing" SET'
                + '"surveyTime" = ' + formatData(data.surveyTime) + ','
                + '"surveyPlace" = ' + formatData(data.surveyPlace) + ','
                + '"surveyLat" = ' + formatData(data.surveyLat) + ','
                + '"surveyLng" = ' + formatData(data.surveyLng) + ','
                + '"insurer" = ' + formatData(data.insurer) + ','
                + '"insurerName" = ' + formatData(data.insurerName) + ','
                + '"insurerPhone" = ' + formatData(data.insurerPhone) + ','
                + '"surveyor" = ' + formatData(data.surveyor) + ','
                + '"accidentDescription" = ' + formatData(data.accidentDescription) + ','
                + '"lossDescription" = ' + formatData(data.lossDescription) + ','
                + '"isSync" = ' + formatData(1)
                + ' WHERE briefingId = "' + $("#briefingId").val() + '"';
        }
        db.executeSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                if (isAdd == 1) {
                    $("#briefingId").val(uuid);
                    isAdd = 0;
                }
                api.openWin({
                    name: '/html/report/add_brief_win2.html',
                    url: api.wgtRootDir + '/html/report/add_brief_win2.html',
                    pageParam: {
                        briefingId: $("#briefingId").val(),
                        projectId: projectId
                    }
                });
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    });
};
function nextStep() {
    $("form").submit();
}
$(".icon-location").click(function () {
    BaiduPush.startLocation(function (ret, err) {
        locationJson = JSON.parse(ret.data);
        $("#surveyPlace").val(locationJson.province + locationJson.city + locationJson.district + locationJson.street);
        $("#surveyLat").val(locationJson.latitude);
        $("#surveyLng").val(locationJson.longitude);
    });
});
$("#surveyTime").click(function () {
    HTDatePicker.startCalenderChoice({style: '1'}, function (ret, err) {
        $("#surveyTime").val(JSON.parse(ret.data).day);
    });
});

$(".icon-record").click(
    function () {
        startRecord($(this).attr('data-id'));
    }
);

function startRecord(id) {
    TranslateModule.startRecord(function back(ret) {
        $('#' + id).val(ret.data);
    });
}

//打开模板
$(".icon-add1").click(function () {
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
    $("#" + dataID).val(detail);
}

//日期格式化
Date.prototype.pattern = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时
        "H+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    var week = {
        "0": "/u65e5",
        "1": "/u4e00",
        "2": "/u4e8c",
        "3": "/u4e09",
        "4": "/u56db",
        "5": "/u4e94",
        "6": "/u516d"
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    if (/(E+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[this.getDay() + ""]);
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
};

//格式化数据
function formatData(data) {
    return data != undefined && data ? '"' + data + '"' : null;
}