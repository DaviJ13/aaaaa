package App;

import controller.ClienteController;
import controller.ReservaController;
import pessoas.Cliente;
import pessoas.Funcionario;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Cria lista de clientes
        List<Cliente> clientes = new ArrayList<>();

        // Cria lista de reservas
        List<ReservaController> reservasControllers = new ArrayList<>();

        Funcionario funcionario = new Funcionario("João", "123.456.789-00");
        System.out.println("Bem-vindo: " + funcionario.getNomeFuncionario());
        System.out.println("CPF: " + funcionario.getCpf());
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        ClienteController clienteController = new ClienteController();
        ReservaController reservaController = new ReservaController(clientes);

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar reserva");
            System.out.println("3 - Listar reservas");
            System.out.println("4 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    clienteController.cadastrarCliente(scanner, clientes);
                    break;
                case 2:
                    reservaController.cadastrarReserva(scanner);
                    break;
                case 3:
                    reservaController.listarReservas();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
