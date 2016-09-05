package br.com.caelum.contas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	@RequestMapping("/form")
	public String form(){
		return "conta/formulario";
	}
	
	@RequestMapping("/adicionaConta")
	public String adiciona(@Valid Conta conta, BindingResult result) {
	    
		// se tiver erro, redirecione para o formulário
	    if(result.hasErrors()) {
	      return "conta/formulario";
	    }
	    
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
	
	@RequestMapping("/mostraConta")
	public String mostra(Long id, Model model) {
		ContaDAO contaDAO = new ContaDAO();
		model.addAttribute("conta", contaDAO.buscaPorId(id));
		return "conta/mostra";
	}
	
	@RequestMapping("/alteraConta")
	public String altera(Conta conta) {
		ContaDAO dao = new ContaDAO();
		dao.altera(conta);
		return "redirect:listaContas";
	}
	
	@RequestMapping("/removeConta")
	public String remove(Conta conta) {
		ContaDAO dao = new ContaDAO();
		dao.remove(conta);
		return "redirect:listaContas";
	}
}
