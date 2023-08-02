package org.example;

public class Endereco {
    private String bairro;
    private String rua;
    private String numero;

    public Endereco(String bairro, String rua, String numero) {
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public void imprimirEndereco() {
        System.out.println("Bairro: " + bairro);
        System.out.println("Rua: " + rua);
        System.out.println("Número: " + numero);
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }



    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }
}
