package util.kite.mester.com.dbflowp1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.container.ForeignKeyContainer;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    EditText etContact;
    EditText etTelefon;
    Spinner spnContacts;
    ArrayAdapter<Contact> myAdapter;
    List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("DBFLOW.MAINACTIVITY: ","STARTED");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnContacts = (Spinner) findViewById(R.id.spnContact);
        //List<Contact> nevek = new Select(ColumnAlias.column(Contact$Table.NEV)).from(Contact.class).queryList();
        contacts = new Select().from(Contact.class).queryList();
        Log.i("LOGTAG","Contacts mérete: " + contacts.size());
        List<Telefonszam> telefonszams = new Select().from(Telefonszam.class).queryList();
        Log.i("LOGTAG","Telefonszámok: "  + telefonszams.size());


        myAdapter = new ArrayAdapter<Contact>(this, R.layout.support_simple_spinner_dropdown_item,contacts);

        spnContacts.setAdapter(myAdapter);
        etContact = (EditText) findViewById(R.id.etContactNev);
        etTelefon = (EditText) findViewById(R.id.etTelefonszam);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v){
        switch (v.getId()){
            case (R.id.btnSaveContact):
            Contact c = new Contact();
                c.setNev(etContact.getText().toString());
                c.save();
               // ArrayList<Telefonszam> telefonszamList = new ArrayList<Telefonszam>();
                Telefonszam t1 = new Telefonszam();
                String tszam = etTelefon.getText().toString();
                if(!tszam.equals(null)){
                    t1.setSzam(tszam);
                    //t1.addToContact(c);
                    //t1.getContact().put(Telefonszam$Table.CONTACT_CONTACT_ID,c);// Ez a másik megoldás közvetlen mentéshez
                    ForeignKeyContainer<Contact> fkc = new ForeignKeyContainer<Contact>(Contact.class);
//                    fkc.put(Telefonszam$Table.CONTACT_CONTACT_ID,c);
                    fkc.setModel(c);
                    t1.setContact(fkc);

                    t1.save();
                    //t1.getContact().setModel(c);
                    //t1.update();

                }
                else {
                    Log.i("DBFLOW.SAVECONTACT","Tszam was null");
                }
                //c.update();
                Log.i("DBFLOW.SAVECONTACT", "Toast come");
                //Toast.makeText(v.getContext(),"Az új contact száma: "+ c.getTelefonszamok().get(0),Toast.LENGTH_LONG).show();
                reloadAdapter();
                break;
            case (R.id.btnTelefonszam):
                Long itempos = spnContacts.getItemIdAtPosition(spnContacts.getSelectedItemPosition());
                Contact cleker = new Select().from(Contact.class).where(Condition.column(Contact$Table.ID).is(itempos + 1)).querySingle();
                Log.i("DBFLOW.TALALATNEVE:",cleker.getNev());
                // Itt lesz az igazi adatbázisból való telefonszám visszakérés
                List<Telefonszam> seleceSzamok = new Select().from(Telefonszam.class).queryList();
                Log.i("DBFLOW.SZAMOK"," FROM DATABASE "+ seleceSzamok.size());
                List<Telefonszam> contactSzamok = cleker.getTelefonszamok();
                for(Telefonszam t: contactSzamok){
                    Log.i("DBFLOW.SZAMOK",t.toString());
                }

                for (Telefonszam t:seleceSzamok){
                    Log.i("DBFLOW.Telefon.elemek",t.toString());
                }
                if (contactSzamok!=null) {
                    //Toast.makeText(v.getContext(), "A telefonszám: "+ contactSzamok.get(0),Toast.LENGTH_LONG).show();
                    Toast.makeText(v.getContext(),"valami",Toast.LENGTH_LONG).show();
                    break;
                }
                Telefonszam t = new Telefonszam();
                t.setSzam(etTelefon.getText().toString());
                t.save();
                break;
            default:

        }
    }

    void reloadAdapter(){
        contacts.clear();
        contacts = new Select().from(Contact.class).queryList();
        myAdapter = new ArrayAdapter<Contact>(this, R.layout.support_simple_spinner_dropdown_item,contacts);
        Log.i("LOGTAG","NEW SELECT loaded new size: " + contacts.size()  );
        myAdapter.notifyDataSetChanged();
        spnContacts.setAdapter(myAdapter);
    }

}
