package com.baizhi.feign;

import com.baizhi.entity.Group;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("GROUPS")
public interface GroupClient {

    //小组信息
    @GetMapping("/groups/{id}")
    Group group(@PathVariable("id") Integer id);
}
