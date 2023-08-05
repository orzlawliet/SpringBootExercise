package com.lawliet.boot.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lawliet
 * @Description
 * @create 2023-08-03 下午 06:03
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {

    private String username;
    private String passwd;
}
