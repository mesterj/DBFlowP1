package util.kite.mester.com.dbflowp1;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.Database;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Joco on 2015.04.26..
 */
@Table(databaseName = Ddfp1db.NAME)
public class Telefonszam extends BaseModel {

    @Column(columnType = Column.PRIMARY_KEY)
    String szam;

    @Column(columnType = Column.FOREIGN_KEY, references = {@ForeignKeyReference(columnName = "Contact", columnType = Integer.class, foreignColumnName = "azon")})
    Contact contact;

}
