package com.wang.mapper;

import com.wang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//这个注解表示了这是一个MyBatis的Mapper类
//也可以在启动类是加@MapperScan("")扫描包
@Mapper
//这个注解表示了它是Dao层
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
