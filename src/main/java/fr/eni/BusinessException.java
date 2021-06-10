package fr.eni;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception {

	/**
	 * classe permettant de lister les erreurs dans les différentes couches
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> ListeCodesErreur;
	
	public BusinessException() {
		super();
		this.ListeCodesErreur=new ArrayList<>();
	}
	
	
	
	//ajout de l'erreur
	public void addErreur(int code)
	{
		if(!this.ListeCodesErreur.contains(code))
		{
			this.ListeCodesErreur.add(code);
		}
	}
	
	public boolean hasErreurs()
	{
		return this.ListeCodesErreur.size()>0;
	}
	
	public List<Integer> getListeCodesErreur()
	{
		return this.ListeCodesErreur;
	}
}
