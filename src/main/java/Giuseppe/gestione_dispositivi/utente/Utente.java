package Giuseppe.gestione_dispositivi.utente;

import java.util.UUID;

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
public class Utente {
	@Id
	@GeneratedValue
	private UUID id;
	private String username;
	private String nome;
	private String cognome;
	private String email;

	public Utente(String username, String nome, String cognome, String email) {
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}

}
