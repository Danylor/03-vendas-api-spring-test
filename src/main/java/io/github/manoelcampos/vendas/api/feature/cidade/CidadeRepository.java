package io.github.manoelcampos.vendas.api.feature.cidade;

import io.github.manoelcampos.vendas.api.shared.EntityRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Essa interface é um Spring Bean: um objeto que o Spring controla o ciclo de vida
@Repository
public interface CidadeRepository extends EntityRepository<Cidade> {
    // select * from cidade where descricao like 'descricao'
    List<Cidade> findByDescricaoLike(String descricao);
}
