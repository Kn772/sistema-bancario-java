import java.io.*;
import java.util.ArrayList;

public class ArquivoUsuarios {
    
    String caminho = "usuarios.txt";

    public void salvarUsuarios(ArrayList<Usuario> usuarios) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(caminho));

            for (Usuario u : usuarios) {

                writer.println(
                    u.nome + ";" +
                    u.sobrenome + ";" +
                    u.email + ";" +
                    u.telefone + ";" +
                    u.senha + ";" +
                    u.agencia + ";" +
                    u.conta + ";" +
                    u.saldo
                );
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar usuários.");
        }
    }
}
