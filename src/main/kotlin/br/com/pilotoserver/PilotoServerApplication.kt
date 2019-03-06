package br.com.pilotoserver

import br.com.pilotoserver.model.Pessoa
import br.com.pilotoserver.model.Veiculo
import br.com.pilotoserver.repository.PessoaRepository
import br.com.pilotoserver.repository.VeiculoRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.stream.Stream

@SpringBootApplication
open class PilotoServerApplication {

	@Bean
	open fun init(veiculoRepository: VeiculoRepository, pessoaRepository: PessoaRepository) = CommandLineRunner {

		veiculoRepository.deleteAll();
		pessoaRepository.deleteAll()

		pessoaRepository.save(Pessoa("Pessoa Piloto","Piloto", "Sem Texto"))

		Stream.of("VW,Golf,", "VW,Touareg,", "VW,Fusca,",
				"Audi,A3,", "Audi,A4,", "Audi,A8,",
				"Mercedes,GT,", "Mercedes,A45,", "Mercedes,E63,")
				.map { fn -> fn.split(",") }
				.forEach { veiculo -> veiculoRepository.save(Veiculo(veiculo[0], veiculo[1], Pessoa(apelido = "Piloto") )) }

		veiculoRepository.all().forEach { println(it) }

	}

}
fun main(args: Array<String>) {
	runApplication<PilotoServerApplication>(*args)
}
