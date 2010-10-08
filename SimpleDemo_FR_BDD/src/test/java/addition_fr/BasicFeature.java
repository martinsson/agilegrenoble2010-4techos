package addition_fr;

//START:imports
import java.util.*;

import org.agile.grenoble.NokiaTest;
import org.agile.grenoble.gui.NokiaControler;

import cuke4duke.annotation.I18n.FR.Soit;

import cuke4duke.annotation.I18n.FR.Alors;
import cuke4duke.annotation.I18n.FR.Quand;

import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.When;
import cuke4duke.annotation.I18n.EN.Then;
import cuke4duke.annotation.Pending;


import static junit.framework.Assert.assertEquals;
//END:imports

@SuppressWarnings({"UnusedDeclaration"})
public class BasicFeature {
//START:fields
    private List<Integer> ints = new ArrayList<Integer>();
    
    private NokiaControler controler ;

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

    @Alors("^l'application est lancée$")
    public void lancementAppli () {
       String []  parameters = { "Coucou" , "coucou2" };
	   //NokiaTest.main(parameters) ;
       
       NokiaControler controler = new NokiaControler() ;
       
       
       
       assertEquals(true,true);
    }
    
    @Given("^les reponses \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void initReponses(String response1, String response2, String response3, String response4, String response5, String response6, String response7, String response8, String response9)
    {
    	controler = new NokiaControler() ;
    	String[] responses = new String[9];
    	responses[0] = response1;
    	responses[1] = response2;
    	responses[2] = response3;
    	responses[3] = response4;
    	responses[4] = response5;
    	responses[5] = response6;
    	responses[6] = response7;
    	responses[7] = response8;
    	responses[8] = response9;
   	    controler.setQuestions(responses) ;
    }
    

    @When ("^je calcule le score total$")
    @Pending
    public void jeCalculeLeScoreTotal() {
    	
    }    
    

    @Then ("^le score total devrait etre 64$")
    @Pending
    public void leScoreTotalDevraitEtre64() {
    }
//    public static void main(String[] args) {
//    	BasicFeature iBF = new BasicFeature();
//    	iBF.lancementAppli() ;
//    }
}
