package com.utfpr.backend_fun_dp;

import com.utfpr.backend_fun_dp.entity.Departamento;
import com.utfpr.backend_fun_dp.entity.Funcionario;
import com.utfpr.backend_fun_dp.service.DepartamentoService;
import com.utfpr.backend_fun_dp.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BackendFunDpApplication {

	private static final Logger log = LoggerFactory.getLogger(BackendFunDpApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendFunDpApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DepartamentoService departamentoService, FuncionarioService funcionarioService) {

		// Crie e configure um novo Funcionario

			// Se não encontrado, crie um novo departamento
			Departamento dp = new Departamento();
			dp.setCodDp(1L);


		Funcionario novoFuncionario = new Funcionario();
		novoFuncionario.setNome("João Silva");
		novoFuncionario.setSalario(5000.0);
		novoFuncionario.setDepartamento(dp);

		return (arg) -> {
			log.info("----------");
			log.info("----------");
			log.info("getFuncionariosByDepartamentoNome");
			for (Funcionario f : funcionarioService.getFuncionariosByDepartamentoNome("suporte")) {
				log.info(f.toString());
			}

			// Salve o novo Funcionario
			log.info("----------");
			log.info("----------");
			funcionarioService.save(novoFuncionario);
			log.info("Novo funcionário salvo: " + novoFuncionario.toString());

			log.info("----------");
			log.info("----------");
			log.info("getFirstDepartamento");
			Departamento d = departamentoService.getFirstDepartamento();
				{log.info(d.toString());
			}

			log.info("----------");
			log.info("----------");
			log.info("getTop3FuncionariosBySalario");
			for (Funcionario f1 : funcionarioService.getTop3FuncionariosBySalario()) {
				log.info(f1.toString());
			}
		};
	};
}









