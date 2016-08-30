var tipValue = "";
var codeValue = "";
var db;
var TranslateModule = null;
$(function () {
    //提交表单
    $(".btn").click(function () {
        $("#form-manage").submit();
    });

//语音转义
    $(".icon-record").click(
        function() {
            startRecord($(this).attr('data-id'));
        }
    );
});
apiready = function() {
    TranslateModule = api.require('TranslateModule');
    var db = api.require('db');
    //加载标签
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
    //加载修改模板
    if (api.pageParam.tempId != null) {
        db.selectSql({
            name: 'klinsurance_db',
            sql: 'select name, content, tags, isShared from text_template where textTemplateId = "' + api.pageParam.tempId + '"'
        }, function (ret, err) {
            if (ret.status) {
                $("#name").val(ret.data[0].name);
                $("#detail").val(ret.data[0].content);
                if (ret.data[0].isShared == 0) {
                    $("input[name='isShared']").attr("checked", false);
                } else {

                    $("input[name='isShared']").attr("checked", true);
                }
                var tagTip = ret.data[0].tags.split(",");
                for (var i = 0; i < tagTip.length; i++) {
                    $("#tip div").each(function() {
                        if ($(this).attr("data-code") == tagTip[i]) {
                            tipActive(this);
                        }
                    });
                }
            }
        });
    }
    //增加或修改模板
    $("#form-manage").baseValidate({
        submitHandler: function() {
            var isShared;
            var sql;
            var formObj = form2json('form-manage');
            var currentTime = new Date().format("yyyy.MM.dd hh:mm:ss");
            if ($("input[name='isShared']").is(':checked')==true) {
                isShared = 1;
            }
            else {
                isShared = 0;
            }
            if (api.pageParam.tempId != null) {
                sql = 'update text_template set name = "' + formObj.name + '", content = "' +formObj.detail + '", tags = "' + codeValue.substring(0, codeValue.length-1) + '", isShared =' + isShared + ', isSync = '+ 1 + ' where textTemplateId = "'+ api.pageParam.tempId + '"';
            }
            else {
                sql = 'insert into text_template values ("' + ht.uuid() + '","'+formObj.name + '","' + formObj.detail + '","' + codeValue.substring(0, codeValue.length-1) +
                    '",' + isShared + ',"' + currentTime.toLocaleString() + '",' + 1 + ')';
            }
            db.executeSql({
                name: 'klinsurance_db',
                sql: sql
            },function(ret, err) {
                if(ret.status) {
                    api.execScript({
                        name: '/html/temp/select_win.html',
                        frameName: '/html/temp/select_frm.html',
                        script: 'loadTemp()'
                    });
                    api.closeWin({name: '/html/temp/manage_win.html'});
                }
                else {
                    alert(JSON.stringify(err))
                }
            });
            ht.storage.setLocalStorage(ht.constants.isSync, 1);
        }
    });
};

//标签点击
function tipActive(obj) {
    if($(obj).attr("class").indexOf("active") == -1) {
        $(obj).addClass("active");
        tipValue += $(obj).text() + " ";
        codeValue += $(obj).attr("data-code") + ",";
    }
    else {
        $(obj).removeClass("active");
        tipValue = tipValue.replace($(obj).text() + " ","");
        codeValue = codeValue.replace($(obj).attr("data-code") + ",","");
    }
    $("textarea[name='tip']").val(tipValue);
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

//语音转义模块
function startRecord(id){
    TranslateModule.startRecord(function back(ret){
        $('#'+id).val(ret.data);
    });
}
