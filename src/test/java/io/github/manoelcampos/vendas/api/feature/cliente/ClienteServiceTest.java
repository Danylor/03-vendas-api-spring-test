package io.github.manoelcampos.vendas.api.feature.cliente;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {
    @InjectMocks
    private ClienteService service;

    @Mock
    private ClienteRepository repository;

    @Test
    void findByCpf() {
        final var cpfComSimolos = "348.113.930-66";
        final var cpfSemSimolos = "34811393066";
        Optional<Cliente> optional = Optional.of(new Cliente());
        Mockito.when(repository.findByCpf(cpfSemSimolos))
                .thenReturn(optional);
        assertTrue(service.findByCpf(cpfComSimolos).isPresent());
        //Mockito.verify(repository).findByCpf(cpf);
    }
}