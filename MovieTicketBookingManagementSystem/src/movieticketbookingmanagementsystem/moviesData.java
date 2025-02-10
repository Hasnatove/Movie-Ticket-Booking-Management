/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movieticketbookingmanagementsystem;
import java.sql.DataTruncation;
import java.util.Date;

/**
 *
 * @author User
 */


public class moviesData {
    private String title;
    private String genre;
    private String duration;
    private Date date;
    
    public moviesData(String title,String genre, String duration, Date date){
        this.title = title;
         this.genre = genre;
          this.duration = duration;
           this.date = date;
    }
    public String getTitle(){
        return title;
    }
    public String getGenre(){
        return genre;
}
 
        public String getDuration(){
        return duration;
       
        }
        public Date getDate(){
        return date;
           
    }
        }
        

