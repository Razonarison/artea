package mg.tana.location.infrastructure.out;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import mg.tana.location.application.port.out.ContratRepositoryPort;
import mg.tana.location.domain.model.Contrat;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ContratRepositoryAdapter implements ContratRepositoryPort {

    @Override
    @Transactional
    public Contrat save(Contrat contrat) {
        if (contrat.getId() == null) {
            contrat.persist();
            return contrat;
        }

        Contrat existing = Contrat.findById(contrat.getId());
        if (existing == null) {
            contrat.persist();
            return contrat;
        }

        existing.setType(contrat.getType());
        existing.setDebutContrat(contrat.getDebutContrat());
        existing.setFinContrat(contrat.getFinContrat());
        existing.setSalaireBase(contrat.getSalaireBase());
        existing.setValide(contrat.isValide());

        return existing;
    }

    @Override
    public Optional<Contrat> findById(Long id) {
        return Optional.ofNullable(Contrat.findById(id));
    }

    @Override
    public List<Contrat> findAll() {
        return Contrat.listAll();
    }
}
