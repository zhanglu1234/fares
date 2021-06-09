package com.sspu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sspu.entity.Test;
import com.sspu.mapper.TestMapper;
import com.sspu.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl  extends ServiceImpl<TestMapper, Test> implements TestService {

}
