package 每日一题;

import java.util.HashMap;
import java.util.Set;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1797.java
 * @createTime 2023年02月09日 11:34:00
 */
public class L1797 {
    public static void main(String[] args) {
        AuthenticationManager a = new AuthenticationManager(5);
        a.renew("aaa", 1);
        a.generate("aaa", 2);
        System.out.println(a.countUnexpiredTokens(6));
        a.generate("bbb", 7);
        a.renew("aaa", 8);
        a.renew("bbb", 10);
        System.out.println(a.countUnexpiredTokens(15));
    }
}

class AuthenticationManager {

    private static int timeToLive;
    private HashMap<String, Integer> authMap;

    public AuthenticationManager(int timeToLive) {
        AuthenticationManager.timeToLive = timeToLive;
        this.authMap = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        authMap.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (authMap.containsKey(tokenId)) {
            if (currentTime - authMap.get(tokenId) < timeToLive) {
                authMap.put(tokenId, currentTime);
            } else {
                authMap.remove(tokenId);
            }

        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int result = 0;
        Set<String> keys = authMap.keySet();
        for (String s : keys) {
            if (currentTime - authMap.get(s) < timeToLive) {
                result++;
            }
        }
        return result;
    }
}