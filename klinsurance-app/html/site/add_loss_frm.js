/**
 * Created by Administrator on 2016/8/12.
 */
var loss_id;
function goList() {
    api.openWin({
        name: '/html/site/loss_list_win.html',
        url: api.wgtRootDir + '/html/site/loss_list_win.html',
        bounces: false,
        pageParam: {name: loss_id}
    });
}

function doChangeLoss(lossId,lossDetail,lossMoney){
    $("#loss-detail").val(lossDetail);
    $("#loss-money").val(lossMoney);
    loss_id = lossId;
}


$(function() {

    $("#form-loss").baseValidate({
        submitHandler: function(){
            alert("提交");
            api.closeWin({
                name: '/html/site/add_loss_win.html'
            });
        }
    });

    $(".btn").click(
        function() {
            $("#form-loss").submit();
        }
    );

});
