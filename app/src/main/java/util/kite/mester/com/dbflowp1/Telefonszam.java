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

    // A sz�mok ment�se egyetlen form�ban t�rt�nhet: +36(illetve orsz�g el�h�v�) 52555555 illetve mobil sz�okn�l +36301234567
    // Mindegy milyen form�ban �rja be valaki, j� form�ban kell elmenteni
    // Ha + vagy 00 taggal kezd�dik �s nem 36-al folytat�dik akkor ellen�rz�s �s �talak�t�s n�lk�l elmentem a sz�mot.
    public void setSzam(String szam) {
        if ((szam.substring(0).equals("+")) || (szam.substring(0,1).equals("00"))){
            this.szam = szam;
        }

        this.szam = szam;
    }
}
