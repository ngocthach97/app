package com.example.app.Utility.Errors;

import org.zalando.problem.AbstractThrowableProblem;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.zalando.problem.Status;
public class BadRequestAlertException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    private final String entityName;

    private final String errorKey;

    public BadRequestAlertException(String label, String entityName, String errorKey) {
        this(ErrorKey.DEFAULT_TYPE, label, entityName, errorKey);
    }

    public BadRequestAlertException(URI type, String label, String entityName, String errorKey) {
        super(type, label, Status.BAD_REQUEST, null, null, null, getAlertParameters(entityName, errorKey));
        this.entityName = entityName;
        this.errorKey = errorKey;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getErrorKey() {
        return errorKey;
    }

    private static Map<String, Object> getAlertParameters(String entityName, String errorKey) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("message", "error." + errorKey);
        parameters.put("params", entityName);
        return parameters;
    }
}
