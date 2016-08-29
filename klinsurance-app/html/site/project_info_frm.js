var totalPages;  // 定义一个变量存储第一次加载返回来的总页数
var nowPage = 1;  //定义一个变量存储当前的页数
var limitNum = 20;  //每页数据条数
var pageType;
var TranslateModule = null;
var db;
var searchContent;
apiready = function () {
    db = api.require('db');
    pageType = api.pageParam.type;
    TranslateModule = api.require('TranslateModule');
    //queryTotalPage();
    // 下拉刷新
    api.setRefreshHeaderInfo({
        visible: true,
        loadingImg: '',//下拉刷新的图片
        bgColor: '#ebebeb',
        textColor: '#000',
        textDown: '下拉刷新...',
        textUp: '松开刷新...',
        showTime: true
    }, function (ret, err) {
        loadData(1); // 第一次加载
    });
    //上滑加载更多
    api.addEventListener({
        name: 'scrolltobottom',
        extra: {
            threshold: 0 //设置距离底部多少距离时触发，默认值为0，数字类型
        }
    }, function (ret, err) {
        var _page = nowPage;
        if (_page + 1 <= totalPages) {
            loadData(_page + 1);
            nowPage = _page + 1; // 页码+1
        }
        else {
            api.toast({
                msg: '没有更多数据了！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
};
//查询共有多少条数据
function queryTotalPage(content) {
    searchContent = content;
    var sql = "SELECT count(*) as total FROM project ";
    if (searchContent) {
        sql += "where projectName like '%" + searchContent + "%'";
    }
    db.selectSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                if (ret.data[0].total > 0) {
                    totalPages = Math.ceil(ret.data[0].total / limitNum);
                    if (totalPages > 0) {
                        loadData(0); // 第一次加载
                    }
                }
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        }
    )
    ;
}
// 加载数据
// @currentPage:当前页码
// @isReload：是否为刷新操作
function loadData(nowPage1) {
    if (nowPage1 == 0) {
        ht.apicloud.showProgress("正在加载");
        nowPage1 = 1;
    }
    var sql = "SELECT * FROM project ";
    if (searchContent) {
        sql += "where projectName like '%" + searchContent + "%'";
    }
    sql += "limit " + (nowPage1 - 1) * limitNum + "," + (nowPage1 * limitNum);
    db.selectSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                var html = template('templateProject', ret);
                if (nowPage1 == 1) {
                    $("#content").html(html);
                } else {
                    $("#content").append(html);
                }
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

function goLocationList(projectId) {
    if (pageType == 'site') {
        api.openWin({
            name: '/html/site/location_list_win.html',
            url: api.wgtRootDir + '/html/site/location_list_win.html',
            pageParam: {projectId: projectId}
        });
    } else if (pageType == 'report') {
        api.openWin({
            name: '/html/report/report_win.html',
            url: api.wgtRootDir + '/html/report/report_win.html',
            pageParam: {projectId: projectId}
        });
    }
}
