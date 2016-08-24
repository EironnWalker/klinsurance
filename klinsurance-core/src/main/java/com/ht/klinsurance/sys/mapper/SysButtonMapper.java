package com.ht.klinsurance.sys.mapper;

import com.ht.klinsurance.sys.model.SysButton;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysButtonMapper {
    List<SysButton> findSysButtonList(@Param("menuCode") String menuCode);
    List<SysButton> findSysButtonListByTreeCode(@Param("menuCode") String menuCode, @Param("roleId") String roleId);
    int addSysButton(SysButton sysButton);
    int updateSysButton(SysButton sysButton);
    int deleteSysButtonById(String buttonId);
}