package com.example.yyblumerandeiheller.takeandgo.model.utils;

public class ConstantsAndEnums {

    public class Log {
        public final static String TAG = "Take&GO";

            public final static String APP_LOG = "Rent";
        }

        public class SharedPreferences{
            public final static String File = "Local.Preferences";
        }

        public class BroadCastMessages{
            public final static String UPDATE = "com.example.ourex.takengo.UPDATE";
        }

    public class Messages{

    }

    public enum gearboxMode{MANUAL, AUTOMATIC}

    public enum carKind{PRIVATE, FAMILY, TRANSIT, JEEP}

    public enum orderMode{OPEN, CLOSE}
}
