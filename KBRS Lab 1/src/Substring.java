import java.util.ArrayList;
import java.util.Iterator;

public class Substring {
    private String message;
    private ArrayList<Integer> positions;
    private ArrayList<Integer> differences;

    public Substring(String msg, int pos) {
        message = msg;
        positions = new ArrayList<Integer>();
        differences = new ArrayList<Integer>();
        positions.add(pos);
    }

    public void addOccurance(int pos) {
        positions.add(pos);
    }


    public void calculateDifferences() {
        if (positions.size() > 1) {
            for (int i = 1; i < positions.size(); i++) {
                differences.add(positions.get(i) - positions.get(i - 1));
            }
        } else {
            differences.add(0);
        }
    }

    public ArrayList<Integer> getPositions() {
        ArrayList<Integer> pos = new ArrayList<Integer>();
        for (Integer n : positions) {
            pos.add(n);
        }
        return pos;
    }

    public boolean isSingleOccurance() {
        return positions.size() <= 1;
    }


    public String getValue() {
        return message;
    }

    public static ArrayList<Substring> removeSingleOccurrenceSubstrings(
            ArrayList<Substring> substrings) {
        Iterator<Substring> it = substrings.iterator();
        while (it.hasNext()) {
            Substring substr = it.next();
            if (substr.isSingleOccurance()) {
                it.remove();
            }
        }
        return substrings;
    }

    public ArrayList<Integer> getDifferences(boolean recalc) {
        if (recalc) {
            calculateDifferences();
        }
        ArrayList<Integer> diff = new ArrayList<Integer>();
        for (Integer n : differences) {
            diff.add(n);
        }
        return diff;
    }

    public int getOccuranceCount() {
        return positions.size();
    }



    public String toString() {
        String out = message + ": ";
        for (int i = 0; i < positions.size(); i++) {
            out += positions.get(i) + ", ";
        }
        return out;
    }
}
