package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();
        int idCliente = 1;

        int opcao;
        do {
            System.out.println("\nMENU:");
            System.out.println("1 - Cliente");
            System.out.println("2 - Pedidos");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuCliente(scanner, clientes, idCliente);
                    break;
                case 2:
                    menuPedidos(scanner, clientes, pedidos);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 3);
    }

    private static void menuCliente(Scanner scanner, List<Cliente> clientes, int idCliente) {
        int opcaoCliente;
        do {
            System.out.println("\nMENU CLIENTE:");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Editar cliente");
            System.out.println("3 - Visualizar todos os clientes");
            System.out.println("4 - Procurar cliente pelo nome");
            System.out.println("5 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcaoCliente = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoCliente) {
                case 1:
                    Cliente cliente = Cliente.cadastrarCliente(scanner, idCliente);
                    clientes.add(cliente);
                    idCliente++;
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o ID do cliente que deseja editar: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine();
                    Cliente clienteEditar = procurarClientePorId(clientes, idEditar);
                    if (clienteEditar != null) {
                        clienteEditar.editarCliente(scanner);
                    } else {
                        System.out.println("Cliente com o ID " + idEditar + " não encontrado.");
                    }
                    break;
                case 3:
                    Cliente.imprimirTodosClientes(clientes);
                    break;
                case 4:
                    System.out.print("Digite o nome do cliente para procurar: ");
                    String nomeProcurado = scanner.nextLine();
                    Cliente.procurarClientePorNome(clientes, nomeProcurado);
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcaoCliente != 5);
    }

    private static Cliente procurarClientePorId(List<Cliente> clientes, int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    private static void menuPedidos(Scanner scanner, List<Cliente> clientes, List<Pedido> pedidos) {
        int opcaoPedido;
        do {
            System.out.println("\nMENU PEDIDOS:");
            System.out.println("1 - Realizar pedido");
            System.out.println("2 - Visualizar todos os pedidos");
            System.out.println("3 - Quantidade de pedidos encerrados");
            System.out.println("4 - Quantidade de pedidos em atendimento");
            System.out.println("5 - Encerrar pedido");
            System.out.println("6 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcaoPedido = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoPedido) {
                case 1:
                    Pedido pedido = Pedido.realizarPedido(scanner, clientes);
                    pedidos.add(pedido);
                    System.out.println("Pedido realizado com sucesso!");
                    break;
                case 2:
                    Pedido.imprimirTodosPedidos(pedidos);
                    break;
                case 3:
                    int quantidadeEncerrados = Pedido.contarPedidosEncerrados(pedidos);
                    System.out.println("Quantidade de pedidos encerrados: " + quantidadeEncerrados);
                    break;
                case 4:
                    int quantidadeEmAtendimento = Pedido.contarPedidosEmAtendimento(pedidos);
                    System.out.println("Quantidade de pedidos em atendimento: " + quantidadeEmAtendimento);
                    break;
                case 5:
                    System.out.print("Digite o ID do pedido que deseja encerrar: ");
                    int idEncerrar = scanner.nextInt();
                    scanner.nextLine();
                    encerrarPedido(pedidos, idEncerrar);
                    Pedido pedidoEncerrado = procurarPedidoPorId(pedidos, idEncerrar);
                    if (pedidoEncerrado != null && pedidoEncerrado.isEncerrado()) {
                        pedidoEncerrado.emitirArquivoEntrega();
                    }
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcaoPedido != 6);
    }

    private static void encerrarPedido(List<Pedido> pedidos, int idEncerrar) {
        Pedido pedidoEncerrar = procurarPedidoPorId(pedidos, idEncerrar);
        if (pedidoEncerrar != null) {
            pedidoEncerrar.encerrarPedido();
            System.out.println("Pedido com ID " + idEncerrar + " encerrado com sucesso!");
        } else {
            System.out.println("Pedido com o ID " + idEncerrar + " não encontrado.");
        }
    }

    private static Pedido procurarPedidoPorId(List<Pedido> pedidos, int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().getId() == id) {
                return pedido;
            }
        }
        return null;
    }

}