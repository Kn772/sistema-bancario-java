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
    
    public ArrayList<Usuario> carregarUsuarios() {

        ArrayList<Usuario> lista = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(caminho));
            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(";");

                Usuario u = new Usuario(
                    partes[0],
                    partes[1],
                    partes[2],
                    partes[3],
                    partes[4]
                );

                u.agencia = partes[5];
                u.conta = partes[6];
                u.saldo = Double.parseDouble(partes[7]);

                lista.add(u);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Arquivo de usuários não encontrado.");
        }

        return lista;
    }

}
