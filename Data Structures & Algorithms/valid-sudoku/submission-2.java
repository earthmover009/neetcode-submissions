class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board.length != 9 || board[0].length != 9){
            return false;
        }
        Map<Integer,Set<Character>> rowMap = new HashMap<>();
        Map<Integer,Set<Character>> columnMap = new HashMap<>();
        Map<Integer,Set<Character>> gridMap = new HashMap<>();

        for(int i = 0; i < 9; i++){
            for( int j = 0; j < 9; j++ ){
                if( Character.isDigit(board[i][j])){
                    char value =  board[i][j];
                    Set<Character> rowSet = rowMap.getOrDefault(i, new HashSet<>());
                    if(!rowSet.add(value)){
                        return false;
                    }
                    rowMap.put(i, rowSet);
                    Set<Character> columnSet = columnMap.getOrDefault(j, new HashSet<>());
                    if(!columnSet.add(value)){
                        return false;
                    }
                    columnMap.put(j, columnSet);
                    int gridKey =  (i / 3) * 3 + (j / 3);
                    Set<Character> gridSet = gridMap.getOrDefault(gridKey, new HashSet<>());
                    if(!gridSet.add(value)){
                        return false;
                    }
                    gridMap.put(gridKey, gridSet);
                }
            }
        }
        return true;
    }

}
