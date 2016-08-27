var db;
var userId;
var lastSyncInfoObj = {};
var briefingListStr = null;
var briefingLossListStr = null;
var briefingLossImageListStr = null;
var briefingLossItemListStr = null;
var customerListStr = null;
var lossListStr = null;
var lossItemListStr = null;
var reportListStr = null;
var reportBriefingListStr = null;
var textTemplateListStr = null;

apiready = function () {
    db = api.require('db');
    userId = ht.storage.getLocalStorage(ht.constants.userId);
    userId = 1277;
    var lastSyncInfo = ht.storage.getLocalStorage(ht.constants.lastSyncInfo);
    if (lastSyncInfo) {
        lastSyncInfoObj = JSON.parse(lastSyncInfo);
        $("#lastSyncTime").html(lastSyncInfoObj.createTime);
        $("#lastSyncContent").html(lastSyncInfoObj.content);
    } else {
        $("#lastSyncTime").html("暂未同步，请同步数据");
        $("#lastSyncContent").html("暂未同步，请同步数据");
    }
    if (lastSyncInfoObj != null) {
        setBriefingListStr();
        setBriefingLossListStr();
        setBriefingLossImageListStr();
        setBriefingLossItemListStr();
        setCustomerListStr();
        setLossListStr();
        setLossItemListStr();
        setRreportListStr();
        setReportBriefingListStr();
        setTextTemplateListStr();
    }
};

