package Giuseppe.gestione_dispositivi.dispositivoAssegnato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispositiviAssegnatiService {
	private final DispositiviAssegnatiRepository dispositiviAssegnatiRepo;

	@Autowired
	private DispositiviAssegnatiService(DispositiviAssegnatiRepository dispositiviAssegnatiRepo) {
		super();
		this.dispositiviAssegnatiRepo = dispositiviAssegnatiRepo;
	}

}
