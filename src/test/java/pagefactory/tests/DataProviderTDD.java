package pagefactory.tests;

import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.util.Iterator;

import static businesslayer.datamanager.UserReaderTDD.usersSupplier;

public class DataProviderTDD {
    @DataProvider(name = "riaTDD", parallel = true)
    public static Iterator<Object[]> users() throws FileNotFoundException {
        return usersSupplier();
    }
}
