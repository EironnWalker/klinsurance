var TranslateModule = null;
var db;
var userId;
var briefingId;
apiready = function () {
    db = api.require('db');
    TranslateModule = api.require('TranslateModule');
    userId = ht.storage.getLocalStorage(ht.constants.userId);
    briefingId = api.pageParam.briefingId;
    loadLoss();
};
//初始化损失项
function loadLoss() {
    var queryData;
    var queryArry = new Array();
    var sql = "SELECT l.lossId AS lossId,l.place AS place,bl.briefingLossId AS briefingLossId FROM briefing_loss bl LEFT JOIN loss l ON bl.lossId = l.lossId " +
        "WHERE bl.briefingId = '" + briefingId + "'";
    db.selectSql({
        name: 'klinsurance_db.db',
        sql: sql
    }, function (ret, err) {
        if (ret.status) {
            queryData = ret.data;
            for (var i = 0; i < queryData.length; i++) {
                var loss = queryData[i];
                loss["isAdd"] = 1;
                db.selectSql({
                    name: 'klinsurance_db.db',
                    sql: "SELECT * FROM loss_item where lossId = '" + queryData[i].lossId + "'"
                }, function (ret, err) {
                    if (ret.status) {
                        //查询地点的损失项
                        loss.lossItems = ret.data;
                    }
                });
                db.selectSql({
                    name: 'klinsurance_db.db',
                    sql: "SELECT * FROM briefing_loss_image where briefingLossId = '" + queryData[i].briefingLossId + "'"
                }, function (ret, err) {
                    if (ret.status) {
                        //查询地点的图片
                        loss.lossImages = ret.data;
                    }
                });
                queryArry.push(loss);
            }
            var ret = {
                data: queryArry
            };
            var html = template('templateLoss', ret);
            $("#content").append(html);
        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
}
//下一步点击事件
function nextStep() {
    $.each($(".lossItem"), function (i, obj) {
        var lossItemObj = $(obj);
        var lossId = lossItemObj.attr("data-id");
        var isAdd = lossItemObj.attr("isAdd");
        if (isAdd == 0) {
            var sql = 'INSERT INTO briefing_loss (briefingLossId, briefingId, lossId, createTime, isSync) VALUES ('
                + ht.formatData(ht.uuid()) + ','
                + ht.formatData(briefingId) + ','
                + ht.formatData(lossId) + ','
                + ht.formatData(new Date().pattern("yyyy-MM-dd HH:mm:ss")) + ','
                + 0 + ')';
            db.selectSql({
                name: 'klinsurance_db.db',
                sql: sql
            }, function (ret, err) {
                if (ret.status) {
                    lossItemObj.attr("isAdd", 1);
                } else {
                    api.toast({
                        msg: '数据错误，请稍后重试！',
                        duration: 2000,
                        location: 'bottom'
                    });
                }
            });
        }
    });
}
$(function () {
    $("form").baseValidate(function () {
        api.openWin({
            name: '/html/report/add_brief_win3.html',
            url: api.wgtRootDir + '/html/report/add_brief_win3.html',
            pageParam: {name: 'pageparamname'}
        });
    });
    $(".btn").click(function () {
        $("#form-brief2").submit();
    });
});

//语音转义
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

function doAddLocation(lossIdStr) {
    var queryData = null;
    var queryArry = new Array();
    if (lossIdStr.length > 0) {
        var sql = "SELECT * FROM loss where userId = '" + userId + "' and lossId in (" + lossIdStr + ")";
        db.selectSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                queryData = ret.data;
                for (var i = 0; i < queryData.length; i++) {
                    var loss = queryData[i];
                    loss["isAdd"] = 0;
                    db.selectSql({
                        name: 'klinsurance_db.db',
                        sql: "SELECT * FROM loss_item where lossId = '" + queryData[i].lossId + "'"
                    }, function (ret, err) {
                        if (ret.status) {
                            loss.lossItems = 1;
                        }
                    });
                    queryArry.push(loss);
                }
                var ret = {
                    data: queryArry
                };
                var html = template('templateLoss', ret);
                $("#content").append(html);
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    }
}

//上传图片
$(".img-wrapper img").click(function () {
    if ($(".img-wrapper .flex-1").children(".wrap").length < 5) {
        api.getPicture({
            sourceType: 'library',
            encodingType: 'jpg',
            mediaValue: 'pic',
            destinationType: 'url',
            allowEdit: false,
            saveToPhotoAlbum: false
        }, function (ret, err) {
            if (ret.data != null) {
                $(".img-wrapper .flex-1").append("<div class='wrap'>" +
                    "<a class='bg-cover' style='background-image: url(" +
                    ret.data +
                    ")'></a>" +
                    "<span class='icon-cross'></span>" +
                    "<p class='ellipsis'>请描述</p>" +
                    "</div>");
            }
        });
    }
    else {
        api.toast({
            msg: '最多上传五张照片',
            duration: 2000,
            location: 'bottom'
        });
    }
});

//删除图片
$(".img-wrapper").on('click', 'span', function (event) {
    event.stopPropagation();
    $(this).parent().remove();
});

//增加图片描述
$(".img-wrapper").on('click', '.flex-1', function (event) {
    event.stopPropagation();
    api.openWin({
        name: '/html/report/add_img_win.html',
        url: api.wgtRootDir + '/html/report/add_img_win.html',
        pageParam: {name: 'pageparamname'}
    });
});

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