package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1138.java
 * @createTime 2023年02月12日 15:20:00
 */
public class L1138 {
}

class Solution1138 {
    public String alphabetBoardPath(String target) {
        int preRow = 0, preCol = 0;
        StringBuilder result = new StringBuilder("");
        StringBuilder rowStr = new StringBuilder("");
        StringBuilder colStr = new StringBuilder("");
        for (int i = 0; i < target.length(); i++) {
            int curRow = (target.charAt(i) - 'a') / 5;
            int curCol = (target.charAt(i) - 'a') % 5;

            if (curRow < preRow) {
                rowStr.append("U".repeat(preRow - curRow));
            }
            if (curRow > preRow) {
                rowStr.append("D".repeat(curRow - preRow));
            }
            if (curCol < preCol) {
                colStr.append("L".repeat(preCol - curCol));
            }
            if (curCol > preCol) {
                colStr.append("R".repeat(curCol - preCol));
            }

            if (preRow == 5) {
                result.append(rowStr);
                result.append(colStr);
            }else {
                result.append(colStr);
                result.append(rowStr);
            }
            result.append("!");
            rowStr.setLength(0);
            colStr.setLength(0);
            preRow = curRow;
            preCol = curCol;
        }
        return String.valueOf(result);
    }
}