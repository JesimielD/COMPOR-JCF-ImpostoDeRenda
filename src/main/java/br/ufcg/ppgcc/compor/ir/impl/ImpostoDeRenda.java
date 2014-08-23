package br.ufcg.ppgcc.compor.ir.impl;

import java.util.ArrayList;
import java.util.List;

import br.ufcg.ppgcc.compor.ir.ExcecaoImpostoDeRenda;
import br.ufcg.ppgcc.compor.ir.FachadaExperimento;
import br.ufcg.ppgcc.compor.ir.Titular;

public class ImpostoDeRenda implements FachadaExperimento {

	private List<Titular> titular1 = new ArrayList<Titular>() ;
	
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
		
		titular1.add(titular);

		
	}

	public List<Titular> listarTitulares() {
	
		return titular1;

		//return null;
	}

}