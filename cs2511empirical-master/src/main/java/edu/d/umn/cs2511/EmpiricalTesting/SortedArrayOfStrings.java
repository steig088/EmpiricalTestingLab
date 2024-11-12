package edu.d.umn.cs2511.EmpiricalTesting;

import java.util.ArrayList;

public class SortedArrayOfStrings extends ArrayList<String> {
    private void sort() {
        super.sort((s1,s2) -> { return s1.compareTo(s2); });
    }
    @Override
    public boolean add(String s) {
        boolean result = super.add(s);
        sort();
        return result;
    }
    @Override
    public void add(int index, String s) {
        super.add(index,s);
        sort();
    }
    @Override
    public String remove(int index) {
        String s = super.remove(index);
        sort();
        return s;
    }
    @Override
    public boolean remove(Object s) {
        boolean result = super.remove(s);
        sort();
        return result;
    }
    @Override
    public String set(int index, String s1) {
        String s2 = super.set(index,s1);
        sort();
        return s2;
    }
    public boolean addAll(ArrayList<String> L) {
        boolean result = super.addAll(L);
        sort();
        return result;
    }
    public int indexOf(String s) {
        int index = super.indexOf(s);
        sort();
        return index;
    }
}
