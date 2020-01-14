package com.logic.page.listlogicpage;

import com.logic.page.listlogicpage.mapper.UserMapper;
import com.logic.page.listlogicpage.model.User;
import com.logic.page.listlogicpage.util.PageList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class ListLogicPageApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    public void findAll(){
        List<User> userList = userMapper.findAll();
        PageList<User> pageList = new PageList<>(userList, 1, 2);
        log.info(userList.toString());
    }

}
