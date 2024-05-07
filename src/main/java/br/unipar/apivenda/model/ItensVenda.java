package br.unipar.apivenda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class ItensVenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal valorUnitario;

    private BigDecimal valorTotal;

    private Integer quantidade;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    @JsonIgnore
    private Venda venda;

}
