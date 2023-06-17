package br.com.mgsystems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.mgsystems.dao.ClienteDAOMock;
import br.com.mgsystems.dao.IClienteDAO;
import br.com.mgsystems.domain.Cliente;
import br.com.mgsystems.exceptions.TipoChaveNaoEncontradaException;
import br.com.mgsystems.services.ClienteService;
import br.com.mgsystems.services.IClienteService;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	private Cliente cliente;
	
	
	public ClienteServiceTest() {
	
		IClienteDAO dao= new ClienteDAOMock();
		clienteService = new ClienteService(dao);
	}


	@Before
	public void init() {
		
		cliente = new Cliente();
		cliente.setCpf(14789632555L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("S�o Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(99668875L);
	}

	@Test
	public void pesquisarCliente() {
		
		
		
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		
		Assert.assertNotNull(clienteConsultado);
		
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		
		Boolean retorno = clienteService.salvar(cliente);
		
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		
		clienteService.excluir(cliente.getCpf());
		
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		
		cliente.setNome("Marcelo de Oliveira");
		
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Marcelo de Oliveira", cliente.getNome());
		
	}

}