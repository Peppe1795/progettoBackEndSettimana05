package Giuseppe.gestione_dispositivi.dispositivoAssegnato;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositiviAssegnatiRepository extends JpaRepository<DispositiviAssegnati, UUID> {

}
