package mg.tana.location.application.port.out;

import mg.tana.location.domain.model.Contrat;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContratRepositoryPort {

    Contrat save(Contrat contrat);

    Optional<Contrat> findById(UUID id);

    List<Contrat> findAll();
}
