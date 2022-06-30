package ca.jrvs.apps.practice.codingChallenge;

import ca.jrvs.apps.practice.dataStructure.map.HashJMap;

import java.util.Map;

public class CompareMaps {

    /**
     * performs the collections .equals comparison method to check if both methods are the same in value
     *
     * @param m1 map object one
     * @param m2 map object two
     * @return true or false if the maps are equal in value
     * @param <K> type of key object
     * @param <V> type of value object
     */
    public <K,V> boolean compareMaps1(Map<K,V> m1, Map<K,V> m2){
        return m1.equals(m2);
    }

    /**
     * uses the HashjMap implementation proceed to check each element of the maps against each other to see if they are equal
     *
     * @param m1 map object one
     * @param m2 map object two
     * @return true or false if the maps are equal in value
     * @param <K> type of key object
     * @param <V> type of value object
     */
    public <K,V> boolean compareMap2(HashJMap<K,V> m1, HashJMap<K,V> m2){
        return m1.equals(m2);
    }

}
