package com.didispace.demo.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.didispace.demo.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "管理员管理")
@RequestMapping("/administrator")
@RestController
public class AdministratorController {

    @ApiOperation("创建管理员")
    @PostMapping("/administrator")
    public User create(@RequestBody @Valid User user) {
        return user;
    }

    @ApiOperation("获取管理员详情")
    @GetMapping("/administrator/{id}")
    public User findById(@PathVariable Long id) {
        return new User("bbb", 21, "上海", "aaa@bbb.com");
    }

    @ApiOperation("管理员列表")
    @GetMapping("/administrators")
    public List<User> list(@ApiParam("查看第几页") @RequestParam int pageIndex,
        @ApiParam("每页多少条") @RequestParam int pageSize) {
        List<User> result = new ArrayList<>();
        result.add(new User("aaa", 50, "北京", "aaa@ccc.com"));
        result.add(new User("bbb", 21, "广州", "aaa@ddd.com"));
        return result;
    }

    @ApiOperation("删除管理员")
    @DeleteMapping("/administrator/{id}")
    public String deleteById(@PathVariable Long id) {
        return "delete user : " + id;
    }
}