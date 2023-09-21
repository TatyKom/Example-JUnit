package org.example;

import java.util.ArrayList;
public class ListTrain {
    private final ArrayList<Train> listTrain = new ArrayList<>();
    public ArrayList<Train> getListTrain() {
        return listTrain;
    }

    public void addAll(Train t) {
        listTrain.add(t);
    }

    public ArrayList<Train> findListStartStation(String nameStartStation) {
        ArrayList<Train> list = new ArrayList<>();
        for (Train e : listTrain) {
            if (nameStartStation.equals(e.getStationStart()))
                list.add(e);
        }
        return list;
    }

    public ArrayList<Train> findListFinishStation(String nameFinishStation, String finishTime) {
        ArrayList<Train> list = new ArrayList<>();
        for (Train e : listTrain) {
            if (nameFinishStation.equals(e.getStationFinish())
                    && finishTime.equals(e.getFinishTime()))
                list.add(e);
        }
        return list;
    }

    @Override
    public String toString() {
        return String.valueOf(listTrain);
    }
}
