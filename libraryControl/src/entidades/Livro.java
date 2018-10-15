/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author repez
 */
public class Livro {

    private int id = 0;
    private String isbn = "";
    private String titulo = "";
    private String fotoDaCapa = "";
    private Autor autor;
    private Editora editora;

    public Livro() {

    }

    public Livro(int id, String isbn, String titulo, String fotoDaCapa) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.fotoDaCapa = fotoDaCapa;
        
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
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the fotoDaCapa
     */
    public String getFotoDaCapa() {
        return fotoDaCapa;
    }

    /**
     * @param fotoDaCapa the fotoDaCapa to set
     */
    public void setFotoDaCapa(String fotoDaCapa) {
        this.fotoDaCapa = fotoDaCapa;
    }

    /**
     * @return the autor
     */
    public Autor getAutor() {
        return this.autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    /**
     * @return the editora
     */
    public Editora getEditora() {
        return this.editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(Editora editora) {
        this.editora = editora;
    }

}
