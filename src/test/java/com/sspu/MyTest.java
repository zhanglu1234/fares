package com.sspu;


import com.sspu.mapper.TestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyTest {

    @Autowired
    TestMapper testMapper;

    @Test
    void test(){

        System.out.println(testMapper);

    }

}
