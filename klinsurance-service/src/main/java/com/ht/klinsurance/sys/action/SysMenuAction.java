package com.ht.klinsurance.sys.action;

import com.ht.common.gson.HtGson;
import com.ht.common.http.HtResponse;
import com.ht.common.utils.UUIDGenerate;
import com.ht.klinsurance.sys.model.SysMenu;
import com.ht.klinsurance.sys.service.ISysMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 菜单管理
 *
 * @author liuqi
 * @date 2015/6/10
 */

@Controller
@RequestMapping("sysMenuAction")
public class SysMenuAction {
    @Resource
    private ISysMenuService sysMenuService;

    /**
     * 查询菜单列表
     *
     * @param menuPcode
     * @param response
     */
    @RequestMapping("findSysMenuList")
    public void findSysMenuList(String menuPcode, HttpServletResponse response) {
        try {
            List<SysMenu> menuList = sysMenuService.findSysMenuList(menuPcode);
            HtResponse.outJson(response, true, menuList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 添加菜单
     *
     * @param sysMenuJson
     * @param response
     */
    @RequestMapping("addSysMenu")
    public void addSysMenu(String sysMenuJson, HttpServletResponse response) {
        SysMenu sysMenu = HtGson.fromJson(sysMenuJson, SysMenu.class);
        sysMenu.setMenuId(UUIDGenerate.generate());
        int result = sysMenuService.addSysMenu(sysMenu);
        if (result > 0) {
            HtResponse.outJson(response, true, String.valueOf(result));
        } else {
            HtResponse.outJson(response, false, String.valueOf(result));
        }
    }

    /**
     * 修改菜单
     *
     * @param sysMenuJson
     * @param response
     */
    @RequestMapping("updateSysMenu")
    public void updateSysMenu(String sysMenuJson, HttpServletResponse response) {
        SysMenu sysMenu;
        sysMenu = HtGson.fromJson(sysMenuJson, SysMenu.class);
        int result = sysMenuService.updateSysMenu(sysMenu);
        if (result > 0) {
            HtResponse.outJson(response, true, String.valueOf(result));
        } else {
            HtResponse.outJson(response, false, String.valueOf(result));
        }
    }

    /**
     * 删除
     *
     * @param menuId
     * @param response
     */
    @RequestMapping("deleteSysMenuById")
    public void deleteSysMenuById(String menuId, HttpServletResponse response) {
        int result = sysMenuService.deleteSysMenuById(menuId);
        if (result > 0) {
            HtResponse.outJson(response, true, String.valueOf(result));
        } else {
            HtResponse.outJson(response, false, String.valueOf(result));
        }
    }

    /**
     * 根据roleId查询当前角色的菜单
     *
     * @param roleId
     * @param response
     */
    @RequestMapping("findSysMenuListByRoleId")
    public void findSysMenuListByRoleId(String roleId, String pCode, HttpServletResponse response) {
        List<SysMenu> menuList = sysMenuService.findSysMenuListByRoleId(roleId, pCode);
        HtResponse.outJson(response, true, menuList);
    }
}
