var db;
var pageParam;
$(function() {
    $("#form-loss").baseValidate({
        submitHandler: function(){
            var sql;
            if(pageParam.isEdit){//编辑update
                sql="update loss_item";
                sql=sql+" set lossItemDictId='"+ $("#lossId").val()+"',lossItemName='"+$("#lossName").val()+"'";
                if(!!$("[name='num']").val()){
                    sql=sql+",lossNumber='"+$("[name='num']").val()+"'";
                }else{
                    sql=sql+",lossNumber=''";
                }
                if(!!$("[name='long']").val()){
                    sql=sql+",length='"+$("[name='long']").val()+"'"
                }else{
                    sql=sql+",length=''";
                }
                if(!!$("[name='width']").val()){
                    sql=sql+",width='"+$("[name='width']").val()+"'"
                }else{
                    sql=sql+",width=''";
                }
                if(!!$("[name='height']").val()){
                    sql=sql+",height='"+$("[name='height']").val()+"'"
                }else{
                    sql=sql+",height=''";
                }
                if(!!$("[name='description']").val()){
                    sql=sql+",remark='"+$("[name='description']").val()+"'"
                }else{
                    sql=sql+",remark=''";
                }
                sql=sql+" where lossItemId='"+pageParam.lossItemId+"'";
            }else{//新增insert
                sql = "insert into loss_item(lossItemId,projectId,lossId,lossItemDictId,lossItemName,createTime,isSync";
                if(!!$("[name='num']").val()){
                    sql=sql+",lossNumber"
                }
                if(!!$("[name='long']").val()){
                    sql=sql+",length"
                }
                if(!!$("[name='width']").val()){
                    sql=sql+",width"
                }
                if(!!$("[name='height']").val()){
                    sql=sql+",height"
                }
                if(!!$("[name='description']").val()){
                    sql=sql+",remark"
                }
                sql=sql+") values('"+ ht.uuid()+"','"+pageParam.projectId+"','"+pageParam.lossId+"','"+
                    $("#lossId").val()+"','"+$("#lossName").val()+"',datetime('now'),0";
                if(!!$("[name='num']").val()){
                    sql=sql+",'"+$("[name='num']").val()+"'"
                }
                if(!!$("[name='long']").val()){
                    sql=sql+",'"+$("[name='long']").val()+"'"
                }
                if(!!$("[name='width']").val()){
                    sql=sql+",'"+$("[name='width']").val()+"'"
                }
                if(!!$("[name='height']").val()){
                    sql=sql+",'"+$("[name='height']").val()+"'"
                }
                if(!!$("[name='description']").val()){
                    sql=sql+",'"+$("[name='description']").val()+"'"
                }
                sql=sql+")";
            }
            db.executeSql({
                    name: 'klinsurance_db.db',
                    sql: sql
                }, function (ret, err) {
                    if (ret.status) {
                        api.closeWin();
                        api.execScript({
                            name: '/html/site/loss_assessment_win.html',
                            frameName: '/html/site/loss_assessment_frm.html',
                            script: 'loadData();'
                        });
                    } else {
                        api.toast({
                            msg: '数据错误，请稍后重试！',
                            duration: 2000,
                            location: 'bottom'
                        });
                    }
                }
            );

        }
    });
    $(".btn").click(
        function() {
            $("#form-loss").submit();
        }
    );

});
apiready=function(){
    db = api.require('db');
    pageParam=api.pageParam;
    if(pageParam.isEdit){//如果是编辑，查询显示数据
        loadItem(pageParam.lossItemId);
    }
}
//进入损失项列表
function goLossList() {
    api.openWin({
        name: '/html/site/loss_list_win.html',
        url: api.wgtRootDir + '/html/site/loss_list_win.html',
        bounces: false
    });
}
//编辑时加载损失项信息
function loadItem(lossItemId){
    var sql="SELECT "+
        "a.*,b.numeraireMsg,b.flag"+
        " FROM"+
        " loss_item a"+
        " LEFT JOIN loss_item_dict b ON a.lossItemDictId = b.lossItemDictId"+
        " where a.lossItemId='"+lossItemId+"'";
    db.selectSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                if(ret.data.length>0){
                    var lossItem=ret.data[0];
                    selLossSuccess(lossItem.lossItemDictId,lossItem.lossItemName,lossItem.numeraireMsg,lossItem.flag);
                    if(!!lossItem.lossNumber){
                        $("[name='num']").val(lossItem.lossNumber);
                    }
                    if(!!lossItem.length){
                        $("[name='long']").val(lossItem.length);
                    }
                    if(!!lossItem.width){
                        $("[name='width']").val(lossItem.width);
                    }
                    if(!!lossItem.height){
                        $("[name='height']").val(lossItem.height);
                    }
                    if(!!lossItem.remark){
                        $("[name='description']").val(lossItem.remark);
                    }
                }
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        }
    );
}
//选中损失项回调
function selLossSuccess(dictId,name,numeraireMsg,flag){
    $("#lossName").val(name);
    $("#lossId").val(dictId);
    $("#units").text(numeraireMsg);
    if(numeraireMsg=="m³"){//根据单位显示长、宽、高
        $("#long").show();
        $("#width").show();
        $("#height").show();
    }else if(numeraireMsg=="㎡"){
        $("#long").show();
        $("#width").show();

        $("#height").hide();
        $("[name='height']").val("");
    }else if(numeraireMsg=="m"){
        $("#long").show();

        $("#width").hide();
        $("#height").hide();
        $("[name='width']").val("");
        $("[name='height']").val("");
    }else{
        $("#long").hide();
        $("#width").hide();
        $("#height").hide();
        $("[name='long']").val("");
        $("[name='width']").val("");
        $("[name='height']").val("");
    }
    if(flag=="1"){//是否需要计算
        $("[name='long']").blur(function(){
            countNum();
        });
        $("[name='width']").blur(function(){
            countNum();
        });
        $("[name='height']").blur(function(){
            countNum();
        });
    }else{
        $("[name='long']").unbind("blur");
        $("[name='width']").unbind("blur");
        $("[name='height']").unbind("blur");
    }
}
//计算数量
function countNum(){
    var long=$("[name='long']").val();
    var width=$("[name='width']").val();
    var height=$("[name='height']").val();
    if(!!long){
        if(!!width){
          if(!!height){
              $("[name='num']").val(parseInt(long)*parseInt(width)*parseInt(height));
          } else{
              $("[name='num']").val(parseInt(long)*parseInt(width));
          }
        }else{
            $("[name='num']").val(parseInt(long));
        }
    }
}
