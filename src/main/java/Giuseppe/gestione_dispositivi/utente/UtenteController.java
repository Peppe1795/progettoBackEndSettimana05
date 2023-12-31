package Giuseppe.gestione_dispositivi.utente;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

	private final UtenteService utenteSrv;

	@Autowired
	public UtenteController(UtenteService utenteSrv) {
		super();
		this.utenteSrv = utenteSrv;
	}

	@GetMapping
	public Page<Utente> getUtenti(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return utenteSrv.find(page, size, sortBy);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUtente(@RequestBody UtenteRequestPayload body) {
		Utente created = utenteSrv.create(body);

		return created;
	}

	@GetMapping("/{utenteId}")
	public Utente findById(@PathVariable UUID utenteId) {
		return utenteSrv.findById(utenteId);

	}

	@PutMapping("/{utenteId}")
	public Utente updateUtente(@PathVariable UUID utenteId, @RequestBody UtenteRequestPayload body) {
		return utenteSrv.findByIdAndUpdate(utenteId, body);
	}

	@DeleteMapping("/{utenteId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUtente(@PathVariable UUID utenteId) {
		utenteSrv.findByIdAndDelete(utenteId);
	}

}