//数据同步
function syncData() {
    ht.apicloud.showProgress("正在同步");
    api.ajax({
            url: ht.ip.insuranceservice + '/projectSyncLogAction/getCanSyncMessage',
            method: 'post',
            timeout: 50,
            dataType: 'json',
            returnAll: false,
            data: {
                values: {
                    userId: userId,
                    lastSyncTime: lastSyncInfoObj == null ? null : lastSyncInfoObj.createTime,
                    briefingListStr: briefingListStr,
                    briefingLossListStr: briefingLossListStr,
                    briefingLossImageListStr: briefingLossImageListStr,
                    briefingLossItemListStr: briefingLossItemListStr,
                    customerListStr: customerListStr,
                    lossListStr: lossListStr,
                    lossItemListStr: lossItemListStr,
                    reportListStr: reportListStr,
                    reportBriefingListStr: reportBriefingListStr,
                    textTemplateListStr: textTemplateListStr
                }
            }
        }, function (ret, err) {
            if (ret) {
                if (ret && ret.success) {
                    ht.storage.setLocalStorage(ht.constants.lastSyncInfo, ret.data.projectSyncLog);
                    lastSyncInfoObj = JSON.parse(ret.data.projectSyncLog);
                    $("#lastSyncTime").html(lastSyncInfoObj.createTime);
                    $("#lastSyncContent").html(lastSyncInfoObj.content);
                    if (ret.data.projectList) {
                        var projectList = JSON.parse(ret.data.projectList);
                        insertProject(projectList);
                    }
                    if (ret.data.customerList) {
                        var customerList = JSON.parse(ret.data.customerList);
                        insertCustomer(customerList);
                    }
                    if (ret.data.userList) {
                        var userList = JSON.parse(ret.data.userList);
                        insertUser(userList);
                    }
                    if (ret.data.textTemplateList) {
                        var textTemplateList = JSON.parse(ret.data.textTemplateList);
                        insertTextTemplate(textTemplateList);
                    }
                    if (ret.data.wordTemplateList) {
                        var wordTemplateList = JSON.parse(ret.data.wordTemplateList);
                        insertWordTemplate(wordTemplateList);
                    }
                    if (ret.data.lossItemDictList) {
                        var lossItemDictList = JSON.parse(ret.data.lossItemDictList);
                        insertLossItemDict(lossItemDictList);
                    }
                    updateIsSync();
                }
            } else {
                api.toast({
                    msg: '网络错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
            ht.apicloud.hideProgress();
        }
    )
    ;
}

function insertBriefing(datas) {
    $.each(datas, function (i, data) {
        var sql = 'INSERT INTO briefing (briefingId, briefingNo, userId, projectId, wordTemplateId, surveyTime, surveyPlace,' +
            ' surveyLat, surveyLng, insurer, insurerName, insurerPhone, surveyor, accidentDescription, lossDescription, ' +
            'nextWork, mainSurveyor, subSurveyor, manager, briefingFile, remark, createTime, isSync) VALUES ('
            + formatData(data.briefingId) + ','
            + formatData(data.briefingNo) + ','
            + formatData(data.userId) + ','
            + formatData(data.projectId) + ','
            + formatData(data.wordTemplateId) + ','
            + formatData(data.surveyTime) + ','
            + formatData(data.surveyPlace) + ','
            + formatData(data.surveyLat) + ','
            + formatData(data.surveyLng) + ','
            + formatData(data.insurer) + ','
            + formatData(data.insurerName) + ','
            + formatData(data.insurerPhone) + ','
            + formatData(data.surveyor) + ','
            + formatData(data.accidentDescription) + ','
            + formatData(data.lossDescription) + ','
            + formatData(data.nextWork) + ','
            + formatData(data.mainSurveyor) + ','
            + formatData(data.subSurveyor) + ','
            + formatData(data.manager) + ','
            + formatData(data.briefingFile) + ','
            + formatData(data.remark) + ','
            + formatData(data.createTime) + ','
            + formatData(0) + ')';
        db.selectSql({
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
        });
    });
}

function insertBriefingLoss(datas) {
    $.each(datas, function (i, data) {
        var sql = 'INSERT INTO briefing_loss (briefingLossId, briefingId, lossId, createTime, isSync) VALUES ('
            + formatData(data.briefingLossId) + ','
            + formatData(data.briefingId) + ','
            + formatData(data.lossId) + ','
            + formatData(data.createTime) + ','
            + formatData(0) + ')';
        db.selectSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                briefingLossListStr = JSON.stringify(ret.data);
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    });
}

function insertBriefingLossImage() {
    $.each(datas, function (i, data) {
        var sql = 'INSERT INTO briefing_loss_image (briefingLossImageId, briefingLossId, originalImage, image, description, ' +
            'createTime, isSync) VALUES ('
            + formatData(data.briefingLossImageId) + ','
            + formatData(data.briefingLossId) + ','
            + formatData(data.originalImage) + ','
            + formatData(data.image) + ','
            + formatData(data.description) + ','
            + formatData(data.createTime) + ','
            + formatData(0) + ')';
        db.selectSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                briefingLossImageListStr = JSON.stringify(ret.data);
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    });
}

function insertBriefingLossItem() {
    $.each(datas, function (i, data) {
        var sql = 'INSERT INTO briefing_loss_item (briefingLossItemId, briefingLossId, lossItemId, createTime, isSync) VALUES ('
            + formatData(data.briefingLossItemId) + ','
            + formatData(data.briefingLossId) + ','
            + formatData(data.lossItemId) + ','
            + formatData(data.createTime) + ','
            + formatData(0) + ')';
        db.selectSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                briefingLossItemListStr = JSON.stringify(ret.data);
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    });
}

function insertCustomer(datas) {
    $.each(datas, function (i, data) {
        var sql = 'INSERT INTO customer (customerId, name, linkMan, linkManPinyin, linkPhone, province, city, county, address,' +
            ' remark, createTime, superiorId, superior, classification, isSync) VALUES ('
            + formatData(data.customerId) + ','
            + formatData(data.name) + ','
            + formatData(data.linkMan) + ','
            + formatData(data.linkManPinyin) + ','
            + formatData(data.linkPhone) + ','
            + formatData(data.province) + ','
            + formatData(data.city) + ','
            + formatData(data.county) + ','
            + formatData(data.address) + ','
            + formatData(data.remark) + ','
            + formatData(data.createTime) + ','
            + formatData(data.superiorId) + ','
            + formatData(data.superior) + ','
            + formatData(data.classification) + ','
            + 0 + ')';
        db.executeSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                if (i == datas.length - 1) {
                    db.selectSql({
                        name: 'klinsurance_db.db',
                        sql: "SELECT count(*) FROM customer"
                    }, function (ret, err) {
                        alert(JSON.stringify(ret));
                        if (ret.status) {
                        } else {
                            api.toast({
                                msg: '数据错误，请稍后1重试！',
                                duration: 2000,
                                location: 'bottom'
                            });
                        }
                    });
                }
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    });
}

function insertUser(datas) {
    $.each(datas, function (i, data) {
        var sql = 'INSERT INTO user (userId, loginName, loginPwd, roleId, name, namePinyin, company, dept, tel, mobile,' +
            ' remark, createTime, email) VALUES ('
            + formatData(data.userId) + ','
            + formatData(data.loginName) + ','
            + formatData(data.loginPwd) + ','
            + formatData(data.roleId) + ','
            + formatData(data.name) + ','
            + formatData(data.namePinyin) + ','
            + formatData(data.company) + ','
            + formatData(data.dept) + ','
            + formatData(data.tel) + ','
            + formatData(data.mobile) + ','
            + formatData(data.remark) + ','
            + formatData(data.createTime) + ','
            + formatData(data.email) + ')';
        db.executeSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                if (i == datas.length - 1) {
                    db.selectSql({
                        name: 'klinsurance_db.db',
                        sql: "SELECT count(*) FROM user"
                    }, function (ret, err) {
                        alert(JSON.stringify(ret));
                        if (ret.status) {
                        } else {
                            api.toast({
                                msg: '数据错误，请稍后1重试！',
                                duration: 2000,
                                location: 'bottom'
                            });
                        }
                    });
                }
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    });
}

function insertLoss() {
    $.each(datas, function (i, data) {
        var sql = 'INSERT INTO loss (lossId, userId, projectId, place, customerSignPath, customerSignTime, remark,' +
            ' createTime, placeNo, isSync) VALUES ('
            + formatData(data.lossId) + ','
            + formatData(data.userId) + ','
            + formatData(data.projectId) + ','
            + formatData(data.place) + ','
            + formatData(data.customerSignPath) + ','
            + formatData(data.customerSignTime) + ','
            + formatData(data.remark) + ','
            + formatData(data.createTime) + ','
            + formatData(data.placeNo) + ','
            + formatData(0) + ')';
        db.selectSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                lossListStr = JSON.stringify(ret.data);
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    });
}

function insertLossItem() {
    $.each(datas, function (i, data) {
        var sql = 'INSERT INTO loss_item (lossItemId, projectId, lossId, lossItemName, lossNumber, length, width, height,' +
            ' price, realLossAmount, reportedLossAmount, remark, createTime, isSync) VALUES ('
            + formatData(data.lossItemId) + ','
            + formatData(data.projectId) + ','
            + formatData(data.lossId) + ','
            + formatData(data.lossItemName) + ','
            + formatData(data.lossNumber) + ','
            + formatData(data.length) + ','
            + formatData(data.width) + ','
            + formatData(data.height) + ','
            + formatData(data.price) + ','
            + formatData(data.realLossAmount) + ','
            + formatData(data.reportedLossAmount) + ','
            + formatData(data.remark) + ','
            + formatData(data.createTime) + ','
            + formatData(0) + ')';
        db.selectSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                lossItemListStr = JSON.stringify(ret.data);
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    });
}

function insertRreport() {
    $.each(datas, function (i, data) {
        var sql = 'INSERT INTO report (reportId, reportNo, userId, projectId, wordTemplateId, insureType, insureCode, insurer,' +
            ' insurerName, insureDeadline, insureAmount, deductible, accidentTime, accidentPlace, accidentCause, ' +
            'accidentPass, liabilityAffirm, reportedLossAmount, verifyLossAmount, adjustmentAmount, surveyor,' +
            ' certificateCode, forewordContent, objectDescription, surveyTime, surveyPlace, surveyCase, ' +
            'insurerRepresentative, surveySurveyor, claimantDescription, dangerTime, dangerPlace, damagedObject,' +
            ' dangerCase, iorderLiability, verifyLossGist, verifyLossProcess, repeatInsure, thirdLiability, ' +
            'deductibleSalvage, lossAdjustment, surveyorConclusion, reportFile, remark, createTime, clientId, isSync) VALUES ('
            + formatData(data.reportId) + ',' + formatData(data.reportNo) + ',' + formatData(data.userId) + ',' + formatData(data.projectId) + ','
            + formatData(data.wordTemplateId) + ',' + formatData(data.insureType) + ',' + formatData(data.insureCode) + ',' + formatData(data.insurer) + ','
            + formatData(data.insurerName) + ',' + formatData(data.insureDeadline) + ',' + formatData(data.insureAmount) + ','
            + formatData(data.deductible) + ',' + formatData(data.accidentTime) + ',' + formatData(data.accidentPlace) + ','
            + formatData(data.accidentCause) + ',' + formatData(data.accidentPass) + ',' + formatData(data.liabilityAffirm) + ','
            + formatData(data.reportedLossAmount) + ',' + formatData(data.verifyLossAmount) + ',' + formatData(data.adjustmentAmount) + ','
            + formatData(data.surveyCase) + ','
            + formatData(data.insurerRepresentative) + ',' + formatData(data.surveySurveyor) + ',' + formatData(data.claimantDescription) + ','
            + formatData(data.dangerTime) + ',' + formatData(data.dangerPlace) + ',' + formatData(data.damagedObject) + ','
            + formatData(data.dangerCase) + ',' + formatData(data.iorderLiability) + ',' + formatData(data.verifyLossGist) + ','
            + formatData(data.verifyLossProcess) + ',' + formatData(data.repeatInsure) + ',' + formatData(data.thirdLiability) + ','
            + formatData(data.deductibleSalvage) + ',' + formatData(data.lossAdjustment) + ',' + formatData(data.surveyorConclusion) + ','
            + formatData(data.reportFile) + ',' + formatData(data.remark) + ',' + formatData(data.createTime) + ','
            + formatData(data.clientId) + ',' + formatData(0) + ')';
        db.selectSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                reportListStr = JSON.stringify(ret.data);
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    });
}

function insertReportBriefing() {
    $.each(datas, function (i, data) {
        var sql = 'INSERT INTO report_briefing (reportBriefingId, reportId, briefingId, createTime, isSync) VALUES ('
            + formatData(data.reportBriefingId) + ','
            + formatData(data.reportId) + ','
            + formatData(data.briefingId) + ','
            + formatData(data.createTime) + ','
            + formatData(0) + ')';
        db.selectSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                reportBriefingListStr = JSON.stringify(ret.data);
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    });
}

function insertTextTemplate(datas) {
    $.each(datas, function (i, data) {
        var sql = 'INSERT INTO text_template (textTemplateId, name, content, tags, isShared, createTime, isSync) VALUES ('
            + formatData(data.textTemplateId) + ','
            + formatData(data.name) + ','
            + formatData(data.content) + ','
            + formatData(data.tags) + ','
            + formatData(data.isShared) + ','
            + formatData(data.createTime) + ','
            + 0 + ')';
        db.executeSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                if (i == datas.length - 1) {
                    db.selectSql({
                        name: 'klinsurance_db.db',
                        sql: "SELECT count(*) FROM text_template"
                    }, function (ret, err) {
                        alert(JSON.stringify(ret));
                        if (ret.status) {
                        } else {
                            api.toast({
                                msg: '数据错误，请稍后1重试！',
                                duration: 2000,
                                location: 'bottom'
                            });
                        }
                    });
                }
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    });
}

function insertWordTemplate(datas) {
    $.each(datas, function (i, data) {
        var sql = 'INSERT INTO word_template (wordTemplateId, name, type, filePath, remark, createTime) VALUES ('
            + formatData(data.wordTemplateId) + ','
            + formatData(data.name) + ','
            + formatData(data.type) + ','
            + formatData(data.filePath) + ','
            + formatData(data.remark) + ','
            + formatData(data.createTime) + ')';
        db.executeSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                if (i == datas.length - 1) {
                    db.selectSql({
                        name: 'klinsurance_db.db',
                        sql: "SELECT count(*) FROM word_template"
                    }, function (ret, err) {
                        alert(JSON.stringify(ret));
                        if (ret.status) {
                        } else {
                            api.toast({
                                msg: '数据错误，请稍后1重试！',
                                duration: 2000,
                                location: 'bottom'
                            });
                        }
                    });
                }
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    });
}

function insertLossItemDict(datas) {
    $.each(datas, function (i, data) {
        var sql = 'INSERT INTO loss_item_dict (lossItemDictId, lossItemDictPid, lossItemDictNo,' +
            ' name, priceUnit, numeraire, numeraireMsg, flag, remark, createTime) VALUES ('
            + formatData(data.lossItemDictId) + ','
            + formatData(data.lossItemDictPid) + ','
            + formatData(data.lossItemDictNo) + ','
            + formatData(data.name) + ','
            + formatData(data.priceUnit) + ','
            + formatData(data.numeraire) + ','
            + formatData(data.numeraireMsg) + ','
            + formatData(data.flag) + ','
            + formatData(data.remark) + ','
            + formatData(data.createTime) + ')';
        db.executeSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                if (i == datas.length - 1) {
                    db.selectSql({
                        name: 'klinsurance_db.db',
                        sql: "SELECT count(*) FROM loss_item_dict"
                    }, function (ret, err) {
                        alert(JSON.stringify(ret));
                        if (ret.status) {
                        } else {
                            api.toast({
                                msg: '数据错误，请稍后1重试！',
                                duration: 2000,
                                location: 'bottom'
                            });
                        }
                    });
                }
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    });
}

function insertProject(datas) {
    $.each(datas, function (i, data) {
        var sql = 'INSERT INTO project (proId, projectId, projectNo, userId, projectName, projectSponsor, projectTime, ' +
            'insureNo, insureName, insurerId, insurerName, accidentTime, accidentSite, accidentCause, responsibilityNo, ' +
            'responsibilityName, certificationCode, insureDeadline, remark, createTime, isSync) VALUES ('
            + formatData(data.proId) + ','
            + formatData(data.projectId) + ','
            + formatData(data.projectNo) + ','
            + formatData(data.userId) + ','
            + formatData(data.projectName) + ','
            + formatData(data.projectSponsor) + ','
            + formatData(data.projectTime) + ','
            + formatData(data.insureNo) + ','
            + formatData(data.insureName) + ','
            + formatData(data.insurerId) + ','
            + formatData(data.insurerName) + ','
            + formatData(data.accidentTime) + ','
            + formatData(data.accidentSite) + ','
            + formatData(data.accidentCause) + ','
            + formatData(data.responsibilityNo) + ','
            + formatData(data.responsibilityName) + ','
            + formatData(data.certificationCode) + ','
            + formatData(data.insureDeadline) + ','
            + formatData(data.remark) + ','
            + formatData(data.createTime) + ','
            + 0 + ')';
        db.executeSql({
            name: 'klinsurance_db.db',
            sql: sql
        }, function (ret, err) {
            if (ret.status) {
                if (i == datas.length - 1) {
                    db.selectSql({
                        name: 'klinsurance_db.db',
                        sql: "SELECT count(*) FROM project"
                    }, function (ret, err) {
                        alert(JSON.stringify(ret));
                        if (ret.status) {
                        } else {
                            api.toast({
                                msg: '数据错误，请稍后1重试！',
                                duration: 2000,
                                location: 'bottom'
                            });
                        }
                    });
                }
            } else {
                api.toast({
                    msg: '数据错误，请稍后重试！',
                    duration: 2000,
                    location: 'bottom'
                });
            }
        });
    });
}
//同步完成之后更新所有的本地表数据为已经同步
function updateIsSync() {
    db.executeSql({
        name: 'klinsurance_db.db',
        sql: "UPDATE briefing set isSync = 0 WHERE isSync= 1"
    }, function (ret, err) {
    });
    db.executeSql({
        name: 'klinsurance_db.db',
        sql: "UPDATE briefing_loss set isSync = 0 WHERE isSync= 1"
    }, function (ret, err) {
    });
    db.executeSql({
        name: 'klinsurance_db.db',
        sql: "UPDATE briefing_loss_image set isSync = 0 WHERE isSync= 1"
    }, function (ret, err) {
    });
    db.executeSql({
        name: 'klinsurance_db.db',
        sql: "UPDATE briefing_loss_item set isSync = 0 WHERE isSync= 1"
    }, function (ret, err) {
    });
    db.executeSql({
        name: 'klinsurance_db.db',
        sql: "UPDATE customer set isSync = 0 WHERE isSync= 1"
    }, function (ret, err) {
    });
    db.executeSql({
        name: 'klinsurance_db.db',
        sql: "UPDATE loss set isSync = 0 WHERE isSync= 1"
    }, function (ret, err) {
    });
    db.executeSql({
        name: 'klinsurance_db.db',
        sql: "UPDATE loss_item set isSync = 0 WHERE isSync= 1"
    }, function (ret, err) {
    });
    db.executeSql({
        name: 'klinsurance_db.db',
        sql: "UPDATE report set isSync = 0 WHERE isSync= 1"
    }, function (ret, err) {
    });
    db.executeSql({
        name: 'klinsurance_db.db',
        sql: "UPDATE report_briefing set isSync = 0 WHERE isSync= 1"
    }, function (ret, err) {
    });
    db.executeSql({
        name: 'klinsurance_db.db',
        sql: "UPDATE text_template set isSync = 0 WHERE isSync= 1"
    }, function (ret, err) {
    });
    ht.apicloud.hideProgress();
}
//设置当前用户未同步的数据
function setBriefingListStr() {
    db.selectSql({
        name: 'klinsurance_db.db',
        sql: "SELECT * FROM briefing where isSync = 1"
    }, function (ret, err) {
        if (ret.status) {
            briefingListStr = JSON.stringify(ret.data);
        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
}

function setBriefingLossListStr() {
    db.selectSql({
        name: 'klinsurance_db.db',
        sql: "SELECT * FROM briefing_loss where isSync = 1"
    }, function (ret, err) {
        if (ret.status) {
            briefingLossListStr = JSON.stringify(ret.data);
        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
}

function setBriefingLossImageListStr() {
    db.selectSql({
        name: 'klinsurance_db.db',
        sql: "SELECT * FROM briefing_loss_image where isSync = 1"
    }, function (ret, err) {
        if (ret.status) {
            briefingLossImageListStr = JSON.stringify(ret.data);
        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
}

function setBriefingLossItemListStr() {
    db.selectSql({
        name: 'klinsurance_db.db',
        sql: "SELECT * FROM briefing_loss_item where isSync = 1"
    }, function (ret, err) {
        if (ret.status) {
            briefingLossItemListStr = JSON.stringify(ret.data);
        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
}

function setCustomerListStr() {
    db.selectSql({
        name: 'klinsurance_db.db',
        sql: "SELECT * FROM customer where isSync = 1"
    }, function (ret, err) {
        if (ret.status) {
            customerListStr = JSON.stringify(ret.data);
        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
}

function setLossListStr() {
    db.selectSql({
        name: 'klinsurance_db.db',
        sql: "SELECT * FROM loss where isSync = 1"
    }, function (ret, err) {
        if (ret.status) {
            lossListStr = JSON.stringify(ret.data);
        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
}

function setLossItemListStr() {
    db.selectSql({
        name: 'klinsurance_db.db',
        sql: "SELECT * FROM loss_item where isSync = 1"
    }, function (ret, err) {
        if (ret.status) {
            lossItemListStr = JSON.stringify(ret.data);
        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
}

function setRreportListStr() {
    db.selectSql({
        name: 'klinsurance_db.db',
        sql: "SELECT * FROM report where isSync = 1"
    }, function (ret, err) {
        if (ret.status) {
            reportListStr = JSON.stringify(ret.data);
        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
}

function setReportBriefingListStr() {
    db.selectSql({
        name: 'klinsurance_db.db',
        sql: "SELECT * FROM report_briefing where isSync = 1"
    }, function (ret, err) {
        if (ret.status) {
            reportBriefingListStr = JSON.stringify(ret.data);
        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
}

function setTextTemplateListStr() {
    db.selectSql({
        name: 'klinsurance_db.db',
        sql: "SELECT * FROM text_template where isSync = 1"
    }, function (ret, err) {
        if (ret.status) {
            textTemplateListStr = JSON.stringify(ret.data);
        } else {
            api.toast({
                msg: '数据错误，请稍后重试！',
                duration: 2000,
                location: 'bottom'
            });
        }
    });
}

//格式化数据
function formatData(data) {
    return data != undefined && data ? '"' + data + '"' : null;
}