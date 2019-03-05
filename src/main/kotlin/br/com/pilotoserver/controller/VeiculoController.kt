package br.com.pilotoserver.controller

import br.com.pilotoserver.model.Veiculo
import br.com.pilotoserver.repository.VeiculoRepository
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
open class VeiculoController(var veiculoRepository: VeiculoRepository) {

    @GetMapping("/marca", produces = arrayOf(APPLICATION_JSON_VALUE))
    private fun findByMarca(@RequestParam(value = "marca") marca: String): List<Veiculo>{
        print(marca)
        return veiculoRepository.findByMarca(marca)
    }


    @GetMapping("/", produces = arrayOf(APPLICATION_JSON_VALUE))
    private fun findAll() = veiculoRepository.findAll()



    @GetMapping("/modelo")
    private fun findByModel(@RequestParam(value = "modelo") veiculo: String): Veiculo {
        return veiculoRepository.findByModelo(veiculo)
    }

    @PostMapping
    fun add(@RequestBody veiculo : Veiculo) {
        veiculoRepository.save(veiculo);
    }
}