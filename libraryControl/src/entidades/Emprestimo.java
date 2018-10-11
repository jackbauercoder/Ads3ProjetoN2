/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author repez
 */
public class Emprestimo {

    private int id = 0;
    private int exemplarID = 0;
    private int clienteID = 0;
    private Date dataEmprestimo = null;
    private Date dataDevolucao = null;
    private boolean isAtivo = true;

    public Emprestimo() {

    }

    public Emprestimo(int id, int exemplarID, int clienteID) {
        this.id = id;
        this.exemplarID = exemplarID;
        this.clienteID = clienteID;
        this.dataEmprestimo = (Date) Calendar.getInstance().getTime();
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
     * @return the dataEmprestimo
     */
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * @param dataEmprestimo the dataEmprestimo to set
     */
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * @return the dataDevolucao
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @param dataDevolucao the dataDevolucao to set
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * @return the isAtivo
     */
    public boolean isAtivo() {
        return isAtivo;
    }

    /**
     * @param isAtivo the statusEmprestimo to set
     */
    public void setIsAtivo(boolean isAtivo) {
        this.isAtivo = isAtivo;
    }

    public float calculaSaldoDevedor() {
        float saldoDevedor = 0;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = Calendar.getInstance().getTime();
        long diferenca = hoje.getTime() - getDataDevolucao().getTime();
        long diasEmAtraso = TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
        saldoDevedor = diasEmAtraso * 2;
        return saldoDevedor;
    }

    public Date calculaDataDeDevolucao(String tipoPessoa) {
        int limite = 15;
        if (tipoPessoa.equals("ALUNO")) {
            limite = 10;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(dataEmprestimo);
        c.add(Calendar.DATE, limite);
        return c.getTime();
    }

}
