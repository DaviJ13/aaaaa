package controller;

import pessoas.Cliente;

import java.util.List;
import java.util.Scanner;

public class ClienteController {
    public void cadastrarCliente(Scanner scanner, List<Cliente> clientes) {
        System.out.print("Nome do Cliente: ");
        String nomeCliente = scanner.next();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();

        String cpf = "";
        boolean cpfValido = false;

        // Loop até o CPF ser válido
        while (!cpfValido) {
            System.out.print("Digite o CPF (somente números): ");
            cpf = scanner.next();

            try {
                // Verifica se o CPF tem 11 dígitos
                if (cpf.length() != 11 || !cpf.matches("[0-9]+")) {
                    throw new IllegalArgumentException("CPF deve conter 11 dígitos numéricos.");
                }

                // Se o CPF for válido, formata e sai do loop
                cpf = formatarCpf(cpf);
                cpfValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Formatação do telefone
        String telefone = "";
        boolean telefoneValido = false;

        // Loop até o telefone ser válido
        while (!telefoneValido) {
            System.out.print("Digite o Telefone (somente números): ");
            telefone = scanner.next();

            try {
                // Verifica se o telefone tem 11 dígitos
                if (telefone.length() != 11 || !telefone.matches("[0-9]+")) {
                    throw new IllegalArgumentException("Telefone deve ter 11 dígitos numéricos.");
                }

                // Se o telefone for válido, formata e sai do loop
                telefone = formatarTelefone(telefone);
                telefoneValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Criando o cliente com o CPF e telefone já formatados
        Cliente cliente = new Cliente(nomeCliente, idade, cpf, telefone);
        clientes.add(cliente);

        System.out.println("\nCliente cadastrado com sucesso!");
    }

    // Método para formatar o CPF com pontos e traço
    private static String formatarCpf(String cpf) {
        // Remove qualquer caracter que não seja número
        cpf = cpf.replaceAll("[^0-9]", "");

        // Aplica a formatação do CPF
        if (cpf.length() == 11) {
            return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
        } else {
            return cpf; // Se não for 11 dígitos, retorna como está (não deveria ocorrer, pois já validamos)
        }
    }

    // Método para formatar o telefone com o formato +55 (xx) 9XXXX-XXXX
    private static String formatarTelefone(String telefone) {
        // Remove qualquer caracter que não seja número
        telefone = telefone.replaceAll("[^0-9]", "");

        // Aplica a formatação do telefone
        if (telefone.length() == 11) {
            return "+55 (" + telefone.substring(0, 2) + ") " + telefone.substring(2, 3) + telefone.substring(3, 8) + "-" + telefone.substring(8, 11);
        } else {
            return telefone; // Se não for 11 dígitos, retorna como está (não deveria ocorrer, pois já validamos)
        }
    }
}
