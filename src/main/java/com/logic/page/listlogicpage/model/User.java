package com.logic.page.listlogicpage.model;

import lombok.Data;

import java.io.Serializable;

/**
 * <pre>描述</pre>
 *
 * @version 1.0
 * @author: Kyle Wong
 * @date: 2020/1/13 13:52
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 8072205449938643631L;
    private Integer id;
    private String account;
    private String username;
    private Double balance;
    private Integer age;
}
