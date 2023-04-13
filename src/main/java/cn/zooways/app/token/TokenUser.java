package cn.zooways.app.token;

import lombok.Data;

@Data
public class TokenUser {

    private String userId;

    public TokenUser(String userId) {
        this.userId = userId;
    }

}
