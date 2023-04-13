package cn.zooways.app.service.impl;

import cn.zooways.app.entity.TestUser;
import cn.zooways.app.mapper.TestUserMapper;
import cn.zooways.app.service.TestUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements TestUserService{
}
