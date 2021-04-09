package com.example.chatting;

import android.provider.BaseColumns;

public class DatabaseContract {
    public DatabaseContract() {}
    public static abstract class Customers implements BaseColumns {
        public static final String TABLE_NAME = "Customers";
        public static final String COL_NAME = "Name";
        public static final String COL_CONTACT="Contact";
        public static final String COL_LOCATION="Location";
        public static final String COL_EMAIL = "Email";
        public static final String COL_PASSWORD="Password";
    }
    public static abstract class MilkMan implements BaseColumns {
        public static final String TABLE_NAME = "MilkMan";
        public static final String COL_NAME = "Name";
        public static final String COL_CONTACT="Contact";
        public static final String COL_LOCATION="Location";
        public static final String COL_EMAIL = "Email";
        public static final String COL_PASSWORD="Password";
        public static final String COL_QUALITY="Quality";
        public static final String COL_QUANTITY="Quantity";
        public static final String COL_PRICE="Price";
        public static final String COL_TOTAL_PRICE="TPrice";

    }
    public static abstract class Riders implements BaseColumns {
        public static final String TABLE_NAME = "Riders";
        public static final String COL_NAME = "Name";
        public static final String COL_CONTACT="Contact";
        public static final String COL_LOCATION="Location";
        public static final String COL_EMAIL = "Email";
        public static final String COL_PASSWORD="Password";
        public static final String COL_TOTAL_PRICE="TPrice";
    }
    public static abstract class OrderT implements BaseColumns {
        public static final String TABLE_NAME = "OrderT";
        public static final String COL_PLACED_BY = "PlacedBy";
        public static final String COL_PLACED_TO="PlacedTo";
        public static final String COL_QUANTITY="Quantity";
        public static final String COL_QUALITY="Quality";
        public static final String COL_PRICE="Price";
        public static final String COL_STATUS="Status";

    }
    public static abstract class Review implements BaseColumns {
        public static final String TABLE_NAME = "Review";
        public static final String COL_PLACED_BY = "PlacedBy";
        public static final String COL_PLACED_TO = "PlacedTo";
        public static final String COL_REVIEW = "Reviews";
    }
}
