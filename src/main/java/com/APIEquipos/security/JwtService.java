package com.APIEquipos.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY="eb82679f3a8e589432a65489573ee085b50e90bf42f639dc5bb1b263145edd47d975c2df210571bf00d8022abedf2e07cc1115344391b109dbccdf06a8621a6968ea515b74d46512fb449d0e6711ad08fa78f45d2d2dd2eeea3c1ae4e897683a338145fee3d079f75a4c45abd880d1a6b3a3d6629b66ef241bbfd174c73ff3e001667dde65cbf05a0a807d64726f42121ed57053099b50b97860f7d96ed84d2c44560df66399930ee37f968b37f309385d3c7ad58f15c65a273d2495edcc1b997fa911c0e94a30f92f4fe581b27824506dab1d2cc19814590257c36dcec80070a366ce0cc00471a0dcf51449847af3bb411867e7e23d305d363bec34db4b683e";


    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims,UserDetails userDetails){
        return Jwts.builder().setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsername(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public <T> T getClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    private Key getSignInKey(){
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username=getUsername(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    private Date getExpiration(String token) {
        return getClaim(token,Claims::getExpiration);
    }
}
