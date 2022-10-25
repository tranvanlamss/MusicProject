package com.example.soundlifeapi.utils;


import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtils {
    private final String JWT_SECRET = "1900819866771508";
    private final long JWT_EXPIRATION = 6000000000L;

    public String generateToken(User userDetails){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String getUserNameFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String authToken){
        try{
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        }catch (MalformedJwtException e){
            System.out.println("Token Invalid");
        }catch (ExpiredJwtException e){
            System.out.println("Token Expired");
        }catch (UnsupportedJwtException e) {
            System.out.println("Unsupported token");
        }catch (IllegalArgumentException e){
            System.out.println("Jwt claims string is empty");
        }
        return false;
    }
}
