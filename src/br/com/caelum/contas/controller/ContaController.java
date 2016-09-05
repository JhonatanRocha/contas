package br.com.caelum.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	private ContaDAO contaDAO;

	@Autowired
	public ContaController(ContaDAO contaDAO) {
		this.contaDAO = contaDAO;
	}
	
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
	    
		this.contaDAO.adiciona(conta);
		System.out.println("Detalhe da Conta: " + conta.getDescricao() + 
							" | Valor " + conta.getValor() +
							" | Tipo " + conta.getTipo());
		return "conta/conta-adicionada";
	}
	
	@RequestMapping("/listaContas")
	public ModelAndView lista(){
		List<Conta> contas = this.contaDAO.lista();
		
		ModelAndView modelAnzdView = new ModelAndView("conta/lista");
		modelAnzdView.addObject("todasContas", contas);
		return modelAnzdView;
	}
	
	@RequestMapping("/mostraConta")
	public String mostra(Long id, Model model) {
		model.addAttribute("conta", this.contaDAO.buscaPorId(id));
		return "conta/mostra";
	}
	
	@RequestMapping("/pagaConta")
	public void paga(Long id, HttpServletResponse response) {
		this.contaDAO.paga(id);

		response.setStatus(200);
	}
	
	@RequestMapping("/alteraConta")
	public String altera(Conta conta) {
		this.contaDAO.altera(conta);
		return "redirect:listaContas";
	}
	
	@RequestMapping("/removeConta")
	public String remove(Conta conta) {
		this.contaDAO.remove(conta);
		return "redirect:listaContas";
	}
}
