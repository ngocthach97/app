package com.example.app.Utility.Errors;

import java.net.URI;

public final  class ErrorKey {

    public static final String _PROBLEM_BASE_URL = "http://localhost:8001/problem";
    public static final URI DEFAULT_TYPE = URI.create(_PROBLEM_BASE_URL + "/problem-with-message");

    public static final String ERROR_INVALID_PASSWORD = "error.invalid-password";
    public static final String ERROR_INVALID_LENGTH_PASSWORD = "error.invalid-length-password";

    public static final String ERROR_INVALID_USERNAME = "error.invalid-username";
    public static final String ERROR_INVALID_EXISTS_USERNAME = "error.invalid-exists-username";
    public static final String ERROR_INVALID_LENGTH_USERNAME = "error.invalid-length-username";

    public static final String ERROR_INVALID_PHONE = "error.invalid-phone";
    public static final String ERROR_INVALID_EXISTS_PHONE = "error.invalid-exists-phone";
    public static final String ERROR_INVALID_LENGTH_PHONE = "error.invalid-length-phone";

    public static final String ERROR_INVALID_GMAIL = "error.invalid-gmail";
    public static final String ERROR_INVALID_EXISTS_GMAIL = "error.invalid-exists-gmail";
    public static final String ERROR_INVALID_LENGTH_GMAIL = "error.invalid-length-gmail";

    public static final String ERROR_INVALID_DATA = "error.invalid-data";

    public static final String ERROR_INVALID_NAME = "error.invalid-name";

    public static final String ERROR_INVALID_ID = "error.invalid-id";

}
