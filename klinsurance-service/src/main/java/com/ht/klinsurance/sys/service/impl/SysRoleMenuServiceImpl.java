package com.ht.klinsurance.sys.service.impl;

import com.ht.klinsurance.sys.mapper.SysRoleMenuMapper;
import com.ht.klinsurance.sys.model.SysRoleMenu;
import com.ht.klinsurance.sys.service.ISysRoleMenuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SysRoleMenuServiceImpl implements ISysRoleMenuService {

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public List<SysRoleMenu> findAuthorityTree(String loginRoleId, String currentRoleId) {
        return sysRoleMenuMapper.findAuthorityTree(loginRoleId, currentRoleId);
    }

    @Override
    public boolean batchAddRoleMenus(String roleId, String menuCodes) {
        sysRoleMenuMapper.deleteByRoleId(roleId);
        if (StringUtils.isNotBlank(menuCodes)) {
            String[] menuCodeArray = menuCodes.split(",");
            return sysRoleMenuMapper.batchAddRoleMenus(roleId, menuCodeArray) > 0;
        }
        return true;
    }

    @Override
    public boolean deleteByRoleId(String roleId) {
        return sysRoleMenuMapper.deleteByRoleId(roleId) > 0;
    }

    @Override
    public boolean copySysRoleMenu(String sourceRunRoleId, String targetRunRoleId) {
        return sysRoleMenuMapper.copySysRoleMenu(sourceRunRoleId, targetRunRoleId) > 0;
    }
}
