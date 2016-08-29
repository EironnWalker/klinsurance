package com.ht.klinsurance.sys.action;

import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.http.HtResponse;
import com.ht.klinsurance.sys.model.SysButton;
import com.ht.klinsurance.sys.model.SysRoleButton;
import com.ht.klinsurance.sys.model.SysRoleMenu;
import com.ht.klinsurance.sys.service.ISysRoleButtonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 角色按钮权限Action
 *
 * @author lindp
 * @date 2016/5/14
 */
@Controller
@RequestMapping("sysRoleButton")
public class SysRoleButtonAction {

    @Resource
    private ISysRoleButtonService sysRoleButtonService;

    /**
     * 查询按钮权限树，只能看到自己已有的按钮权限并分配
     *
     * @param loginRoleId   登录人的角色ID
     * @param currentRoleId 当前选中的角色ID
     * @param response
     * @return
     */
    @RequestMapping("findAuthorityTree")
    public void findAuthorityTree(String loginRoleId, String currentRoleId, HttpServletResponse response) {
        List<SysRoleMenu> roleMenus = sysRoleButtonService.findAuthorityTree(loginRoleId, currentRoleId);
        HtResponse.outJson(response, true, roleMenus);
    }

    /**
     * 查询角色ID下所有没有权限的按钮
     *
     * @param roleId
     * @param response
     */
    @RequestMapping("findNoAuthorityByRoleId")
    public void findNoAuthorityByRoleId(String roleId, HttpServletResponse response) {
        Map<String, List<SysButton>> roleButtonMap = sysRoleButtonService.findNoAuthorityByRoleId(roleId);
        HtResponse.outJson(response, true, HtGson.toJson(roleButtonMap));
    }

    /**
     * 批量添加角色按钮关系
     *
     * @param roleId         角色ID
     * @param roleButtonJson 按钮Json
     * @param response
     */
    @RequestMapping("batchAddRunRoleButtons")
    public void batchAddRunRoleButtons(String roleId, String roleButtonJson, HttpServletResponse response) {
        List<SysRoleButton> roleButtons = HtGson.fromJson(roleButtonJson, new TypeToken<List<SysRoleButton>>() {
        });
        boolean result = sysRoleButtonService.batchAddRoleButtons(roleId, roleButtons);
        HtResponse.outJson(response, result, result);
    }
}
