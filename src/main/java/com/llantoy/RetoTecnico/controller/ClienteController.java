package com.llantoy.RetoTecnico.controller;

import com.llantoy.RetoTecnico.dto.RequestCliente;
import com.llantoy.RetoTecnico.dto.RequestClienteFecha;
import com.llantoy.RetoTecnico.entity.Cliente;
import com.llantoy.RetoTecnico.service.implementation.ClienteServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClienteController {

	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);

	@Autowired
	private ClienteServiceImpl clienteService;

	// Guardar
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/cliente", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente request) {

		Cliente response = new Cliente();
		HttpStatus httpStatus = null;

		try {
			response = clienteService.save(request);
			httpStatus = HttpStatus.OK;
			log.info("Guardando la información del cliente");
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			log.error("Error al guardar el cliente: " + e.getMessage());
		}

		return ResponseEntity.status(httpStatus).body(response);
	}

	// Listar todos los clientes segun primer requerimiento
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/clienteConsulta", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<Cliente>> clienteConsulta(@RequestBody RequestCliente requestCliente) {

		List<Cliente> response = new ArrayList<>();
		HttpStatus httpStatus = null;

		try {
			response = clienteService.findByTipoNumero(requestCliente.getTipo_documento(), requestCliente.getNumero());
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return ResponseEntity.status(httpStatus).body(response);
	}

	// Cliente listar
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/cliente", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<Cliente>> listClientes() {

		List<Cliente> response = new ArrayList<Cliente>();
		HttpStatus httpStatus = null;

		try {
			response = clienteService.findAll();
			httpStatus = HttpStatus.OK;

		} catch (Exception e) {
			System.out.println("Error listClientes Controller: " + e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return ResponseEntity.status(httpStatus).body(response);

	}

	// Listar por rangos de fechas
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/clienteConsultaRangoFecha", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<Cliente>> clienteConsulta(@RequestBody RequestClienteFecha requestClienteFecha) {

		List<Cliente> response = new ArrayList<>();
		HttpStatus httpStatus = null;

		try {
			response = clienteService.clienteConsultaRangoFecha(requestClienteFecha.getInicio_(),
					requestClienteFecha.getFinal_());
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return ResponseEntity.status(httpStatus).body(response);
	}

}
