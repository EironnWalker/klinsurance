package com.ht.klinsurance.sys.service;


import com.ht.klinsurance.sys.model.SysRole;

import java.util.List;

/**
 * 角色管理
 *
 * @author lindp
 * @date 2016/5/14
 */
public interface ISysRoleService {

    /**
     * 查询角色列表
     *
     * @param roleName
     * @return
     */
    List<SysRole> findList(String roleName);

    /**
     * 按角色名称查询角色
     *
     * @param roleName
     * @return
     */
    SysRole findByRoleName(String roleName);

    /**
     * 添加角色
     *
     * @param sysRole
     * @return
     */
    boolean add(SysRole sysRole);

    /**
     * 修改角色
     *
     * @param sysRole
     * @return
     */
    boolean update(SysRole sysRole);

    /**
     * 拷贝角色
     *
     * @param sourceRoleId   源角色ID
     * @param targetRoleName 目标角色名称
     * @return
     */
    boolean copyRole(String sourceRoleId, String targetRoleName);

}
