package com.river.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.river.mapper.UserMapper;
import com.river.pojo.User;
import com.river.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/26.
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    private EntityWrapper<User> ew = new EntityWrapper<>();

    @Override
    public List<User> selectUsers() {
        ew.setEntity(new User());
        ew.where("age", "nan").orderBy("id", false);
        String sqlSegment = ew.getSqlSegment();
        System.out.println("ew:"+sqlSegment);
        return userMapper.selectUsers(ew);
    }


}
