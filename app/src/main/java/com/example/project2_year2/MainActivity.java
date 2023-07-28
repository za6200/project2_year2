package com.example.project2_year2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    Spinner continents;
    ListView countries;
    TextView capital;
    TextView population;
    TextView officialLanguage;
    TextView anthem;
    int choice = 0;

    // continents names in alphabetical order
    String[] continents1 = {"Asia", "Africa", "Australia", "Europe", "North America", "South America"};

    // countries names in alphabetical order
    String[] countriesAsia = {"China", "Georgia", "Israel", "India", "Japan", "Kazakhstan", "Singapore"};
    String[] countriesAfrica = {"Algeria", "Ghana", "Maroc", "Nigeria", "Senegal", "Somalia", "Tunisia"};
    String[] countriesAustralia = {"Fiji", "French Polynesia", "Guam", "New Zealand", "Solomon Island", "Tonga", "Papua New Guinea"};
    String[] countriesEurope = {"Belgium", "France", "Germany", "Greece", "Italy", "Portugal", "Spain"};
    String[] countriesNorthAmerica = {"Canada", "Mexico", "United States", "Jamaica", "Costa Rica", "Honduras", "Panama"};
    String[] countriesSouthAmerica = {"Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Peru", "Venezuela"};

    // Countries in Asia
    String[] China = {"Beijing", "1444216107", "Mandarin", "March of the Volunteers"};
    String[] Georgia = {"Tbilisi", "3989167", "Georgian", "Tavisupleba"};
    String[] Israel = {"Jerusalem", "9272700", "Hebrew", "Hatikvah"};
    String[] India = {"New Delhi", "1393409038", "Hindi", "Jana Gana Mana"};
    String[] Japan = {"Tokyo", "125785930", "Japanese", "Kimigayo"};
    String[] Kazakhstan = {"Nur-Sultan", "19137400", "Kazakh", "My Kazakhstan"};
    String[] Singapore = {"Singapore", "5850343", "English", "Majulah Singapura"};

    // Countries in Africa
    String[] Algeria = {"Algiers", "44616626", "Arabic", "Kassaman"};
    String[] Ghana = {"Accra", "32405720", "English", "God Bless Our Homeland Ghana"};
    String[] Maroc = {"Rabat", "37375730", "Arabic", "Cherifian Anthem"};
    String[] Nigeria = {"Abuja", "206139587", "English", "Arise, O Compatriots"};
    String[] Senegal = {"Dakar", "17439578", "French", "Pincez Tous vos Koras, Frappez les Balafons"};
    String[] Somalia = {"Mogadishu", "1748139", "Somali", "Qolobaa Calankeed"};
    String[] Tunisia = {"Tunis", "11925342", "Arabic", "Humat al-Hima"};

    // Countries in Australia
    String[] Fiji = {"Suva", "901180", "English", "God Bless Fiji"};
    String[] FrenchPolynesia = {"Papeete", "295153", "French", "Ia Ora 'O Tahiti Nui"};
    String[] Guam = {"Hagåtña", "168485", "English", "Fanohge Chamorro"};
    String[] NewZealand = {"Wellington", "5123445", "English", "God Defend New Zealand"};
    String[] SolomonIslands = {"Honiara", "699345", "English", "God Bless Our Solomon Islands"};
    String[] Tonga = {"Nukuʻalofa", "105600", "Tongan", "Ko e fasi 'o e tu'i 'o e 'Otu Tonga"};
    String[] PapuaNewGuinea = {"Port Moresby", "1054569", "Hiri Motu", "O Arise, All You Sons"};

    // Countries in Europe
    String[] Belgium = {"Brussels", "11589623", "Dutch", "The Brabançonne"};
    String[] France = {"Paris", "67564251", "French", "La Marseillaise"};
    String[] Germany = {"Berlin", "83457017", "German", "Deutschlandlied"};
    String[] Greece = {"Athens", "10724599", "Greek", "Hymn to Liberty"};
    String[] Italy = {"Rome", "60461826", "Italian", "Il Canto degli Italiani"};
    String[] Portugal = {"Lisbon", "10191409", "Portuguese", "A Portuguesa"};
    String[] Spain = {"Madrid", "47329981", "Spanish", "Marcha Real"};

    // Countries in North America
    String[] Canada = {"Ottawa", "38207192", "English, French", "O Canada"};
    String[] Mexico = {"Mexico City", "132379259", "Spanish", "Himno Nacional Mexicano"};
    String[] UnitedStates = {"Washington, D.C.", "353169804", "English", "The Star-Spangled Banner"};
    String[] Jamaica = {"Kingston", "2990565", "English", "Jamaica, Land We Love"};
    String[] CostaRica = {"San Jose", "5182990", "Spanish", "Noble patria, tu hermosa bandera"};
    String[] Honduras = {"Tegucigalpa", "10328288", "Spanish", "Tu bandera es un lampo de cielo"};
    String[] Panama = {"Panama City", "4632932", "Spanish", "Himno Istmeño"};

    // Countries in South America
    String[] Argentina = {"Buenos Aires", "47010616", "Spanish", "Himno Nacional Argentino"};
    String[] Brazil = {"Brasília", "230718513", "Portuguese", "Hino Nacional Brasileiro"};
    String[] Chile = {"Santiago", "20791520", "Spanish", "Himno Nacional de Chile"};
    String[] Colombia = {"Bogotá", "52553246", "Spanish", "¡Oh, Gloria Inmarcesible!"};
    String[] Ecuador = {"Quito", "19181780", "Spanish", "Salve, Oh Patria"};
    String[] Peru = {"Lima", "34164549", "Spanish", "Himno Nacional del Perú"};
    String[] Venezuela = {"Caracas", "32497567", "Spanish", "Gloria al Bravo Pueblo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        continents = findViewById(R.id.continents);
        countries = findViewById(R.id.countries);
        capital = findViewById(R.id.capital);
        population = findViewById(R.id.population);
        officialLanguage = findViewById(R.id.officialLanguage);
        anthem = findViewById(R.id.anthem);

        continents.setOnItemSelectedListener(this);
        countries.setOnItemClickListener(this);

        ArrayAdapter<String> continents2 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, continents1);
        continents.setAdapter(continents2);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                ArrayAdapter<String> countriesAsiaAdp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countriesAsia);
                countries.setAdapter(countriesAsiaAdp);
                choice = 0;
                break;
            case 1:
                ArrayAdapter<String> countriesAfricaAdp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countriesAfrica);
                countries.setAdapter(countriesAfricaAdp);
                choice = 1;
                break;
            case 2:
                ArrayAdapter<String> countriesAustraliaAdp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countriesAustralia);
                countries.setAdapter(countriesAustraliaAdp);
                choice = 2;
                break;
            case 3:
                ArrayAdapter<String> countriesEuropeAdp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countriesEurope);
                countries.setAdapter(countriesEuropeAdp);
                choice = 3;
                break;
            case 4:
                ArrayAdapter<String> countriesNorthAmericaAdp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countriesNorthAmerica);
                countries.setAdapter(countriesNorthAmericaAdp);
                choice = 4;
                break;
            case 5:
                ArrayAdapter<String> countriesSouthAmericaAdp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countriesSouthAmerica);
                countries.setAdapter(countriesSouthAmericaAdp);
                choice = 5;
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(getApplicationContext(), "Have to select content!!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (choice) {
            case 0:
                switch (position) {
                    case 0:
                        capital.setText("Capital: " + China[0]);
                        population.setText("Population: " + China[1]);
                        officialLanguage.setText("Official Language: " + China[2]);
                        anthem.setText("Anthem: " + China[3]);
                        break;
                    case 1:
                        capital.setText("Capital: " + Georgia[0]);
                        population.setText("Population: " + Georgia[1]);
                        officialLanguage.setText("Official Language: " + Georgia[2]);
                        anthem.setText("Anthem: " + Georgia[3]);
                        break;
                    case 2:
                        capital.setText("Capital: " + Israel[0]);
                        population.setText("Population: " + Israel[1]);
                        officialLanguage.setText("Official Language: " + Israel[2]);
                        anthem.setText("Anthem: " + Israel[3]);
                        break;
                    case 3:
                        capital.setText("Capital: " + India[0]);
                        population.setText("Population: " + India[1]);
                        officialLanguage.setText("Official Language: " + India[2]);
                        anthem.setText("Anthem: " + India[3]);
                        break;
                    case 4:
                        capital.setText("Capital: " + Japan[0]);
                        population.setText("Population: " + Japan[1]);
                        officialLanguage.setText("Official Language: " + Japan[2]);
                        anthem.setText("Anthem: " + Japan[3]);
                        break;
                    case 5:
                        capital.setText("Capital: " + Kazakhstan[0]);
                        population.setText("Population: " + Kazakhstan[1]);
                        officialLanguage.setText("Official Language: " + Kazakhstan[2]);
                        anthem.setText("Anthem: " + Kazakhstan[3]);
                        break;
                    case 6:
                        capital.setText("Capital: " + Singapore[0]);
                        population.setText("Population: " + Singapore[1]);
                        officialLanguage.setText("Official Language: " + Singapore[2]);
                        anthem.setText("Anthem: " + Singapore[3]);
                        break;
                }
                break;

            case 1:
                switch (position) {
                    case 0:
                        capital.setText("Capital: " + Algeria[0]);
                        population.setText("Population: " + Algeria[1]);
                        officialLanguage.setText("Official Language: " + Algeria[2]);
                        anthem.setText("Anthem: " + Algeria[3]);
                        break;
                    case 1:
                        capital.setText("Capital: " + Ghana[0]);
                        population.setText("Population: " + Ghana[1]);
                        officialLanguage.setText("Official Language: " + Ghana[2]);
                        anthem.setText("Anthem: " + Ghana[3]);
                        break;
                    case 2:
                        capital.setText("Capital: " + Maroc[0]);
                        population.setText("Population: " + Maroc[1]);
                        officialLanguage.setText("Official Language: " + Maroc[2]);
                        anthem.setText("Anthem: " + Maroc[3]);
                        break;
                    case 3:
                        capital.setText("Capital: " + Nigeria[0]);
                        population.setText("Population: " + Nigeria[1]);
                        officialLanguage.setText("Official Language: " + Nigeria[2]);
                        anthem.setText("Anthem: " + Nigeria[3]);
                        break;
                    case 4:
                        capital.setText("Capital: " + Senegal[0]);
                        population.setText("Population: " + Senegal[1]);
                        officialLanguage.setText("Official Language: " + Senegal[2]);
                        anthem.setText("Anthem: " + Senegal[3]);
                        break;
                    case 5:
                        capital.setText("Capital: " + Somalia[0]);
                        population.setText("Population: " + Somalia[1]);
                        officialLanguage.setText("Official Language: " + Somalia[2]);
                        anthem.setText("Anthem: " + Somalia[3]);
                        break;
                    case 6:
                        capital.setText("Capital: " + Tunisia[0]);
                        population.setText("Population: " + Tunisia[1]);
                        officialLanguage.setText("Official Language: " + Tunisia[2]);
                        anthem.setText("Anthem: " + Tunisia[3]);
                        break;
                }
                break;

            case 2:
                switch (position) {
                    case 0:
                        capital.setText("Capital: " + Fiji[0]);
                        population.setText("Population: " + Fiji[1]);
                        officialLanguage.setText("Official Language: " + Fiji[2]);
                        anthem.setText("Anthem: " + Fiji[3]);
                        break;
                    case 1:
                        capital.setText("Capital: " + FrenchPolynesia[0]);
                        population.setText("Population: " + FrenchPolynesia[1]);
                        officialLanguage.setText("Official Language: " + FrenchPolynesia[2]);
                        anthem.setText("Anthem: " + FrenchPolynesia[3]);
                        break;
                    case 2:
                        capital.setText("Capital: " + Guam[0]);
                        population.setText("Population: " + Guam[1]);
                        officialLanguage.setText("Official Language: " + Guam[2]);
                        anthem.setText("Anthem: " + Guam[3]);
                        break;
                    case 3:
                        capital.setText("Capital: " + NewZealand[0]);
                        population.setText("Population: " + NewZealand[1]);
                        officialLanguage.setText("Official Language: " + NewZealand[2]);
                        anthem.setText("Anthem: " + NewZealand[3]);
                        break;
                    case 4:
                        capital.setText("Capital: " + SolomonIslands[0]);
                        population.setText("Population: " + SolomonIslands[1]);
                        officialLanguage.setText("Official Language: " + SolomonIslands[2]);
                        anthem.setText("Anthem: " + SolomonIslands[3]);
                        break;
                    case 5:
                        capital.setText("Capital: " + Tonga[0]);
                        population.setText("Population: " + Tonga[1]);
                        officialLanguage.setText("Official Language: " + Tonga[2]);
                        anthem.setText("Anthem: " + Tonga[3]);
                        break;
                    case 6:
                        capital.setText("Capital: " + PapuaNewGuinea[0]);
                        population.setText("Population: " + PapuaNewGuinea[1]);
                        officialLanguage.setText("Official Language: " + PapuaNewGuinea[2]);
                        anthem.setText("Anthem: " + PapuaNewGuinea[3]);
                        break;
                }
                break;

            case 3:
                switch (position) {
                    case 0:
                        capital.setText("Capital: " + Belgium[0]);
                        population.setText("Population: " + Belgium[1]);
                        officialLanguage.setText("Official Language: " + Belgium[2]);
                        anthem.setText("Anthem: " + Belgium[3]);
                        break;
                    case 1:
                        capital.setText("Capital: " + France[0]);
                        population.setText("Population: " + France[1]);
                        officialLanguage.setText("Official Language: " + France[2]);
                        anthem.setText("Anthem: " + France[3]);
                        break;
                    case 2:
                        capital.setText("Capital: " + Germany[0]);
                        population.setText("Population: " + Germany[1]);
                        officialLanguage.setText("Official Language: " + Germany[2]);
                        anthem.setText("Anthem: " + Germany[3]);
                        break;
                    case 3:
                        capital.setText("Capital: " + Greece[0]);
                        population.setText("Population: " + Greece[1]);
                        officialLanguage.setText("Official Language: " + Greece[2]);
                        anthem.setText("Anthem: " + Greece[3]);
                        break;
                    case 4:
                        capital.setText("Capital: " + Italy[0]);
                        population.setText("Population: " + Italy[1]);
                        officialLanguage.setText("Official Language: " + Italy[2]);
                        anthem.setText("Anthem: " + Italy[3]);
                        break;
                    case 5:
                        capital.setText("Capital: " + Portugal[0]);
                        population.setText("Population: " + Portugal[1]);
                        officialLanguage.setText("Official Language: " + Portugal[2]);
                        anthem.setText("Anthem: " + Portugal[3]);
                        break;
                    case 6:
                        capital.setText("Capital: " + Spain[0]);
                        population.setText("Population: " + Spain[1]);
                        officialLanguage.setText("Official Language: " + Spain[2]);
                        anthem.setText("Anthem: " + Spain[3]);
                        break;
                }
                break;

            case 4:
                switch (position) {
                    case 0:
                        capital.setText("Capital: " + Canada[0]);
                        population.setText("Population: " + Canada[1]);
                        officialLanguage.setText("Official Language: " + Canada[2]);
                        anthem.setText("Anthem: " + Canada[3]);
                        break;
                    case 1:
                        capital.setText("Capital: " + Mexico[0]);
                        population.setText("Population: " + Mexico[1]);
                        officialLanguage.setText("Official Language: " + Mexico[2]);
                        anthem.setText("Anthem: " + Mexico[3]);
                        break;
                    case 2:
                        capital.setText("Capital: " + UnitedStates[0]);
                        population.setText("Population: " + UnitedStates[1]);
                        officialLanguage.setText("Official Language: " + UnitedStates[2]);
                        anthem.setText("Anthem: " + UnitedStates[3]);
                        break;
                    case 3:
                        capital.setText("Capital: " + Jamaica[0]);
                        population.setText("Population: " + Jamaica[1]);
                        officialLanguage.setText("Official Language: " + Jamaica[2]);
                        anthem.setText("Anthem: " + Jamaica[3]);
                        break;
                    case 4:
                        capital.setText("Capital: " + CostaRica[0]);
                        population.setText("Population: " + CostaRica[1]);
                        officialLanguage.setText("Official Language: " + CostaRica[2]);
                        anthem.setText("Anthem: " + CostaRica[3]);
                        break;
                    case 5:
                        capital.setText("Capital: " + Honduras[0]);
                        population.setText("Population: " + Honduras[1]);
                        officialLanguage.setText("Official Language: " + Honduras[2]);
                        anthem.setText("Anthem: " + Honduras[3]);
                        break;
                    case 6:
                        capital.setText("Capital: " + Panama[0]);
                        population.setText("Population: " + Panama[1]);
                        officialLanguage.setText("Official Language: " + Panama[2]);
                        anthem.setText("Anthem: " + Panama[3]);
                        break;
                }
                break;

            case 5:
                switch (position) {
                    case 0:
                        capital.setText("Capital: " + Argentina[0]);
                        population.setText("Population: " + Argentina[1]);
                        officialLanguage.setText("Official Language: " + Argentina[2]);
                        anthem.setText("Anthem: " + Argentina[3]);
                        break;
                    case 1:
                        capital.setText("Capital: " + Brazil[0]);
                        population.setText("Population: " + Brazil[1]);
                        officialLanguage.setText("Official Language: " + Brazil[2]);
                        anthem.setText("Anthem: " + Brazil[3]);
                        break;
                    case 2:
                        capital.setText("Capital: " + Chile[0]);
                        population.setText("Population: " + Chile[1]);
                        officialLanguage.setText("Official Language: " + Chile[2]);
                        anthem.setText("Anthem: " + Chile[3]);
                        break;
                    case 3:
                        capital.setText("Capital: " + Colombia[0]);
                        population.setText("Population: " + Colombia[1]);
                        officialLanguage.setText("Official Language: " + Colombia[2]);
                        anthem.setText("Anthem: " + Colombia[3]);
                        break;
                    case 4:
                        capital.setText("Capital: " + Ecuador[0]);
                        population.setText("Population: " + Ecuador[1]);
                        officialLanguage.setText("Official Language: " + Ecuador[2]);
                        anthem.setText("Anthem: " + Ecuador[3]);
                        break;
                    case 5:
                        capital.setText("Capital: " + Peru[0]);
                        population.setText("Population: " + Peru[1]);
                        officialLanguage.setText("Official Language: " + Peru[2]);
                        anthem.setText("Anthem: " + Peru[3]);
                        break;
                    case 6:
                        capital.setText("Capital: " + Venezuela[0]);
                        population.setText("Population: " + Venezuela[1]);
                        officialLanguage.setText("Official Language: " + Venezuela[2]);
                        anthem.setText("Anthem: " + Venezuela[3]);
                        break;
                }
                break;
        }

    }
}