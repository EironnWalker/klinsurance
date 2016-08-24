package com.ht.klinsurance.sys.service.impl;

import com.ht.common.utils.UUIDGenerate;
import com.ht.klinsurance.sys.mapper.SysRoleMapper;
import com.ht.klinsurance.sys.model.SysRole;
import com.ht.klinsurance.sys.service.ISysRoleButtonService;
import com.ht.klinsurance.sys.service.ISysRoleMenuService;
import com.ht.klinsurance.sys.service.ISysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SysRoleServiceImpl implements ISysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private ISysRoleMenuService sysRoleMenuService;
    @Resource
    private ISysRoleButtonService sysRoleButtonService;

    @Override
    public List<SysRole> findList(String roleName) {
        return sysRoleMapper.findList(roleName);
    }

    @Override
    public SysRole findByRoleName(String roleName) {
        return sysRoleMapper.findByRoleName(roleName);
    }

    @Override
    public boolean add(SysRole sysRole) {
        return sysRoleMapper.add(sysRole) > 0;
    }

    @Override
    public boolean update(SysRole sysRole) {
        return sysRoleMapper.update(sysRole) > 0;
    }

    @Override
    public boolean copyRole(String sourceRoleId, String targetRoleName) {
        SysRole role = sysRoleMapper.findById(sourceRoleId);
        role.setRoleId(UUIDGenerate.generate());
        role.setRoleName(targetRoleName);
        boolean result = this.add(role);

        result = sysRoleMenuService.copySysRoleMenu(sourceRoleId, role.getRoleId()) && result;
        result = sysRoleButtonService.copySysRoleButton(sourceRoleId, role.getRoleId()) && result;
        return result;
    }


}
