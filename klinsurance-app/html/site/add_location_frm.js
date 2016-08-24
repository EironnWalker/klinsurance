var paramLocation;
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