package com.ht.klinsurance.sys.service.impl;

import com.ht.klinsurance.sys.mapper.SysRoleButtonMapper;
import com.ht.klinsurance.sys.model.SysButton;
import com.ht.klinsurance.sys.model.SysRoleButton;
import com.ht.klinsurance.sys.model.SysRoleMenu;
import com.ht.klinsurance.sys.service.ISysRoleButtonService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色按钮分配
 *
 * @author liuqi
 * @date 2015/6/11
 */
@Service
@Transactional
public class SysRoleButtonServiceImpl implements ISysRoleButtonService {

    @Resource
    private SysRoleButtonMapper sysRoleButtonMapper;

    @Override
    public List<SysRoleMenu> findAuthorityTree(String loginRoleId, String currentRoleId) {
        return sysRoleButtonMapper.findAuthorityTree(loginRoleId, currentRoleId);
    }

    @Override
    public Map<String, List<SysButton>> findNoAuthorityByRoleId(String roleId) {
        List<SysButton> buttons = sysRoleButtonMapper.findNoAuthorityByRoleId(roleId);
        Map<String, List<SysButton>> buttonMap = new HashMap<>();
        for (SysButton button : buttons) {
            if (buttonMap.containsKey(button.getMenuCode())) {
                List<SysButton> list = buttonMap.get(button.getMenuCode());
                list.add(button);
                buttonMap.put(button.getMenuCode(), list);
            } else {
                List<SysButton> list = new ArrayList<>();
                list.add(button);
                buttonMap.put(button.getMenuCode(), list);
            }
        }
        return buttonMap;
    }

    @Override
    public boolean batchAddRoleButtons(String roleId, List<SysRoleButton> roleButtons) {
        sysRoleButtonMapper.deleteByRoleId(roleId);
        if (CollectionUtils.isNotEmpty(roleButtons)) {
            int result = sysRoleButtonMapper.batchAddRoleButtons(roleId, roleButtons);
            return result > 0;
        }
        return true;
    }

    @Override
    public boolean copySysRoleButton(String sourceRunRoleId, String targetRunRoleId) {
        return sysRoleButtonMapper.copySysRoleButton(sourceRunRoleId, targetRunRoleId) > 0;
    }
}
