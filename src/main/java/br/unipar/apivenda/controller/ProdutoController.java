package br.unipar.apivenda.controller;

import br.unipar.apivenda.model.Produto;
import br.unipar.apivenda.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/produto")
public class ProdutoController {

    @Inject
    private ProdutoService produtoService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarProduto() {
        return Response.ok(produtoService.listar()).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarProduto(Produto produto) {
        try {
            produtoService.cadastrar(produto);
            return Response.status(201).entity("Produto cadastrado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editarproduto(Produto produto) {
        try {
            produtoService.editar(produto);
            return Response.status(201).entity("Produto editado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response excluirproduto(@PathParam("id") Integer id) {
        try {
            Produto produto = produtoService.buscarPorID(id);
            produtoService.excluir(produto);
            if (produto == null) {
                return Response.status(404).entity("Produto não encontrado").build();
            }
            produtoService.excluir(produto);
            return Response.status(200).entity("Produto excluído com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
