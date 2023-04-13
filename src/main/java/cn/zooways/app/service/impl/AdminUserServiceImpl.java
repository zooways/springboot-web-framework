package cn.zooways.app.service.impl;

import cn.zooways.app.entity.AdminUserEntity;
import cn.zooways.app.mapper.AdminUserMapper;
import cn.zooways.app.service.AdminUserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Description:
 * @Author: Zoowayss Shi
 * @Date: 2023/4/13 13:39
 * @Version: 1.0
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUserEntity> implements AdminUserService, InitializingBean {

    @Value("${core.user.jwtSecret:secret}")
    private String secret;
    private Algorithm algorithm;
    private JWTVerifier verifier;

    @Override
    public String verifyAndGetUserId(String token) {
        try {
            DecodedJWT decodedJWT = verifier.verify(token);
            String userId = decodedJWT.getClaim("adminId").asString();
            if (StringUtils.hasText(userId)) {
                AdminUserEntity adminUserEntity = getById(userId);
                if (adminUserEntity != null && adminUserEntity.getStatus() == AdminUserEntity.STATUS_NORMAL) {
                    return userId;
                }
            }
            return null;
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        algorithm = Algorithm.HMAC256("admin " + secret);
        verifier = JWT.require(algorithm).build();
    }
}
