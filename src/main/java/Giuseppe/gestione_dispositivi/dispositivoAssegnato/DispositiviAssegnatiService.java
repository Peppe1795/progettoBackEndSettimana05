//package Giuseppe.gestione_dispositivi.dispositivoAssegnato;
//
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import Giuseppe.gestione_dispositivi.Exception.NotFoundException;
//import Giuseppe.gestione_dispositivi.utente.Utente;
//import Giuseppe.gestione_dispositivi.utente.UtenteRequestPayload;
//
//@Service
//public class DispositiviAssegnatiService {
//	private final DispositiviAssegnatiRepository dispositiviAssegnatiRepo;
//
//	@Autowired
//	private DispositiviAssegnatiService(DispositiviAssegnatiRepository dispositiviAssegnatiRepo) {
//		super();
//		this.dispositiviAssegnatiRepo = dispositiviAssegnatiRepo;
//	}
//
//	public DispositiviAssegnati create(UtenteRequestPayload body) {
//
//		DispositiviAssegnati nuovoUtente = new Utente(body.getNome(), body.getCognome(), body.getEmail(),
//				body.getUsername(), body.getPassword());
//		return dispositiviAssegnatiRepo.save(nuovoUtente);
//	}
//
//	public Page<DispositiviAssegnati> find(int page, int size, String sort) {
//		Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
//		return dispositiviAssegnatiRepo.findAll(pageable);
//	}
//
//	public DispositiviAssegnati findById(UUID id) throws NotFoundException {
//		return dispositiviAssegnatiRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
//	}
//
//	public DispositiviAssegnati findByIdAndUpdate(UUID id, UtenteRequestPayload body) throws NotFoundException {
//		DispositiviAssegnati found = this.findById(id);
//		found.setEmail(body.getEmail());
//		found.setNome(body.getNome());
//		found.setCognome(body.getCognome());
//		found.setUsername(body.getUsername());
//		found.setPassword(body.getPassword());
//
//		return dispositiviAssegnatiRepo.save(found);
//	}
//
//	public void findByIdAndDelete(UUID id) throws NotFoundException {
//		DispositiviAssegnati found = this.findById(id);
//		dispositiviAssegnatiRepo.delete(found);
//	}
//
//}
