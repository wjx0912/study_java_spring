package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //用来通知springboot 扫描当前该注解  作用: 用来在工厂中创建对象   @Component <bean id="" class="com.baizhi.service.UserServiceImpl">
@Transactional //控制事务   作用: 用来控制事务  修饰范围:  类 代表类中所有方法加入事务控制  方法上: 代表当前方法加入事务控制
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDAO userDAO;


    @Override  //A.save{ B.find(){ cService.update() }}
    @Transactional(propagation = Propagation.SUPPORTS)//有融入 没有不开启 //propagation: 事务传播属性
    public List<User> findAll() {//取钱  conn1
        //1.取钱  独立事务
        //2.记录日志  独立事务  需要事务: 外部存在事务则融入事务  没有开启新的事务 conn1  需要新事务: 外部存在事务外部事务挂起 自己创建新的事务运行 运行结束回复外部事务
        //logService.log();
        return userDAO.findAll();
    }


    @Override
    public void save(User user) {

        //保存订单
        System.out.println("执行DAO方法之前id: "+user.getId());
        userDAO.save(user);
        System.out.println("执行DAO方法之后id: "+user.getId());
        //for保存订单项 orderItem.setOrderId()
    }

    @Override
    public User findById(Integer id) {
        return userDAO.findById(id);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }
}

//@Transactional(propagation = Propagation.REQUIRES_NEW)
//LogService  logs方法
