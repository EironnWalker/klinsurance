var speechDistinguish  = true;//录完的话是否已经识别
var speechFinish = false;//是否点击完毕按钮
//语音转换文字切换
function speakClick(index){
    if(!speechDistinguish){
        api.toast({
            msg: '语音识别中，请稍后！',
            duration: 2000,
            location: 'bottom'
        });
        return;
    }
    speechDistinguish = false;
    $("#say").show();
    var speechRecognizer = api.require('speechRecognizer');
    speechFinish = false;
    speechRecognizer.record({
        vadbos:5000,
        vadeos:5000,
        rate:16000,
        asrptt:1
    }, function(ret, err) {
        if (ret.status) {
            $("#"+index).val(ret.wordStr);
        }
        speechDistinguish = true;
        speechRecognizer.cancelRecord();
        $("#say").hide();
    });
}
//关闭语音
function finishSay() {
    speechFinish = true;
    $("#say").hide();
}