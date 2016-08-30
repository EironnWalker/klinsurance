var codeValue = "";

$(function () {

//语音转义
    $(".icon-record").click(
        function() {
            startRecord($(this).attr('data-id'));
        }
    );

//标签展开与合上
    $(".tip-wrap .icon").click(
        function() {
            var tipHeight =  $(".tip-wrap .wrap>div").height();
            var frameH;
            if ($(this).attr("class").indexOf("icon-fold") == -1) {
                //$(this).prev().animate({maxHeight: tipHeight});
                $(this).prev().css("max-height", tipHeight);
                $(this).removeClass("icon-unfold");
                $(this).addClass("icon-fold");
                frameH = $("header").height() + $(".search-wrap").outerHeight() + $(".p-title").outerHeight() + $(".tip-wrap .wrap>div").outerHeight() + $(".tip-wrap .icon").outerHeight();
            }
            else {
                //$(this).prev().animate({maxHeight: '33px'});
                $(this).prev().css("max-height", "33px");
                $(this).removeClass("icon-fold");
                $(this).addClass("icon-unfold");
                frameH = $("header").height() + $(".search-wrap").outerHeight() + $(".p-title").outerHeight() + 55;
            }
            api.setFrameAttr({
                name: '/html/temp/select_frm.html',
                rect: {
                    x: 0,
                    y: frameH,
                    w: 'auto',
                    h: 'auto'
                }
            });
        }
    );

//输入框搜索
    $(".search-wrap .btn").click(function() {
        var jsfun1 = 'searchTemp("' + $("#search").val() + '", "name");';
        api.execScript({
            name: '/html/temp/select_win.html',
            frameName: '/html/temp/select_frm.html',
            script: jsfun1
        });
    });
    $(".search-wrap input").on("input propertychange", function() {
        var jsfun2 = 'searchTemp("' + $("#search").val() + '", "name");';
        api.execScript({
            name: '/html/temp/select_win.html',
            frameName: '/html/temp/select_frm.html',
            script: jsfun2
        });
    });

});


apiready = function () {
    TranslateModule = api.require('TranslateModule');
    api.openFrame({
        name: '/html/temp/select_frm.html',
        url: api.wgtRootDir + '/html/temp/select_frm.html',
        rect: {
            x: 0,
            y: $("header").height() + $(".search-wrap").outerHeight() + $(".p-title").outerHeight() + 55,
            w: 'auto',
            h: 'auto'
        },
        pageParam: {name: 'pageparam'},
        bounces: true
    });
    //fs.moveTo({
    //    oldPath: api.wgtRootDir + '/wgt/klinsurance_db.db',
    //    newPath: 'fs://'
    //}, function(ret, err) {
    //    if (ret.status) {
    //        alert(JSON.stringify(ret));
    //    } else {
    //        alert(JSON.stringify(err));
    //    }
    //});
    showContent();
};

//从数据库中获取标签和模板，并显示
function showContent() {
    db = api.require('db');
    db.openDatabase({
        name: 'klinsurance_db',
        path: 'fs://klinsurance_db.db'
    },function(ret, err) {
        if (ret.status) {
            //db.executeSql({
            //    name: 'klinsurance_db',
            //    sql: 'delete from text_template'
            //}, function (ret, err) {
            //
            //})
            db.selectSql({
                name: 'klinsurance_db',
                sql: 'select * from text_template_tag order by text_template_tag_id'
            }, function (ret, err) {
                if (ret.status) {
                    tipHtml = template("tip-template", ret);
                    $("#tip").html(tipHtml);
                    tipColor();
                }
            });
            //loadTemp();
        } else {
            alert('打开数据库失败');
        }
    });
}

function addTemp() {
    api.openWin({

        name: '/html/temp/manage_win.html',
        url: api.wgtRootDir + '/html/temp/manage_win.html',
        pageParam: {tempId: null}
    });
}
//标签颜色控制
function tipColor() {
    $("#tip div").each(function(){
        var index = $("#tip div").index(this);
        switch (index % 6) {
            case 0: $(this).addClass("orange"); break;
            case 1: $(this).addClass("brown"); break;
            case 2: $(this).addClass("grey"); break;
            case 3: $(this).addClass("red"); break;
            case 4: $(this).addClass("blue"); break;
            case 5: $(this).addClass("pink"); break;
        }
    });
}

//标签点击
function tipActive(obj) {
    if($(obj).attr("class").indexOf("active") == -1) {
        $(obj).addClass("active");
        codeValue += $(obj).attr("data-code") + ",";
    }
    else {
        $(obj).removeClass("active");
        codeValue = codeValue.replace($(obj).attr("data-code") + ",","");
    }
    var jsfun = 'searchTemp("' + codeValue.substring(0,codeValue.length-1) + '", "tags");';
    api.execScript({
        name: '/html/temp/select_win.html',
        frameName: '/html/temp/select_frm.html',
        script: jsfun
    });
}

//语音转义模块
function startRecord(id){
    TranslateModule.startRecord(function back(ret){
        if (JSON.stringify(ret.data).type == 0) {
            $('#'+id).val(JSON.stringify(ret.data).result);
        }
        else {
            var prev = $('#'+id).val();
            $('#'+id).val(prev + JSON.stringify(ret.data).result);
        }
    });
}