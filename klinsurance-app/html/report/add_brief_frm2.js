var TranslateModule = null;
apiready = function () {
    TranslateModule = api.require('TranslateModule');
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

function doAddLocation(location_id, location_detail) {
    $("#stake-number").val(location_detail);
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