package br.com.pilotoserver.controller

import br.com.pilotoserver.model.Pessoa
import br.com.pilotoserver.repository.PessoaRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pessoa")
open class PessoaController(var pessoaRepository: PessoaRepository) {

    @GetMapping("/nome")
    private fun findByNome(@RequestParam(value = "nome") nome: String): Pessoa {
        return pessoaRepository.findByNome(nome)
    }



    @GetMapping("/apelido")
    private fun findByApelido(@RequestParam(value = "apelido") pessoa: String): Pessoa {
        return pessoaRepository.findByApelido(pessoa)
    }

    @PostMapping
    fun add(@RequestBody pessoa : Pessoa) {
        pessoaRepository.save(pessoa);
    }
}