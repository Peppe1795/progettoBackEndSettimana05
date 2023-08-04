package Giuseppe.gestione_dispositivi.dispositivi;

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
@RequestMapping("/dispositivi")
public class DispositiviController {
	private final DispositiviService dispositiviSrv;

	@Autowired
	private DispositiviController(DispositiviService dispositiviSrv) {
		super();
		this.dispositiviSrv = dispositiviSrv;
	}

	@GetMapping
	public Page<Dispositivi> getDispositivi(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return dispositiviSrv.find(page, size, sortBy);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Dispositivi saveDispositivo(@RequestBody DispositiviRequestPayload body) {
		Dispositivi created = dispositiviSrv.create(body);

		return created;
	}

	@GetMapping("/{dispositiviId}")
	public Dispositivi findById(@PathVariable UUID utenteId) {
		return dispositiviSrv.findById(utenteId);

	}

	@PutMapping("/{dispositiviId}")
	public Dispositivi updateDispositivo(@PathVariable UUID utenteId, @RequestBody DispositiviRequestPayload body) {
		return dispositiviSrv.findByIdAndUpdate(utenteId, body);
	}

	@DeleteMapping("/{dispositiviId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteDispositivo(@PathVariable UUID utenteId) {
		dispositiviSrv.findByIdAndDelete(utenteId);
	}

}
