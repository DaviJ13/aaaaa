package model;

import java.time.LocalDate;

public class Reserva {
    private final int id;
    private final int numeroQuarto;
    private final String nomeHospede;
    private final double valorDiaria;
    private final LocalDate dataEntrada;
    private final LocalDate dataSaida;

    public Reserva(int id, int numeroQuarto, String nomeHospede, double valorDiaria, LocalDate dataEntrada, LocalDate dataSaida) {
        this.id = id;
        this.numeroQuarto = numeroQuarto;
        this.nomeHospede = nomeHospede;
        this.valorDiaria = valorDiaria;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    @Override
    public String toString() {
        return String.format("Reserva ID: %d, Quarto: %d, Hóspede: %s, Diária: %.2f, Check-in: %s, Check-out: %s",
                id, numeroQuarto, nomeHospede, valorDiaria, dataEntrada, dataSaida);
    }
}
