package com.example.person.controller;

import com.example.person.model.Weather;
import com.example.person.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherRepository repository;

    @GetMapping
    public Iterable<Weather> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Weather> findById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Weather> save(@RequestBody Weather weather) {
        return new ResponseEntity<>(repository.save(weather), HttpStatus.CREATED);
    }

    // Метод для получения погоды по координатам (например, latitude и longitude)
    @GetMapping("/coordinates")
    public ResponseEntity<Weather> getWeatherByCoordinates(@RequestParam double latitude, @RequestParam double longitude) {
        // Здесь можно добавить логику, чтобы извлечь данные о погоде из БД
        // или сделать запрос к внешнему API для получения информации о погоде.
        return ResponseEntity.ok().build();
    }
}
