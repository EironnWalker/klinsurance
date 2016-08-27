package com.ht.klinsurance.sys.mapper;

import com.ht.klinsurance.sys.model.SysRoleMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 社区系统角色菜单Mapper
 *
 * @author lindp
 * @date 2016/5/14
 */
@Repository
public interface SysRoleMenuMapper {

    /**
     * 查询菜单权限树，只能看到自己已有的菜单权限并分配
     *
     * @param loginRoleId   登录人的角色ID
     * @param currentRoleId 当前选中的角色ID
     * @return
     */
    List<SysRoleMenu> findAuthorityTree(@Param("loginRoleId") String loginRoleId,
                                        @Param("currentRoleId") String currentRoleId);

    /**
     * 批量添加角色菜单关系
     *
     * @param roleId        角色ID
     * @param menuCodeArray 菜单编码
     * @return
     */
    int batchAddRoleMenus(@Param("roleId") String roleId,
                          @Param("menuCodeArray") String[] menuCodeArray);

    /**
     * 删除菜单关系
     *
     * @param roleId 角色ID
     * @return
     */
    int deleteByRoleId(String roleId);

    /**
     * 拷贝角色菜单
     *
     * @param sourceRunRoleId 源角色ID
     * @param targetRunRoleId 目标角色ID
     * @return
     */
    int copySysRoleMenu(@Param("sourceRunRoleId") String sourceRunRoleId,
                        @Param("targetRunRoleId") String targetRunRoleId);

}