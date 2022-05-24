package br.com.api.veiculo.controller;

import br.com.api.veiculo.business.dto.VeiculoDTO;
import br.com.api.veiculo.business.service.VeiculoService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/veiculo", produces = MediaType.APPLICATION_JSON_VALUE)
public class VeiculosController {

  @NonNull
  private final VeiculoService accountService;

  @GetMapping(path = "/{veiculoId}")
  public VeiculoDTO find(@PathVariable Long veiculoId) {
    return accountService.findById(veiculoId);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public VeiculoDTO save(@RequestBody final VeiculoDTO veiculoDTO) {
    return accountService.save(veiculoDTO);
  }

}