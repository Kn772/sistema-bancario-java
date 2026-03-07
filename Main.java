import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();

        int opcao = 0;

        while (opcao != 3) {

            System.out.println("\n=== Sistema Bancário ===");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Login");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {

                case 1:

                    System.out.println("\n=== Criar Conta ===");

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Sobrenome: ");
                    String sobrenome = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    String telefone;
                    while (true){
                        System.out.println("Telefone: ");
                        telefone = sc.nextLine();
                        if (telefone.matches("\\d{9,11}")){
                            break;
                        }
                        System.out.println("Telefone inválido!");
                        System.out.println("Digite apenas números (entre 9 e 11 dígitos).");
                    }

                    System.out.print("Senha: ");
                    String senha = sc.nextLine();

                    Usuario novo = banco.criarUsuario(nome, sobrenome, email, telefone, senha);

                    System.out.println("\nConta criada com sucesso!");
                    System.out.println("Agência: " + novo.agencia);
                    System.out.println("Conta: " + novo.conta);
                    System.out.println("Saldo inicial: R$ " + novo.saldo);

                    break;

                case 2:

                    System.out.println("\n=== Login ===");

                    System.out.print("Email ou Nº da conta: ");
                    String identificador = sc.nextLine();

                    System.out.print("Senha: ");
                    String senhaLogin = sc.nextLine();

                    Usuario usuarioLogado = banco.login(identificador, senhaLogin);

                    if (usuarioLogado != null) {
                        System.out.println("Login realizado com sucesso!");
                        System.out.println("Bem-vindo, " + usuarioLogado.nome);
                    } else {
                        System.out.println("Login inválido!");
                    }

                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");

            }

        }

        sc.close();
    }
}
