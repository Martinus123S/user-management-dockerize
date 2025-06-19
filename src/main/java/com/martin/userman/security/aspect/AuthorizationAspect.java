package com.martin.userman.security.aspect;

import com.martin.userman.repository.UserRepository;
import com.martin.userman.security.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Aspect
@Component
@RequiredArgsConstructor
public class AuthorizationAspect {
	private final HttpServletRequest request;
	private final JWTUtil jwtUtil;
	private final UserRepository userRepository;

	@Before("@annotation(com.martin.userman.security.annotation.Authorized)")
	public void authorize() {
		String authHeader = request.getHeader("Authorization");
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Missing or invalid token");
		}

		String token = authHeader.substring(7);
		if (!jwtUtil.isTokenValid(token)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token is invalid or expired");
		}

		String email = jwtUtil.extractEmail(token);
		if (Objects.isNull(userRepository.findByEmail(email))) {
			new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found");
		}
	}
}
