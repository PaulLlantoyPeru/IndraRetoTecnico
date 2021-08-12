package com.llantoy.RetoTecnico.service;

import com.llantoy.RetoTecnico.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ClienteService {

    Cliente save (Cliente cliente);
    List<Cliente> findAll();
    List<Cliente> findByTipoNumero(String tipo, String numero);
    List<Cliente> clienteConsultaRangoFecha(Date inicio_, Date final_);



}
