var loss_id;
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
apiready=function(){

}
//进入损失项列表
function goLossList() {
    api.openWin({
        name: '/html/site/loss_list_win.html',
        url: api.wgtRootDir + '/html/site/loss_list_win.html',
        bounces: false
    });
}
//选中损失项回调
function selLossSuccess(dictId,name,numeraireMsg){
    alert(dictId+":"+name+":"+numeraireMsg);
}
function doChangeLoss(lossId,lossDetail,lossMoney){
    $("#loss-detail").val(lossDetail);
    //$("#loss-money").val(lossMoney);
    loss_id = lossId;
}