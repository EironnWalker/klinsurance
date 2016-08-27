package com.ht.klinsurance.sys.mapper;

import com.ht.klinsurance.sys.model.SysButton;
import com.ht.klinsurance.sys.model.SysRoleButton;
import com.ht.klinsurance.sys.model.SysRoleMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 社区系统角色按钮Mapper
 *
 * @author lindp
 * @date 2016/5/14
 */
@Repository
public interface SysRoleButtonMapper {

    /**
     * 查询按钮权限树，只能看到自己已有的按钮权限并分配
     *
     * @param loginRoleId   登录人的角色ID
     * @param currentRoleId 当前选中的角色ID
     * @return
     */
    List<SysRoleMenu> findAuthorityTree(@Param("loginRoleId") String loginRoleId,
                                        @Param("currentRoleId") String currentRoleId);

    /**
     * 查询角色ID下所有没有权限的按钮
     *
     * @param roleId
     * @return
     */
    List<SysButton> findNoAuthorityByRoleId(String roleId);

    /**
     * 拷贝角色按钮
     *
     * @param sourceRunRoleId 源角色ID
     * @param targetRunRoleId 目标角色ID
     * @return
     */
    int copySysRoleButton(@Param("sourceRunRoleId") String sourceRunRoleId,
                          @Param("targetRunRoleId") String targetRunRoleId);

    /**
     * 批量添加角色按钮关系
     *
     * @param roleId      角色ID
     * @param roleButtons 按钮
     * @return
     */
    int batchAddRoleButtons(@Param("roleId") String roleId,
                            @Param("roleButtons") List<SysRoleButton> roleButtons);

    /**
     * 使用角色ID删除关系表
     *
     * @param roleId
     * @return
     */
    int deleteByRoleId(String roleId);
}