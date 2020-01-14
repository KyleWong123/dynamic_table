package com.logic.page.listlogicpage.mapper;

import com.logic.page.listlogicpage.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <pre>描述</pre>
 *
 * @version 1.0
 * @author: Kyle Wong
 * @date: 2020/1/13 13:55
 */
@Component
public interface UserMapper {
    /**
     * 查询用户列表
     * @return
     */
    List<User> findAll();

    /**
     * 新增用户
     * @param user 用户实体
     */
    // void insertUser(User user);

    /**
     * 新增用户(获取自增主键)
     * @param user 用户实体
     */
    void insertUser(@Param("user") User user);

    /**
     * 创建表
     * @param tableName 表名
     */
    void createTable(@Param("tableName") String tableName);

    /**
     * 删除表
     * @param tableName 表名
     */
    void dropTable(@Param("tableName") String tableName);

    /**
     * 查询数据库中是否已经存在该表
     * @param tableName 表名
     * @return
     */
    int checkTableExists(@Param("tableName") String tableName);
}
