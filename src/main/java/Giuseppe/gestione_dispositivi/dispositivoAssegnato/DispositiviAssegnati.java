package Giuseppe.gestione_dispositivi.dispositivoAssegnato;

import java.util.UUID;

import Giuseppe.gestione_dispositivi.dispositivi.Dispositivi;
import Giuseppe.gestione_dispositivi.utente.Utente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DispositiviAssegnati {
	@Id
	@GeneratedValue
	private UUID id;
	@ManyToOne
	private Utente utente;
	@ManyToOne
	private Dispositivi dispositivi;

	private DispositiviAssegnati(Utente utente, Dispositivi dispositivi) {
		this.utente = utente;
		this.dispositivi = dispositivi;
	}

}
