package com.example.iasmim;

import com.example.iasmim.Curriculo;
// import com.example.iasmim.ServiceTarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curriculos")
public class CurriculoController {
    @Autowired
    private CurriculoRepository curriculoRepository;

    @GetMapping
    public List<Curriculo> listarCurriculos() {
        return curriculoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Curriculo buscarCurriculo(@PathVariable Long id) {
        return curriculoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Curriculo cadastrarCurriculo(@RequestBody Curriculo curriculo) {
        return curriculoRepository.save(curriculo);
    }

    @PutMapping("/{id}")
    public Curriculo atualizarCurriculo(@PathVariable Long id, @RequestBody Curriculo curriculo) {
        curriculo.setId(id);
        return curriculoRepository.save(curriculo);
    }

    @DeleteMapping("/{id}")
    public void deletarCurriculo(@PathVariable Long id) {
        curriculoRepository.deleteById(id);
    }
}
