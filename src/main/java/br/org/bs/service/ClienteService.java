package br.org.bs.service;

import br.org.bs.model.entity.Cliente;
import br.org.bs.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository repository;

    public List listarClientes(){
        return repository.findAll();
    }

    public Cliente salvar(Cliente cliente){

        return repository.save(cliente);
    }
    public Cliente findById(String id){
        return repository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public void deletar(String id){
        repository.findById(id)
                .map(Cliente -> {
                    repository.delete(Cliente);
                    return Void.TYPE;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public void atualizar(String id, Cliente atualizarCliente){
        repository.findById(id)
                .map(cliente ->{
                   cliente.setNome(atualizarCliente.getNome());
                   cliente.setCpf(atualizarCliente.getCpf());
                   cliente.setHoraModificada(LocalTime.now());
                   cliente.setDataModificacao(LocalDate.now());
                    return repository.save(cliente);
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
