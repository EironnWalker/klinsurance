package com.ht.klinsurance.user.action;

import cn.jingsheng.ldap.WinUser;
import cn.jingsheng.ldap.service.WindowsDomainService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.ht.HtMap;
import com.ht.common.http.HtResponse;
import com.ht.klinsurance.common.BaseAction;
import com.ht.klinsurance.common.KlConsts;
import com.ht.klinsurance.user.model.User;
import com.ht.klinsurance.user.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 用户信息
 * @author liuqi
 * @date 2016/7/18
 */
@Controller
@RequestMapping("userAction")
public class UserAction  extends BaseAction{

    @Resource
    private IUserService userService;
    @Autowired
    private WindowsDomainService windowsDomainService = null;

    /**
     * 登录
     * @param userJson
     * @param response
     */
    @RequestMapping("login")
    public void login(String userJson, HttpServletResponse response) {
        try {

            User user =  HtGson.fromJson(userJson, new TypeToken<User>() {
            });
            //如果是默认密码
            if(user.getLoginPwd()!=null&&user.getLoginPwd().equals(KlConsts.COMMPSW) )
            {
                HtMap htMap = new HtMap();
                htMap.put("loginName", user.getLoginName());
                List<User> userList = userService.findUserByUserNameLogin(htMap);
                if(userList!=null&&userList.size()>0)
                {
                    HtResponse.outJson(response, true, userList.get(0));
                }else {
                    HtResponse.outJson(response, false, "通讯录中未发现该用户，请重新登录");
                    //TODO 重新同步通讯录信息后继续查新
                }
            }else {
                WinUser ldapUser = windowsDomainService.getWindowsDomain().login(user.getLoginName(), user.getLoginPwd());
                if(ldapUser==null)
                {
                    HtResponse.outJson(response, false, "登录失败");
                }else {
                    //登录成功之后，根据用户名去查询通讯录信息
                    HtMap htMap = new HtMap();
                    htMap.put("loginName", user.getLoginName());
                    List<User> userList = userService.findUserByUserNameLogin(htMap);
                    if(userList!=null&&userList.size()>0)
                    {
                        HtResponse.outJson(response, true, userList.get(0));
                    }else {
                        HtResponse.outJson(response, false, "通讯录中未发现该用户，请重新登录");
                        //TODO 重新同步通讯录信息后继续查新
                    }
                }
            }
        } catch (Exception e) {
            log.error("登录主方法", e);
            HtResponse.outJson(response, false, "登录失败");
        }
    }

    /**
     * 查看用户列表
     * @param name
     * @param response
     */
    @RequestMapping("findUserPageList")
    public void findUserPageList(String name,String loginName,Integer limit,Integer pageNo, HttpServletResponse response) {
        try {
            limit = limit == null ? KlConsts.PAGE_LIMIT : limit;
            HtMap htMap = new HtMap();
            if(StringUtils.isNotBlank(name)){
                htMap.put("name",name);
            }
            if(StringUtils.isNotBlank(loginName)){
                htMap.put("loginName",loginName);
            }
            PageList<User> userList = (PageList<User>)userService
                    .findUserPageList(htMap, new PageBounds(pageNo, limit));
            HtResponse.outPageJson(response, true, userList);
        } catch (Exception e) {
            log.error("查看用户列表列表主方法", e);
        }
    }

    /**
     * 验证账号唯一性
     * @param loginName
     * @param response
     */
    @RequestMapping("findUserList")
    public void findUserList(String loginName,HttpServletResponse response) {
        try {
            HtMap htMap = new HtMap();
            if(StringUtils.isNotBlank(loginName)){
                htMap.put("loginName",loginName);
            }
            List<User> userList = userService.findUserList(htMap);
            HtResponse.outJson(response, true, userList);
        } catch (Exception e) {
            log.error("查看用户列表列表主方法", e);
        }
    }


    /**
     * 修改用户
     * @param userJson
     * @param response
     */
    @RequestMapping("updateUser")
    public void updateUser(String userJson, HttpServletResponse response) {
        try {
            User user =  HtGson.fromJson(userJson, new TypeToken<User>() {});
            int result = userService.updateUser(user);
            if (result>0) {
                HtResponse.outJson(response, true, result);
            } else {
                HtResponse.outJson(response, false, result);
            }
        } catch (Exception e) {
            log.error("修改用户主方法", e);
        }
    }

    /**
     * 添加系统用户
     * @param userJson
     * @param response
     */
    @RequestMapping("addSysUser")
    public void addSysUser(String userJson, HttpServletResponse response) {
        try {
            User user =  HtGson.fromJson(userJson, new TypeToken<User>() {});
            int result = userService.addSysUser(user);
            if (result>0) {
                HtResponse.outJson(response, true, result);
            } else {
                HtResponse.outJson(response, false, result);
            }
        } catch (Exception e) {
            log.error("添加系统用户主方法", e);
        }
    }




}
