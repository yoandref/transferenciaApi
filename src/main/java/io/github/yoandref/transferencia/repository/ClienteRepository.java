package io.github.yoandref.transferencia.repository;

import io.github.yoandref.transferencia.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
