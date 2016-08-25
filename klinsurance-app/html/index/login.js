var exitNum = 0;//退出次数
apiready = function () {
    //双击返回退出
    exitApp();

    $("#form").baseValidate(function () {
        ht.apicloud.showProgress('正在提交');
        api.ajax({
            url: ht.ip.insuranceservice + "/userAction/login",
            method: 'post',
            timeout: 30,
            dataType: 'json',
            returnAll: false,
            data: {
                values:{
                    userJson:JSON.stringify(form2json('form'))
                }
            }
        }, function (ret, err) {
            ht.apicloud.hideProgress();
            if (!!ret) {
                if(ret.success){
                    //$("#loginName").val(null);
                    //$("#loginPwd").val(null);
                    //存storage
                    ht.storage.setLocalStorage(ht.constants.userId, ret.data.userId);
                    ht.storage.setLocalStorage(ht.constants.loginName, ret.data.loginName);
                    ht.storage.setLocalStorage(ht.constants.name, ret.data.name);
                    ht.storage.setLocalStorage(ht.constants.phone, ret.data.mobile);
                    setLockPwd();
                    goGuesture()
                }else{
                    api.toast({
                        msg: ret.data,
                        duration: 2000,
                        location: 'bottom'
                    });
                }
            } else {
                api.toast({
                    msg: "网络错误，请稍后重试！",
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    });
};

//登录
$("#loginBtn").click(function () {
    $("#form").submit();
});

//设置手势密码
function setLockPwd(){
    var patternLock = api.require('patternLock');
    patternLock.addPatternLock({
        viewName: '/html/index/login.html',
        rightColor: '#00FF00',
        drawColor: '#222222',
        wrongColor: '#FF0000',
        normalColor: '#000000',
        frame: '{{0,100},{320,300}}',
        mode: '1',
        rightCode: ''
    }, function(ret, err) {
        if (ret) {
            alert(JSON.stringify(ret));
        } else {
            alert(JSON.stringify(err));
        }
    });
}
//跳到手势页面
function goGuesture() {
    api.openWin({
        name: '/html/index/guesture.html',
        url: 'guesture.html',
        bounces: false,
        slidBackEnabled:false
    });
}

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
