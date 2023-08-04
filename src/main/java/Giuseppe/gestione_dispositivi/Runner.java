package Giuseppe.gestione_dispositivi;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import Giuseppe.gestione_dispositivi.dispositivi.DispositiviRequestPayload;
import Giuseppe.gestione_dispositivi.dispositivi.DispositiviService;
import Giuseppe.gestione_dispositivi.dispositivi.StatoDispositivo;
import Giuseppe.gestione_dispositivi.dispositivi.TipoDispositivo;
import Giuseppe.gestione_dispositivi.dispositivoAssegnato.DispositiviAssegnatiService;
import Giuseppe.gestione_dispositivi.utente.UtenteRequestPayload;
import Giuseppe.gestione_dispositivi.utente.UtenteService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	UtenteService utenteSrv;

	@Autowired
	DispositiviService dispositivoSrv;

	@Autowired
	DispositiviAssegnatiService dispositiviAssegnatiService;

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker(new Locale("it"));

		for (int i = 0; i < 8; i++) {
			String nome = faker.name().firstName();
			String cognome = faker.name().lastName();
			String email = faker.internet().emailAddress();
			String username = (nome + cognome).toLowerCase().trim();
			String password = "3456";
			UtenteRequestPayload utente = new UtenteRequestPayload(cognome, email, nome, password, username);
			// utenteSrv.create(utente);

		}

		DispositiviRequestPayload dipositivo1 = new DispositiviRequestPayload(StatoDispositivo.ASSEGNATO,
				TipoDispositivo.LAPTOP);
		DispositiviRequestPayload dipositivo2 = new DispositiviRequestPayload(StatoDispositivo.DISMESSO,
				TipoDispositivo.SMARTPHONE);
		DispositiviRequestPayload dipositivo3 = new DispositiviRequestPayload(StatoDispositivo.DISPONIBILE,
				TipoDispositivo.TABLET);
		DispositiviRequestPayload dipositivo4 = new DispositiviRequestPayload(StatoDispositivo.IN_MANUTENZIONE,
				TipoDispositivo.LAPTOP);

//		dispositivoSrv.create(dipositivo1);
//		dispositivoSrv.create(dipositivo2);
//		dispositivoSrv.create(dipositivo3);
//		dispositivoSrv.create(dipositivo4);

		// il metodo assegna dispositivo è commentato perche va runnato dopo aver creato
		// un utente e un dispositivo.
		// dopodiche basta inserire gli uuid nel metodo sia di utente che di dispostivo.

//		dispositiviAssegnatiService.assegnaDispositivo(UUID.fromString("32a8de46-11a3-44fb-a2e1-9dd92d454146"),
//				UUID.fromString("538bcba2-2e65-40d2-a5fd-32bccdbee914"));

	}

}
