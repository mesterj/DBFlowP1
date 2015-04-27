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

    // A számok mentése egyetlen formában történhet: +36(illetve ország elõhívó) 52555555 illetve mobil száoknál +36301234567
    // Mindegy milyen formában írja be valaki, jó formában kell elmenteni
    // Ha + vagy 00 taggal kezdõdik és nem 36-al folytatódik akkor ellenörzés és átalakítás nélkül elmentem a számot.
    public void setSzam(String szam) {
        if ((szam.substring(0).equals("+")) || (szam.substring(0,1).equals("00"))){
            this.szam = szam;
        }

        this.szam = szam;
    }
}
