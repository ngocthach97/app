package com.example.app.Utility.Errors;

public interface LabelKey {

    public interface USER {
        public static final String LABEL_USER_ID = "label.id";
        public static final String LABEL_USER_NAME = "label.name";
        public static final String LABEL_USER_PHONE = "label.phone";
        public static final String LABEL_USER_GENDER = "label.gender";
        public static final String LABEL_USER_GMAIL = "label.gmail";
        public static final String LABEL_USER_PASSWORD = "label.password";
        public static final String LABEL_USER_DISTRICT = "label.phone";
        public static final String LABEL_USER_PROVINCE = "label.phone";
        public static final String LABEL_USER_WARD = "label.phone";
    }

    public interface PROVINCE {
        public static final String LABEL_PROVINCE_CODE = "label.code";
        public static final String LABEL_PROVINCE_NAME = "label.name";
    }

    public interface DISTRICT {
        public static final String LABEL_DISTRICT_CODE = "label.code";
        public static final String LABEL_DISTRICT_NAME = "label.name";
    }

    public interface WARD {
        public static final String LABEL_WARD_CODE = "label.code";
        public static final String LABEL_WARD_NAME = "label.name";
    }

}
