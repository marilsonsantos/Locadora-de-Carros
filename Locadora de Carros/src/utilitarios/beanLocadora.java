
package utilitarios;


public class beanLocadora {

    private int cod_locacao;
    private String data_retirada;
    private String data_entrega;
    private int valor_diaria;
    private String marca_carro;
    private String nome_locatario;

    
    public int getCod_locacao() {
        return cod_locacao;
    }

    
    public void setCod_locacao(int cod_locacao) {
        this.cod_locacao = cod_locacao;
    }

    
    public String getData_retirada() {
        return data_retirada;
    }

    
    public void setData_retirada(String data_retirada) {
        this.data_retirada = data_retirada;
    }

    
    public String getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(String data_entrega) {
        this.data_entrega = data_entrega;
    }

    
    public double getValor_diaria() {
        return valor_diaria;
    }

    
    public void setValor_diaria(int valor_diaria) {
        this.valor_diaria = valor_diaria;
    }

    public String getMarca_carro() {
        return marca_carro;
    }

    public void setMarca_carro(String marca_carro) {
        this.marca_carro = marca_carro;
    }

    
    public String getNome_locatario() {
        return nome_locatario;
    }

   
    public void setNome_locatario(String nome_locatario) {
        this.nome_locatario = nome_locatario;
    }
    
    
    
}
