var rightCode = '';//退出次数
apiready = function () {
    if (ht.storage.getLocalStorage(ht.constants.rightCode)) {
        rightCode = ht.storage.getLocalStorage(ht.constants.rightCode);
    }
    var mode = 0;
    if (!rightCode) {
        $("#title").html('请设置手势密码');
        mode = 1;
    }
    var left = (api.winWidth - 320) / 2;
    var top = api.winWidth * 0.44;
    var patternLock = api.require('patternLock');
    patternLock.addPatternLock({
        viewName: '/html/index/guesture.html',
        rightColor: '#00FF00',
        drawColor: '#222222',
        wrongColor: '#FF0000',
        normalColor: '#FFFFFF',
        frame: '{{'+left+','+top+'},{320,300}}',
        mode: mode,
        rightCode: rightCode
    }, function (ret, err) {
        if (ret) {
            if (ret.status == 0) {
                goIndex();
            } else if (ret.status == 1) {
                $("#title").html('手势密码错误');
            } else if (ret.status == 2) {
                $("#title").html('请再次输入手势密码');
            } else if (ret.status == 3) {
                $("#title").html('两次输入不一致，请重新输入');
            } else if (ret.status == 4) {
                ht.storage.setLocalStorage(ht.constants.rightCode, ret.code);
                goIndex();
            }
        } else {
            alert(JSON.stringify(err));
            api.toast({
                msg: '手势密码模块错误，请退出重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
};

function goIndex() {
    api.openWin({
        name: '/html/index/index_win.html',
        url: 'index_win.html',
        bounces: false,
        slidBackEnabled: false
    });
}
