package com.example.app.Utility.Common;

public interface Constant {

    public interface Validator {

        public static final String Valid_Username = "";

        public static final String Valid_Password = "";

        public static final String Valid_Gmail = "";

        public static final String Valid_Phone = "";

        public static final String Valid_Code = "";

        public static final String Valid_Date = "\\d{1,2}[-,/]\\d{1,2}[-,/]\\d{4}";

        public static final String Valid_IPv4 = "\\d{1,2}[-,/]\\d{1,2}[-,/]\\d{4}";
    }

    public interface EntityStatus {
        public static final int DELETED = -1, NOT_ACTIVE = 0, ACTIVE = 1;

    }
}
