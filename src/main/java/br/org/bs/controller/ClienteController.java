package br.org.bs.controller;

import br.org.bs.model.entity.Cliente;
import br.org.bs.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente){

        return service.salvar(cliente);
    }
    @GetMapping("{id}")
    public Cliente findById(@PathVariable String id){

        return service.findById(id);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable String id){
        service.deletar(id);
    }
    @GetMapping
    public List listarClientes(){
        return service.listarClientes();
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCliemte(@PathVariable String id, @RequestBody Cliente cliente){
        service.atualizar(id, cliente);
    }


}
