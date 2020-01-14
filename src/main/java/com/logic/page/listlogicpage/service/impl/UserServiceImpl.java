package com.logic.page.listlogicpage.service.impl;

import cn.hutool.core.util.IdUtil;
import com.logic.page.listlogicpage.mapper.UserMapper;
import com.logic.page.listlogicpage.model.User;
import com.logic.page.listlogicpage.util.PageList;
import com.logic.page.listlogicpage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>描述</pre>
 *
 * @version 1.0
 * @author: Kyle Wong
 * @date: 2020/1/13 14:07
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageList<User> findAll(Integer current, Integer pageSize) {
        List<User> userList = userMapper.findAll();
        PageList<User> pageList = new PageList<>(userList, current, pageSize);
        return pageList;
    }

//    @Override
//    public String insertUser(User user) {
//        String id = IdUtil.simpleUUID();
//        user.setId(id);
//        log.info("生成的主键ID={}", id);
//        userMapper.insertUser(user);
//        log.info("新添加用户的主键ID={}", user.getId());
//        return user.getId();
//    }

    @Override
    public String insertUser(User user) {
        userMapper.insertUser(user);
        log.info("新添加用户的主键ID={}", user.getId());
        return String.valueOf(user.getId());
    }

    @Override
    public void createTable(String tableName) {
        userMapper.createTable(tableName);
    }

    @Override
    public void dropTable(String tableName) {
        userMapper.dropTable(tableName);
    }

    @Override
    public boolean checkTableExists(String tableName) {
        if (0 == userMapper.checkTableExists(tableName)) {
            log.info("数据库中不存在表{}", tableName);
            return false;
        }
        return true;
    }
}
