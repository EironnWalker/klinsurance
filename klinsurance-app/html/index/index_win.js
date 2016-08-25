var url;
var db;
apiready = function () {
    db = api.require('db');
    var fs = api.require('fs');
    fs.exist({
        path: 'fs://klinsurance_db.db'
    }, function (ret, err) {
        if (ret.exist) {
            db.openDatabase({
                name: 'klinsurance_db.db',
                path: 'fs://klinsurance_db.db'
            }, function (ret, err) {
            });
        } else {
            fs.copyTo({
                oldPath: 'widget://wgt/klinsurance_db.db',
                newPath: 'fs://'
            }, function (ret, err) {
                if (ret.status) {
                    db.openDatabase({
                        name: 'klinsurance_db.db',
                        path: 'fs://klinsurance_db.db'
                    }, function (ret, err) {
                    });
                }
            });
        }
    });
    $(".home-list a").click(function () {
        url = $(this).attr("data-href");
        if (url == "info") {
            api.openWin({
                name: '/html/sync/info_sync_win.html',
                url: api.wgtRootDir + '/html/sync/info_sync_win.html',
                bounces: false
            });
        }
        else if (url == "site") {
            api.openWin({
                name: '/html/site/project_info_win.html',
                url: api.wgtRootDir + '/html/site/project_info_win.html',
                pageParam: {type: 'site'},
                bounces: false
            });
        }
        else if (url == "report") {
            api.openWin({
                name: '/html/site/project_info_win.html',
                url: api.wgtRootDir + '/html/site/project_info_win.html',
                pageParam: {type: 'report'},
                bounces: false
            });
        }
        else if (url == "temp") {
            api.openWin({
                name: '/html/temp/select_win.html',
                url: api.wgtRootDir + '/html/temp/select_win.html',
                bounces: false
            });
        }
    });
};