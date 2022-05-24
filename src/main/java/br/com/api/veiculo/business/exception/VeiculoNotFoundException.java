package br.com.api.veiculo.business.exception;

public class VeiculoNotFoundException extends ApplicationException {

  private static final String errorMsg = "Veiculo não encontrado!";

  public VeiculoNotFoundException() {
    super(errorMsg);
  }
}
