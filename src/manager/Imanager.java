package manager;

import java.util.ArrayList;

public interface Imanager <P>{
    void add (P p);
    boolean edit (int id, P p);
    boolean delete (int id );
    int findById(int id);
    int findByType(int type);
    ArrayList<P>findAll();
}
