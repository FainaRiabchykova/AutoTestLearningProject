package pagefactory.tests;

import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.stream.Stream;

public  class DataProviderClass {
    @DataProvider(name = "riaTest", parallel = true)
    public static Iterator<Object[]> users() {
        return Stream.of(
                new Object[]{ new User("qariatest@gmail.com\n", "Aaaa!111") },
                new Object[]{ new User("qariatest2@gmail.com\n", "Aaaa@222") },
                new Object[]{ new User("qariatest3@gmail.com\n", "Aaaa#333") },
                new Object[]{ new User("qariatest4@gmail.com\n", "Aaaa$444") },
                new Object[]{ new User("qariatest5@gmail.com\n", "Aaaa%555") } )
        .iterator();
    }
}
