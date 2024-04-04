//import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.SQLException ; 


public class DatabaseConnection{

    public static void main(String[] args) {
        
        String jdbcUrl = "jdbc:mysql://localhost:3306/bibliotheque";
        String username = "root";
        String password = "";
        
        //String sql = "update livres set auteur ='sanctyMens' where id = 1";
         //String sql1 = "insert into livres(titre,auteur,annee_publication) values ('Au pays de mes reves' , 'sanctyMens', 2023)";
        //String sql2 = "delete from livres where id = 4";

        String sql1 = "insert into livres (titre,auteur,annee_publication) values (?,?,?)";
        
        try {
            Connection conn = DriverManager.getConnection(jdbcUrl,username,password);
            System.out.println("la connexion etablie");
            //Statement stmEtat = conn.createStatement();

             //stmEtat.executeUpdate(sql1);
            // contient les requete vers la base de donnée 
            //ResultSet resultat = stmEtat.executeQuery(sql);

            /********************Les Prepare **************/

            PreparedStatement stmEtat = conn.prepareStatement(sql1);
            

            /* stmEtat.setString(1 ,"Revelation de la montagne");
            stmEtat.setString(2,"Eliyah");
            stmEtat.setInt(3,2024); */


            stmEtat.executeUpdate();
           /**
            *
              while(resultat.next())
            {
               int id = resultat.getInt("id");
                String titre = resultat.getString("titre");

                System.out.println("Le livre N :  " + id + "  le titre est  : " + titre);
            } */



            conn.close(); // fermeture de la BD
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
         

    }
}
