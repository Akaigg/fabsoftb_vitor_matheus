package br.univille;

public class Cliente {
    //variavel ou atributo:
    private String nome;
    

    //construtor - mesmo nome da classe e não tem retorno
    // inicializar atributos
    // obriga a passagem de valores

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

}


