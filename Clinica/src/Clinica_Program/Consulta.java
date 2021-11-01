package Clinica_Program;

public class Consulta {
    private int codConsulta;
    private Medico medicoResponsavel;

    public Consulta(int codConsulta, Medico medicoResponsavel) {
        this.codConsulta = codConsulta;
        this.medicoResponsavel = medicoResponsavel;
    }

    public int getCodConsulta() {
        return codConsulta;
    }

    public void setCodConsulta(int codConsulta) {
        this.codConsulta = codConsulta;
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }
}
