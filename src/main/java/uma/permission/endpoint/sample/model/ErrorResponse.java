package uma.permission.endpoint.sample.model;

import java.io.Serializable;

public class ErrorResponse implements Serializable {
    private String error = null;
    private String errorDescription = null;

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }


    public String getErrorDescription() {
        return errorDescription;
    }
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

}
