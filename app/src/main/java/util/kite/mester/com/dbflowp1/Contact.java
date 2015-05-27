package util.kite.mester.com.dbflowp1;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by Joco on 2015.04.26..
 */
@ModelContainer
@Table(databaseName = Ddfp1db.NAME)
public class Contact extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    public Long id;

    @Column
    public String nev;

    List<Telefonszam> telefonszamok;

    @OneToMany(methods = {OneToMany.Method.ALL})
    public List<Telefonszam> getTelefonszamok() {
        if(telefonszamok == null){
            telefonszamok = new Select().from(Telefonszam.class)
                    .where(Condition.column(Telefonszam$Table.CONTACT_CONTACT_ID).is(id))
                    .queryList();
        }
        return telefonszamok;

    }


}
