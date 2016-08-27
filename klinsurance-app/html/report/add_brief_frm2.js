var TranslateModule = null;
var db;
var userId;
apiready = function () {
    db = api.require('db');
    TranslateModule = api.require('TranslateModule');
    userId = ht.storage.getLocalStorage(ht.constants.userId);
};
$(function () {
    $("#form-brief2").baseValidate({
        submitHandler: function () {
            alert("success");
            api.openWin({
                name: '/html/report/add_brief_win3.html',
                url: api.wgtRootDir + '/html/report/add_brief_win3.html',
                pageParam: {name: 'pageparamname'}
            });
        }
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
    if (lossIdStr.length > 0) {
        var sql = "SELECT * FROM loss where userId = '" + userId + "' and lossId in (" + lossIdStr + ")";
        db.selectSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                var queryRet = ret;
                for (var i = 0; i < queryRet.data.length; i++) {
                    db.selectSql({
                        name: 'klinsurance_db.db',
                        sql: "SELECT * FROM loss_item where lossId = '" + queryRet.data[i].lossId + "'"
                    }, function (ret, err) {
                        if (ret.status) {
                            queryRet.data[i]["lossItem"] = ret.data;
                            queryRet.data[i]["lossImage"] = null;
                        }
                    });
                }
                var html = template('templateLoss', queryRet);
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