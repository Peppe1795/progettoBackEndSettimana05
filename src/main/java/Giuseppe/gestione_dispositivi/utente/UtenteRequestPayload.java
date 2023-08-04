package Giuseppe.gestione_dispositivi.utente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UtenteRequestPayload {
	private String username;
	private String nome;
	private String cognome;
	private String email;
}
