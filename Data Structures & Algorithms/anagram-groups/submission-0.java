class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> listMap = new HashMap<>();

        for(var str: strs){
            int[] arr = new int[26];
            for(int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            String charStr = Arrays.toString(arr);
            List<String> stringList = listMap.getOrDefault(charStr, new ArrayList<>());
            stringList.add(str);
            listMap.put(charStr, stringList);
        }
        for(var key: listMap.keySet()){
            list.add(listMap.get(key));
        }
        return list;
    }
}
