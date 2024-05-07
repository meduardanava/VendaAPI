package br.unipar.apivenda.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ValorTotalVendaDTO {

    private String nomeCliente;
    private BigDecimal valorTotalVenda;

}
