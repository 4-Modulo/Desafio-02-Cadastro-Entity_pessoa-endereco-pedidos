package org.example;

import java.util.List;
import java.util.Scanner;

public class Cliente {

    private int id;
    private String nome;
    private String numeroTelefone;
    private Endereco endereco;

    public Cliente(int id, String nome, String numeroTelefone, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
        this.endereco = endereco;
    }


    public static Cliente cadastrarCliente(Scanner scanner, int id) {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite o número de telefone do cliente: ");
        String numeroTelefoneCliente = scanner.nextLine();

        System.out.println("Digite o bairro do cliente: ");
        String bairro = scanner.nextLine();
        System.out.println("Digite a rua do cliente: ");
        String rua = scanner.nextLine();
        System.out.println("Digite o número do cliente: ");
        String numero = scanner.nextLine();

        Endereco enderecoCliente = new Endereco(bairro, rua, numero);
        return new Cliente(id, nomeCliente, numeroTelefoneCliente, enderecoCliente);
    }

    public void editarCliente(Scanner scanner) {
        System.out.print("Digite o novo nome do cliente: ");
        String novoNome = scanner.nextLine();
        System.out.print("Digite o novo número de telefone do cliente: ");
        String novoNumeroTelefone = scanner.nextLine();

        System.out.println("Digite o novo bairro do cliente: ");
        String novoBairro = scanner.nextLine();
        System.out.println("Digite a nova rua do cliente: ");
        String novaRua = scanner.nextLine();
        System.out.println("Digite o novo número do cliente: ");
        String novoNumero = scanner.nextLine();

        this.nome = novoNome;
        this.numeroTelefone = novoNumeroTelefone;
        this.endereco.setBairro(novoBairro);
        this.endereco.setRua(novaRua);
        this.endereco.setNumero(novoNumero);

        System.out.println("Cliente atualizado com sucesso!");
    }

    public void imprimirDados() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Número de Telefone: " + numeroTelefone);
        System.out.println("Endereço:");
        endereco.imprimirEndereco();
    }

    public static void procurarClientePorNome(List<Cliente> clientes, String nome) {
        boolean encontrado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                cliente.imprimirDados();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Cliente com o nome '" + nome + "' não encontrado.");
        }
    }

    public static void imprimirTodosClientes(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            cliente.imprimirDados();
            System.out.println("--------------------");
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
