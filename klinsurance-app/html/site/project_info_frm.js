var pageType;
var TranslateModule = null;
$(function () {

});

apiready = function () {
    pageType = api.pageParam.type;
    TranslateModule = api.require('TranslateModule');
};

function goLocationList() {
    if (pageType == 'site') {
        api.openWin({
            name: '/html/site/location_list_win.html',
            url: api.wgtRootDir + '/html/site/location_list_win.html',
            pageParam: {id: 'pageparamname'}
        });
    } else if (pageType == 'report') {
        api.openWin({
            name: '/html/report/report_win.html',
            url: api.wgtRootDir + '/html/report/report_win.html',
            pageParam: {id: 'pageparamname'}
        });
    }
}

$(".icon-record").click(
    function() {
        startRecord($(this).attr('data-id'));
    }
);

function startRecord(id){
    TranslateModule.startRecord(function back(ret){
        $('#'+id).val(ret.data);
    });
}