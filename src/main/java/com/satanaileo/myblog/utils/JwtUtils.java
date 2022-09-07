package com.satanaileo.myblog.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * satanaileo
 * 2022/9/3 17:48
 */
@Slf4j
@Component
@Data
@ConfigurationProperties(prefix = "satanaileo.jwt")
public class JwtUtils {
    private String secret;
    private long expire;
    private String header;


    /**
    * 生成Jwt token
    * @author satanaileo
    * 2022/9/3 17:51
    **/
    public String generateToken(long userId) {
        Date nowDade = new Date();
        Date expireDate = new Date(nowDade.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(userId+"")
                .setIssuedAt(nowDade)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    
    /** 
    * 获取jwt的信息
    * @author satanaileo
    * 2022/9/3 17:52
    **/
    public Claims getClaimByToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJwt(token)
                .getBody();
    }
    
    
    /** 
    * token是否过期
    * @author satanaileo
    * 2022/9/3 17:53
    **/
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }
}
