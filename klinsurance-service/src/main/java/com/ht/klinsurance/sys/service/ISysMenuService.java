package com.ht.klinsurance.sys.service;


import com.ht.klinsurance.sys.model.SysMenu;

import java.util.List;

/**
 * 菜单管理
 * @author liuqi
 * @date 2015/6/10
 */
public interface ISysMenuService {

    /**
     * 查询列表
     *
     * @param menuPcode
     * @return
     */
    List<SysMenu> findSysMenuList(String menuPcode);

    /**
     * 根据角色查询相关的菜单
     * @param roleId
     * @param pCode
     * @return
     */
    List<SysMenu> findSysMenuListByRoleId(String roleId, String pCode);

    /**
     * 添加
     *
     * @param sysMenu
     * @return
     */
    int addSysMenu(SysMenu sysMenu);

    /**
     * 修改
     *
     * @param sysMenu
     * @return
     */
    int updateSysMenu(SysMenu sysMenu);

    /**
     * 删除
     *
     * @param menuId
     * @return
     */
    int deleteSysMenuById(String menuId);

    /**
     * 查询最大menuCode
     *
     * @return
     */
    String findMaxMenuCode(String menuPcode);


}
