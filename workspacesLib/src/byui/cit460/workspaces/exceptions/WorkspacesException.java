/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.exceptions;

/**
 *
 * @author jacksonrkj
 */
public class WorkspacesException extends Exception {

    public WorkspacesException() {
    }

    public WorkspacesException(String message) {
        super(message);
    }

    public WorkspacesException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkspacesException(Throwable cause) {
        super(cause);
    }

    public WorkspacesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
