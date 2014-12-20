package com.ipmedt4.challengeweek_v2;

/**
 * Created by Charlie on 17-12-2014.
 */
public class Studenten
{

    private int _id;
    private String _naam;
    private String _studentnummer;
    private String _klas;
    private int _cijfer;
    private String _opmerkingen;

    public Studenten(){
      }

    public Studenten(int id, String naam, String studentnummer, String klas, int cijfer, String opmerkingen){

      this._id = id;
      this._naam = naam;
      this._studentnummer = studentnummer;
      this._klas = klas;
      this._cijfer = cijfer;
      this._opmerkingen = opmerkingen;

    }

    public Studenten (String naam, String studentnummer, String klas, int cijfer, String opmerkingen){

        this._naam = naam;
        this._studentnummer = studentnummer;
        this._klas = klas;
        this._cijfer = cijfer;
        this._opmerkingen = opmerkingen;

    }


   public void setID(int id){
      this._id = id;

   }

   public String getStudentnaam(){
    return this._naam;

   }

    public String getKlas() {
       return this._klas;
    }

    public String getStudentnummer(){
        return this._studentnummer;

    }

    public int getCijfer(){
        return this._cijfer;

    }

    public String getOpmerkingen(){
        return this._opmerkingen;

    }
}
