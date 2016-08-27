var location_id = null;
var location_detail = null;
var db;
apiready = function () {
    db = api.require('db');
    var userId = ht.storage.getLocalStorage(ht.constants.userId);
    var projectId = api.pageParam.projectId;
    var sql = 'INSERT INTO loss (lossId, userId, projectId, place, customerSignPath, customerSignTime, remark,' +
        ' createTime, placeNo, isSync) VALUES ('
        + ht.formatData(1) + ','
        + ht.formatData(1277) + ','
        + ht.formatData(projectId) + ','
        + ht.formatData("中俄科技园") + ','
        + null + ','
        + null + ','
        + null + ','
        + ht.formatData(new Date().pattern("yyyy-MM-dd HH:mm:ss")) + ','
        + ht.formatData(1) + ','
        + 0 + ')';
    db.executeSql({
        name: 'klinsurance_db.db',
        sql: sql
    }, function (ret, err) {
        if (ret.status) {
        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
    var sql = 'INSERT INTO loss (lossId, userId, projectId, place, customerSignPath, customerSignTime, remark,' +
        ' createTime, placeNo, isSync) VALUES ('
        + 2 + ','
        + 1277 + ','
        + ht.formatData(projectId) + ','
        + ht.formatData("北方星空") + ','
        + null + ','
        + null + ','
        + null + ','
        + ht.formatData(new Date().pattern("yyyy-MM-dd HH:mm:ss")) + ','
        + 2 + ','
        + 0 + ')';
    db.executeSql({
        name: 'klinsurance_db.db',
        sql: sql
    }, function (ret, err) {
        if (ret.status) {
        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
    db.selectSql({
        name: 'klinsurance_db.db',
        sql: "SELECT * FROM loss where projectId = '" + projectId + "' and userId = '" + userId + "'"
    }, function (ret, err) {
        if (ret.status) {
            var html = template('templateLoss', ret);
            $(".search-wrap").after(html);
        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
};
$(function () {
    $("li .flex-1").each(function () {
        if ($(this).height() > 20) {
            $(this).removeClass("text-right");
        }
    });
    $(".ul-select").first().click();
});
$(".ul-select").click(function () {
    $(this).find("input[type='radio']")[0].checked = true;
    location_id = $(this).find(".id").html();
    location_detail = $(this).find(".location").html();
});

function selectLocation() {
    api.execScript({
        name: '/html/report/add_brief_win2.html',
        frameName: '/html/report/add_brief_frm2.html',
        script: 'doAddLocation("' + location_id + '","' + location_detail + '");'
    });
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