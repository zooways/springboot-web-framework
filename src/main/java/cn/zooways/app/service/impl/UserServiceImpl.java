package cn.zooways.app.service.impl;

import cn.zooways.app.service.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Description:
 * @Author: Zoowayss Shi
 * @Date: 2023/4/13 13:35
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService, InitializingBean {
    @Value("${core.user.jwtSecret:secret}")
    private String secret;
    private Algorithm algorithm; //use more secure key
    private JWTVerifier verifier; //Reusable verifier instance
    @Override
    public String verifyAndGetUserId(String token) {
        try {
            DecodedJWT decodedJWT = verifier.verify(token);
            String id = decodedJWT.getClaim("id").asString();
            return id;
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    @Override
    public Set<String> getRoles(String token) {
        return UserService.super.getRoles(token);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        algorithm = Algorithm.HMAC256(secret);
        verifier = JWT.require(algorithm).build();
    }
}
