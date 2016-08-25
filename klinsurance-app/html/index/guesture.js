var exitNum = 0;//退出次数
var rightCode = '';//退出次数
apiready = function () {
    //双击返回退出
    exitApp();
    if(ht.storage.getLocalStorage(ht.constants.rightCode)){
        rightCode = ht.storage.getLocalStorage(ht.constants.rightCode);
    }
    var mode = 0;
    if(!rightCode){
        $("#title").html('请设置手势密码');
        mode = 1;
    }
    var patternLock = api.require('patternLock');
    patternLock.addPatternLock({
        viewName: '/html/index/guesture.html',
        rightColor: '#00FF00',
        drawColor: '#222222',
        wrongColor: '#FF0000',
        normalColor: '#000000',
        frame: '{{0,100},{320,300}}',
        mode: mode,
        rightCode: rightCode
    }, function(ret, err) {
        if (ret) {
            if(ret.status ==0) {
                goIndex();
            }else if(ret.status ==1){
                $("#title").html('手势密码错误');
            }else if(ret.status ==2){
                $("#title").html('请再次输入手势密码');
            }else if(ret.status ==3){
                $("#title").html('两次输入不一致，请再次输入');
            }else if(ret.status ==4){
                ht.storage.setLocalStorage(ht.constants.rightCode,ret.code);
                goIndex();
            }
        } else {
            alert(JSON.stringify(err));
        }
    });
};

//添加返回按钮的监听
function exitApp() {
    api.addEventListener({
        name: 'keyback'
    }, function (ret, err) {
        if (exitNum == 0) {
            exitNum = 1;
            api.toast({
                msg: '再次点击返回退出应用',
                duration: 2000,
                location: 'bottom'
            });
            setTimeout(function(){
                exitNum = 0;
            },2000)
        } else {
            api.closeWidget({
                id: api.appId,  //填写自己的id
                retData: {name: 'closeWidget'},
                silent: true
            });
        }
    });
}
//添加返回按钮的监听
function goIndex() {
    api.openWin({
        name: '/html/index/index_win.html',
        url: 'index_win.html',
        bounces: false,
        slidBackEnabled:false
    });
}
