package com.itikawabruno.ms.pedidos.repository;

import com.itikawabruno.ms.pedidos.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositoy extends JpaRepository<Pedido, Long> {
}
