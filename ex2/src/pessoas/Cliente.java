package pessoas;

import model.Reserva;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final String nomeCliente;
    private final int idade;
    private final String cpf;
    private final String telefone;
    private final List<Reserva> reservas; // Lista para armazenar as reservas do cliente

    public Cliente(String nomeCliente, int idade, String cpf, String telefone) {
        this.nomeCliente = nomeCliente;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.reservas = new ArrayList<>();  // Inicializa a lista de reservas
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void adicionarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public int contarReservas() {
        return reservas.size();
    }

    @Override
    public String toString() {
        return String.format("Cliente: %s, CPF: %s, Reservas: %d", nomeCliente, cpf, contarReservas());
    }
}
