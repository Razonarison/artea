package mg.tana.location.application.port.out;

import mg.tana.location.domain.model.Contrat;

import java.util.List;
import java.util.Optional;

public interface ContratRepositoryPort {

    Contrat save(Contrat contrat);

    Optional<Contrat> findById(Long id);

    List<Contrat> findAll();
}
