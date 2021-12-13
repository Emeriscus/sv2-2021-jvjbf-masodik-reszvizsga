package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private List<Human> humans = new ArrayList<>();

    public List<Human> getHumans() {
        return humans;
    }

    public void readHumansFromFile(Path path) {
        List<String> lines = readLines(path);
        humans = getDataFromLines(lines);
    }

    public List<String> readLines(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    private List<Human> getDataFromLines(List<String> lines) {
        List<Human> humans = new ArrayList<>();
        for (String actual : lines) {
            String[] parts = actual.split(";");
            humans.add(new Human(parts[0], parts[1]));
        }
        return humans;
    }

    public void writeMaleHumansToFile(Path path) {
        List<Human> males = getMaleHumans(humans);
        List<String> malesToText = malesToText(males);
        try {
            Files.write(path, malesToText);
        } catch (IOException ioe) {
            System.out.println("Can't write file!");
        }
    }

    private List<Human> getMaleHumans(List<Human> humans) {
        List<Human> males = new ArrayList<>();
        for (Human actual : humans) {
            if (isMale(actual)) {
                males.add(actual);
            }
        }
        return males;
    }

    private boolean isMale(Human human) {
        return human.getIdentityNumber().startsWith("1") || human.getIdentityNumber().startsWith("3");
    }

    private List<String> malesToText(List<Human> males) {
        List<String> result = new ArrayList<>();
        for (Human actual : males) {
            result.add(actual.getName() + ";" + actual.getIdentityNumber());
        }
        return result;
    }
}
