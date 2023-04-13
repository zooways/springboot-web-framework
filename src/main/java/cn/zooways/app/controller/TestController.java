package cn.zooways.app.controller;

import cn.zooways.app.utils.PageUtils;
import cn.zooways.app.controller.domain.Result;
import cn.zooways.app.entity.TestUser;
import cn.zooways.app.service.TestUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description:
 * @Author: Zoowayss Shi
 * @Date: 2023/4/13 13:44
 * @Version: 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestUserService testUserService;

    @GetMapping
    public Result hello() {
        Date now = new Date();
        return Result.ok(testUserService.save(new TestUser(null, "zooways", 18, now, now)));
    }

    @GetMapping("page")
    public Result page(Pageable page) {
        return Result.ok(testUserService.page(PageUtils.of(page), new LambdaQueryWrapper<TestUser>()));
    }
}
