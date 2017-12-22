package com.river.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.river.entity.JY;
import com.river.mapper.JyMapper;
import com.river.service.JyService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/11.
 */
@Service("jyServiceImpl")
public class JyServiceImpl extends ServiceImpl<JyMapper,JY> implements JyService {
}
