package io.github.manoelcampos.vendas.api.feature.cidade;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// Java Bean (bean = feijão ou grão): objeto java com getters e setters
// Spring bean: objeto gerenciado pelo Spring.
// JPA = Java Persistence API: é apenas uma especificação (como uma norma)
// (API de Object Relational Mapping - ORM: Mapeamento Objeto-Relacional)
@DataJpaTest
class CidadeRepositoryTest {
    @Autowired
    private CidadeRepository repository;

    @Test
    void findByDescricaoLike() {
        final var listaObtida = repository.findByDescricaoLike("São %");

        final var listaEsperada =
                List.of(
                        new Cidade(1L, "São Paulo"),
                        new Cidade(13L, "São Luiz"),
                        new Cidade(28L, "São José dos Campos"));
        assertThat(listaObtida).size().isEqualTo(listaEsperada.size());
        assertThat(listaObtida).containsAll(listaEsperada);
    }


    @Test
    void deleteById() {
        //Uma variável é como uma caixa também,
        // mas quando ela contém null, é como se a caixa nao existisse
        //Cidade cidade =  null;
        //cidade.getId()

        final long id = 28;
        // TODO Usar Preconditions do AssertJ (ou do JUnit)
        assertThat(repository.findById(id)).isPresent();

        // delete from cidade where id = 28
        repository.deleteById(id);

        // Optional é como uma caixa que conter algo ou não
        assertThat(repository.findById(id)).isEmpty();
    }
}
