package br.unipar.apivenda.mapper;

import br.unipar.apivenda.dto.DadosClienteDTO;
import br.unipar.apivenda.dto.QuantidadeVendaClienteDTO;
import br.unipar.apivenda.dto.ValorTotalVendaDTO;
import br.unipar.apivenda.model.Cliente;
import br.unipar.apivenda.model.Venda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;

@Mapper
public interface VendaMapper {

    @Mapping(source = "cliente.nome", target = "nomeCliente")
    @Mapping(source = "total", target = "valorTotalVenda")
    ValorTotalVendaDTO mapToValorTotalVendaDTO(BigDecimal total, Cliente cliente);

    @Mapping(source = "cliente.nome", target = "nomeCliente")
    @Mapping(source = "quantidadeVenda", target = "quantVendaCliente")
    QuantidadeVendaClienteDTO mapToQuantidadeVendaClienteDTO(Cliente cliente, int quantidadeVenda);

    @Mapping(source = "cliente.nome", target = "nomeCliente")
    @Mapping(source = "cliente.telefone", target = "telefoneCliente")
    @Mapping(source = "cliente.aniversario", target = "aniversarioCliente")
    DadosClienteDTO mapToDadosClienteDTO(Venda venda);
}
