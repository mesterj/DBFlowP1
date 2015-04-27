package util.kite.mester.com.dbflowp1;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by Joco on 2015.04.26..
 */
@Table(databaseName = Ddfp1db.NAME)
public class Contact extends BaseModel {

    @Column(columnType = Column.PRIMARY_KEY)
    public int azon;

    @Column
    public String nev;

    private List<Telefonszam> telefonszamok;

    public List<Telefonszam> getTelefonszamok() {
        if(telefonszamok == null){
            telefonszamok = Select.all(Telefonszam.class, Condition.column(Telefonszam$Table.CONTACT_CONTACT).is(azon));
            //telefonszamok = Select.all(Telefonszam.class, Condition.column(Contact$Table.azon).is(azon));


            //Condition.column(TestManyModels$Table.TESTMODELNAME).is(name));
        }
        return telefonszamok;
    }
}
