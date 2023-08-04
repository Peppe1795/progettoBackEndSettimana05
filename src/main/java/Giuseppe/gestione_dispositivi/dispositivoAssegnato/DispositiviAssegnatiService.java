package Giuseppe.gestione_dispositivi.dispositivoAssegnato;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Giuseppe.gestione_dispositivi.dispositivi.Dispositivi;
import Giuseppe.gestione_dispositivi.dispositivi.DispositiviRepository;
import Giuseppe.gestione_dispositivi.utente.Utente;
import Giuseppe.gestione_dispositivi.utente.UtenteRepository;

@Service
public class DispositiviAssegnatiService {
	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private DispositiviRepository dispositivoRepository;

	public void assegnaDispositivo(UUID dispositiviId, UUID utentiId) {
		Utente utente = utenteRepository.findById(utentiId)
				.orElseThrow(() -> new IllegalArgumentException("Utente non trovato con ID: " + utentiId));
		Dispositivi dispositivo = dispositivoRepository.findById(dispositiviId)
				.orElseThrow(() -> new IllegalArgumentException("Dispositivo non trovato con ID: " + dispositiviId));
		dispositivo.setUtente(utente);
		dispositivoRepository.save(dispositivo);
	}

}
