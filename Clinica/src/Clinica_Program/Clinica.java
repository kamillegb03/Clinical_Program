package Clinica_Program;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Clinica {
    private String nomeClinica;
    private String endereco;
    protected ArrayList<Medico> listaMedicos = new ArrayList<Medico>();
    protected ArrayList <Consulta> listaConsultas = new ArrayList<Consulta>();

    public Clinica(String nomeClinica, String endereco) {
        this.nomeClinica = nomeClinica;
        this.endereco = endereco;
    }

    public String getNomeClinica() {
        return nomeClinica;
    }

    public void setNomeClinica(String nomeClinica) {
        this.nomeClinica = nomeClinica;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Medico buscarMedico(int crm){
        for (Medico listaMedico : listaMedicos) {
            if (listaMedico.getCRM() == crm) {
                return listaMedico;
            }
        }
        return null;
    }

    public boolean contratarMedico(Medico medico){
        if(buscarMedico(medico.getCRM()) != null){
            System.out.println("O "+medico.getNome()+" já está cadastrado na clínica com este CRM!");
            return false;
        }
        listaMedicos.add(medico);
        System.out.println("Médico Cadastrado com Sucesso!");
        return true;
    }

    Random gerador = new Random();
    boolean flag;
    public int marcarConsulta(Medico medico){
        int codConsulta = gerador.nextInt(100);
        do{
            flag = false;
            for (Consulta listaConsulta : listaConsultas) {
                if (listaConsulta.getCodConsulta() == codConsulta) {
                    flag = true;
                    break;
                }
            }
            codConsulta = gerador.nextInt(100);
        }while(flag);

        Consulta novaConsulta = new Consulta(codConsulta, medico);
        listaConsultas.add(novaConsulta);
        System.out.println("Código de Consulta: "+codConsulta+"\nMédico: "+medico.getNome());
        return codConsulta;
    }

    Scanner entrada = new Scanner(System.in);
    int tempo;
    public double pagarConsulta(int codConsulta){
        for (Consulta listaConsulta : listaConsultas) {
            if (listaConsulta.getCodConsulta() == codConsulta) {
                System.out.println("Digite o tempo total da consulta: ");
                tempo = entrada.nextInt();
                return listaConsulta.getMedicoResponsavel().totalConsulta(tempo);
            }
        }
        System.out.println("A consulta não foi encontrada");
        return 0;
    }
}
