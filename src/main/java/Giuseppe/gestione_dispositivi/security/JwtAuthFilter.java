package Giuseppe.gestione_dispositivi.security;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import Giuseppe.gestione_dispositivi.Exception.UnauthorizedException;
import Giuseppe.gestione_dispositivi.utente.Utente;
import Giuseppe.gestione_dispositivi.utente.UtenteService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
	@Autowired
	JwtTools jwttools;
	@Autowired
	UtenteService utenteService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authHeader = request.getHeader("Authorization");

		if (authHeader == null || !authHeader.startsWith("Bearer "))
			throw new UnauthorizedException("Per favore passa il token nell'authorization header");
		String token = authHeader.substring(7);
		System.out.println("TOKEN -------> " + token);

		jwttools.verifyToken(token);

		String id = jwttools.extractSubject(token);
		Utente currentUser = utenteService.findById(UUID.fromString(id));

		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(currentUser, null,
				currentUser.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authToken);

		filterChain.doFilter(request, response);

	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		System.out.println(request.getServletPath());

		return new AntPathMatcher().match("/auth/**", request.getServletPath());
	}

}
