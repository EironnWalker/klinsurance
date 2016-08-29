var TranslateModule;//语音识别插件
var pageParam;
var db;
var searchContent;//搜索内容
$(".icon-record").click(
    function() {
        startRecord($(this).attr('data-id'));
    }
);
apiready = function () {
    TranslateModule = api.require('TranslateModule');
    pageParam=api.pageParam;
    db = api.require('db');
    loadData();
};
// 加载数据
// @currentPage:当前页码
// @isReload：是否为刷新操作
function loadData() {
    var sql = "SELECT * FROM loss where projectId='"+pageParam.projectId+"'";
    if (searchContent) {
        sql += " and place like '%" + searchContent + "%'";
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
//损失项列表
function goAssessLoss() {
    api.openWin({
        name: '/html/site/loss_assessment_win.html',
        url: api.wgtRootDir + '/html/site/loss_assessment_win.html',
        pageParam: {name: 'pageparamname'}
    });
}
//添加地点回调
function newLocation(place) {
    //alert('新地点为' + paramLoacation)
    var sql = "insert into loss(lossId,userId,projectId,place,createTime,placeNo,isSync) values('"+
        ht.uuid()+"','"+ht.storage.getLocalStorage(ht.constants.userId)+"','"+pageParam.projectId+"','"+
        place+"',datetime('now'),'"+moment().format('YYYYMMDDHHmmssSS')+"',0)";
    db.executeSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                loadData();
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        }
    );
}
//录音
function startRecord(id){
    TranslateModule.startRecord(function back(ret){
        $('#'+id).val(ret.data);
    });
}