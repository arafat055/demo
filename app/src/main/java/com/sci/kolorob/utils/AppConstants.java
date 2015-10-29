package com.sci.kolorob.utils;

/**
 * Created by touhid on 10/29/15.
 * @author touhid
 */
public class AppConstants {

    public static final String[] SUB_CAT_EDU_BN = {"স্কুল-কলেজ", "মাদ্রাসা", "কারিগরি", "মেডিকেল", "অন্যান্য"};
    public static final String[] SUB_CAT_FUN_BN = {"খেলার মাঠ", "সাংস্কৃতিক", "ভ্রমণ", "ইলেক্ট্রনিক্স", "অন্যান্য"};
    public static final String[] SUB_CAT_GOVT_BN = {"উপযোগ", "সরকারী অফিস", "জরুরী", "অন্যান্য"};
    public static final String[] SUB_CAT_HEALTH_BN = {"ক্লিনিক", "হসপিটাল", "ফার্মেসি", "অন্যান্য"};
    public static final String[] SUB_CAT_JOB_BN = {"sub-category-1", "sub-category-2", "sub-category-3"};
    public static final String[] SUB_CAT_LAW_BN = {"আইনজীবী", "আইন-কেন্দ্র", "সালিশ কেন্দ্র"};
    public static final String[] SUB_CAT_MONEY_BN = {"sub-category-1", "sub-category-2", "sub-category-3"};

    public static final String[][] SUB_CATEGORIES = {SUB_CAT_EDU_BN, SUB_CAT_FUN_BN, SUB_CAT_GOVT_BN,
            SUB_CAT_HEALTH_BN, SUB_CAT_JOB_BN, SUB_CAT_LAW_BN, SUB_CAT_MONEY_BN};

    //region category IDs
    public static final int CAT_EDU = 101;
    public static final int CAT_FUN = 102;
    public static final int CAT_GOVT = 103;
    public static final int CAT_HEALTH = 104;
    public static final int CAT_JOB = 105;
    public static final int CAT_LAW = 106;
    public static final int CAT_MONEY = 107;
    public static final int CAT_BASE = CAT_EDU;
    //endregion
    //region sub-category IDs
    public static final int SUB_CAT_EDU_SCHOOL_COLLEGE = 10101;
    public static final int SUB_CAT_EDU_MADRASA = 10102;
    public static final int SUB_CAT_EDU_VOCATIONAL = 10103;
    public static final int SUB_CAT_EDU_MEDICAL = 10104;
    public static final int SUB_CAT_EDU_OTHERS = 10105;

    public static final int SUB_CAT_FUN_FIELD = 10201;
    public static final int SUB_CAT_FUN_CULT = 10202;
    public static final int SUB_CAT_FUN_TOUR = 10203;
    public static final int SUB_CAT_FUN_ELECTRONICS = 10204;
    public static final int SUB_CAT_FUN_OTHERS = 10205;

    public static final int SUB_CAT_GOVT_UTIL = 10301;
    public static final int SUB_CAT_GOVT__OFC = 10302;
    public static final int SUB_CAT_GOVT_EMRGENCY = 10303;
    public static final int SUB_CAT_GOVT_OTHERS = 10304;
    // TODO Declare other sub-category IDs
    //endregion

    //region Keys of the activity data-passing extras
    public static final String KEY_PLACE = "place";
    public static final int PLACE_BAUNIABADH = 1;
    public static final int PLACE_PARIS_ROAD = 2;
    //endregion
}
