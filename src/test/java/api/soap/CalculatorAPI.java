package api.soap;

import org.apache.commons.io.IOUtils;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.IntStream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CalculatorAPI {

    @Test
    public void add() throws IOException {
        InputStream inputStream = new FileInputStream(getClass().getClassLoader().getResource("add.xml").getFile());
        String xmlBody = IOUtils.toString(inputStream);
        given()
                .contentType("text/xml")
                .body(xmlBody)
                .when()
                .post("http://www.dneonline.com/calculator.asmx")
                .then()
                .body("//AddResult.text()",equalTo("5"))
                .log().all();
    }
}
