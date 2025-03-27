/*
Design an interface called Series with the following methods:
i) getNext (returns the next number in series)
ii) reset(to restart the series)
iii) setStart (to set the value from which the series should start)
Design a class named ByTwos that implements Series such that it generates a series of numbers, each two greater than the previous one. 
Also design a class which will include the main method for referencing the interface.
*/
interface Series {
    int getNext();
    void reset();
    void setStart(int x);
}

class ByTwos implements Series {
    private int start, val;
    
    ByTwos() {
        start = 0;
        val = 0;
    }
    
    public int getNext() {
        val += 2;
        return val;
    }
    
    public void reset() {
        val = start;
    }
    
    public void setStart(int x) {
        start = x;
        val = x;
    }
}

class SeriesDemo {
    public static void main(String[] args) {
        ByTwos series = new ByTwos();
        series.setStart(2);
        System.out.println("First 5 terms of ByTwos series:");
        for (int i = 0; i < 5; i++) {
            System.out.println(series.getNext());
        }
    }
}
