package com.crud;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Path("/produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @POST
    @Transactional
    public void CadastrarProduto(Produto p){
        p.persist();
    }

    @GET
    public List<Produto> LerProdutos(){
        return Produto.listAll();
    }

    @GET
    @Path("/{id}")
    public Produto LerProduto(@PathParam("id") Long id){
        Optional<Produto> produtoOpt = Produto.findByIdOptional(id);
        if(produtoOpt.isPresent()){
            return produtoOpt.get();
        }else{
            throw new NotFoundException();
        }
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void AtualizarProduto(@PathParam("id") Long id, Produto produtoAtualizado){
        Optional<Produto> produtoOpt = Produto.findByIdOptional(id);
        if(produtoOpt.isPresent()){
            Produto produto = produtoOpt.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setValor(produtoAtualizado.getValor());
            produto.persist();
        }else{
            throw new NotFoundException();
        }
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void ApagarProduto(@PathParam("id") Long id){
        Optional<Produto> produtoOpt = Produto.findByIdOptional(id);
        if(produtoOpt.isPresent()){
            produtoOpt.get().delete();
        }else{
            throw new NotFoundException();
        }
    }
}
