/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webservice.pojo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yusuf
 */
@XmlRootElement(name="person")
public class Ev {
    int evId;
    String evIl;
    String evEmlak;
    int evAlan;
    int odaSayisi;
    int binaYasi;
    int bulKat;
    double fiyat;
    String evAciklama;
    List<String> resim;
    public Ev(){
        resim=new ArrayList<>();
    }
    public int getEvId() {
        return evId;
    }

    public void setEvId(int evId) {
        this.evId = evId;
    }

    public String getEvIl() {
        return evIl;
    }

    public void setEvIl(String evIl) {
        this.evIl = evIl;
    }

    public String getEvEmlak() {
        return evEmlak;
    }

    public void setEvEmlak(String evEmlak) {
        this.evEmlak = evEmlak;
    }

    public int getEvAlan() {
        return evAlan;
    }

    public void setEvAlan(int evAlan) {
        this.evAlan = evAlan;
    }

    public int getOdaSayisi() {
        return odaSayisi;
    }

    public void setOdaSayisi(int odaSayisi) {
        this.odaSayisi = odaSayisi;
    }

    public int getBinaYasi() {
        return binaYasi;
    }

    public void setBinaYasi(int binaYasi) {
        this.binaYasi = binaYasi;
    }

    public int getBulKat() {
        return bulKat;
    }

    public void setBulKat(int bulKat) {
        this.bulKat = bulKat;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public String getEvAciklama() {
        return evAciklama;
    }

    public void setEvAciklama(String evAciklama) {
        this.evAciklama = evAciklama;
    }

    public List<String> getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim.add(resim);
    }

    
    
}
