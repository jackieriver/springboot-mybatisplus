package com.river.service;

import com.baomidou.mybatisplus.service.IService;
import com.river.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2017/9/26.
 */
public interface UserService extends IService<User> {
    public List<User> selectUsers();
}
