var db;
var yH;//打开通讯录列表的起始高度
var viewADBook;
var TranslateModule = null;
apiready = function () {
    var headerHeight = $("header").fixStatusBar();
    TranslateModule = api.require('TranslateModule');
    viewADBook = api.require('HTViewADBook');
    db = api.require('db');
    yH = headerHeight + $(".horizontal").outerHeight(true);
    firstRefresh();
};
//进入页面首次刷新数据
function firstRefresh() {
    db.selectSql({
        name: 'insurance_db.db',
        sql: "SELECT * FROM customer"
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
    //在名为winName的window中执行jsfun脚本
    var jsfun = "setDataLength(" + data.length + ");";
    api.execScript({
        name: '/html/customer/customer_list_win.html',
        script: jsfun
    });
    var param = {
        x: 0,
        y: yH,
        w: 0,
        h: api.winHeight - footerH - yH,
        type: bookType,
        persons: JSON.stringify(data)
    };
    viewADBook.startADBookView(param, function resultCallback(ret) {
        alert(ret.data);
        var data = JSON.parse(ret.data);
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