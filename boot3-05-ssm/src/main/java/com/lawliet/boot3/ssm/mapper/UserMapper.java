package com.lawliet.boot3.ssm.mapper;

import com.lawliet.boot3.ssm.bean.TUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author Lawliet
 * @Description
 * @create 2023-07-31 下午 09:41
 */
public interface UserMapper {

    /**
     * 1、每個方法都在Mapper文件中有一個sql標籤對應。
     * 2、所有參數都應該用@Param進行簽名，以後使用指定的名字在SQL中取值
     * @param id
     * @return
     * */
    TUser getUserById(@Param("id") Long id);
}
