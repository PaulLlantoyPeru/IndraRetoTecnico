package com.llantoy.RetoTecnico.repository;

import com.llantoy.RetoTecnico.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {


    List<Cliente> findByTipo_documentoAndNumero_documento(String tipo, String numero);
    List<Cliente> findBInicioAndFin(Date inicio_, Date final_);

}
