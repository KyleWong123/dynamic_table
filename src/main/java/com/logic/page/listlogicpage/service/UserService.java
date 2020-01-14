package com.logic.page.listlogicpage.service;

import com.logic.page.listlogicpage.model.User;
import com.logic.page.listlogicpage.util.PageList;

/**
 * <pre>描述</pre>
 *
 * @version 1.0
 * @author: Kyle Wong
 * @date: 2020/1/13 14:06
 */
public interface UserService {
    /**
     * 多查询的列表进行逻辑分页
     * @param current 当前页
     * @param pageSize 一页显示的数目
     * @return
     */
    PageList<User> findAll(Integer current, Integer pageSize);

    /**
     * 插入用户并返回其主键
     * @param user
     */
    String insertUser(User user);

    /**
     * 动态创建表
     * @param tableName 表名
     */
    void createTable(String tableName);

    /**
     * 动态删除表
     * @param tableName 表名
     */
    void dropTable(String tableName);

    /**
     * 动态查询数据库中是否存在数据库表
     * @param tableName 表名
     * @return
     */
    boolean checkTableExists(String tableName);
}
