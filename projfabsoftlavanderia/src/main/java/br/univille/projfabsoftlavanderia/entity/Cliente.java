package br.univille.projfabsoftlavanderia.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

///[NOK] Diagrama de entidades (Não reflete o código do sistema: 
/// entidade Cliente não possui associação com Comanda, entidade 
/// Comanda possui associação com Cliente e Pagamento, a entidade 
/// Roupa não possui associação com Serviço) 
/// [NOK] API REST (apenas o endpoint do Cliente foi implementado e possui erros)

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;
    @Column(length=1000, nullable = false)
    private String nome;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String codigo;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Roupa> roupas;
    @OneToOne(fetch = FetchType.EAGER)
    private Pagamento pagamento;
    @OneToOne(fetch = FetchType.EAGER)
    private Comanda comanda;

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Roupa> getRoupas() {
        return roupas;
    }

    public void setRoupas(List<Roupa> roupas) {
        this.roupas = roupas;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
}