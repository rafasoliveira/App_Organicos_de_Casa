package com.odc.organicosdecasa.Domain;

import java.io.Serializable;

public class ItemDomain implements Serializable {
    private String nome;
    private String pic;
    private String descricao;
    private Double taxa;
    private int estrela;
    private int favorito;
    private int listaCompra;
    private int numeroNoCarrinho;

    public ItemDomain(String nome, String pic, String descricao, Double taxa, int estrela, int favorito, int listaCompra) {
        this.nome = nome;
        this.pic = pic;
        this.descricao = descricao;
        this.taxa = taxa;
        this.estrela = estrela;
        this.favorito = favorito;
        this.listaCompra = listaCompra;
    }

    public int getNumeroNoCarrinho() {
        return numeroNoCarrinho;
    }

    public void setNumeroNoCarrinho(int numeroNoCarrinho) {
        this.numeroNoCarrinho = numeroNoCarrinho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public int getEstrela() {
        return estrela;
    }

    public void setEstrela(int estrela) {
        this.estrela = estrela;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public int getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(int listaCompra) {
        this.listaCompra = listaCompra;
    }
}
