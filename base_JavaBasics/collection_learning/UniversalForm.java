package collection_learning;

import java.util.List;

public class UniversalForm {
    public static <T> void copy(List<?extends T> list1,List<?super T> list2){
        for (int i =0; i < list1.size(); i++){
            list2.add(list1.get(i));
        }
    }
}
