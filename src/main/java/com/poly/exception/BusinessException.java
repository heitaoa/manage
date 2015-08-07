package com.poly.exception;

/**
 * 业务异常
 * @author niuhaidong
 *
 * 2015年5月7日
 */
public class BusinessException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException() {
        super();
    }
	
	public BusinessException(String message) {
        super(message);
    }
}
