package br.com.api.veiculo.business.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VeiculoDTO {

  private Long id;
  private int ano;
  private String modelo;
  private String tipo;
  private String cor;

}
