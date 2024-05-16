package fr.diginamic.recensement.utils;

public class SaisieException extends Exception {
	String message;
	/**
	 * Inutile
	 */
	private static final long serialVersionUID = 1L;
	/** Constructor
	 * @param message
	 */
	public SaisieException(String message) {
		this.message = message;
	}
	/** Getter pour message
	 * @return message
	 */
	public String getMessage() {
		return message;
	}
	/**Setter pour message
	 * @param message message 
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
