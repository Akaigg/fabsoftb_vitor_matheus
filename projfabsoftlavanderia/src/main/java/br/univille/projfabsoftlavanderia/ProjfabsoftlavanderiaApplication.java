package br.univille.projfabsoftlavanderia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.univille.projfabsoftlavanderia.repository.ServicoRepository;
import br.univille.projfabsoftlavanderia.entity.Servico;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ProjfabsoftlavanderiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjfabsoftlavanderiaApplication.class, args);
	}

	@Bean
	CommandLineRunner inicializarServicos(ServicoRepository servicoRepository) {
		return args -> {
			if (servicoRepository.count() == 0) {
				servicoRepository.save(new Servico("Lavação normal"));
				servicoRepository.save(new Servico("Lavação a seco"));
				servicoRepository.save(new Servico("Apenas lavar e secar"));
				servicoRepository.save(new Servico("Apenas secar"));
				servicoRepository.save(new Servico("Apenas passar"));
				servicoRepository.save(new Servico("Lavar, secar e passar"));
			}
		};
	}
}



//package br.univille.projfabsoftlavanderia;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//public class ProjfabsoftlavanderiaApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(ProjfabsoftlavanderiaApplication.class, args);
//	}
//}