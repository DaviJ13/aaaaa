package controller;

import model.Reserva;
import pessoas.Cliente;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservaController {
    private final List<Reserva> reservas;
    private final List<Cliente> clientes;
    private static int idReserva = 1111111; // ID inicial para reservas

    public ReservaController(List<Cliente> clientes) {
        this.reservas = new ArrayList<>();
        this.clientes = clientes;
    }

    public void cadastrarReserva(Scanner scanner) {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.next();
        Cliente cliente = buscarClientePorCpf(cpf);

        if (cliente != null) {
            System.out.print("Número do Quarto: ");
            int numeroQuarto = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Valor da Diária: ");
            double valorDiaria = scanner.nextDouble();

            System.out.println("Data de Check-in: " + java.time.LocalDate.now());
            System.out.print("Data de Check-out (dd/MM/yyyy): ");
            String dataSaidaStr = scanner.next();
            java.time.LocalDate dataSaida = java.time.LocalDate.parse(dataSaidaStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            // Criando a reserva
            Reserva reserva = new Reserva(idReserva++, numeroQuarto, cliente.getNomeCliente(), valorDiaria, java.time.LocalDate.now(), dataSaida);
            reservas.add(reserva);
            cliente.adicionarReserva(reserva);  // Adiciona a reserva ao cliente

            System.out.println("Reserva criada com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
        } else {
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }
}
