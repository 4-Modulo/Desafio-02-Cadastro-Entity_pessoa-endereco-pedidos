package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Pedido {
    private Cliente cliente;
    private boolean encerrado;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.encerrado = false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isEncerrado() {
        return encerrado;
    }

    public void encerrarPedido() {
        this.encerrado = true;
    }

    public static Pedido realizarPedido(Scanner scanner, List<Cliente> clientes) {
        System.out.println("Escolha um cliente para associar ao pedido:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + " - " + clientes.get(i).getNome());
        }
        int indexCliente = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        Cliente clienteSelecionado = clientes.get(indexCliente);
        return new Pedido(clienteSelecionado);
    }

    public static void imprimirTodosPedidos(List<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
            pedido.imprimirPedido();
            System.out.println("--------------------");
        }
    }

    public void imprimirPedido() {
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Status: " + (encerrado ? "Encerrado" : "Em atendimento"));
    }

    public static int contarPedidosEncerrados(List<Pedido> pedidos) {
        int quantidadeEncerrados = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.isEncerrado()) {
                quantidadeEncerrados++;
            }
        }
        return quantidadeEncerrados;
    }

    public static int contarPedidosEmAtendimento(List<Pedido> pedidos) {
        int quantidadeEmAtendimento = 0;
        for (Pedido pedido : pedidos) {
            if (!pedido.isEncerrado()) {
                quantidadeEmAtendimento++;
            }
        }
        return quantidadeEmAtendimento;
    }
    public void emitirArquivoEntrega() {
        String nomeArquivo = "Entrega_" + cliente.getNome() + ".txt";

        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write("Dados do cliente:\n");
            writer.write("Nome: " + cliente.getNome() + "\n");
            writer.write("Número de telefone: " + cliente.getNumeroTelefone() + "\n");
            writer.write("Endereço:\n");
            writer.write("Bairro: " + cliente.getEndereco().getBairro() + "\n");
            writer.write("Rua: " + cliente.getEndereco().getRua() + "\n");
            writer.write("Número: " + cliente.getEndereco().getNumero() + "\n");
            writer.write("\nPedido encerrado. Pronto para a entrega.");
            writer.close();
            System.out.println("Arquivo de entrega gerado com sucesso: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo de entrega: " + e.getMessage());
        }
    }
}