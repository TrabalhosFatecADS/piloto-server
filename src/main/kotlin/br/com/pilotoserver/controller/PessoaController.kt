package br.com.pilotoserver.controller

import br.com.pilotoserver.model.Pessoa
import br.com.pilotoserver.model.Veiculo
import br.com.pilotoserver.repository.PessoaRepository
import br.com.pilotoserver.repository.VeiculoRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pessoa")
open class PessoaController(var pessoaRepository: PessoaRepository) {

    @GetMapping("/nome") //http://localhost:8080/pessoa/nome/?nome=Pessoa Piloto
    private fun findByNome(@RequestParam("nome") nome: String): Pessoa {
        return pessoaRepository.findByNome(nome)
    }

    //http://localhost:8080/pessoa/
    @GetMapping("/", produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    private fun findAll() = pessoaRepository.findAll()



    @GetMapping("/apelido") //http://localhost:8080/pessoa/apelido/?apelido=Piloto
    private fun findByApelido(@RequestParam("apelido") apelido: String): Pessoa {
        return pessoaRepository.findByApelido(apelido)
    }

    @PostMapping
    fun add(@RequestBody pessoa : Pessoa) {
        pessoaRepository.save(pessoa);
    }
}