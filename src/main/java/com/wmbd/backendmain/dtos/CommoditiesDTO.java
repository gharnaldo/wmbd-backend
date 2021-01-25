package com.wmbd.backendmain.dtos;

public class CommoditiesDTO {

	String name;
	Double oro;
	Double plata;
	Double usd;
	Double eur;
	Double yen;
	
	public CommoditiesDTO() {
		super();
	}

	public CommoditiesDTO(String name, Double oro, Double plata, Double usd, Double eur, Double yen) {
		super();
		this.name = name;
		this.oro = oro;
		this.plata = plata;
		this.usd = usd;
		this.eur = eur;
		this.yen = yen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getOro() {
		return oro;
	}

	public void setOro(Double oro) {
		this.oro = oro;
	}

	public Double getPlata() {
		return plata;
	}

	public void setPlata(Double plata) {
		this.plata = plata;
	}

	public Double getUsd() {
		return usd;
	}

	public void setUsd(Double usd) {
		this.usd = usd;
	}

	public Double getEur() {
		return eur;
	}

	public void setEur(Double eur) {
		this.eur = eur;
	}

	public Double getYen() {
		return yen;
	}

	public void setYen(Double yen) {
		this.yen = yen;
	}

	@Override
	public String toString() {
		return "CommoditiesDTO [name=" + name + ", oro=" + oro + ", plata=" + plata + ", usd=" + usd + ", eur=" + eur
				+ ", yen=" + yen + "]";
	}
	
	
}
