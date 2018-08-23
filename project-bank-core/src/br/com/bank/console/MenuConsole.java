package br.com.bank.console;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.bank.dao.ClienteDAO;
import br.com.bank.dao.impl.ClienteDaoImpl;
import br.com.bank.entity.Cliente;
import br.com.bank.entity.TipoPessoa;
import br.com.bank.exceptions.CommitException;
import br.com.bank.exceptions.IsAtivoExeption;
import br.com.bank.exceptions.TipoPessoaException;
import br.com.bank.singleton.EntityManagerFactorySingleton;
import br.com.bank.singleton.PropertySingleton;

public class MenuConsole {

	EntityManagerFactory fabrica =
			EntityManagerFactorySingleton.getInstance();

	EntityManager em = fabrica.createEntityManager();

	private final static String bank = 
			PropertySingleton.getInstance().getProperty("bank");

	private final Logger log = 
			LoggerFactory.getLogger(MenuConsole.class);

	Scanner input = new Scanner(System.in);

	Calendar calendar = Calendar.getInstance();

	SimpleDateFormat sdf = 
			new SimpleDateFormat("dd/MM/yyyy HH:mm"); 

	ClienteDAO clienteDAO = new ClienteDaoImpl(em);
	Cliente cliente = new Cliente();


	public int opcoesMenu() {
		System.out.println(bank+ "         "+ sdf.format(calendar.getTime()));	
		System.out.println("****************************");
		System.out.println("[1] - Cadastrar");
		System.out.println("[2] - Listar");
		System.out.println("[3] - Pesquisar por codigo");
		System.out.println("****************************");		
		return input.nextInt();
	}


	public void menu(int op) throws TipoPessoaException, IsAtivoExeption {
		if(op == 1) {
			System.out.println("Nome do cliente: ");
			cliente.setNome(input.next());

			System.out.println("Pessoa Fisica [1] ou Pessoa Juridica[2]");
			int opcaoPessoa = input.nextInt();

			if(opcaoPessoa == 1) {
				cliente.setTipoPessoa(TipoPessoa.PESSOA_FISICA);
			}else if(opcaoPessoa == 2) {
				cliente.setTipoPessoa(TipoPessoa.PESSOA_JURIDICA);
			}else {
				throw new TipoPessoaException();
			}

			System.out.println(cliente.validarCpfOuCnpj(cliente.getTipoPessoa()));
			cliente.setCpfoucnpj(input.next());

			System.out.println("Ativo [1] ou Inativo[2]");
			int isAtivo = input.nextInt();

			if(isAtivo == 1) {
				cliente.setAtivo(true);
			}else if(isAtivo == 2) {
				cliente.setAtivo(false);
			}else {
				throw new IsAtivoExeption();

			}
			cliente.setAtivo(true); 
			cliente.setDtCadastro(Calendar.getInstance());

			try {
				clienteDAO.inserir(cliente);
				log.debug("Inserindo o cliente:" +cliente.getNome());
				clienteDAO.commit();
				log.debug("Commitando");
			}catch(CommitException e) {
				e.printStackTrace();
				log.error("Erro ao comitar");
			}finally {
				log.trace("Fim de operação!");
			}
		}else if (op == 2) {
			List<Cliente> lista = 
					clienteDAO.listar(cliente);
			lista.forEach(c -> {
				System.out.println("Nome: "+c.getNome());
			});	
		}else if (op == 3) {
			System.out.println("Digite o codigo");
			Cliente c = clienteDAO.pesquisar(input.nextInt());
			System.out.println(c.getNome());
		}
		voltarMenu();
	}

	public void voltarMenu() throws TipoPessoaException, IsAtivoExeption {
		System.out.println("****************************");
		System.out.println("Deseja continuar? S/N");
		System.out.println("****************************");
		String newOp = input.next();
		newOp = newOp.toLowerCase();
		if(newOp.equals("s")) {
			menu(opcoesMenu());
		}else if(newOp.equals("n")) {
			System.out.println("Saindo...");
			System.exit(0);
		}else {
			System.out.println("Opcao invalida!");
			voltarMenu();
		}
	}
}
