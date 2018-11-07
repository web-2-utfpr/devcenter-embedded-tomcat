/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {

    private static String key;

    static {
        key = System.getenv("JWT_SECRET");
        if (key == null) {
            key = "secret";
        }
    }

    public static final String TOKEN_HEADER = "Authorization";

    public static String create(String subject) {

        return Jwts.builder()
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

    public static Jws<Claims> decode(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token);
    }

}
