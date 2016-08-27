package com.ht.klinsurance.sys.action;

import com.ht.common.gson.HtGson;
import com.ht.common.http.HtResponse;
import com.ht.common.utils.UUIDGenerate;
import com.ht.klinsurance.sys.model.SysRole;
import com.ht.klinsurance.sys.service.ISysRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 角色管理
 *
 * @author liuqi
 * @date 2015/6/10
 */
@Controller
@RequestMapping("sysRoleAction")
public class SysRoleAction {

    @Resource
    private ISysRoleService sysRoleService;

    /**
     * 查询角色列表
     *
     * @param response
     */
    @RequestMapping("findSysRoleList")
    public void findSysRoleList( String roleName, HttpServletResponse response) {
        List<SysRole> roleList = sysRoleService.findList(roleName);
        HtResponse.outJson(response, true, roleList);
    }

    /**
     * 根据名称查询角色
     *
     * @param roleName
     * @param response
     */
    @RequestMapping("findSysRoleByName")
    public void findSysRoleByName(String roleName, HttpServletResponse response) {
        SysRole role = sysRoleService.findByRoleName(roleName);
        HtResponse.outJson(response, true, role);
    }

    /**
     * 添加角色
     *
     * @param sysRoleJson
     * @param response
     */
    @RequestMapping("addSysRole")
    public void addSysRole(String sysRoleJson, HttpServletResponse response) {
        SysRole sysRole = HtGson.fromJson(sysRoleJson, SysRole.class);
        sysRole.setRoleId(UUIDGenerate.generate());
        boolean result = sysRoleService.add(sysRole);
        HtResponse.outJson(response, result, result);
    }

    /**
     * 修改角色
     *
     * @param sysRoleJson
     * @param response
     */
    @RequestMapping("updateSysRole")
    public void updateSysRole(String sysRoleJson, HttpServletResponse response) {
        SysRole sysRole = HtGson.fromJson(sysRoleJson, SysRole.class);
        boolean result = sysRoleService.update(sysRole);
        HtResponse.outJson(response, result, result);
    }

    /**
     * 复制角色
     *
     * @param roleId
     * @param response
     */
    @RequestMapping("addCopyRole")
    public void addCopyRole(String roleId, String roleName, HttpServletResponse response) {
        boolean result = sysRoleService.copyRole(roleId, roleName);
        HtResponse.outJson(response, result, result);
    }
}
