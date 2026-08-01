class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for(String email : emails) {
            String[] arr = email.split("@");
            String localName = cleanString(arr[0]);
            String domain = arr[1];

            set.add(localName + "@" + domain);
        }

        return set.size();
    }

    private String cleanString(String str) {
        str = str.replace(".", "");
        String[] arr = str.split("\\+");
        return arr[0];
    }
}