package com.br.lp3.ejb;

import com.br.lp3.model.Pet;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 */
@Local
public interface PetsManagerLocal {

    public ArrayList<Pet> getPets();

}
