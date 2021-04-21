package pagefactory.tests;

import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.stream.Stream;

public  class DataProviderClass {
    @DataProvider(name = "riaTest", parallel = true)
    public static Iterator<Object[]> users() {
        return Stream.of(
                new Object[]{
                        "qualitydandelion+to@gmail.com",
                        "qualitydandelion+cc@gmail.com",
                        "qualitydandelion+bcc@gmail.com",
                        "Subject text User1" },
                new Object[]{
                        "qualitydandelion+to2@gmail.com",
                        "qualitydandelion+cc2@gmail.com",
                        "qualitydandelion+bcc2@gmail.com",
                        "Subject text User2" },
                new Object[]{
                        "qualitydandelion+to3@gmail.com",
                        "qualitydandelion+cc3@gmail.com",
                        "qualitydandelion+bcc3@gmail.com",
                        "Subject text User3" },
                new Object[]{
                        "qualitydandelion+to4@gmail.com",
                        "qualitydandelion+cc4@gmail.com",
                        "qualitydandelion+bcc4@gmail.com",
                        "Subject text User4" },
                new Object[]{
                        "qualitydandelion+to5@gmail.com",
                        "qualitydandelion+cc5@gmail.com",
                        "qualitydandelion+bcc5@gmail.com",
                        "Subject text User5" } )
        .iterator();
    }

}
