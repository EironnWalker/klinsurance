package com.ht.klinsurance.sys.service;


import com.ht.klinsurance.sys.model.SysButton;

import java.util.List;

/**
 * 按钮管理
 * @author liuqi
 * @date 2015/6/11
 */
public interface ISysButtonService {
    /**
     * 查询列表
     *
     * @param menuCode
     * @return
     */
    List<SysButton> findSysButtonList(String menuCode);


    /**
     * 根据角色查询
     * @param menuCode
     * @param roleId
     * @return
     */
    List<SysButton> findSysButtonListByTreeCode(String menuCode, String roleId);



    /**
     * 添加
     *
     * @param sysButton
     * @return
     */
    int addSysButton(SysButton sysButton);

    /**
     * 修改
     *
     * @param sysButton
     * @return
     */
    int updateSysButton(SysButton sysButton);

    /**
     * 删除
     *
     * @param buttonId
     * @return
     */
    int deleteSysButtonById(String buttonId);
}
