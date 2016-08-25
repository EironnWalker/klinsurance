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
};
//数据同步
function syncData() {

}