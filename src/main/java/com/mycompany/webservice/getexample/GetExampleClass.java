/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webservice.getexample;

import com.mycompany.webservice.pojo.Ev;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Yusuf
 */
@Path("/getExample")
public class GetExampleClass {
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getListValue")
    public List<Ev> getListValue(){
       
             
        Connection c = null;
        try {
          Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Yusuf\\Documents\\NetBeansProjects\\WebService\\dbEV.sqlite");
        } catch ( Exception e ) {
         JOptionPane.showMessageDialog( null,e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Opened database successfully");
        String sql="SELECT * from tblEV";
        PreparedStatement p=null;
         ResultSet rs = null;
           
           List<Ev> evList=new ArrayList<>();
         try{
             p=c.prepareStatement(sql);
             p.clearParameters();
             rs=p.executeQuery();
             while(rs.next()) {
                 Ev ev =new Ev();   
                 ev.setEvId(rs.getInt("evID"));
                 ev.setEvIl(rs.getString("evIL"));
                 ev.setEvEmlak(rs.getString("evEmlakTip"));
                 ev.setEvAlan(rs.getInt("evAlan"));
                 ev.setOdaSayisi(rs.getInt("evOdaSayisi"));
                 ev.setBinaYasi(rs.getInt("evBinaYasi"));
                 ev.setBulKat(rs.getInt("evBulKat"));
                 ev.setFiyat(rs.getDouble("evFiyat"));
                 ev.setEvAciklama(rs.getString("evAciklama"));
                 evList.add(ev);
            }
         }catch(SQLException s){
             System.out.println("exepcion="+s);
         }
         sql="SELECT * from tblResim";
        try{
             p=c.prepareStatement(sql);
             p.clearParameters();
             rs=p.executeQuery();
             while(rs.next()) {
                 int evId;
                 evId=rs.getInt("resimEvID");
                 for (int i = 0; i < evList.size(); i++) {
                     if(evId==evList.get(i).getEvId()){
                         evList.get(i).setResim(rs.getString("resimYol"));
                     }
                 }
            }
         }catch(SQLException s){
             System.out.println("exepcion="+s);
         }
        
      
        return evList;
    }
    
    
}
