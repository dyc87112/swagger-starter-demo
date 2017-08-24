package com.didispace.demo;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("/users/{id}")
    public User list(@PathVariable Long id) {
        return new User("bbb", 21, "上海", "aaa@bbb.com");
    }

    @GetMapping("/users")
    public List<User> list(@RequestParam int pageIndex,
                           @RequestParam int pageSize) {
        List<User> result = new ArrayList<>();
        result.add(new User("aaa", 50, "北京", "aaa@ccc.com"));
        result.add(new User("bbb", 21, "广州", "aaa@ddd.com"));
        return result;
    }

    @PostMapping("/users")
    public User create(@RequestBody @Valid User user) {
        return user;
    }
}