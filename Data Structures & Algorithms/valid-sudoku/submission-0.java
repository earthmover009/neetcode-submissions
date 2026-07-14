class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board.length != 9 || board[0].length != 9){
            return false;
        }
        Map<Integer,Set<Integer>> rowMap = new HashMap<>();
        Map<Integer,Set<Integer>> columnMap = new HashMap<>();
        Map<Integer,Set<Integer>> gridMap = new HashMap<>();

        for(int i = 0; i < 9; i++){
            for( int j = 0; j < 9; j++ ){
                if( Character.isDigit(board[i][j])){
                    int value = Character.getNumericValue(board[i][j]);
                    Set<Integer> rowSet = rowMap.getOrDefault(i, new HashSet<>());
                    if(!rowSet.add(value)){
                        return false;
                    }
                    rowMap.put(i, rowSet);
                    Set<Integer> columnSet = columnMap.getOrDefault(j, new HashSet<>());
                    if(!columnSet.add(value)){
                        return false;
                    }
                    columnMap.put(j, columnSet);
                    Set<Integer> gridSet = gridMap.getOrDefault(gridKey(i,j), new HashSet<>());
                    if(!gridSet.add(value)){
                        return false;
                    }
                    gridMap.put(gridKey(i,j), gridSet);
                }
            }
        }
        return true;
    }

    private Integer gridKey(int i, int j) {
        int gridKey = 0;
        if(i < 3 && j < 3){
            gridKey = 1;
        } else if(i < 3 && j < 6){
            gridKey = 2;
        } else if( i < 3 && j < 9 ){
            gridKey = 3;
        } else if (i < 6 && j < 3) {
            gridKey = 4;
        } else if (i < 6 && j < 6) {
            gridKey = 5;
        } else if (i < 6 && j < 9) {
            gridKey = 6;
        } else if (i < 9 && j < 3) {
            gridKey = 7;
        } else if (i < 9 && j < 6) {
            gridKey = 8;
        } else if (i < 9 && j < 9) {
            gridKey = 9;
        }
        return gridKey;
    }
}
