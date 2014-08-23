package br.ufcg.ppgcc.compor.ir.impl;

import java.util.ArrayList;
import java.util.List;

import br.ufcg.ppgcc.compor.ir.FachadaExperimento;
import br.ufcg.ppgcc.compor.ir.Titular;

public class ImpostoDeRenda implements FachadaExperimento {

	private List<Titular> titular1 = new ArrayList<Titular>() ;
	
	public void criarNovoTitular(Titular titular) {
		// TODO Auto-generated method stub
		titular1.add(titular);
		
	}

	public List<Titular> listarTitulares() {
	
		return titular1;
		
		
		//return null;
	}

}
