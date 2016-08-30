var pageParam;
var db;
var customDesignModule;
apiready = function () {
    pageParam=api.pageParam;
    customDesignModule = api.require('CustomDesignModule');
    db = api.require('db');
    loadData();
};
// 加载数据
function loadData() {
    var sql = "SELECT * FROM loss where lossId='"+pageParam.lossId+"'";
    db.selectSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
               if(ret.data.length>0){
                   var loss=ret.data[0];
                   if(!!loss.customerSignPath){
                       $("#customer1").attr("src", loss.customerSignPath);
                   }
                   if(!!loss.customerSignPath2){
                       $("#customer2").attr("src", loss.customerSignPath2);
                   }
                   if(!!loss.customerSignPath3){
                       $("#customer3").attr("src", loss.customerSignPath3);
                   }
                   if(!!loss.customerSignPath4){
                       $("#customer4").attr("src", loss.customerSignPath4);
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
//打开签名插件
function startDesigh(id) {
    customDesignModule.startDesigh(function back(ret) {
        var path=JSON.parse(ret.data).picUri;
        $("#customer"+id).attr("src",path);
        var sql="update loss set "
        if(id=='1'){
            sql=sql+"customerSignPath='"+path+"',customerSignTime=datetime('now')"
        }else if(id=='2'){
            sql=sql+"customerSignPath2='"+path+"',customerSignTime2=datetime('now')"
        }else if(id=='3'){
            sql=sql+"customerSignPath3='"+path+"',customerSignTime3=datetime('now')"
        }else if(id=='4'){
            sql=sql+"customerSignPath4='"+path+"',customerSignTime4=datetime('now')"
        }
        db.executeSql({
                name: 'klinsurance_db.db',
                sql: sql
            }, function (ret, err) {
                if (ret.status) {

                } else {
                    api.toast({
                        msg: '数据错误，请稍后重试！',
                        duration: 2000,
                        location: 'bottom'
                    });
                }
            }
        );
    });
}