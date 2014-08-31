package br.ufcg.ppgcc.compor.ir.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufcg.ppgcc.compor.ir.Dependente;
import br.ufcg.ppgcc.compor.ir.ExcecaoImpostoDeRenda;
import br.ufcg.ppgcc.compor.ir.FachadaExperimento;
import br.ufcg.ppgcc.compor.ir.FontePagadora;
import br.ufcg.ppgcc.compor.ir.Titular;

public class ImpostoDeRenda implements FachadaExperimento {

	private List<Titular> titular1 = new ArrayList<Titular>() ;
	private Map<Titular, List<FontePagadora>> mapaFontes = new HashMap<Titular, List<FontePagadora>>();
	private List<FontePagadora> fontes = new ArrayList<FontePagadora>() ;
	
	private Map<Titular, List<Dependente>> mapaDependentes = new HashMap<Titular, List<Dependente>>();
	private List<Dependente> dependentes = new ArrayList<Dependente>() ;
	
	
	public void criarNovoTitular(Titular titular) {
		if (titular.getNome() == null){
			throw new ExcecaoImpostoDeRenda("O campo nome é obrigatório");				
		} 

		if (titular.getCpf() == null){
			throw new ExcecaoImpostoDeRenda("O campo CPF é obrigatório");				
		}
		if (titular.getCpf().length() !=14){
			throw new ExcecaoImpostoDeRenda("O campo CPF está inválido");				
		}
		
		fontes = new ArrayList<FontePagadora>();
		titular1.add(titular);
		mapaFontes.put(titular, fontes);
		

		
	}

	public List<Titular> listarTitulares() {
	
		return titular1;

	}
	public List<FontePagadora> listarFontes(Titular titular) {
		// TODO Auto-generated method stub
		return mapaFontes.get(titular);
	}
	public void criarFontePagadora(Titular titular, FontePagadora fonte) {
		/* Primeira coisa, eu preciso pegar a fonte do titular, se já existir */
		List<FontePagadora> fontesDoTitular = mapaFontes.get(titular);
		
		if (fonte.getNome() == null){
			throw new ExcecaoImpostoDeRenda("O campo nome é obrigatório");				
		} 

		if (fonte.getCpfCnpj() == null){
			throw new ExcecaoImpostoDeRenda("O campo CPF/CNPJ é obrigatório");				
		}
		if (fonte.getRendimentoRecebidos() == 0){
			throw new ExcecaoImpostoDeRenda("O campo rendimentos recebidos é obrigatório");				
		}
		if (fonte.getRendimentoRecebidos() < 0){
			throw new ExcecaoImpostoDeRenda("O campo rendimentos recebidos deve ser maior que zero");				
		}
		if ((fonte.getCpfCnpj() != null) && (fonte.getCpfCnpj().length() != 18)){
			throw new ExcecaoImpostoDeRenda("O campo CPF/CNPJ é inválido");				
		}
		
		//*/
		/* Verifico se existe, ou se é null */
		if (fontesDoTitular == null) {
			throw new ExcecaoImpostoDeRenda("Titular não cadastrado");
			/* Se não existe, cria nova lista */
			
		}
		/* Adiciona a nova fonte na nova lista, ou na lista que já existia */
		
		fontesDoTitular.add(fonte);
	
		
	}

	public void criarDependente(Titular titular, Dependente dependente) {
		/*pego os dependentes*/
		List<Dependente> dependentesDoTitular = mapaDependentes.get(titular);
	
		dependentes.add(dependente);	
		mapaDependentes.put(titular, dependentes);
		
		if (dependentesDoTitular == null) {
		
			dependentesDoTitular = new ArrayList<Dependente>();
	
		}
		
		dependentesDoTitular.add(dependente);
		mapaDependentes.put(titular,dependentesDoTitular);
		dependentes.add(dependente);
		
		
	}

	public List<Dependente> listarDependentes(Titular titular) {
		 return mapaDependentes.get(titular);
	}

}
