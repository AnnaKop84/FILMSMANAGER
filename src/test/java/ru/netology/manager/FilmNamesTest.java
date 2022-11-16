package ru.netology.manager;

import org.junit.jupiter.api.Test;

import ru.netology.domain.FilmNames;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class FilmNamesTest {


    private FilmNames film1 = new FilmNames(10, "Бладшот", 100, 0);
    FilmNames film2 = new FilmNames(20, "Вперёд", 500, 1);
    FilmNames film3 = new FilmNames(30, "Отель Белград", 500, 2);
    FilmNames film4 = new FilmNames(40, "Джентльмены", 800, 3);
    FilmNames film5 = new FilmNames(50, "Человек-неведимка", 600, 4);
    FilmNames film6 = new FilmNames(60, "Тролли.Мировой тур", 500, 5);
    FilmNames film7 = new FilmNames(70, "Номер один", 500, 6);
    FilmNames film8 = new FilmNames(80, "Номер два", 400, 7);
    FilmNames film9 = new FilmNames(90, "Номер три", 400, 8);
    FilmNames film10 = new FilmNames(100, "Номер четыре", 400, 9);
    FilmNames film11 = new FilmNames(110, "Номер пятьь", 400, 10);

    @Test
    public void testLastMovie() {
        FilmNamesManager manager = new FilmNamesManager();
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);


        FilmNames[] actual = manager.findLast();
        FilmNames[] expected = {film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldAddMovie() {
        FilmNamesManager manager = new FilmNamesManager();
        manager.add(film1);
        manager.add(film2);

        FilmNames[] expected = {film1, film2};
        FilmNames[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllLimit() {
        FilmNamesManager manager = new FilmNamesManager();

        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);
        manager.add(film11);
        FilmNames[] expected = {film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11};
        FilmNames[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllLimit5() {
        FilmNamesManager manager = new FilmNamesManager();

        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);

        FilmNames[] expected = {film1, film2, film3, film4, film5};
        FilmNames[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUnderLimit() {
        FilmNamesManager manager = new FilmNamesManager();
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        FilmNames[] expected = {film3, film2, film1};
        FilmNames[] actual = manager.findLast();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldLimit() {
        FilmNamesManager manager = new FilmNamesManager();
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);
        FilmNames[] expected = {film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        FilmNames[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOverLimit() {
        FilmNamesManager manager = new FilmNamesManager();
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);
        manager.add(film11);
        FilmNames[] expected = {film11, film10, film9, film8, film7, film6, film5, film4, film3, film2};
        FilmNames[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }
}
