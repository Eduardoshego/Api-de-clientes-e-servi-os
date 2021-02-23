package br.org.bs.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;
    @Column(nullable = false, length = 11)
    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;
    @Column(name = "data_cadastro")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;
    @Column(name = "hora_cadastro")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime horaCadastro;
    @Column(name = "data_modificacao")
    @JsonFormat(pattern ="dd/MM/yyyy" )
    private LocalDate dataModificacao;
    @Column(name = "hora_modificada")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime horaModificada;

    @PrePersist
    public void dataCadastro(){
        setDataCadastro(LocalDate.now());
        setHoraCadastro(LocalTime.now());
    }



}
