package br.unipar.apivenda.service;

import br.unipar.apivenda.model.Cliente;
import br.unipar.apivenda.repository.ClienteRepository;
import br.unipar.apivenda.repository.VendaRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.List;

@Stateless
public class ClienteService {

    @Inject
    private ClienteRepository clienteRepository;

    @Inject
    private VendaRepository vendaRepository;

    public List<Cliente> listar() {
        return clienteRepository.listar();
    }

    public Cliente buscarPorID(Integer id) {
        return clienteRepository.buscaPorID(id);
    }

    public void cadastrar(Cliente cliente) throws Exception {
        clienteRepository.cadastrar(cliente);
    }

    public void editar(Cliente cliente) throws Exception {
        clienteRepository.editar(cliente);
    }

    public void excluir(Cliente cliente) throws Exception {
        clienteRepository.excluir(cliente);
    }

    public BigDecimal obterValorTotalVendaPorCliente(Integer idCliente) {
        return vendaRepository.obterValorTotalVendaPorCliente(idCliente);
    }

}