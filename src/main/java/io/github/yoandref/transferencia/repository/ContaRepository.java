package io.github.yoandref.transferencia.repository;

import io.github.yoandref.transferencia.entity.Conta;
import io.github.yoandref.transferencia.entity.ContaChaveComposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, ContaChaveComposta> {

}
