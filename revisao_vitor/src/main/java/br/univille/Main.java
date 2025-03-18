package br.univille;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        Cliente zezinho = new Cliente("Zeninho");
        zezinho.setNome("Zezinho");
        Cliente mariazinha = new Cliente("mariazinha");    
        mariazinha.setNome("Mariazinha");

        System.out.println(zezinho);
        System.out.println(mariazinha);
    }
}