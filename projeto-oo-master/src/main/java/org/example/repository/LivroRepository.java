package org.example.repository;

import org.example.dominios.Livro;

import java.util.ArrayList;

// USO DE SINGLETON

public class LivroRepository extends AbstractListRepository<Livro> {

    private static LivroRepository livroRepository;
    private ArrayList<Livro> livrosCadastrados = super.list;
    ;

    private LivroRepository() {
    }

    public static LivroRepository getInstance() {
        if (livroRepository == null) {
            livroRepository = new LivroRepository();
        }
        return livroRepository;
    }

    public int getCopiasDisponiveis(Livro livro) {
        int contaCopias = 0;
        for (Livro livrosCadastrado : livrosCadastrados) {
            if (livrosCadastrado.getId().equals(livro.getId())) {
                contaCopias += 1;
            }
        }
        return contaCopias;
    }

    @Override
    public Livro read(String id) {
        for (Livro livro : livrosCadastrados) {
            if (livro.getId().equals(id)) {
                return livro;
            }
        }
        return null;
    }

    public void save(Livro livro) {
        int numero = 0;
        while (numero < livro.getTotalCopias()) {
            livrosCadastrados.add(livro);
            numero++;
        }
        //System.out.println(livro.getTitulo() + " cadastrado com sucesso");
    }

    @Override
    public boolean isSaved(Livro livroEntrada) {
        for (Livro livro : livrosCadastrados) {
            int comparador = livro.getId().compareTo(livroEntrada.getId());
            if (comparador != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compare(Livro livro1, Livro livro2) {
        return livro1.getId().compareTo(livro2.getId());
    }

    public void retirarDaEstante(Livro livro) {
        livrosCadastrados.remove(livro);
    }

    public StringBuilder getTitulos(String tituloLivro) {
        StringBuilder titulo = new StringBuilder();

        for (Livro livro : livrosCadastrados) {
            if (livro.getTitulo().contains(tituloLivro) || livro.getTitulo().equalsIgnoreCase(tituloLivro)) {
                titulo.append(livro.getTitulo());
            }
        }
        return titulo;
    }

    public StringBuilder getAutores(String nomeAutor) {
        StringBuilder autor = new StringBuilder();
        for (Livro livro : livrosCadastrados) {
            if (livro.getAutor().contains(nomeAutor) || livro.getAutor().equalsIgnoreCase(nomeAutor)) {
                autor.append(livro.getAutor()).append("\n");
            }
        }
        return autor;
    }

    public Livro procurarLivroISBN(String isbnBusca) {
        for (Livro livroBuscado : livrosCadastrados) {
            String isbn = livroBuscado.getId();
            if (isbn.equals(isbnBusca)) {
                return livroBuscado;
            }
        }
        return null;
    }

}
