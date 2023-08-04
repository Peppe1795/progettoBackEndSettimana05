package Giuseppe.gestione_dispositivi.dispositivoAssegnato;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Giuseppe.gestione_dispositivi.dispositivi.Dispositivi;
import Giuseppe.gestione_dispositivi.dispositivi.DispositiviService;
import Giuseppe.gestione_dispositivi.dispositivi.StatoDispositivo;
import Giuseppe.gestione_dispositivi.utente.Utente;
import Giuseppe.gestione_dispositivi.utente.UtenteService;

@Service
public class DispositiviAssegnatiService {
	private final DispositiviService dispositivoService;
	private final UtenteService utenteService;

	@Autowired
	private DispositiviAssegnatiService(DispositiviService dispositivoService, UtenteService utenteService) {
		super();
		this.dispositivoService = dispositivoService;
		this.utenteService = utenteService;
	}

	public String assegnaDispositivo(UUID utenteId, UUID dispositivoId) {
		// Controlla se il dispositivo esiste nel database
		Dispositivi dispositivo = dispositivoService.findById(dispositivoId);
		if (dispositivo == null) {
			return "Dispositivo non trovato.";
		}

		// Controlla se il dispositivo è in manutenzione
		if (dispositivo.getStatoDispositivo() == StatoDispositivo.IN_MANUTENZIONE) {
			return "Il dispositivo è in manutenzione e non può essere assegnato.";
		}

		// Controlla se il dispositivo è già assegnato all'utente corrente
		if (dispositivo.getStatoDispositivo() == StatoDispositivo.ASSEGNATO && dispositivo.getUtente() != null
				&& dispositivo.getUtente().getId().equals(utenteId)) {
			return "Il dispositivo è già assegnato all'utente.";
		}

		// Controlla se l'utente esiste nel database
		Utente utente = utenteService.findById(utenteId);
		if (utente == null) {
			return "Utente non trovato.";
		}

		// Assegna il dispositivo all'utente e cambia il suo stato a "ASSEGNATO"
		dispositivo.setUtente(utente);
		dispositivo.setStatoDispositivo(StatoDispositivo.ASSEGNATO);
		dispositivoService.saveDispositivo(dispositivo);

		return "Dispositivo assegnato con successo all'utente.";
	}
}
