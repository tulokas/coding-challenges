/** 
* a rudimentary implemenation of binary period
**/

public class BinaryPeriod {
    public static void main(String[] args) {
        String s = "abracadabracadabra";
        int sol = solution(s);
        System.out.println("solution: " + sol);
    }
    public static int solution(String s) {
        Character[] d = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        int l = d.length;
        for (int p = 1; p < 1 + l; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok && p != l && p <= l / 2) {
                return p;
            }
        }
        return -1;
    }
}
