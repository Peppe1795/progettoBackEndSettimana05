package Giuseppe.gestione_dispositivi.dispositivoAssegnato;

import java.util.UUID;

import Giuseppe.gestione_dispositivi.dispositivi.Dispositivi;
import Giuseppe.gestione_dispositivi.utente.Utente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DispositiviAssegnati {
	@Id
	@GeneratedValue
	private UUID id;
	private Utente utente;
	private Dispositivi dispositivi;
}
