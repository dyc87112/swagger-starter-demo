package com.didispace.demo.controller.department;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.didispace.demo.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "部门管理")
@RequestMapping("/department")
@RestController
public class DepartmentController {

    @ApiOperation("创建部门")
    @PostMapping("/departments")
    public User create(@RequestBody @Valid User user) {
        return user;
    }

    @ApiOperation("部门详情")
    @GetMapping("/departments/{id}")
    public User findById(@PathVariable Long id) {
        return new User("bbb", 21, "上海", "aaa@bbb.com");
    }

    @ApiOperation("部门列表")
    @GetMapping("/departments")
    public List<User> list(@ApiParam("查看第几页") @RequestParam int pageIndex,
        @ApiParam("每页多少条") @RequestParam int pageSize) {
        List<User> result = new ArrayList<>();
        result.add(new User("aaa", 50, "北京", "aaa@ccc.com"));
        result.add(new User("bbb", 21, "广州", "aaa@ddd.com"));
        return result;
    }

    // @ApiIgnore 用于屏蔽 Swagger
    @ApiIgnore
    @ApiOperation("根据 ID 删除部门")
    @DeleteMapping("/departments/{id}")
    public String deleteById(@PathVariable Long id) {
        return "delete user : " + id;
    }

}