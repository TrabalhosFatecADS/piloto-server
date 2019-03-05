package br.com.pilotoserver

import br.com.pilotoserver.model.Veiculo
import br.com.pilotoserver.repository.VeiculoRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.stream.Stream

@SpringBootApplication
open class PilotoServerApplication {

	@Bean
	open fun init(veiculoRepository: VeiculoRepository) = CommandLineRunner {

		veiculoRepository.deleteAll();

		Stream.of("VW,Golf", "VW,Touareg", "VW,Fusca",
				"Audi,A3", "Audi,A4", "Audi,A8",
				"Mercedes,GT", "Mercedes,A45", "Mercedes,E63")
				.map { fn -> fn.split(",") }
				.forEach { veiculo -> veiculoRepository.save(Veiculo(veiculo[0], veiculo[1])) }

		veiculoRepository.all().forEach { println(it) }

	}

}
fun main(args: Array<String>) {
	runApplication<PilotoServerApplication>(*args)
}
