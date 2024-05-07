package br.unipar.apivenda.controller;

import br.unipar.apivenda.dto.QuantidadeVendaClienteDTO;
import br.unipar.apivenda.dto.ValorTotalVendaDTO;
import br.unipar.apivenda.model.Cliente;
import br.unipar.apivenda.model.Venda;
import br.unipar.apivenda.service.ClienteService;
import br.unipar.apivenda.service.VendaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;

@Path("/venda")
public class VendaController {

    @Inject
    private VendaService vendaService;

    @Inject
    private ClienteService clienteService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response listarVendaPorID(@PathParam("id") Integer id) {

        Venda venda = vendaService.buscarPorID(id);

        if (venda == null)
            return Response.status(204).entity("Venda não encontrada").build();

    return Response.ok(vendaService.buscarPorID(id)).build();
    }

    @POST
    @Path("/{id}")
    public Response cadastrarVenda(@PathParam("id") Integer id) {
        try {
            Venda venda = vendaService.buscarPorID(id);
            vendaService.cadastrar(venda);
            return Response.status(201).entity("Venda cadastrada com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response editarVenda(@PathParam("id") Integer id) {
        try {
            Venda venda = vendaService.buscarPorID(id);
            vendaService.editar(venda);
            return Response.status(201).entity("Venda editada com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response excluirVenda(@PathParam("id") Integer id) {
        try {
            Venda venda = vendaService.buscarPorID(id);
            vendaService.excluir(venda);
            if (venda == null) {
                return Response.status(404).entity("Venda não encontrada!").build();
            }
            vendaService.excluir(venda);
            return Response.status(200).entity("Venda excluída com sucesso!").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/valorTotal/{idCliente}")
    public Response obterValorTotalVendaPorCliente(@PathParam("idCliente") Integer idCliente) {

        try {
            BigDecimal valorTotal = clienteService.obterValorTotalVendaPorCliente(idCliente);
            Cliente cliente = clienteService.buscarPorID(idCliente);
            ValorTotalVendaDTO dto = new ValorTotalVendaDTO();
            dto.setNomeCliente(cliente.getNome());
            dto.setValorTotalVenda(valorTotal);

            return Response.status(200).build();

        } catch (Exception ex) {
            return Response.status(500).entity("Erro ao obter o valor total da venda por cliente!")
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/quantidadeVenda/{idCliente}")
    public Response obterQuantidadeVendaPorCliente(@PathParam("idCliente") Integer idCliente) {

        try {
            int quantidadeVenda = vendaService.obterQuantidadeVendaPorCliente(idCliente);
            Cliente cliente = clienteService.buscarPorID(idCliente);
            QuantidadeVendaClienteDTO dto = new QuantidadeVendaClienteDTO();
            dto.setNomeCliente(cliente.getNome());
            dto.setQuantVendaCliente(String.valueOf(quantidadeVenda));

            return Response.status(200).build();

        } catch (Exception ex) {
            return Response.status(500).entity("Erro ao obter a quantidade de venda por cliente!").build();
        }
    }

}
