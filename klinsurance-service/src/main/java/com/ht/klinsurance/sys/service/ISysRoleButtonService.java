package com.ht.klinsurance.sys.service;


import com.ht.klinsurance.sys.model.SysButton;
import com.ht.klinsurance.sys.model.SysRoleButton;
import com.ht.klinsurance.sys.model.SysRoleMenu;

import java.util.List;
import java.util.Map;

/**
 * 社区系统按钮权限
 *
 * @author lindp
 * @date 2016/5/14
 */
public interface ISysRoleButtonService {

    /**
     * 查询按钮权限树，只能看到自己已有的按钮权限并分配
     *
     * @param loginRoleId   登录人的角色ID
     * @param currentRoleId 当前选中的角色ID
     * @return
     */
    List<SysRoleMenu> findAuthorityTree(String loginRoleId, String currentRoleId);

    /**
     * 查询角色ID下所有没有权限的按钮
     *
     * @param roleId
     * @return
     */
    Map<String, List<SysButton>> findNoAuthorityByRoleId(String roleId);

    /**
     * 批量添加角色按钮关系
     *
     * @param roleId      角色ID
     * @param roleButtons 按钮编码
     * @return
     */
    boolean batchAddRoleButtons(String roleId, List<SysRoleButton> roleButtons);

    /**
     * 拷贝角色按钮
     *
     * @param sourceRunRoleId 源角色ID
     * @param targetRunRoleId 目标角色ID
     * @return
     */
    boolean copySysRoleButton(String sourceRunRoleId, String targetRunRoleId);
}
