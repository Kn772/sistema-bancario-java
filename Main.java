import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();

        System.out.println("=== Sistema Bancário ===");

        System.out.println("Nome: ");
        String nome = sc.nextLine();

        System.out.println("Sobrenome: ");
        String sobrenome = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Usuario novo = banco.criarUsuario(nome, sobrenome, email, telefone, senha);
        
        System.out.println("Conta criada com sucesso!");
        System.out.println("Agência: " + novo.agencia);
        System.out.println("Conta: " + novo.conta);
        System.out.println("Saldo inicial: R$ " + novo.saldo);

        sc.close();
    }
}
