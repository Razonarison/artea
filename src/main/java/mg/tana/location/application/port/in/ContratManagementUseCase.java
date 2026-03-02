package mg.tana.location.application.port.in;

import mg.tana.location.application.command.CreateContratCommand;
import mg.tana.location.domain.model.Contrat;
import mg.tana.location.infrastructure.in.rest.dto.response.ContratListResponse;

import java.util.List;

public interface ContratManagementUseCase {

    Contrat createContrat(CreateContratCommand command);

    List<ContratListResponse> listContrats();

    Contrat getContrat(Long id);
}
