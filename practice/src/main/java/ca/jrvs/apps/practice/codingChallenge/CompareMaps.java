package ca.jrvs.apps.practice.codingChallenge;

import ca.jrvs.apps.practice.dataStructure.map.HashJMap;

import java.util.Map;

public class CompareMaps {

    public <K,V> boolean compareMaps1(Map<K,V> m1, Map<K,V> m2){
        return m1.equals(m2);
    }

    public <K,V> boolean compareMap2(HashJMap<K,V> m1, HashJMap<K,V> m2){
        return m1.equals(m2);
    }
}
