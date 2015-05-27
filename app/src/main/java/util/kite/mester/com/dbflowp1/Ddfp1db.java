package util.kite.mester.com.dbflowp1;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by mester on 2015.04.24..
 */
@Database(name = Ddfp1db.NAME ,version = Ddfp1db.VERSION, foreignKeysSupported = true)
public class Ddfp1db  {

   public static final String NAME= "DbFlowP1";

    public static  final int VERSION = 2;
}

