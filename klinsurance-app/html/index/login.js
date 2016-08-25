apiready = function () {
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
                    $("#loginName").val(null);
                    $("#loginPwd").val(null);
                    //存storage
                    ht.storage.setLocalStorage(ht.constants.userId, ret.data.userId);
                    ht.storage.setLocalStorage(ht.constants.loginName, ret.data.loginName);
                    ht.storage.setLocalStorage(ht.constants.name, ret.data.name);
                    ht.storage.setLocalStorage(ht.constants.phone, ret.data.mobile);
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

//跳到手势页面
function goGuesture() {
    api.openWin({
        name: '/html/index/guesture.html',
        url: 'guesture.html',
        bounces: false,
        slidBackEnabled:false
    });
}
