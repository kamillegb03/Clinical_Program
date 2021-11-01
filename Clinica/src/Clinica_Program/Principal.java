package Clinica_Program;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Clinica c1 = new Clinica("Sempre Saudável", "Aracaju");
        String opcaoCadastro, nome;
        int crm, opcao;
        double valorConsulta;

        do{
            opcao = menu(entrada);
            switch (opcao) {
                case 1 -> {
                    System.out.println("\nMédicos Cadastrados no Sistema:");
                    if (c1.listaMedicos.isEmpty()) {
                        System.out.println("Nenhum Médico Cadastrado Na Clinica");
                    }
                    for (int i = 0; i < c1.listaMedicos.size(); i++) {
                        System.out.println("Nome: " + c1.listaMedicos.get(i).getNome() + " || CRM : " + c1.listaMedicos.get(i).getCRM());
                    }
                    do {
                        System.out.println("Deseja Cadastrar Um Novo Médico? ");
                        opcaoCadastro = entrada.next().toUpperCase();
                    } while (opcaoCadastro.charAt(0) != 'S' && opcaoCadastro.charAt(0) != 'N');
                    if (opcaoCadastro.charAt(0) == 'S') {
                        System.out.println("\nDigite os dados do novo médico:");
                        entrada.nextLine();
                        System.out.print("Nome: ");
                        nome = entrada.nextLine().toUpperCase();
                        System.out.print("CRM: ");
                        crm = entrada.nextInt();

                        if (c1.buscarMedico(crm) == null) {
                            System.out.print("Valor da Consulta: R$");
                            valorConsulta = entrada.nextDouble();
                            Medico novoMedico = new Medico(nome, crm, valorConsulta);
                            c1.contratarMedico(novoMedico);
                        } else {
                            System.out.println("O(A) MÉDICO(A) <" + c1.buscarMedico(crm).getNome() + "> JÁ ESTÁ CADASTRADO(A) NO SISTEMA " +
                                    "COM O CRM: " + c1.buscarMedico(crm).getCRM() + "!");
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Digite o CRM do Médico(A) Para Marcar a Consulta: ");
                    crm = entrada.nextInt();
                    if (c1.buscarMedico(crm) != null) {
                        c1.marcarConsulta(c1.buscarMedico(crm));
                    } else {
                        System.out.println("CRM Não Encontrado!");
                    }
                }
                case 3 -> {
                    System.out.println("Digite o Código da Consulta: ");
                    int codConsulta = entrada.nextInt();
                    System.out.println(c1.pagarConsulta(codConsulta));
                }
            }
        }while (opcao != 4);
    }

    public static int menu(Scanner entrada){
        String menuOpcoes = """

        ===== MENU DE OPÇÕES =====
        DIGITE O NÚMERO REFERENTE A OPÇÃO DESEJADA

            1 - Contratar Médico
            2 - Marcar Consulta
            3 - Pagar Consulta
            4 - Sair Do Sistema
        """;
        int opcao;
        do{
            System.out.println(menuOpcoes);
            opcao = entrada.nextInt();
        }while(opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4);
        return opcao;
    }
}
