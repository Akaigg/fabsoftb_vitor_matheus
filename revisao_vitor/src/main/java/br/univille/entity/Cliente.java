package br.univille.entity;

import java.util.ArrayList;

public class Cliente {
    //variavel ou atributo:
    private long id;
    private String nome;
    private String endereco;
    private Cidade cidade;
    private ArrayList<Pokemon> listaPokemon = new ArrayList<Pokemon>();

    //construtor - mesmo nome da classe e não tem retorno
    // inicializar atributos
    // obriga a passagem de valores

    public ArrayList<Pokemon> getListaPokemon() {
        return listaPokemon;
    }
    public void setListaPokemon(ArrayList<Pokemon> listaPokemon) {
        this.listaPokemon = listaPokemon;
    }








    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Cliente(String nome) {
        this.nome = nome;
    }
    //polimorfismo - várias formas de existir a mesma coisa
    public Cliente() { 
    }

    //método
    //sobreescrita de método (meu pai me deu pronto e eu zuera reescrevi)
    @Override
    public String toString(){
        return getNome();
    }

    //método
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    } 
    //encapsulamento = esconder a implementação dentro do objeto
    // atributos viram variaveis, métodos viram códigos

}


