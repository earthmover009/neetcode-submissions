class Solution {

    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        if(strs.size() == 1 && strs.getFirst().isEmpty()){
            return "";
        } else if(strs.isEmpty()){
            return null;
        }
        for(String str : strs){
            stringBuilder.append(str).append('\u200E');
        }
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> strList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        if(str == null){
          return Collections.emptyList();
        } else if(str.isEmpty()){
            return List.of("");
        }
        char[] charArray = str.toCharArray();
        for (char c : charArray){
            if(c=='\u200E'){
                strList.add(builder.toString());
                builder.setLength(0);
            } else {
                builder.append(c);
            }
        }
        return strList;
    }
}
