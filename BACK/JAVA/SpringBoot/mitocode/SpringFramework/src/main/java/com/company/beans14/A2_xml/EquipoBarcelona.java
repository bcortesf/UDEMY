package com.company.beans14.A2_xml;

public class EquipoBarcelona extends AEquipo implements IEquipo {

	public EquipoBarcelona() {}
	
	///////////////////////////////////////
	//				->INTERFAZ-IEQUIPO
	@Override
	public String mostrarNombre() {
		return "Barcelona FC";
	}
	@Override
	public AEquipo getTeamInstance() {
		return this;
	}
	@Override
	public void setTeamInstance(AEquipo equipo) {
		// TODO Programado en beans14/A2_xml/Brasil.java
	}

	///////////////////////////////////////////
	//				->CLASE-OBJECT
	@Override
	public String toString() {
		return "EquipoBarcelona [this.mostrarNombre()=" + this.mostrarNombre() + "]"; //interface IEquipo
	}
	/////////////////////////////////////////
	
}
