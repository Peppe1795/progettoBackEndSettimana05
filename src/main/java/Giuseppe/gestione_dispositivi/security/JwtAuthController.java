package Giuseppe.gestione_dispositivi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Giuseppe.gestione_dispositivi.Exception.UnauthorizedException;
import Giuseppe.gestione_dispositivi.utente.Utente;
import Giuseppe.gestione_dispositivi.utente.UtenteLoginPayload;
import Giuseppe.gestione_dispositivi.utente.UtenteRequestPayload;
import Giuseppe.gestione_dispositivi.utente.UtenteService;

@RestController
@RequestMapping("/auth")
public class JwtAuthController {
	@Autowired
	UtenteService utenteService;

	@Autowired
	JwtTools jwtTools;

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUser(@RequestBody UtenteRequestPayload body) {
		Utente created = utenteService.create(body);

		return created;
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UtenteLoginPayload body) {

		Utente user = utenteService.findByEmail(body.getEmail());

		if (body.getPassword().equals(user.getPassword())) {

			String token = jwtTools.createToken(user);
			return new ResponseEntity<>(token, HttpStatus.OK);

		} else {

			throw new UnauthorizedException("Credenziali non valide!");
		}
	}

}
