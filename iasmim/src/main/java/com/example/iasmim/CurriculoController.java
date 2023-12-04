package com.example.iasmim;

import com.example.iasmim.Curriculo;
import com.example.iasmim.CurriculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/iasmim/curriculos")
public class CurriculoController {
    @Autowired
    private CurriculoService curriculoService;

    @GetMapping
    public List<Curriculo> listarCurriculos() {
        return curriculoService.listarCurriculos();
    }

    @GetMapping("/{id}")
    public Curriculo buscarCurriculo(@PathVariable Long id) {
        return curriculoService.buscarCurriculo(id);
    }

    @PostMapping
    public Curriculo cadastrarCurriculo(@RequestBody Curriculo curriculo) {
        return curriculoService.cadastrarCurriculo(curriculo);
    }

    @PutMapping("/{id}")
    public Curriculo atualizarCurriculo(@PathVariable Long id, @RequestBody Curriculo curriculo) {
        return curriculoService.atualizarCurriculo(id, curriculo);
    }

    @DeleteMapping("/{id}")
    public void deletarCurriculo(@PathVariable Long id) {
        curriculoService.deletarCurriculo(id);
    }
}
