package Api.company.relationships.database.repository;

import Api.company.relationships.database.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
}
