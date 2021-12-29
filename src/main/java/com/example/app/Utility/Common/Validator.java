package com.example.app.Utility.Common;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.app.Utility.Common.Constant.*;

public class Validator {
    // Validate equals

    /**
     * Description : So sánh 2 giá trị kiểu "int"
     * Type_Param : int
     * Param :value1 , value2
     * Returns :boolean
     */
    public static boolean equals(int value1, int value2) {
        if (value1 == value2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Description : So sánh 2 giá trị kiểu "long"
     * Type_Param : long
     * Param :value1 , value2
     * Returns :boolean
     */
    public static boolean equals(long value1, long value2) {
        if (value1 == value2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Description : So sánh 2 giá trị kiểu "char"
     * Type_Param : char
     * Param :value1 , value2
     * Returns :boolean
     */
    public static boolean equals(char value1, char value2) {
        if (value1 == value2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Description : So sánh 2 giá trị kiểu "float"
     * Type_Param : float
     * Param :value1 , value2
     * Returns :boolean
     */
    public static boolean equals(float value1, float value2) {
        if (value1 == value2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Description : So sánh 2 giá trị kiểu "double"
     * Type_Param : double
     * Param :value1 , value2
     * Returns :boolean
     */
    public static boolean equals(double value1, double value2) {
        if (value1 == value2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Description : So sánh 2 đối tượng bằng nhau
     * Type_Param : Object
     * Param :value1 , value2
     * Returns :boolean
     */
    public static boolean equals(Object obj1, Object obj2) {
        if ((obj1 == null) && (obj2 == null)) {
            return true;
        } else if ((obj1 == null) || (obj2 == null)) {
            return false;
        } else {
            return obj1.equals(obj2);
        }
    }


    // Validate isNull

    /**
     * Description : Kiểm tra kiểu "Object" bằng NULL
     * Type_Param : Object
     * Param :value
     * Returns :boolean
     */
    public static boolean isNull(Object value) {
        if (value instanceof Long) {
            return isNull((Long) value);
        } else if (value instanceof String) {
            return isNull((String) value);
        } else if (value == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Description : Kiểm tra kiểu "String" bằng NULL
     * Type_Param : String
     * Param :value
     * Returns :boolean
     */
    public static boolean isNull(String value) {
        if (value.trim() == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Description : Kiểm tra kiểu "Long" bằng NULL
     * Type_Param : Long
     * Param :value
     * Returns :boolean
     */
    public static boolean isNull(Long value) {
        if (value == null) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Description : Kiểm tra kiểu "Collection" bằng NULL
     * Type_Param : String
     * Param :value
     * Returns :boolean
     */
    public static boolean isNull(Collection value) {
        if (value.isEmpty() || value == null) {
            return true;
        } else {
            return false;
        }
    }

    // Validate isNotNull

    /**
     * Description : Kiểm tra kiểu "Object" khác NULL
     * Type_Param : Object
     * Param :value
     * Returns :boolean
     */
    public static boolean isNotNull(Object value) {
        if (isNull(value)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Description : Kiểm tra kiểu "String" khác NULL
     * Type_Param : String
     * Param :value
     * Returns :boolean
     */
    public static boolean isNotNull(String value) {
        if (isNull(value)) {
            return false;
        } else {
            return true;
        }
    }

    // Validate Gmail
    /**
     * Description : Kiểm tra giá trị thuộc kiểu Email
     * Type_Param : String
     * Param :value
     * Returns :boolean
     */
    public static Pattern patternGmail = Pattern.compile(Valid_Gmail);

    public static boolean isGmail(String value) {
        Matcher matcher = patternGmail.matcher(value);
        return matcher.find();
    }

    // Validate Phone
    /**
     * Description : Kiểm tra giá trị thuộc kiểu Phone
     * Type_Param : String
     * Param :value
     * Returns :boolean
     */
    public static Pattern patternPhone = Pattern.compile(Valis_Phone);

    public static boolean isPhone(String value) {
        Matcher matcher = patternPhone.matcher(value);
        return matcher.find();
    }

    // Validate Code
    /**
     * Description : Kiểm tra giá trị thuộc kiểu Code
     * Type_Param : String
     * Param :value
     * Returns :boolean
     */
    public static Pattern patternCode = Pattern.compile(Valid_Code);

    public static boolean isCode(String value) {
        Matcher matcher = patternCode.matcher(value);
        return matcher.find();
    }

    // Validate Date
    /**
     * Description : Kiểm tra giá trị thuộc kiểu Date
     * Type_Param : String
     * Param :value
     * Returns :boolean
     */
    public static Pattern patternDate = Pattern.compile(Valid_Date);

    public static boolean isDate(String value) {
        Matcher matcher = patternDate.matcher(value);
        return matcher.find();
    }

    // Validate IPv4
    /**
     * Description : Kiểm tra giá trị thuộc kiểu IPv4
     * Type_Param : String
     * Param :value
     * Returns :boolean
     */
    public static Pattern patternIPv4 = Pattern.compile(Valid_IPv4);

    public static boolean isIPv4(String value) {
        Matcher matcher = patternIPv4.matcher(value);
        return matcher.find();
    }


    // Validate Password
    /**
     * Description : Kiểm tra giá trị thuộc kiểu Password
     * Type_Param : String
     * Param :value
     * Returns :boolean
     */
    public static Pattern patternPassword = Pattern.compile(Valid_Password);

    public static boolean isPassword(String value) {
        Matcher matcher = patternPassword.matcher(value);
        return matcher.find();
    }


    public static Pattern patternUsername = Pattern.compile(Valid_Username);

    public static boolean isUsername(String value) {
        Matcher matcher = patternPassword.matcher(value);
        return matcher.find();
    }
}
