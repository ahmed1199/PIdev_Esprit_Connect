package Services;
import Entites.LostandFound;
import java.util.List;

/**
 *
 * @author anice
 */
public interface ServiceLaf {
    public void ajouter(LostandFound l);
    public void modifier(int num_tel,String description,String photo,int id,String titre);
   // public void modifier(LostandFound l);
    public void supprimer(int id);
    public List<LostandFound> afficher();
}
