package com.ht.klinsurance.sys.mapper;

import com.ht.klinsurance.sys.model.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dul
 * @date 2015-06-08
 */
@Repository
public interface SysMenuMapper {

    /**
     * 分页查询
     * @param menuPcode
     * @return
     */
    List<SysMenu> findSysMenuList(@Param("menuPcode") String menuPcode);

    /**
     * 根据主键查询
     *
     * @param menuId
     * @return
     */
    SysMenu findSysMenuById(String menuId);

    /**
     * 新增
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
     * 根据主键删除
     *
     * @param menuId
     * @return
     */
    int deleteSysMenuById(String menuId);

    /**
     * 查找最大的菜单编号
     * @param menuPcode
     * @return
     */
    String findMaxMenuCode(String menuPcode);

    /**
     * 根据roleid 查询相关菜单
     * @param roleId
     * @return
     */
    List<SysMenu> findSysMenuListByRoleId(@Param("roleId") String roleId, @Param("pCode") String pCode);

}