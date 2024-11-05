package pessoas;

public class Funcionario {
    private final String nomeFuncionario;
    private final String cpf;

    public Funcionario(String nomeFuncionario, String cpf) {
        this.nomeFuncionario = nomeFuncionario;
        this.cpf = cpf;
    }

    public String getNomeFuncionario() {
        return "Bem vindo " + nomeFuncionario;
    }

    public String getCpf() {
        return cpf;
    }
}
