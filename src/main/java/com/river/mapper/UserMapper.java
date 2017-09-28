package com.river.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.river.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2017/9/26.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> selectUsers(@Param("ew") String ew);

}
