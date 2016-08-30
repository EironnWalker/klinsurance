var TranslateModule = null;
var db;
var tipHtml;
var tempHtml;

apiready = function() {
    showContent();
};

//从数据库中获取模板，并显示
function showContent() {
    db = api.require('db');
    loadTemp();
}

//加载模板
function loadTemp() {
    db.selectSql({
        name: 'klinsurance_db',
        sql: 'select * from text_template order by createTime desc'
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
            sql: 'select * from text_template where ' + option + ' like "%' + value + '%"' + 'order by createTime desc'
        }, function (ret, err) {
            if (ret.status) {
                tempHtml = template("temp-template", ret);
                $("#temp").html(tempHtml);
            }
        });
    } else {
        var tagTip = value.split(",");
        var sql = 'select * from text_template where tags like "%';
        for (var i = 0; i < tagTip.length; i++) {
            sql += tagTip[i] + '%" and tags like "%';
        }
        sql = sql.substring(0, sql.length-17) + ' order by createTime desc';
        db.selectSql({
            name: 'klinsurance_db',
            sql: sql
        }, function (ret, err) {
            tempHtml = template("temp-template", ret);
            $("#temp").html(tempHtml);
        });
    }
}

//跳转到模板修改页
function updateTemp(obj) {
        api.openWin({
            name: '/html/temp/manage_win.html',
            url: api.wgtRootDir + '/html/temp/manage_win.html',
            pageParam: {tempId: $(obj).attr("id") }
        });
}