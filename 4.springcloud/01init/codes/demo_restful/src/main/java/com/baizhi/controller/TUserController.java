package com.baizhi.controller;

import com.baizhi.entity.TUser;
import com.baizhi.service.TUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TUser)表控制层
 *
 * @author chenyn
 * @since 2021-04-13 11:22:03
 */
@RestController
@RequestMapping("user")
public class TUserController {
    private static final Logger log = LoggerFactory.getLogger(TUserController.class);
    /**
     * 服务对象
     */
    @Resource
    private TUserService tUserService;


    /**
     * 根据id查询一个
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public TUser selectOne(@PathVariable("id") Integer id) {
        return this.tUserService.queryById(id);
    }


    //查询所有用户
    @GetMapping
    public List<TUser> select() {
        return this.tUserService.queryAllByLimit(0,Integer.MAX_VALUE);
    }


    /**
     * ajax
     * @param id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
         this.tUserService.deleteById(id);
    }


    //form表单提交
    @PostMapping
    public void save(TUser user){
        this.tUserService.insert(user);
    }


    @PostMapping("/file")
    public void saveUser(MultipartFile photo){
        log.debug("文件名: "+photo.getOriginalFilename());
        log.debug("文件大小: "+photo.getSize());
        log.debug("文件类型: "+photo.getContentType());

        //文件上传
        //photo.transferTo(new File(""));
        //oss文件上传

    }
    //ajax发起更新请求   json格式参数

    /**
     * java提供注解: 元注解: 用来修饰注解的注解
     * @Target(ElementType.PARAMETER)     //作用:用来指定自定义注解作用范围
     * @Retention(RetentionPolicy.RUNTIME)  //作用: 指定注解生效实际
     * @Documented
     *
     */
    @PatchMapping("/{id}")   //@RequestBody : 修饰范围:只能用在方法参数列表上
    public void update(@PathVariable("id") Integer id,@RequestBody TUser user){
        user.setId(id);
        this.tUserService.update(user);
    }




}
