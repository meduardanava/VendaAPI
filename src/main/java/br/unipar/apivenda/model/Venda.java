package br.unipar.apivenda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal total;

    private String observacoes;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "venda", orphanRemoval = true)
    private List<ItensVenda> itens;

}
