var db;
apiready = function () {
    db = api.require('db');
    var briefingLossId = api.pageParam.briefingLossId;
    db.selectSql({
        name: 'klinsurance_db.db',
        sql: "SELECT * from briefing_loss_image WHERE briefingLossId = '"+briefingLossId+"'"
    }, function (ret, err) {
        var html = template('templateLossImg', ret);
        $("#content").html(html);
    });
};