package mil.dha.health.dveivr

import groovy.xml.MarkupBuilder
import org.junit.Test

/**
 * Created by phoehne on 8/12/16.
 */
class PatientTest {

    @Test
    public void testSerialization() {
        Patient patient = new Patient()
        patient.firstName = "joe"

        StringWriter sw = new StringWriter()
        MarkupBuilder markupBuilder = new MarkupBuilder(sw)

        markupBuilder.patient()


        print(sw.toString())
    }
}
