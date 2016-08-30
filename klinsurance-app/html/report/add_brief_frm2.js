var TranslateModule = null;
var db;
var userId;
var briefingId;
var briefingLossId;
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
            $.each(queryData, function (i, n) {
                var loss = n;
                db.selectSql({
                    name: 'klinsurance_db.db',
                    sql: "SELECT * FROM loss_item where lossId = '" + loss.lossId + "'"
                }, function (ret, err) {
                    if (ret.status) {
                        //查询地点的损失项
                        loss["lossItems"] = ret.data;
                        var sql = "SELECT * FROM briefing_loss_image where briefingLossId = '" + loss.briefingLossId + "'" +
                            " order by createTime,imageOrder";
                        db.selectSql({
                            name: 'klinsurance_db.db',
                            sql: sql
                        }, function (ret, err) {
                            if (ret.status) {
                                //查询地点的图片
                                loss["lossImages"] = ret.data;
                                queryArry.push(loss);
                                if (i == queryData.length - 1) {
                                    var ret = {
                                        data: queryArry
                                    };
                                    var html = template('templateLoss', ret);
                                    $("#content").html(html);
                                }
                            }
                        });
                    }
                });

            })

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

}
//录音按钮点击事件
function record(id) {
    TranslateModule.startRecord(function back(ret) {
        var data = JSON.parse(ret.data);
        if (data.type == "0") {
            $('#' + id).val(data.result);
        } else {
            $('#' + id).val($('#' + id).val() + data.result);
        }
        placeChange(id);
    });
}
//地点修改时间
function placeChange(lossId) {
    var newPlace = $("#" + lossId).val();
    if (!newPlace) {
        api.toast({
            msg: '地点名称不能为空！',
            duration: 2000,
            location: 'bottom'
        });
        return;
    }
    var sql = "UPDATE loss SET place = '" + newPlace + "',isSync = 1 WHERE lossId = '" + lossId + "'";
    db.executeSql({
        name: 'klinsurance_db.db',
        sql: sql
    }, function (ret, err) {
        if(ret.status){

        }
    });
}
//选择地点回调时间
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
                    db.selectSql({
                        name: 'klinsurance_db.db',
                        sql: "SELECT * FROM loss_item where lossId = '" + queryData[i].lossId + "'"
                    }, function (ret, err) {
                        if (ret.status) {
                            loss.lossItems = ret.data;
                        }
                    });
                    var briefingLossId = ht.uuid();
                    loss["briefingLossId"] = briefingLossId;
                    queryArry.push(loss);
                    var sql = 'INSERT INTO briefing_loss (briefingLossId, briefingId, lossId, createTime, isSync) VALUES ('
                        + ht.formatData(briefingLossId) + ','
                        + ht.formatData(briefingId) + ','
                        + ht.formatData(queryData[i].lossId) + ','
                        + ht.formatData(new Date().pattern("yyyy-MM-dd HH:mm:ss")) + ','
                        + 0 + ')';
                    db.executeSql({
                        name: 'klinsurance_db.db',
                        sql: sql
                    }, function (ret, err) {
                    });
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

//增加图片描述
function imgEdit(briefingLossId){
    api.openWin({
        name: '/html/report/add_img_win.html',
        url: api.wgtRootDir + '/html/report/add_img_win.html',
        pageParam: {briefingLossId: briefingLossId}
    });
}
//上传图片
function openSelectPhoto(blossId) {
    briefingLossId = blossId;
    //还可以添加的图片数量
    media.openPhoto(addImgTemplate, 5);
}
//显示图片并且添加本地数据库
function addImgTemplate() {
    var lossImg = {};
    var lossImgArry = new Array();
    $.each(Imgs, function (i, url) {
        var briefingLossImageId = ht.uuid();
        var sql = 'INSERT INTO briefing_loss_image (briefingLossImageId, briefingLossId, originalImage, image, description, ' +
            'imageOrder,createTime, isSync) VALUES ('
            + ht.formatData(briefingLossImageId) + ','
            + ht.formatData(briefingLossId) + ','
            + ht.formatData(url) + ','
            + ht.formatData(url) + ','
            + ht.formatData("请描述") + ','
            + i + ','
            + ht.formatData(new Date().pattern("yyyy-MM-dd HH:mm:ss")) + ','
            + 1 + ')';
        db.executeSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                lossImg = {
                    briefingLossImageId: briefingLossImageId,
                    originalImage: url
                };
                lossImgArry.push(lossImg);
                if (i == Imgs.length - 1) {
                    var ret = {
                        data: lossImgArry
                    };
                    var html = template('templateLossImg', ret);
                    $("#" + briefingLossId + "Img").append(html);
                    ht.apicloud.hideProgress();
                }
            } else {
                ht.apicloud.hideProgress();
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    });
}

function delImg(briefingLossImageId) {
    db.executeSql({
        name: 'klinsurance_db.db',
        sql: "DELETE from  briefing_loss_image WHERE briefingLossImageId ='" + briefingLossImageId + "'"
    }, function (ret, err) {
        if (ret.status) {
            $("#" + briefingLossImageId).remove();
        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
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