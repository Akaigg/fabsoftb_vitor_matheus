package br.univille.projfabsoftlavanderia.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private long id;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataRetirada;
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Pagamento pagamento;

    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "comanda_id")
    private List<Roupa> listaRoupas;
    
    @OneToMany (cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "comanda_id")
    private List<Servico> listaServico;


    public List<Servico> getListaServico() {
        return listaServico;
    }

    public void setListaServico(List<Servico> listaServico) {
        this.listaServico = listaServico;
    }

    public List<Roupa> getListaRoupas() {
        return listaRoupas;
    }

    public void setListaRoupas(List<Roupa> listaRoupas) {
        this.listaRoupas = listaRoupas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
  

    

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDateTime dataRetirada) {
        this.dataRetirada = dataRetirada;
    }
}