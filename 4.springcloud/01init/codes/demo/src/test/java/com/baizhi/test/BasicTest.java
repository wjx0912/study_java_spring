package com.baizhi.test;

import com.baizhi.DemoApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = DemoApplication.class)  //类对象  .class 类的对象 new
@RunWith(SpringRunner.class)
public class BasicTest {
}
