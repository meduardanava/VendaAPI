package br.unipar.apivenda.mapper;


import br.unipar.apivenda.dto.DadosClienteDTO;
import br.unipar.apivenda.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ClienteMapper {

    @Mapping(source = "cliente", target = "DadosCliente")
    DadosClienteDTO dadosClienteDto(Cliente cliente);

}
