package model;

import java.util.List;
import java.util.Map;

public class Shop {
    String[] arrs;
    List<String> list;
    Map<String,String> map;

    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String[] getArrs() {
        return arrs;
    }

    public List<String> getList() {
        return list;
    }

    public Map<String, String> getMap() {
        return map;
    }
}
