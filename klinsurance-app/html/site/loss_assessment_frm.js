var CustomDesignModule = null;
var imgSrc;
$(function () {
    $("li .flex-1").each(function () {
        if ($(this).height() > 20) {
            $(this).removeClass("text-right");
        }
    })
});

apiready = function () {
    CustomDesignModule = api.require('CustomDesignModule');
};


$(".zoom").click(
    function () {
        startDesigh();
    }
);

function startDesigh() {
    CustomDesignModule.startDesigh(function back(ret) {
        alert(ret.data)
        $(".sign img").attr("src", ret.data)
    });
}

$(".ul-one").click(function() {
    api.openWin({
        name: '/html/site/add_loss_win.html',
        url: api.wgtRootDir + '/html/site/add_loss_win.html',
        pageParam: {name: 'pageparamname'}
    });
});