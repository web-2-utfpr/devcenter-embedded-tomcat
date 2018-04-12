/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 * Custom exception class that handles Web Exceptions.
 *
 * @author DV8FromTheWorld (Austin Keener)
 * @version v1.0.0  July 16, 2014
 */
@SuppressWarnings("serial")
public class WebException extends RuntimeException {

    private StatusCode code;

    /**
     * Creates a new instance of WebException containing the StatusCode and the
     * original exception.
     *
     * @param code The StatusCode related to this exception.
     * @param cause The Throwable that set off this exception.
     */
    public WebException(StatusCode code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    /**
     * Creates a new instance of WebException containing the StatusCode.
     *
     * @param code The StatusCode related to this exception.
     */
    public WebException(StatusCode code) {
        this(code, null);
    }

    /**
     * Creates a new instance of WebException containing the StatusCode(based on
     * the provided httpCode) and the original exception.
     *
     * @param httpCode The httpCode related to this exception.
     * @param cause The Throwable that set off this exception.
     */
    public WebException(int httpCode, Throwable cause) {
        this(StatusCode.getStatus(httpCode), cause);
    }

    /**
     * Creates a new instance of WebException containing the StatusCode(based on
     * the provided httpCode).
     *
     * @param httpCode The httpCode related to this exception.
     */
    public WebException(int httpCode) {
        this(httpCode, null);
    }

    /**
     * Gets the Http StatusCode associated with this exception.
     *
     * @return The StatusCode that caused the exception.
     */
    public StatusCode getStatusCode() {
        return code;
    }

    /**
     * Gets the description of the exception based on the description of the
     * StatusCode.
     *
     * @return Description of exception based on Http StatusCode.
     */
    @Override
    public String getMessage() {
        return code.getDescription();
    }
}
