package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.ChamadoService;
import br.usjt.arqsw.service.FilaService;
/**
 * Controller que implementa os serviços REST/JSON
 * @author jhonnanthn.balsas
 *
 */
@RestController
public class ManterChamadosRest {

	private ChamadoService cService;
	private FilaService fService;

	@Autowired
	public ManterChamadosRest(ChamadoService c, FilaService f) {
		cService = c;
		fService = f;
	}
    /**
     * Lista todos os chamados de uma determinada fila
     * @param id Recebe o id da fila como parâmetro
     * @return um JSON Array com todos os chamados da fila
     */
	@RequestMapping(method = RequestMethod.GET, value = "rest/chamados/{id}")
	public @ResponseBody List<Chamado> listarChamados(
			@PathVariable("id") Long id) {
		List<Chamado> chamados = null;
		try {
			Fila fila = fService.carregar(id.intValue());
			chamados = cService.listarChamados(fila);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chamados;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/chamados")
	public @ResponseBody List<Chamado> listarChamados() {
		List<Chamado> chamados = null;
		chamados = cService.listarChamados();
		return chamados;
	}

	/**
     * Lista todos os chamados abertos de uma determinada fila
     * @param id Recebe o id da fila como parâmetro
     * @return um JSON Array com somente os chamados abertos da fila
     */
//	@RequestMapping(method = RequestMethod.GET, value = "rest/chamados/abertos/{id}")
//	public @ResponseBody List<Chamado> listarChamadosAbertos(
//			@PathVariable("id") Long id) {
//		List<Chamado> chamados = null;
//		try {
//			Fila fila = fService.carregar(id.intValue());
//			chamados = cService.listarChamadosAbertos(fila);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return chamados;
//	}

	/**
	 * Inclui um novo chamado
	 * @param chamado, com descrição e fila preenchidos
	 * @return um JSON do chamado com o id criado pelo autoincrement do banco, a data e o status
	 */
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "rest/chamados")
	public ResponseEntity<Chamado> criarChamado(@RequestBody Chamado chamado) {
		try {
			System.out.println(chamado);
			cService.adicionarChamado(chamado.getFila().getId(), chamado.getNome());
			return new ResponseEntity<Chamado>(chamado, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<Chamado>(chamado,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.GET, value = "rest/removeFila/{id}")
		public @ResponseBody String removeFila(
				@PathVariable("id") String id) {
		try {
			Fila fila = fService.carregar(Integer.parseInt(id));
			List<Chamado> chamados = cService.listarChamados(fila);
			if(chamados.size() == 0)	{
				fService.removerFila(fila);
				return "OK";
			} else	{
				return "FALHA";
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.GET, value = "rest/editarFila")
		public @ResponseBody String removeFila(
				String id, String nome, String imagem) {
		Fila fila = new Fila();
		fila.setFigura(imagem);
		fila.setId(Integer.parseInt(id));
		fila.setNome(nome);
		fService.alterarFila(fila);
		return "Alterado";
	}
	
	/**
	 * Fecha chamados.
	 * @param chamados: lista de chamados a serem fechados.
	 */
//	@Transactional
//	@RequestMapping(method = RequestMethod.PUT, value = "rest/chamados")
//	public void fecharChamados(@RequestBody List<Chamado> chamados) {
//		try {
//			ArrayList<Integer> lista = new ArrayList<>();
//			for(Chamado chamado:chamados){
//				lista.add(chamado.getNumero());
//			}
//			cService.fecharChamados(lista);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}









