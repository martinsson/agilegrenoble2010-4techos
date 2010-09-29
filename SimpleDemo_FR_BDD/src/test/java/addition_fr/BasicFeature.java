package addition_fr;

//START:imports
import cuke4duke.annotation.I18n.FR.Soit;
import cuke4duke.annotation.I18n.FR.Alors;
import cuke4duke.annotation.I18n.FR.Quand;
import static junit.framework.Assert.assertEquals;
//END:imports

@SuppressWarnings({"UnusedDeclaration"})
public class BasicFeature {
//START:fields
    private String action;
    private String subject;
//END:fields
//START:given
    @Soit("^une calculatrice$")
    public void theActionIs() {
        
    }
//END:given
//START:when
    @Quand("^The Subject is ([A-z]*)$")
    public void theSubjectIs(String subject) {
        this.subject = subject;
    }
//END:when
//START:then
    @Alors("^The Greeting is ([^\\.]*).$")
    public void theGreetingIs(String greeting) {
        assertEquals(String.format("%s, %s", action, subject), greeting);
    }
//END:then
}
