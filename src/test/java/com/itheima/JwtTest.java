package com.itheima;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void testGen() {
        Map<String,Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "zhangsan");
        // 生成jwt的代码
        String token = JWT.create()
                .withClaim("user", claims)// 设置载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))// 设置过期时间为1天
                .sign(Algorithm.HMAC256("itheima")); // 设置签名，使用HMAC256算法，并设置SecretKey(字符串)
        System.out.println(token);
    }

    @Test
    public void testParse(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6InpoYW5nc2FuIn0sImV4cCI6MTcwMjIwNzM1NX0." +
                "-GSWVGSnGGgpVt8wDSzkl9AMn4f5RvYOkAfbZ_uupBE";

        // 解析jwt的代码
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("itheima")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);// 验证token，生成一个解析后的JWT对象
        Map<String, Claim> claims = decodedJWT.getClaims();// 获取载荷信息
        Claim user = claims.get("user");// 获取指定的载荷信息
        System.out.println(user.asMap());
    }
}