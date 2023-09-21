package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ListTrainTest {
    private ListTrain listTrain;
    @BeforeEach
    public void setUp() throws Exception {
        listTrain = new ListTrain();
        listTrain.addAll(new Train("Москва-Кострома", "Кострома",
                "Москва", 300, "2023-05-22 23:00", "2023-05-23 05:00"));
        listTrain.addAll(new Train("Москва-Кострома", "Москва",
                "Кострома", 300, "2023-05-22 23:00", "2023-05-23 05:00"));
        listTrain.addAll(new Train("Ярославль-Кострома", "Кострома",
                "Москва", 70, "2023-05-22 10:00", "2023-05-22 11:20"));
    }

    @ParameterizedTest
    @CsvSource({
            "Москва-Кострома, Кострома, Москва, 300, 2023-05-22 23:00, 2023-05-23 05:00",
            "Ярославль-Кострома, Кострома, Ярославль, 70, 2023-05-22 10:00, 2023-05-22 11:20"
    })
    public void addListTest(String name, String stationStart, String stationFinish,
                            double distance, String startTime, String finishTime) throws Exception {
        Train train = new Train(name, stationStart, stationFinish, distance, startTime, finishTime);
        ArrayList<Train> list = new ArrayList<>();
        list.add(train);
        assertIterableEquals(list, listTrain.getListTrain());
    }
    @Test
    public void addListChoiceOfOptionsTest() throws Exception {
        Train train1 = new Train("Москва-Кострома", "Кострома",
                "Москва", 300, "2023-05-22 23:00", "2023-05-23 05:00");
        Train train3 = new Train("Ярославль-Кострома", "Кострома",
                "Москва", 70, "2023-05-22 10:00", "2023-05-22 11:20");
        ArrayList<Train> listTrainStartStation = new ArrayList<>(Arrays.asList(train1, train3));
        ArrayList<Train> listTrainFinishStationTime = new ArrayList<>();
        listTrainFinishStationTime.add(train1);
        assertIterableEquals(listTrainStartStation, listTrain.findListStartStation("Кострома"));
        assertIterableEquals(listTrainFinishStationTime, listTrain.findListFinishStation("Москва",
                "2023-05-23 05:00"));
    }
}