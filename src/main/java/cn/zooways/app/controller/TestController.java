package cn.zooways.app.controller;

import cn.zooways.app.controller.domain.Result;
import cn.zooways.app.token.TokenUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Zoowayss Shi
 * @Date: 2023/4/13 13:44
 * @Version: 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public Result hello(TokenUser user) {
        return Result.ok("hello");
    }

}
