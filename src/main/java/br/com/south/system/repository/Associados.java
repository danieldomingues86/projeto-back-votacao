package br.com.south.system.repository;

import br.com.south.system.model.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface Associados extends JpaRepository<Associado, Long> {

    @Query("SELECT obj FROM Associado obj WHERE obj.cpf =:cpf")
    Optional<Associado> findByCpf(Long cpf);

}
