package com.ht.klinsurance.sys.service.impl;

import com.ht.klinsurance.sys.mapper.SysButtonMapper;
import com.ht.klinsurance.sys.model.SysButton;
import com.ht.klinsurance.sys.service.ISysButtonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuqi
 * @date 2015/6/11
 */
@Service
@Transactional
public class SysButtonServiceImpl implements ISysButtonService {

    @Resource
    private SysButtonMapper sysButtonMapper;
    /**
     * 查询列表
     *
     * @param menuCode
     * @return
     */
    @Override
    public List<SysButton> findSysButtonList(String menuCode) {
        return sysButtonMapper.findSysButtonList(menuCode);
    }

    /**
     * 根据角色查询
     *
     * @param menuCode
     * @param roleId
     * @return
     */
    @Override
    public List<SysButton> findSysButtonListByTreeCode(String menuCode, String roleId) {
        return sysButtonMapper.findSysButtonListByTreeCode(menuCode,roleId);
    }

    /**
     * 添加
     *
     * @param sysButton
     * @return
     */
    @Override
    public int addSysButton(SysButton sysButton) {
        return sysButtonMapper.addSysButton(sysButton);
    }

    /**
     * 修改
     *
     * @param sysButton
     * @return
     */
    @Override
    public int updateSysButton(SysButton sysButton) {
        return sysButtonMapper.updateSysButton(sysButton);
    }

    /**
     * 删除
     *
     * @param buttonId
     * @return
     */
    @Override
    public int deleteSysButtonById(String buttonId) {
        return sysButtonMapper.deleteSysButtonById(buttonId);
    }
}
