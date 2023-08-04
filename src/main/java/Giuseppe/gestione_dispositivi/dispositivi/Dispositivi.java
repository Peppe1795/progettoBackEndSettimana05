package Giuseppe.gestione_dispositivi.dispositivi;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Dispositivi {
	@Id
	@GeneratedValue
	private UUID id;
	@Enumerated(EnumType.STRING)
	private StatoDispositivo statoDispositivo;
	@Enumerated(EnumType.STRING)
	private TipoDispositivo tipoDispositivo;

	public Dispositivi(StatoDispositivo statoDispositivo, TipoDispositivo tipoDispositivo) {
		super();
		this.statoDispositivo = statoDispositivo;
		this.tipoDispositivo = tipoDispositivo;
	}

}
