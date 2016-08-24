var json_loss = {
    list: [
        {id: '001', title: '损失项1', detail: '111损失项损失项损失项损失项', money: 100},
        {id: '002', title: '损失项2', detail: '222损失项损失项损失项损失项', money: 200},
        {id: '003', title: '损失项3', detail: '333损失项损失项损失项损失项', money: 300}
    ]
};
var loss_id, loss_detail, loss_money;
var loss_html = template("loss-template", json_loss);

$(function () {
    $("#loss-ul").html(loss_html)

    $('.div-select').click(function () {
        $(this).find('input[type="radio"]')[0].checked = true;
        loss_id = $(this).find("input").attr("id");
        loss_detail = $(this).find(".detail").text();
        loss_money = $(this).find("span span").text();
    });

});

apiready = function () {
    loss_id = api.pageParam.name;

    selectById();
    api.setRefreshHeaderInfo({
        visible: true,
        loadingImg: '',
        bgColor: '#ebebeb',
        textColor: '#333',
        textDown: '下拉刷新',
        textUp: '松开刷新',
        showTime: true
    }, function (ret, err) {
        alert(1);
        api.refreshHeaderLoadDone();
    });

    api.addEventListener({
        name:'scrolltobottom',
        extra:{
            threshold:0 //设置距离底部多少距离时触发，默认值为0，数字类型
        }
    },function(data,err){
        //if(!page || page.isLastPage){
        //    api.toast({
        //        msg: '没有更多数据了！',
        //        duration: 2000,
        //        location: 'bottom'
        //    });
        //}else{
        //    loadData(page.nextPage,false);
        //}
        alert(2);
    });

};


function selectLoss() {
    api.execScript({
        name: '/html/site/add_loss_win.html',
        frameName: '/html/site/add_loss_frm.html',
        script: 'doChangeLoss("'+loss_id+'","'+loss_detail+'","'+loss_money+'");'
    });
}

function selectById() {
    if(loss_id == null) {
        $("li:first-of-type .div-select").click();
    }
    else {
        $("#"+loss_id).parent(".div-select").click();
    }
}