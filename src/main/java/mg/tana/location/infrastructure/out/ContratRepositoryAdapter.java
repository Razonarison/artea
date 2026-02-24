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
    public Contrat save(Contrat contrat)  {
        if (contrat.getId() == null) {
            contrat.persist();
            return contrat;
        }

        Optional<Contrat> existing = findById(contrat.getId());
        if (!existing.isPresent()) {
            contrat.persist();
            return contrat;
        }

        existing.get().setType(contrat.getType());
        existing.get().setDebutContrat(contrat.getDebutContrat());
        existing.get().setFinContrat(contrat.getFinContrat());
        existing.get().setValide(contrat.isValide());

        return existing.get();
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
