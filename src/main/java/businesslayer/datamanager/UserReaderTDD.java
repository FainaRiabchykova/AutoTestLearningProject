package businesslayer.datamanager;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class UserReaderTDD {
    public static Iterator<Object[]> usersSupplier() throws FileNotFoundException {
        List<User> usersList = new CsvToBeanBuilder(new FileReader("src/test/resourses/usersData.csv"))
                .withType(User.class).build().parse();
        return Stream.of(
                new Object[]{ usersList.get(0)},
                new Object[]{ usersList.get(1)},
                new Object[]{ usersList.get(2)},
                new Object[]{ usersList.get(3)},
                new Object[]{ usersList.get(4)}
        ).iterator();
    }

}
