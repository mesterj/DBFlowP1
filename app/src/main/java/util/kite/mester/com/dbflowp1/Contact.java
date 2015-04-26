package util.kite.mester.com.dbflowp1;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by Joco on 2015.04.26..
 */
@Table(databaseName = Ddfp1db.NAME)
public class Contact extends BaseModel {

    @Column(columnType = Column.PRIMARY_KEY)
    public String nev;

    public List<Telefonszam> telefonszamok;

}
