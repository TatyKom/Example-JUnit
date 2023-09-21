package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;


class TrainTest {
    private Train trainParam;
    @BeforeEach
    public void setUp() throws Exception {
        trainParam = new Train("Москва-Кострома", "Кострома",
                "Москва", 300, "2023-05-22 23:00", "2023-05-23 05:00");
    }

    @ParameterizedTest
    @CsvSource({
            "Москва-Кострома, Кострома, Москва, 300, 2023-05-22 23:00, 2023-05-23 05:00",
            "Ярославль-Кострома, Кострома, Ярославль, 70, 2023-05-22 10:00, 2023-05-22 11:20"
    })
    @Tag("Parameter")
    public void examinationGetOptions(String name, String stationStart, String stationFinish,
                                      double distance, String startTime, String finishTime) throws Exception {
        Train train = new Train(name, stationStart, stationFinish, distance, startTime, finishTime);
        assertEquals(name, train.getName());
        assertEquals(stationStart, train.getStationStart());
        assertEquals(stationFinish, train.getStationFinish());
        assertEquals(distance, train.getDistance());
        assertEquals(startTime, train.getStartTime());
        assertEquals(finishTime, train.getFinishTime());
    }

    @ParameterizedTest
    @CsvSource({
            "Москва-Кострома, Кострома, Москва, 300, 2023-05-22 23:00, 2023-05-23 05:00",
            "Ярославль-Кострома, Кострома, Ярославль, 70, 2023-05-22 10:00, 2023-05-22 11:20"
    })
    @Tag("Parameter")
    public void examinationSetOptions(String name, String stationStart, String stationFinish,
                                      double distance, String startTime, String finishTime) throws Exception {
        Train train = new Train(name, stationStart, stationFinish, distance, startTime, finishTime);
        String nameNew = "Кострома-Хабаровск";
        train.setName(nameNew);
        assertEquals(nameNew, train.getName());
        String stationStartNew = "Кострома";
        train.setStationStart(stationStartNew);
        assertEquals(train.getStationStart(), stationStartNew);
        String stationFinishNew = "Хабаровск";
        train.setStationFinish(stationFinishNew);
        assertEquals(stationFinishNew, train.getStationFinish());
        double distanceNew = 5847;
        train.setDistance(distanceNew);
        assertEquals(distanceNew, train.getDistance());
        String startTimeNew = "2023-05-23 15:00";
        train.setStartTime(startTimeNew);
        assertEquals(startTimeNew, train.getStartTime());
        String finishTimeNew ="2023-05-28 12:00";
        train.setFinishTime(finishTimeNew);
        assertEquals(finishTimeNew, train.getFinishTime());
    }

    @Test
    @Tag("Throws")
    public void objectEqual() throws Exception {
        Train trainTwo = new Train("Москва-Кострома", "Кострома",
                "Москва", 300, "2023-05-22 23:00", "2023-05-23 05:00");
        Train trainThree = new Train("Москва-Кострома", "Кострома",
                "Москва", 300, "2023-05-22 23:00", "2023-05-23 05:00");
        assertEquals(trainParam, trainThree);
        assertEquals(trainTwo, trainParam);
    }
    @Test
    @Tag("Throws")
    public void objectNotEqual() throws Exception {
        Train trainTwo = new Train("Москва-Кострома", "Москва",
                "Кострома", 300, "2023-05-22 23:00", "2023-05-23 05:00");
        Train trainThree = new Train("Ярославль-Кострома", "Кострома",
                "Москва", 70, "2023-05-22 10:00", "2023-05-22 11:20");
        assertNotEquals(trainParam, trainTwo);
        assertNotEquals(trainTwo, trainThree);
    }

    @ParameterizedTest
    @CsvSource({
            "Москва-Кострома, Кострома, Москва, 300, 2023-05-22 23:00, 2023-05-23 05:00",
            "Ярославль-Кострома, Кострома, Ярославль, 70, 2023-05-22 10:00, 2023-05-22 11:20"
    })
    @Tag("Parameter")
    public void toStringTest(String name, String stationStart, String stationFinish,
                             double distance, String startTime, String finishTime) throws Exception {
        Train train = new Train(name, stationStart, stationFinish, distance, startTime, finishTime);
        String expected = "Поезд:  " + name + " следует от станции " + stationStart + " до станции "
                + stationFinish + ". Отбывает: " + startTime + ", прибывает: " + finishTime;
        assertEquals(expected, train.toString());
    }

    @Test
    @Tag("Function")
    public void timeDistanceTest() {
        assertEquals(6, trainParam.timeDistance());
    }

    @Test
    @Tag("Function")
    public void speedTest() {
        assertEquals(50, trainParam.speed());
    }

    @ParameterizedTest
    @CsvSource({
            ", , , -300, 2023-05-22 23:00, 2023-05-23 05:00",
            ", , , 0, 2023-05-22 10:00, 2023-05-22 11:20"
    })
    @Tag("Parameter")
    public void ExceptionIsThrownTest(String name, String stationStart, String stationFinish,
                                      double distance, String startTime, String finishTime) {
        Exception exception = assertThrows(Exception.class, () ->
                new Train(name, stationStart, stationFinish, distance, startTime, finishTime));
        String expectedStringMessage = "Некорректный ввод";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedStringMessage));
    }
}