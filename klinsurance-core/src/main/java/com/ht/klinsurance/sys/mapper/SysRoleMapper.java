package com.ht.klinsurance.sys.mapper;

import com.ht.klinsurance.sys.model.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色Mapper
 *
 * @author lindp
 * @date 2016/5/14
 */
@Repository
public interface SysRoleMapper {

    /**
     * 查询角色列表
     *
     * @param roleName
     * @return
     */
    List<SysRole> findList(@Param("roleName") String roleName);

    /**
     * 使用roleId查询角色
     *
     * @param roleId
     * @return
     */
    SysRole findById(String roleId);

    /**
     * 使用角色名称查询角色
     *
     * @param roleName
     * @return
     */
    SysRole findByRoleName(@Param("roleName") String roleName);

    /**
     * 添加角色
     *
     * @param sysRole
     * @return
     */
    int add(SysRole sysRole);

    /**
     * 修改角色
     *
     * @param sysRole
     * @return
     */
    int update(SysRole sysRole);

}