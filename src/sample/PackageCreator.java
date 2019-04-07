package sample;

import java.util.ArrayList;

public class PackageCreator {

    public Package pakkiEitt(){
        Package myPackage = new Package();
        myPackage.setName("Fjörpakkinn");
        myPackage.setDepartureDestination("Bíldudalur");
        myPackage.setDestination("Akureyri");
        myPackage.setHotel("Hótel Akureyri");
        myPackage.setEvent("Bjórbað");
        myPackage.setDepartureDestinationID("BIU");
        myPackage.setDestinationID("AEY");
        return myPackage;
    }
    public Package pakkiTvo(){
        Package myPackage = new Package();
        myPackage.setName("Klikkpakkinn");
        myPackage.setDepartureDestination("Árnanes");
        myPackage.setDestination("Akureyri");
        myPackage.setHotel("Hótel Akureyri");
        myPackage.setEvent("Bjórbað");
        myPackage.setDepartureDestinationID("GJR");
        myPackage.setDestinationID("AEY");
        return myPackage;
    }
    public Package pakkiThrju(){
        Package myPackage = new Package();
        myPackage.setName("Eyjabailpakkinn");
        myPackage.setDepartureDestination("Vestmanneyjar");
        myPackage.setDestination("Hornafjörður");
        myPackage.setHotel("Hótel Akureyri");
        myPackage.setEvent("Bjórbað");
        myPackage.setDepartureDestinationID("VEY");
        myPackage.setDestinationID("HFN");
        return myPackage;
    }
    public Package pakkiFjogur() {
        Package myPackage = new Package();
        myPackage.setName("Gjöróðipakkinn");
        myPackage.setDepartureDestination("Egilsstaðir");
        myPackage.setDestination("Árnanes");
        myPackage.setHotel("Hótel Akureyri");
        myPackage.setEvent("Bjórbað");
        myPackage.setDepartureDestinationID("EGS");
        myPackage.setDestinationID("GJR");
        return myPackage;
    }
    public Package pakkiFimm() {
        Package myPackage = new Package();
        myPackage.setName("Höfuðsvæðisbeilpakkinn");
        myPackage.setDepartureDestination("Reykjavík");
        myPackage.setDestination("Árnanes");
        myPackage.setHotel("Hótel Akureyri");
        myPackage.setEvent("Bjórbað");
        myPackage.setDepartureDestinationID("RKV");
        myPackage.setDestinationID("GJR");
        return myPackage;
    }

    public ArrayList pakkaSafn(){
        ArrayList pakkar = new ArrayList();
        pakkar.add(pakkiEitt());
        pakkar.add(pakkiTvo());
        pakkar.add(pakkiThrju());
        pakkar.add(pakkiFjogur());
        pakkar.add(pakkiFimm());

        return pakkar;
    }
}
