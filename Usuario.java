import java.util.ArrayList;


public class Usuario {

    String nome;
    String sobrenome;
    String email;
    String telefone;
    String senha;

    String agencia;
    String conta;

    double saldo;

    ArrayList<String> historico;

    public Usuario(String nome, String sobrenome, String email, String telefone, String senha) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;

        historico = new ArrayList<>();
    }

}
