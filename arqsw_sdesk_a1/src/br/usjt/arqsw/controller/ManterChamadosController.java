package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.entity.Usuario;
import br.usjt.arqsw.service.ChamadoService;
import br.usjt.arqsw.service.FilaService;
import br.usjt.arqsw.service.UsuarioService;
/**
 * 
 * @author asbonato
 *
 */
@Transactional
@Controller
public class ManterChamadosController {
	private FilaService filaService;
	private ChamadoService chamadoService;
	private UsuarioService usuarioService;
	
	@Autowired
	public ManterChamadosController(FilaService filaService, ChamadoService chamadoService, UsuarioService usuarioService) {
		this.filaService = filaService;
		this.chamadoService = chamadoService;
		this.usuarioService = usuarioService;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String inicio() {
		return "index";
	}

	private List<Fila> listarFilas() throws IOException{
			return filaService.listarFilas();
	}
	
	/**
	 * 
	 * @param model Acesso à request http
	 * @return JSP de Listar Chamados
	 */
	@RequestMapping("/listar_filas_exibir")
	public String listarFilasExibir(Model model) {
		try {
			model.addAttribute("filas", listarFilas());
			return "ChamadoListar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/login")
	public String login(HttpSession session, Model model) {
		session.invalidate();
		return "login";
	}
	
	@RequestMapping("/logar")
	public String logar(@Valid Usuario usuario, BindingResult result, Model model, HttpSession session) {
		try {
			Usuario usuarioLogado = usuarioService.buscaUsuario(usuario);
			if(usuarioLogado != null) {
				session.setAttribute("usuarioLogado", usuarioLogado);
				return "index";
			} else {
				return "Erro";
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/listar_chamados_exibir")
	public String listarChamadosExibir(@Valid Fila fila, BindingResult result, Model model) {
		try {
			model.addAttribute("chamado", chamadoService.listarChamados(fila));
			return "ChamadoListarExibir";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/listar_filas")
	public String listarFilasExibir(@Valid Fila fila, BindingResult result, Model model) {
		try {
			model.addAttribute("fila", filaService.listarFilas());
			return "FilaListarExibir";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/adicionar_chamado")
	public String adicionar_chamado(@Valid Fila fila, @Valid Chamado chamado, BindingResult result, Model model) {
		try {
			chamadoService.adicionarChamado(fila.getId(), chamado.getNome());
			model.addAttribute("chamado", chamadoService.listarChamados(fila));
			return "ChamadoListarExibir";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/adicionar_fila")
	public String adicionar_fila(Fila fila, Model model) {
		try {
			filaService.adicionarFila(fila);
			model.addAttribute("fila", filaService.listarFilas());
			return "FilaListarExibir";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/page_adicionar")
	public String page_adicionar(Model model) {
		try {
			model.addAttribute("filas", listarFilas());
			return "Adicionar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
}
