class TimeMap {
    Map <String, List<List<String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<List<String>> valueList = map.getOrDefault(key, new ArrayList<>());
        insertInto(value, timestamp, valueList);
        map.put(key, valueList);
    }

    public String get(String key, int timestamp) {
        List<List<String>> valueList = map.getOrDefault(key, new ArrayList<>());
        if (valueList.isEmpty()) {
            return "";
        }
        return getValue(timestamp, valueList);
    }

    private void insertInto(String value, int timestamp, List<List<String>> valueList) {
        if (valueList.isEmpty()) {
            valueList.add(Arrays.asList(String.valueOf(timestamp), value));
            return;
        }
        int top = 0;
        int end = valueList.size() - 1;
        int idx = 0;
        while (top <= end) {
            int mid = top + (end - top) / 2;
            int time = Integer.parseInt(valueList.get(mid).get(0));

            if (time <= timestamp) {
                idx = mid;
                top = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        valueList.add(idx + 1, Arrays.asList(String.valueOf(timestamp), value));
    }

    private String getValue(int timestamp, List<List<String>> valueList) {
        int top = 0;
        int end = valueList.size() - 1;
        String ans = "";
        while (top <= end) {
            int mid = top + (end - top) / 2;

            int time = Integer.parseInt(valueList.get(mid).get(0));

            if (time <= timestamp) {
                ans = valueList.get(mid).get(1);
                top = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
