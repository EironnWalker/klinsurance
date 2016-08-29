package com.ht.klinsurance.sys.service.impl;

import com.ht.klinsurance.sys.mapper.SysMenuMapper;
import com.ht.klinsurance.sys.model.SysMenu;
import com.ht.klinsurance.sys.service.ISysMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单管理
 *
 * @author liuqi
 * @date 2015/6/10
 */
@Service
@Transactional
public class SysMenuServiceImpl implements ISysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    /**
     * 查询列表
     *
     * @param menuPcode
     * @return
     */
    @Override
    public List<SysMenu> findSysMenuList(String menuPcode) {
        return sysMenuMapper.findSysMenuList(menuPcode);
    }

    /**
     *根据角色查询相关的菜单
     * @param roleId
     * @param pCode
     * @return
     */
    @Override
    public List<SysMenu> findSysMenuListByRoleId(String roleId,String pCode) {
        return sysMenuMapper.findSysMenuListByRoleId(roleId,pCode);
    }

    /**
     * 添加
     *
     * @param sysMenu
     * @return
     */
    @Override
    public int addSysMenu(SysMenu sysMenu) {
        String menuCode = findMaxMenuCode(sysMenu.getMenuPcode());
        sysMenu.setMenuCode(menuCode);
        return sysMenuMapper.addSysMenu(sysMenu);
    }

    /**
     * 修改
     *
     * @param sysMenu
     * @return
     */
    @Override
    public int updateSysMenu(SysMenu sysMenu) {
        return sysMenuMapper.updateSysMenu(sysMenu);
    }

    /**
     * 删除
     *
     * @param menuId
     * @return
     */
    @Override
    public int deleteSysMenuById(String menuId) {
        return sysMenuMapper.deleteSysMenuById(menuId);
    }

    /**
     * 查询最大menuCode
     *
     * @return
     */
    @Override
    public String findMaxMenuCode(String menuPcode) {
        String newTreeCode ="";
        String nowTreeCode = sysMenuMapper.findMaxMenuCode(menuPcode);
        if (nowTreeCode == null) {
            newTreeCode = Long.parseLong(menuPcode)+"01";
        }else{
            Long  newTreeCodeInt = Long.parseLong(nowTreeCode) + 1;
            newTreeCode = newTreeCodeInt+"";
        }

        return newTreeCode ;

    }
}
