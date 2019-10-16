package com.gestion.controller;

import com.gestion.modele.Film;
import com.gestion.service.FilmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FilmControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilmService filmService;

    @Test
    public void findAll() throws Exception {
        // given
        Film film = new Film();
        film.setId(1L);
        film.setTitre("fire on man");
        film.setDuree("2h");

        List<Film> films = Arrays.asList(film);
        when(filmService.findAll()).thenReturn(films);

        // when + then

        this.mockMvc.perform(get("/cinema/Films"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1,'titre': 'fire on man','duree': '2h'}]"));
    }

}
