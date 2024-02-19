package org.example.EJERCICIOS.E2;

public class Libro {
    private String titulo,autor ;
    private int año_publicación;
    private int ISBN;

    public Libro(String titulo, String autor, int año_publicación, int id) {
        this.titulo = titulo;
        this.autor = autor;
        this.año_publicación = año_publicación;
        this.ISBN = id;
    }

    public Libro() {}

    @Override
    public String toString() {
        return "Libro: "+getTitulo()+"\n" +
                "Autor: "+getAutor()+"\n" +
                "Año Publicación: "+getAño_publicación()+"\n" +
                "ISBN: "+getId()+"\n";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAño_publicación() {
        return año_publicación;
    }

    public void setAño_publicación(int año_publicación) {
        this.año_publicación = año_publicación;
    }

    public int getId() {
        return ISBN;
    }

    public void setId(int id) {
        this.ISBN = id;
    }
}
