package aplicativos;

import java.io.IOException;
import java.util.Scanner;

import classes.Pessoa;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 1;
        int NOVO_TAMANHO = 0;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == (MAX_ELEMENTOS + NOVO_TAMANHO)) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                //Cadastre seu piloto aqui
                pilotos[qtdCadastrados] = new Pessoa();
                
                System.out.print("\nNome: ");
                pilotos[qtdCadastrados].setNome(in.nextLine());

                System.out.print("CPF: ");
                pilotos[qtdCadastrados].setCpf(in.nextLine());

                System.out.println("\nPiloto cadastrado com sucesso.");

                qtdCadastrados = qtdCadastrados +1; 


                voltarMenu(in);
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

              // Exiba os pilotos aqui
              System.out.println("\nPilotos cadastrados: ");
               for (int i = 0; i < qtdCadastrados; i++) {
                System.out.println(pilotos[i].toString()); 
               }
            
                
                voltarMenu(in);
            } else if (opcao == 3) {
             // Buscar piloto pelo CPF
             if (qtdCadastrados == 0) {
                System.out.println("\nNão há motoristas cadastrados para pesquisar.");
            }else{
                System.out.print("Informe o CPF: ");
                String cpf = in.nextLine();
                boolean achou  = false;
                Pessoa pessoaEncontrada = null;

                for (int i= 0; !achou && i < qtdCadastrados;  i++){
		            achou = (pilotos[i].getCpf().equals(cpf));
                    pessoaEncontrada = pilotos[i];
                }

                if (achou == true) {
                    System.out.println("\nPiloto encontrado:");
                    System.out.println(pessoaEncontrada.toString());
                } else {
                    System.out.println("\nPiloto não encontrado!");
                }
                }
                
                
            } else if (opcao == 4) {
               System.out.print("Informe o tamanho do vetor: "); 
               NOVO_TAMANHO  = in.nextInt();
               in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

               //Declaração no novo array
               Pessoa[] newarray = new Pessoa[NOVO_TAMANHO];

                //Copia os dados do antigo array para o novo 
                System.arraycopy(pilotos, 0, newarray, 0, Math.min (pilotos.length, newarray.length));

                //Desaloca o array antigo
                pilotos = newarray;
                
                //Remove a referência
                newarray = null;
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}