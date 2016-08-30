package com.ht.klinsurance.user.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.common.utils.UUIDGenerate;
import com.ht.klinsurance.user.mapper.UserMapper;
import com.ht.klinsurance.user.model.User;
import com.ht.klinsurance.user.service.IUserService;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户信息（主要是包含登录信息）
 * @author liuqi
 * @date 2016/7/18
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService{
    @Resource
    private UserMapper userMapper;
    /**
     *
     * 登录
     * @author liuqi
     * @date 2016/7/18
     */
    @Override
    public Map<String, Object> findUserLogin(User user) {
        Map<String,Object> returnMap = new HashMap<>();
        List<User> list = userMapper.findListByParam(user);
        if (list.size() == 1) {
            returnMap.put("result","1");
            returnMap.put("data",list.get(0));
        }else if(list.size() > 1){
            returnMap.put("result","账号重复");
        }else{
            returnMap.put("result","账号或者密码错误");
        }
        return returnMap;
    }

    /**
     * 根据用户名查询用户信息（用于登录后的信息查询）
     *
     * @param parameter
     * @return
     */
    @Override
    public  List<User> findUserByUserNameLogin(Map<String, Object> parameter) {
        return userMapper.findUserByUserNameLogin(parameter);
    }

    /**
     * 用户分页查询
     * @param parameter
     * @param pageBounds
     * @return
     */
    @Override
    public List<User> findUserPageList(Map<String, Object> parameter, PageBounds pageBounds) {
        return userMapper.findUserPageList(parameter, pageBounds);
    }

    /**
     * 用户列表查询
     * 用于验证账号唯一性
     * @param parameter
     * @return
     */
    @Override
    public List<User> findUserList(Map<String, Object> parameter) {
        return userMapper.findList(parameter);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int addSysUser(User user) {
        user.setUserId(UUIDGenerate.generate());
        user.setUserType("2");
        user.setCreateTime(new Date());
        user.setNamePinyin(getFirstSpell(user.getName()));
        return userMapper.addUser(user);
    }

    /**
     * 获取汉字串拼音首字母，英文字符不变
     * @param chinese 汉字串
     * @return 汉语拼音首字母
     */
    public String getFirstSpell(String chinese) {
        StringBuffer pybf = new StringBuffer();
        char[] arr = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        if (arr[0] > 128) {
            try {
                String[] temp = PinyinHelper.toHanyuPinyinStringArray(arr[0], defaultFormat);
                if (temp != null) {
                    pybf.append(temp[0].charAt(0));
                }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        } else {
            pybf.append(arr[0]);
        }
        return pybf.toString().replaceAll("\\W", "").trim();
    }
}
