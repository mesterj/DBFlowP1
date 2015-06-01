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
            saveForeignKeyModel = false)
    ForeignKeyContainer<Contact> contact;

    // A szĂˇmok mentĂ©se egyetlen formĂˇban tĂ¶rtĂ©nhet: +36(illetve orszĂˇg elĹ‘hĂ­vĂł) 52555555 illetve mobil szĂˇoknĂˇl +36301234567
    // Mindegy milyen formĂˇban Ă­rja be valaki, jĂł formĂˇban kell elmenteni
    // Ha + vagy 00 taggal kezdĹ‘dik Ă©s nem 36-al folytatĂłdik akkor ellenĂ¶rzĂ©s Ă©s ĂˇtalakĂ­tĂˇs nĂ©lkĂĽl elmentem a szĂˇmot.
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
        return szam;
    }

    public void addToContact(Contact contact){
        Long contId = contact.getId();
        ArrayList<Contact> contactList = new ArrayList<>();
        contactList.add(contact);
        ForeignKeyContainer<Contact> foreignKeyContainer = new ForeignKeyContainer<Contact>(Contact.class);
        foreignKeyContainer.setModel(contact);
//        this.setContact(contactList);
        this.save();
    }
}
