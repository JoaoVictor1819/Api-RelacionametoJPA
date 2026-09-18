package Api.company.relationships.database.repository;

import Api.company.relationships.database.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
