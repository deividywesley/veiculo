package br.com.api.veiculo.business.repository;

import br.com.api.veiculo.business.entity.Veiculo;
import org.springframework.data.repository.CrudRepository;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {

}
