package util.kite.mester.com.dbflowp1;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Joco on 2015.04.26..
 */
public class Telefonszam extends BaseModel {

    @Column(columnType = Column.PRIMARY_KEY)
    public String szam;
}
