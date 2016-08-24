var TranslateModule = null;

apiready = function () {
    TranslateModule = api.require('TranslateModule');
};

function goAssessLoss() {
    api.openWin({
        name: '/html/site/loss_assessment_win.html',
        url: api.wgtRootDir + '/html/site/loss_assessment_win.html',
        pageParam: {name: 'pageparamname'}
    });
}

function newLocation(paramLoacation) {
    alert('新地点为' + paramLoacation)
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