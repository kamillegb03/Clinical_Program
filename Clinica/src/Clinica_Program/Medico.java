package Clinica_Program;

public class Medico {
    private String nome;
    private int CRM;
    private double vlrConsulta;
    private int tempoServico;

    public Medico(){}

    public Medico(String nome, int CRM, double vlrConsulta) {
        this.nome = nome;
        this.CRM = CRM;
        this.vlrConsulta = vlrConsulta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCRM() {
        return CRM;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    public double getVlrConsulta() {
        return vlrConsulta;
    }

    public void setVlrConsulta(double vlrConsulta) {
        this.vlrConsulta = vlrConsulta;
    }

    public int getTempoServico() {
        return tempoServico;
    }

    public void setTempoServico(int tempoServico) {
        this.tempoServico = tempoServico;
    }

    public double totalConsulta(int tempoTotal){
        if(getTempoServico() > 10){
            return (getVlrConsulta() * tempoTotal) * 2;
        }
        return (getVlrConsulta() * tempoTotal);
    }
}
