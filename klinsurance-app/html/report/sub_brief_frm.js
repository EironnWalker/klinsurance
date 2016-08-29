var db;
var projectId;
apiready = function () {
    db = api.require('db');
    projectId = api.pageParam.projectId;
    loadData();
};
//加载数据
function loadData() {
    var sql = "SELECT b.briefingId AS briefingId ,b.briefingNo AS briefingNo,b.projectId AS projectId,p.projectName AS projectName," +
        " b.createTime AS createTime FROM briefing b LEFT JOIN project p ON b.projectId = p.projectId WHERE b.projectId = '" + projectId + "'" +
        " ORDER BY b.createTime DESC";
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
        }
    )
}