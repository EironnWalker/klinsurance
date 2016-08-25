package com.ht.klinsurance.sys.action;

import com.ht.common.http.HtResponse;
import com.ht.klinsurance.sys.model.SysRoleMenu;
import com.ht.klinsurance.sys.service.ISysRoleMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 角色菜单权限管理
 * @author liuqi
 * @date 2015/6/11
 */
@Controller
@RequestMapping("sysRoleMenu")
public class SysRoleMenuAction {

    @Resource
    private ISysRoleMenuService sysRoleMenuService;

    /**
     * 查询菜单权限树，只能看到自己已有的菜单权限并分配
     *
     * @param loginRoleId   登录人的角色ID
     * @param currentRoleId 当前选中的角色ID
     * @param response
     * @return
     */
    @RequestMapping("findAuthorityTree")
    public void findAuthorityTree(String loginRoleId, String currentRoleId, HttpServletResponse response) {
        List<SysRoleMenu> runRoleMenus = sysRoleMenuService.findAuthorityTree(loginRoleId, currentRoleId);
        HtResponse.outJson(response, true, runRoleMenus);
    }

    /**
     * 批量添加角色菜单关系
     *
     * @param roleId    角色ID
     * @param menuCodes 菜单编码，使用“,”分隔
     * @param response
     */
    @RequestMapping("batchAddRoleMenus")
    public void batchAddRoleMenus(String roleId, String menuCodes, HttpServletResponse response) {
        boolean result = sysRoleMenuService.batchAddRoleMenus(roleId, menuCodes);
        HtResponse.outJson(response, result, result);
    }
}
