class Solution {

    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        if(strs.isEmpty()){
            return null;
        }
        for(String str : strs){
            stringBuilder.append(str).append('\u170E');
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> strList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        if(str == null){
          return Collections.emptyList();
        }
        char separator = '\u170E';
        int i = 0;
        int beginIndex = 0;
        for (;i < str.length(); i++){
            if(str.charAt(i) == separator){
                strList.add(str.substring(beginIndex, i));
                beginIndex = i + 1;
            }
        }
        strList.add(str.substring(beginIndex, i));
        return strList;
    }
}
