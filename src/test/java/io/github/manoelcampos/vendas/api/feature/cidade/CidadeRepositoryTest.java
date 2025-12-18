package io.github.manoelcampos.vendas.api.feature.cidade;

import org.junit.jupiter.api.Test;
import org.springdoc.core.service.GenericResponseService;
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
    /// Injeção de Dependêndica: instanciar automaticamente objetos
    /// Só funciona se a classe onde o objeto será instanciado
    /// for um Spring Bean, ou seja, for um objeto criado e gerenciado
    /// pelo Spring.
    /// `@Autowirded`: pedir pro spring instanciar um objeto pra mim.
    /// Ele só faz isso com objetos Spring Bean.
    @Autowired
    private CidadeRepository repository;
    @Autowired
    private GenericResponseService responseBuilder;

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
}
