package sv.edu.udb.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    //Clave secreta
    private static final String SECRET_KEY = "miclavesupersecretamiclavesupersecret";

    //Generar llave
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    //Generar token
    public String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //Extraer username
    public String extractUsername(String token) {

        return extractClaims(token).getSubject();
    }

    //Validar token
    public boolean isTokenValid(String token, String username) {

        String user = extractUsername(token);

        return user.equals(username);
    }

    //Extraer claims
    private Claims extractClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}