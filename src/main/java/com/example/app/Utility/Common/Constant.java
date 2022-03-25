package com.example.app.Utility.Common;

public interface Constant {

    public interface Validator {
        // Constant Username
        public static final String Valid_Username = "";

        // Constant Password
        public static final String Valid_Password = "";

        //   Constant  Gmail
        public static final String Valid_Gmail = "";

        //   Constant  Phone
        public static final String Valid_Phone = "";

        //   Constant  Code
        public static final String Valid_Code = "";

        //   Constant  Date
        public static final String Valid_Date = "\\d{1,2}[-,/]\\d{1,2}[-,/]\\d{4}";

        // Constant IPv4
        public static final String Valid_IPv4 = "\\d{1,2}[-,/]\\d{1,2}[-,/]\\d{4}";
    }

    public interface EntityStatus {
        public static final int DELETED = -1, NOT_ACTIVE = 0, ACTIVE = 1;

    }
}
