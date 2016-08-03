package com.suncreate.exception;

/**
 * @author Cheng,Zhi
 * @version builder 2010.02.02
 */
public class NullTableNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Table name for searching column must not be empty, please check yourself!";
	}

}
