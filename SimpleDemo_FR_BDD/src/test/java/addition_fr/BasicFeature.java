package addition_fr;

//START:imports
import java.util.*;
import cuke4duke.annotation.I18n.FR.Soit;
import cuke4duke.annotation.I18n.FR.Alors;
import cuke4duke.annotation.I18n.FR.Quand;
import static junit.framework.Assert.assertEquals;
//END:imports

@SuppressWarnings({"UnusedDeclaration"})
public class BasicFeature {
//START:fields
    private List<Integer> ints = new ArrayList<Integer>();

    private int resultat;
//END:fields
//START:given
    @Soit("^une calculatrice$")
    public void Init() {
        
    }
//END:given
//START:when
    @Quand("^.*on tape ([0-9]*)$")
    public void OnTape(int nombre) {
        ints.add(nombre);
    }
//END:when
    @Quand("^on tape additionner$")
    public void OnAdditionne() {
        resultat = ints.get(0) + ints.get(1) ;
    }

//START:then
    @Alors("^le résultat doit être ([0-9]*)$")
    public void VerificationResultat(int resultat_attendu) {
       assertEquals(resultat_attendu,resultat);
    }
//END:then
}
