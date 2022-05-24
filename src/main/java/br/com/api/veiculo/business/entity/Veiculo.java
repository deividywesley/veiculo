package br.com.api.veiculo.business.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "veiculo", schema = "api")
@Builder
@AllArgsConstructor
public class Veiculo implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "ano")
  private int ano;

  @NotNull
  @Column(name = "modelo")
  private String modelo;

  @NotNull
  @Column(name = "tipo")
  private String tipo;

  @NotNull
  @Column(name = "cor")
  private String cor;

  public Veiculo() {
  }
}