package com.ht.klinsurance.sys.service;


import com.ht.klinsurance.sys.model.SysRoleMenu;

import java.util.List;

/**
 * 社区系统菜单权限
 *
 * @author lindp
 * @date 2016/5/14
 */
public interface ISysRoleMenuService {

    /**
     * 查询菜单权限树，只能看到自己已有的菜单权限并分配
     *
     * @param loginRoleId   登录人的角色ID
     * @param currentRoleId 当前选中的角色ID
     * @return
     */
    List<SysRoleMenu> findAuthorityTree(String loginRoleId, String currentRoleId);

    /**
     * 批量添加角色菜单关系
     *
     * @param roleId    角色ID
     * @param menuCodes 菜单编码，使用“,”分隔
     * @return
     */
    boolean batchAddRoleMenus(String roleId, String menuCodes);

    /**
     * 删除角色菜单关系
     *
     * @param roleId
     * @return
     */
    boolean deleteByRoleId(String roleId);

    /**
     * 拷贝角色菜单
     *
     * @param sourceRunRoleId 源角色ID
     * @param targetRunRoleId 目标角色ID
     * @return
     */
    boolean copySysRoleMenu(String sourceRunRoleId, String targetRunRoleId);

}
