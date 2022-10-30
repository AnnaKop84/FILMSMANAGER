package ru.netology.manager;

import ru.netology.domain.FilmNames;

public class FilmNamesManager {
    private int countMovie = 10;
    private FilmNames[] movies = new FilmNames[0];

    public FilmNamesManager(int countMovie) {
        this.countMovie = countMovie;
    }

    public FilmNamesManager() {

    }

    public void add(FilmNames movie) {
        FilmNames[] tmp = new FilmNames[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;


    }

    public FilmNames[] findAll() {
        return movies;
    }

    public FilmNames[] findLast() {
        int resultLength = movies.length;
        if (resultLength >= countMovie) {
            resultLength = countMovie;
        } else {
            resultLength = movies.length;
        }
        FilmNames[] result = new FilmNames[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;

    }
}
