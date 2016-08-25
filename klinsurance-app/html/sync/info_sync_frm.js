var db;
var userId;
var lastSyncInfoObj = {};
apiready = function () {
    userId = ht.storage.getLocalStorage(ht.constants.userId);
    var lastSyncInfo = ht.storage.getLocalStorage(ht.constants.lastSyncInfo);
    if (lastSyncInfo) {
        lastSyncInfoObj = JSON.parse(lastSyncInfo);
        $("#lastSyncTime").html(lastSyncInfoObj.createTime);
        $("#lastSyncContent").html(lastSyncInfoObj.count);
    } else {
        $("#lastSyncTime").html("暂未同步，请同步数据");
        $("#lastSyncContent").html("暂未同步，请同步数据");
    }
    if (lastSyncInfoObj != null) {

    }
};

function setBriefingListStr() {
    db.selectSql({
        name: 'klinsurance_db.db',
        sql: "SELECT * FROM crm_customer where type = " + custType + " and user_id = '" + userId + "'"
    }, function (ret, err) {
        if (ret.status) {

        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
}


//数据同步
function syncData() {
    api.ajax({
        url: ht.ip.insuranceservice + '/projectSyncLogAction/getCanSyncMessage',
        method: 'post',
        timeout: 30,
        dataType: 'json',
        returnAll: false,
        data: {
            values: {
                userId: userId,
                lastSyncTime: lastSyncInfoObj == null ? null : lastSyncInfoObj.createTime,
                briefingListStr: userId,
                briefingLossListStr: userId,
                briefingLossImageListStr: userId,
                briefingLossItemListStr: userId,
                customerListStr: userId,
                lossListStr: userId,
                lossItemListStr: userId,
                reportListStr: userId,
                reportBriefingListStr: userId,
                textTemplateListStr: userId
            }
        }
    }, function (ret, err) {
        if (ret) {
            if (ret && ret.success) {
                ht.storage.setLocalStorage(ht.constants.isFirstCust, 0);
                //插入本地数据并更新远程数据
                addLocalCustAndUpdateRemote(ret.data);
            }
        } else {
            api.toast({
                msg: '网络错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
}