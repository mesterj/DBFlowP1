package util.kite.mester.com.dbflowp1;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.container.ForeignKeyContainer;

import java.util.ArrayList;

/**
 * Created by Joco on 2015.04.26..
 */
@Table(databaseName = Ddfp1db.NAME)
public class Telefonszam extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    Long id;

    @Column
    String szam;

    @Column
    @ForeignKey(references = {@ForeignKeyReference(columnName = "contact_id",
            columnType = Long.class,
            foreignColumnName = "id")},
            saveForeignKeyModel = true)
    ForeignKeyContainer<Contact> contact;

    // A számok mentése egyetlen formában történhet: +36(illetve ország előhívó) 52555555 illetve mobil számoknál +36301234567
    // Mindegy milyen formában írja be valaki, jó formában kell elmenteni
    // Ha + vagy 00 taggal kezdódik és nem 36-al folytatódik akkor ellenőrzés és átalakítás nélkül elmentem a számot.
    public void setSzam(String szam) {
        if ((szam.substring(0).equals("+")) || (szam.substring(0, 1).equals("00"))) {
            this.szam = szam;
        }

        this.szam = szam;
    }

    public String getSzam() {
        return szam;
    }

    public ForeignKeyContainer<Contact> getContact() {
        return contact;
    }

    public void setContact(ForeignKeyContainer<Contact> contact) {
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Szám: " + getSzam() + " A kontaktja:  "  + getContact();
    }

    public void addToContact(Contact contact){
        ForeignKeyContainer<Contact> foreignKeyContainer = getContact();
        foreignKeyContainer.put(Telefonszam$Table.CONTACT_CONTACT_ID,contact);
        //foreignKeyContainer.setModel(contact);
//        this.setContact(contactList);
//        this.save();
    }
}
