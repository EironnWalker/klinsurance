var BaiduPush = null;
var paramLocation;
var locationJson;
apiready = function() {
    BaiduPush = api.require('LocationModule');
    BaiduPush.initDb();//将模块中的数据库写入手机
    $(".icon-location").click();
};
$(".icon-location").click(function() {
    BaiduPush.startLocation(function (ret,err) {
        locationJson = JSON.parse(ret.data);
        $("#location").val(locationJson.province + locationJson.city + locationJson.district + locationJson.street);
    });
});
$(function() {
    $("#form-location").baseValidate({
        submitHandler: function() {
            paramLocation = $("input[name='location']").val();

            //在名为winName的window中找到
            //名为frmName的frame，并在该frame中执行jsfun脚本
            api.execScript({
                name: '/html/site/location_list_win.html',
                frameName: '/html/site/location_list_frm.html',
                script: 'newLocation("'+paramLocation+'");'
            });
            api.closeWin({
                name: '/html/site/add_location_win.html'
            });
        }
    });
    $(".btn").click(
        function() {
            $("#form-location").submit();
        }
    );
})