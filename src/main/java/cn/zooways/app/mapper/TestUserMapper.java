package cn.zooways.app.mapper;

import cn.zooways.app.entity.TestUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestUserMapper extends BaseMapper<TestUser> {
}