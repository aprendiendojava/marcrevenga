package com.wpsnetwork.patrones.factory;

public class PacienteFactory {
	public static Paciente getPaciente(String tipoPaciente){
		Paciente paciente = null;
		
		if(tipoPaciente.equalsIgnoreCase("HOMBRE"))
			paciente = new PacienteHombre();
		else if (tipoPaciente.equalsIgnoreCase("MUJER"))
			paciente = new PacienteMujer();
		
		return paciente;
	}
}
