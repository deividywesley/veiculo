package br.com.api.veiculo.business.service;

import br.com.api.veiculo.business.dto.VeiculoDTO;
import br.com.api.veiculo.business.entity.Veiculo;
import br.com.api.veiculo.business.exception.VeiculoNotFoundException;
import br.com.api.veiculo.business.repository.VeiculoRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class VeiculoService {

  @NonNull
  private final VeiculoRepository veiculoRepository;

  public VeiculoDTO findById(Long id) {
    return findOptionalById(id).map(this::entityToDTO)
        .orElseThrow(VeiculoNotFoundException::new);
  }

  public VeiculoDTO save(VeiculoDTO veiculoDTO) {
    return entityToDTO(veiculoRepository.save(dtoToEntity(veiculoDTO)));
  }

  public Optional<Veiculo> findOptionalById(Long id) {
    return veiculoRepository.findById(id);
  }

  private Veiculo dtoToEntity(final VeiculoDTO veiculoDTO) {
    return Veiculo.builder().id(veiculoDTO.getId())
            .ano(veiculoDTO.getAno())
            .cor(veiculoDTO.getCor())
            .modelo(veiculoDTO.getModelo())
            .tipo(veiculoDTO.getTipo())
        .build();
  }

  private VeiculoDTO entityToDTO(final Veiculo veiculo) {
    return VeiculoDTO.builder().id(veiculo.getId())
            .ano(veiculo.getAno())
            .cor(veiculo.getCor())
            .modelo(veiculo.getModelo())
            .tipo(veiculo.getTipo())
            .build();
  }

}