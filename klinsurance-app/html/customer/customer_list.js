var db;
var yH;//打开通讯录列表的起始高度
var viewADBook;
var TranslateModule = null;
var importCustomModule = null;
var bookType;
apiready = function () {
    var headerHeight = $("header").fixStatusBar();
    TranslateModule = api.require('TranslateModule');
    importCustomModule = api.require('ImportCustomModule');
    db = api.require('db');
    yH = headerHeight + $(".horizontal").outerHeight(true);
    bookType = api.pageParam.bookType;
    firstRefresh();
};
//进入页面首次刷新数据
function firstRefresh() {
    db.selectSql({
        name: 'klinsurance_db.db',
        sql: "SELECT * FROM customer"
    }, function (ret, err) {
        if (ret.status) {
            alert(JSON.stringify(ret.data));
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
        persons: JSON.stringify(data)
    };
    importCustomModule.importCustom(param, function resultCallback(ret) {
        alert(ret.data);
    });
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