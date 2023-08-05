package com.lawliet.boot3.ssm.bean;

import lombok.Data;

/**
 * @author Lawliet
 * @Description
 * @create 2023-07-31 下午 09:28
 */
@Data
public class TUser {
    private int id;
    private String loginName;
    private String nickName;
    private String passwd;

}
