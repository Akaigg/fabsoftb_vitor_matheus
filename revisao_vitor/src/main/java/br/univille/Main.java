package br.univille;

import br.univille.entity.Cidade;
import br.univille.entity.Cliente;
import br.univille.entity.Pokemon;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        Cidade joinville = new Cidade();
        joinville.setNome("Joinville");
        joinville.setEstado("Santa Catarina");

        Pokemon jigglypuff = new Pokemon("Jigglypuff");


        Cliente zezinho = new Cliente("Zeninho");
        zezinho.setNome("Zezinho");
        zezinho.setCidade(joinville);
        zezinho.getListaPokemon().add(jigglypuff);
        
        Cliente mariazinha = new Cliente("mariazinha");    
        mariazinha.setNome("Mariazinha");

       

        System.out.println(zezinho);
        System.out.println(mariazinha);
    }
}