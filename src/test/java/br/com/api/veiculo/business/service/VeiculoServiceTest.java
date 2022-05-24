package br.com.api.veiculo.business.service;

import br.com.api.veiculo.business.dto.VeiculoDTO;
import br.com.api.veiculo.business.entity.Veiculo;
import br.com.api.veiculo.business.exception.VeiculoNotFoundException;
import br.com.api.veiculo.business.repository.VeiculoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class VeiculoServiceTest {

  @InjectMocks
  private VeiculoService veiculoService;

  @Mock
  private VeiculoRepository veiculoRepository;

  private Veiculo veiculo;
  private static final Long VEICULO_ID = 1l;

  @Captor
  private ArgumentCaptor<Veiculo> veiculoArgumentCaptor;

  @BeforeEach
  public void init() {
    veiculo = Veiculo.builder().id(VEICULO_ID)
            .ano(2002)
            .tipo("carro")
            .modelo("A20")
            .cor("Branco")
            .build();
  }

  @Test
  void findById() {
    when(veiculoRepository.findById(VEICULO_ID)).thenReturn(Optional.of(veiculo));
    VeiculoDTO veiculoDTO = veiculoService.findById(veiculo.getId());
    assertEquals(veiculoDTO.getId(), veiculo.getId());
    assertEquals(veiculoDTO.getModelo(), veiculo.getModelo());
  }

  @Test
  void findByIdReturnThrowsAccountNotFoundException() {
    when(veiculoRepository.findById(any(Long.class))).thenReturn(Optional.empty());
    Assertions.assertThrows(VeiculoNotFoundException.class, () -> {
      veiculoService.findById(veiculo.getId());
    });

  }

  @Test
  void save() {
    VeiculoDTO veiculoDtoToSave = VeiculoDTO.builder()
            .ano(2002)
            .tipo("carro")
            .modelo("A20")
            .cor("Branco")
            .build();
    when(veiculoRepository.save(any(Veiculo.class))).thenReturn(veiculo);

    VeiculoDTO newVeiculoDTO = veiculoService.save(veiculoDtoToSave);

    verify(veiculoRepository).save(veiculoArgumentCaptor.capture());
    assertEquals(newVeiculoDTO.getModelo(), veiculoDtoToSave.getModelo());
    assertEquals(veiculoDtoToSave.getModelo(),
            veiculoArgumentCaptor.getValue().getModelo());
    assertNotNull(newVeiculoDTO.getId());
  }

}