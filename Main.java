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

                    String nome;
                    while (true){
                        System.out.print("Nome: ");
                        nome = sc.nextLine();
                        if(nome.matches("^[A-Za-z]{2,25}$")) {
                            break;
                        }
                        System.out.println("Nome inválido!");
                    }
                    
                    String sobrenome;
                    while (true){
                        System.out.print("Sobrenome: ");
                        sobrenome = sc.nextLine();
                        if(sobrenome.matches("^[A-Za-z]{2,35}$")) {
                            break;
                        }
                        System.out.println("Sobrenome inválido!");
                    }
                    
                    String email;
                    while (true) {
                        System.out.print("Email: ");
                        email = sc.nextLine();
                        if (email.matches("^[A-Za-z0-9._%+-]+@(gmail|hotmail|outlook)\\.com$")){
                            break;
                        }
                        System.out.println("Email inválido!");
                    }

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

                    String senha;
                    while (true) {

                        System.out.print("Senha: ");
                        senha = sc.nextLine();

                        if (senha.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$")) {
                            break;
                        }

                        System.out.println("Senha inválida!");
                        System.out.println("A senha precisa ter:");
                        System.out.println("- mínimo 8 caracteres");
                        System.out.println("- pelo menos 1 letra");
                        System.out.println("- pelo menos 1 número");
                        System.out.println("- pelo menos 1 símbolo (@$!%*?&)");
                    }

                    Usuario novo = banco.criarUsuario(nome, sobrenome, email, telefone, senha);
                    if (novo == null) {
                        System.out.println("Esse email já está cadastrado!");
                        break;
                    }
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
