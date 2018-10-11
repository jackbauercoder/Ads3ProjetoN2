package entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author repez
 */
public class Reserva {

    private int id = 0;
    private int exemplarID = 0;
    private int clienteID = 0;
    private Date dataReserva = null;
    private boolean isAtiva = true;

    public Reserva() {

    }

    public Reserva(int id, int exemplarID, int clienteID, Date dataReserva) {
        this.id = id;
        this.exemplarID = exemplarID;
        this.clienteID = clienteID;
        this.dataReserva = dataReserva;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the exemplarID
     */
    public int getExemplarID() {
        return exemplarID;
    }

    /**
     * @param exemplarID the exemplarID to set
     */
    public void setExemplarID(int exemplarID) {
        this.exemplarID = exemplarID;
    }

    /**
     * @return the clienteID
     */
    public int getClienteID() {
        return clienteID;
    }

    /**
     * @param clienteID the clienteID to set
     */
    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    /**
     * @return the isAtiva
     */
    public boolean isAtiva() {
        return isAtiva;
    }

    /**
     * @param isAtiva the ativa to set
     */
    public void setIsAtiva(boolean isAtiva) {
        this.isAtiva = isAtiva;
    }

    /**
     * @return the dataReserva
     */
    public Date getDataReserva() {
        return dataReserva;
    }

    /**
     * @param dataReserva the dataReserva to set
     */
    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

}
