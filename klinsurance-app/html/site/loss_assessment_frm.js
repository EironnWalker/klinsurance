var pageParam;
var searchContent;
$(function () {
    $("li .flex-1").each(function () {
        if ($(this).height() > 20) {
            $(this).removeClass("text-right");
        }
    })
    $(".ul-one").click(function() {
        api.openWin({
            name: '/html/site/add_loss_win.html',
            url: api.wgtRootDir + '/html/site/add_loss_win.html',
            pageParam: {name: 'pageparamname'}
        });
    });
});

apiready = function () {
    pageParam=api.pageParam;
    loadData();
};
// 加载数据
function loadData() {
    var sql = "SELECT * FROM loss_item where lossId='"+pageParam.lossId+"'";
    if (searchContent) {
        sql += " and lossItemName like '%" + searchContent + "%'";
    }
    db.selectSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                var html = template('template', ret);
                $("#content").html(html);
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
            //将刷新完成后关闭
            api.refreshHeaderLoadDone();
            ht.apicloud.hideProgress();
        }
    );
}


