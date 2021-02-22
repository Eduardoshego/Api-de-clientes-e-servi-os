package br.org.bs.repository;

import br.org.bs.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, String> {
}
