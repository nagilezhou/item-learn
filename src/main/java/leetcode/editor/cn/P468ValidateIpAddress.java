//Given a string IP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP i
//s a valid IPv6 address or "Neither" if IP is not a correct IP of any type.
//
// A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255
//and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0
//" are valid IPv4 addresses but "192.168.01.1", while "192.168.1.00" and "192.168
//@1.1" are invalid IPv4 addresses.
//
// A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:
//
//
// 1 <= xi.length <= 4
// xi is a hexadecimal string which may contain digits, lower-case English lette
//r ('a' to 'f') and upper-case English letters ('A' to 'F').
// Leading zeros are allowed in xi.
//
//
// For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0
//:8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334
//" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.
//
//
// Example 1:
//
//
//Input: IP = "172.16.254.1"
//Output: "IPv4"
//Explanation: This is a valid IPv4 address, return "IPv4".
//
//
// Example 2:
//
//
//Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
//Output: "IPv6"
//Explanation: This is a valid IPv6 address, return "IPv6".
//
//
// Example 3:
//
//
//Input: IP = "256.256.256.256"
//Output: "Neither"
//Explanation: This is neither a IPv4 address nor a IPv6 address.
//
//
// Example 4:
//
//
//Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:"
//Output: "Neither"
//
//
// Example 5:
//
//
//Input: IP = "1e1.4.5.6"
//Output: "Neither"
//
//
//
// Constraints:
//
//
// IP consists only of English letters, digits and the characters '.' and ':'.
//
// Related Topics 字符串
// 👍 92 👎 0

package leetcode.editor.cn;

//Java：Validate IP Address 字符串
// 2021-08-21 review 1
public class P468ValidateIpAddress {
    public static void main(String[] args) {
        Solution solution = new P468ValidateIpAddress().new Solution();
        System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String validIPAddress(String IP) {
            if(IP.endsWith(".") || IP.endsWith(":")) {
                return "Neither";
            }
            if(isIPV4(IP.split("\\."))){
                return "IPv4";
            }
            if(isIPV6(IP.split(":"))){
                return "IPv6";
            }
            return "Neither";
        }

        private boolean isIPV6(String[] ips) {
            if (ips.length != 8) {
                return false;
            }
            for (String ip : ips) {
                if (ip.length() > 4 || ip.length() == 0) {
                    return false;
                }

                for (int i = 0; i < ip.length(); i++) {
                    char c = ip.charAt(i);
                    if(!isSixteenNumber(c)){
                        return false;
                    }

                }
            }
            return true;
        }

        private boolean isIPV4(String[] ips) {
            if (ips.length != 4) {
                return false;
            }
            for (String ip : ips) {
                if (ip.length() > 3 || ip.length() == 0) {
                    return false;
                }
                if (ip.length() > 1 && ip.charAt(0) == '0') {
                    return false;
                }
                int sum = 0;
                for (int i = 0; i < ip.length(); i++) {
                    char c = ip.charAt(i);
                    if(!isTenNumber(c)){
                        return false;
                    }
                    sum += (c - '0') * Math.pow(10, ip.length() - i - 1);
                }
                if (sum > 255) {
                    return false;
                }

            }
            return true;
        }

        private boolean isTenNumber(char c) {
            return c <= '9' && c >= '0';
        }

        private boolean isSixteenNumber(char c) {
            return isTenNumber(c) || (c <= 'F' && c >= 'A') || (c <= 'f' && c >= 'a');
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



