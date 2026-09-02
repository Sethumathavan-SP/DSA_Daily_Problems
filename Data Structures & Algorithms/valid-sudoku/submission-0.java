class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] marker = new int[9];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '.') continue;
                int num = board[r][c] - '0';
                int bx = (r / 3) * 3 + c/3;
                if ((marker[r] & (1 << num)) > 0
                || (marker[c] & (1 << (num + 9))) > 0
                || (marker[bx] & (1 << (num + 18))) > 0) {
                    return false;
                }
                
                System.out.println(bx);
                marker[r] = marker[r] | (1 << num);
                marker[c] = marker[c] | (1 << (num + 9));
                marker[bx] = marker[bx] | (1 << (num + 18));
            }
        }   

        return true;
    }
}
