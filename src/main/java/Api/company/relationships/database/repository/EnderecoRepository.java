package Api.company.relationships.database.repository;

import Api.company.relationships.database.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Cargo, Long> {
}
