package br.org.bs.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(nullable = false, length = 255)
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "id_Cliente")
    private Cliente cliente;
}
