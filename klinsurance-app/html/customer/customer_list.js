var db;
var yH;//打开通讯录列表的起始高度
var TranslateModule = null;
var importCustomModule = null;
var searchContent;//搜索内容
var bookType;//类型 0 user 1 customer
var fromPage;//从哪个页面过来的，然后选择完成后回调哪个页面的方法
apiready = function () {
    var headerHeight = $("header").fixStatusBar();
    TranslateModule = api.require('TranslateModule');
    importCustomModule = api.require('ImportCustomModule');
    db = api.require('db');
    yH = headerHeight + $(".horizontal").outerHeight(true);
    bookType = api.pageParam.bookType;
    fromPage = api.pageParam.fromPage;
    $("#title").html(api.pageParam.title);
    refresh();
};
//进入页面首次刷新数据
function refresh() {
    var sql = "";
    if (bookType == 1) {
        if (searchContent) {
            sql = "SELECT * FROM customer where name like '%" + searchContent + "%'";
        } else {
            sql = "SELECT * FROM customer";
        }
    } else {
        if (searchContent) {
            sql = "SELECT * FROM user where name like '%" + searchContent + "%'";
        } else {
            sql = "SELECT * FROM user";
        }
    }
    db.selectSql({
        name: 'klinsurance_db.db',
        sql: sql
    }, function (ret, err) {
        if (ret.status) {
            initCustomerBook(ret.data);
        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
}
//初始化客户列表
function initCustomerBook(data) {
    var param = {
        x: 0,
        y: yH,
        w: 0,
        h: api.winHeight - yH,
        type: bookType,
        data: JSON.stringify(data)
    };
    importCustomModule.importCustom(param, function resultCallback(ret) {
        var jsfun;
        if (fromPage == "brief") {
            if (bookType == 1) {
                jsfun = 'setBBR(' + ret.data + ');';
            } else {
                jsfun = 'setGGR(' + ret.data + ');';
            }
            api.execScript({
                name: '/html/report/add_brief_win1.html',
                frameName: '/html/report/add_brief_frm1.html',
                script: jsfun
            });
        }
        api.closeWin();
    });
}

function searchCustomer(){
    searchContent = $("#search").val();
    refresh();
}
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