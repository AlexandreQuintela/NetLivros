package modelo;

/**
 *
 * @author Alexandre
 */
public class EstadoCivil {

    private int idEstadoCivil;
    private String descricao;

    public EstadoCivil(int idEstadoCivil, String descricao) {
        this.idEstadoCivil = idEstadoCivil;
        this.descricao = descricao;
    }

    public EstadoCivil(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the idEstadoCivil
     */
    public int getIdEstadoCivil() {
        return idEstadoCivil;
    }

    /**
     * @param idEstadoCivil the idEstadoCivil to set
     */
    public void setIdEstadoCivil(int idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
