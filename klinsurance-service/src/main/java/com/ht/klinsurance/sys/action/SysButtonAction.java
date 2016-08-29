package com.ht.klinsurance.sys.action;

import com.ht.common.gson.HtGson;
import com.ht.common.http.HtResponse;
import com.ht.common.utils.UUIDGenerate;
import com.ht.klinsurance.sys.model.SysButton;
import com.ht.klinsurance.sys.service.ISysButtonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 按钮管理
 *
 * @author liuqi
 * @date 2015/8/27
 */
@Controller
@RequestMapping("sysButtonAction")
public class SysButtonAction {
    @Resource
    private ISysButtonService sysButtonService;

    /**
     * 查询按钮列表
     *
     * @param menuCode
     * @param response
     */
    @RequestMapping("findSysButtonList")
    public void findSysButtonList(String menuCode, HttpServletResponse response) {
        List<SysButton> roleList = sysButtonService.findSysButtonList(menuCode);
        HtResponse.outJson(response, true, roleList);
    }

    /**
     * 根据角色查询
     *
     * @param menuCode
     * @param roleId
     * @param response
     */
    @RequestMapping("findSysButtonListByTreeCode")
    public void findSysButtonListByTreeCode(String menuCode, String roleId, HttpServletResponse response) {
        List<SysButton> roleList = sysButtonService.findSysButtonListByTreeCode(menuCode, roleId);
        HtResponse.outJson(response, true, roleList);
    }

    /**
     * 添加按钮
     *
     * @param sysButtonJson
     * @param response
     */
    @RequestMapping("addSysButton")
    public void addSysButton(String sysButtonJson, HttpServletResponse response) {
        SysButton sysButton = HtGson.fromJson(sysButtonJson, SysButton.class);
        sysButton.setButtonId(UUIDGenerate.generate());
        int result = sysButtonService.addSysButton(sysButton);
        if (result > 0) {
            HtResponse.outJson(response, true, String.valueOf(result));
        } else {
            HtResponse.outJson(response, false, String.valueOf(result));
        }
    }

    /**
     * 修改按钮
     *
     * @param sysButtonJson
     * @param response
     */
    @RequestMapping("updateSysButton")
    public void updateSysButton(String sysButtonJson, HttpServletResponse response) {
        SysButton sysButton;
        sysButton = HtGson.fromJson(sysButtonJson, SysButton.class);
        int result = sysButtonService.updateSysButton(sysButton);
        if (result > 0) {
            HtResponse.outJson(response, true, String.valueOf(result));
        } else {
            HtResponse.outJson(response, false, String.valueOf(result));
        }
    }

    /**
     * 删除
     *
     * @param buttonId
     * @param response
     */
    @RequestMapping("deleteSysButtonById")
    public void deleteSysButtonById(String buttonId, HttpServletResponse response) {
        int result = sysButtonService.deleteSysButtonById(buttonId);
        if (result > 0) {
            HtResponse.outJson(response, true, String.valueOf(result));
        } else {
            HtResponse.outJson(response, false, String.valueOf(result));
        }
    }
}
