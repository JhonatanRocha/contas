package br.com.caelum.contas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	@RequestMapping("/form")
	public String form(){
		return "formulario";
	}
	
	@RequestMapping("/adicionaConta")
	public String adiciona(Conta conta){
		ContaDAO contadao = new ContaDAO();
		contadao.adiciona(conta);
		System.out.println("Detalhe da Conta: " + conta.getDescricao() + 
							" | Valor " + conta.getValor() +
							" | Tipo " + conta.getTipo());
		return "conta/conta-adicionada";
	}
	
	@RequestMapping("/listaContas")
	public ModelAndView lista(){
		ContaDAO contadao = new ContaDAO();
		List<Conta> contas = contadao.lista();
		
		ModelAndView modelAnzdView = new ModelAndView("conta/lista");
		modelAnzdView.addObject("todasContas", contas);
		return modelAnzdView;
	}
}
