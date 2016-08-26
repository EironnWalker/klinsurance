var TranslateModule = null;
var db;
var tipHtml;
var tempHtml;
var codeValue = "";

apiready = function() {
    TranslateModule = api.require('TranslateModule');
    fs = api.require('fs');
    fs.moveTo({
        oldPath: api.wgtRootDir + '/wgt/klinsurance_db.db',
        newPath: 'fs://'
    }, function(ret, err) {
        if (ret.status) {
            alert(JSON.stringify(ret));
        } else {
            alert(JSON.stringify(err));
        }
    });
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
            db.executeSql({
                name: 'klinsurance_db',
                sql: 'update text_template set name = "事故原因" where text_template_id="276ac3079c9042a190ea53a5fd81ce37' +
                '";'
            }, function(ret, err) {
                if(ret.status) {
                }
            });
            loadTemp();
        } else {
            alert('打开数据库失败');
        }
    });
}

//标签展开与合上
$(".tip-wrap .icon").click(
    function() {
        var tipHeight =  $(".tip-wrap .wrap>div").height();
        if ($(this).attr("class").indexOf("icon-fold") == -1) {
            $(this).prev().animate({maxHeight: tipHeight});
            $(this).removeClass("icon-unfold");
            $(this).addClass("icon-fold");
        }
        else {
            $(this).prev().animate({maxHeight: '33px'});
            $(this).removeClass("icon-fold");
            $(this).addClass("icon-unfold");
        }
    }
);

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
        codeValue += $(obj).attr("data-code") + " ";
        codeValue = codeValue.substring(0, codeValue.length-1);
        searchTemp(codeValue, "tags")
    }
    else {
        $(obj).removeClass("active");
        codeValue = codeValue.replace($(obj).attr("data-code") + " ","");
        codeValue = codeValue.substring(0, codeValue.length-1);
        searchTemp(codeValue, "tags")
    }
}

//加载模板
function loadTemp() {
    db.selectSql({
        name: 'klinsurance_db',
        sql: 'select * from text_template order by create_time desc'
    }, function (ret, err) {
        if (ret.status) {
            tempHtml = template("temp-template", ret);
            $("#temp").html(tempHtml);
        }
    });
}

//探索模板结果
function searchTemp(value, option) {
    if (option == "name") {
        db.selectSql({
            name: 'klinsurance_db',
            sql: 'select * from text_template where ' + option + ' like "%' + value + '%"'
        }, function (ret, err) {
            if (ret.status) {
                tempHtml = template("temp-template", ret);
                $("#temp").html(tempHtml);
            }
        });
    } else {
        var tagTip = value.split(" ");
        alert(tagTip)
        var sql = 'select * from text_template where tags like "%';
        for (var i = 0; i < tagTip.length; i++) {
            sql += tagTip[i] + '%" and tags like "%';
            alert(tagTip[i])
        }
        sql = sql.substring(0, sql.length-17);
        alert(sql)
    }
}

//语音转义
$(".icon-record").click(
    function() {
        startRecord($(this).attr('data-id'));
    }
);
function startRecord(id){
    TranslateModule.startRecord(function back(ret){
        $('#'+id).val(ret.data);
    });
}

//输入框搜索
$(".search-wrap .btn").click(function() {
    searchTemp($("#search").val(),"name")
});
$(".search-wrap input").on("input propertychange", function() {
    searchTemp($("#search").val(),"name")
});