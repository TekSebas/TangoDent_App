package horarios;

public class Hora {
	private int idHora;
    private String inicio;
    private String fin;

    private boolean disponible;
    
    public Hora(int id) {
        this.idHora = id;
        this.inicio = "";
        this.fin = "";
        
        this.disponible = true;
    }
    
    public Hora(int id, String inicio, String fin){
        this.idHora = id;
        this.inicio = inicio;
        this.fin = fin;
       
        this.disponible = true;
    }

    public Hora() {
        this.idHora = 0;
        this.inicio = "";
        this.fin = "";
        
        this.disponible = true;
    }

    /**
     * @return the idHora
     */
    public int getIdHora() {
        return idHora;
    }

    /**
     * @param idHora the idHora to set
     */
    public void setIdHora(int idHora) {
        this.idHora = idHora;
    }

    /**
     * @return the inicio
     */
    public String getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the fin
     */
    public String getFin() {
        return fin;
    }

    /**
     * @param fin the fin to set
     */
    public void setFin(String fin) {
        this.fin = fin;
    }

    /**
     * @return the disponible
     */
    public boolean estaDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

}
