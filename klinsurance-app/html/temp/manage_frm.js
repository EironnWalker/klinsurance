var tipValue = "";
var codeValue = "";
var db;
var TranslateModule = null;
apiready = function() {
    TranslateModule = api.require('TranslateModule');
    var db = api.require('db');
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
    $("#form-manage").baseValidate({
        submitHandler: function() {
            var currentTime = new Date();
            var formObj = form2json('form-manage');
            db.executeSql({
                name: 'klinsurance_db',
                sql: 'insert into text_template values ("' + ht.uuid() + '","'+formObj.name + '","' + formObj.detail + '","' + codeValue.substring(0, codeValue.length-1) + '","' + currentTime.toLocaleString() + '")'
            },function(ret, err) {
                if(ret.status) {
                    api.execScript({
                        name: '/html/temp/select_win.html',
                        frameName: '/html/temp/select_frm.html',
                        script: 'loadTemp()'
                    });
                    api.closeWin({name: '/html/temp/manage_win.html'});
                }
            });
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

$(".btn").click(function () {
    $("#form-manage").submit();
});

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
