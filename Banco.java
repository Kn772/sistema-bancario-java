import java.util.ArrayList;
import java.util.Random;

public class Banco {
    ArrayList<Usuario> usuarios = new ArrayList<>();
    Random random = new Random();

    public String gerarNumeroConta() {
        int numero = 1000000 + random.nextInt(90000000);
        int digito = random.nextInt(10);
        return numero + "-" + digito;
    }

    public double gerarSaldoInicial() {
        return 500 + random.nextInt(9501);
    }

    public Usuario criarUsuario(String nome, String sobrenome, String email, String telefone, String senha) {
        Usuario u = new Usuario();

        u.nome = nome;
        u.sobrenome = sobrenome;
        u.email = email;
        u.telefone = telefone;
        u.senha = senha;

        u.agencia = "0772";
        u.conta = gerarNumeroConta();
        u.saldo = gerarSaldoInicial();

        usuarios.add(u);

        arquivo.salvarUsuarios(usuarios);

        return u;
    }

    public Usuario login(String identicador, String senha) {
        for (Usuario u : usuarios) {
            if ((u.email.equals(identicador) || u.conta.equals(identicador)) 
                && u.senha.equals(senha)) {
                
                return u;
            }
        }
        return null;
    }

    public void depositar(Usuario u, double valor) {
        if (valor > 0) {
            u.saldo += valor;
            u.historico.add("Depósito de R$ " + valor);
        }
    }

    public boolean sacar (Usuario u, double valor) {
        if (valor > 0 && u.saldo >= valor) {
            u.saldo -= valor;
            u.historico.add("Saque de R$ " + valor);
            return true;
        }
        return false;
    }

    public boolean tranferir(Usuario origem, Usuario destino, double valor) {
        if (valor > 0 && origem.saldo >= valor) {
            origem.saldo -= valor;
            destino.saldo += valor;

            origem.historico.add("Tranferiu R$ " + valor + " para " + destino.nome);
            destino.historico.add("Recebeu R$ " + valor + " de " + origem.nome);

            return true;
        }
        return false;
    }

    public Usuario buscarConta(String conta) {
        for (Usuario u : usuarios) {
            if (u.conta.equals(conta)) {
                return u;
            }
        }
        return null;
    }
ArquivoUsuarios arquivo = new ArquivoUsuarios();
}
