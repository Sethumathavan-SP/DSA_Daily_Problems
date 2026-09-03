class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int pos = Collections.binarySearch(list, num);
        if (pos < 0) {
            pos = -(pos + 1);
        }
        list.add(pos, num);
    }
    
    public double findMedian() {
        if ((list.size()&1) == 0) {
            return (list.get(list.size()/2) + list.get(list.size()/2 - 1)) / 2.0;
        }
        else {
            return list.get(list.size()/2);
        }
    }
}
