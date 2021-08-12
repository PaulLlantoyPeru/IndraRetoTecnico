package com.llantoy.RetoTecnico.service.implementation;


import com.llantoy.RetoTecnico.entity.Cliente;
import com.llantoy.RetoTecnico.repository.ClienteRepository;
import com.llantoy.RetoTecnico.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Cliente> findByTipoNumero(String tipo, String numero) {
        return clienteRepository.findByTipo_documentoAndNumero_documento(tipo,numero);
    }

    @Override
    public List<Cliente> clienteConsultaRangoFecha(Date inicio_, Date final_) {
        return clienteRepository.findBInicioAndFin(inicio_,final_);
    }


}
