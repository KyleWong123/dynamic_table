package com.logic.page.listlogicpage.controller;

import com.logic.page.listlogicpage.model.User;
import com.logic.page.listlogicpage.service.UserService;
import com.logic.page.listlogicpage.util.HttpResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>描述</pre>
 *
 * @version 1.0
 * @author: Kyle Wong
 * @date: 2020/1/13 14:15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("findAll")
    public HttpResultService findAll(@RequestParam("current")Integer current, @RequestParam("pageSize") Integer pageSize){
        if (current == null) {
            return HttpResultService.failed("传入的页码有误");
        }
        if (pageSize == null) {
            return HttpResultService.failed("传入的条数有误");
        }
        return HttpResultService.success(userService.findAll(current, pageSize));
    }

    @PostMapping("insertUser")
    public HttpResultService insertUser(User user){
        if (user == null) {
            return HttpResultService.failed("参数传递有误");
        }
        return HttpResultService.success(userService.insertUser(user));
    }

    @PostMapping("createTable")
    public HttpResultService createTable(String tableName){
        if (StringUtils.isEmpty(tableName)) {
            return HttpResultService.failed("传入的表名为空");
        }
        if (userService.checkTableExists(tableName)) {
            return HttpResultService.success("数据库中已经存在表" + tableName);
        }
        userService.createTable(tableName);
        return HttpResultService.success(tableName + "表创建成功");
    }

    @PostMapping("dropTable")
    public HttpResultService dropTable(String tableName){
        if (StringUtils.isEmpty(tableName)) {
            return HttpResultService.failed("传入的表名为空");
        }
        if (!userService.checkTableExists(tableName)) {
            return HttpResultService.success("数据库中暂不存在表" + tableName);
        }
        userService.dropTable(tableName);
        return HttpResultService.success(tableName + "表删除成功");

    }
}
