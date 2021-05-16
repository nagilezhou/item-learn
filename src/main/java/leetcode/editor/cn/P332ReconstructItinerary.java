//You are given a list of airline tickets where tickets[i] = [fromi, toi] repres
//ent the departure and the arrival airports of one flight. Reconstruct the itiner
//ary in order and return it.
//
// All of the tickets belong to a man who departs from "JFK", thus, the itinerar
//y must begin with "JFK". If there are multiple valid itineraries, you should ret
//urn the itinerary that has the smallest lexical order when read as a single stri
//ng.
//
//
// For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["
//JFK", "LGB"].
//
//
// You may assume all tickets form at least one valid itinerary. You must use al
//l the tickets once and only once.
//
//
// Example 1:
//
//
//Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//Output: ["JFK","MUC","LHR","SFO","SJC"]
//
//
// Example 2:
//
//
//Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["AT
//L","SFO"]]
//Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL"
//,"SFO"] but it is larger in lexical order.
//
//
//
// Constraints:
//
//
// 1 <= tickets.length <= 300
// tickets[i].length == 2
// fromi.length == 3
// toi.length == 3
// fromi and toi consist of uppercase English letters.
// fromi != toi
//
// Related Topics 深度优先搜索 图
// 👍 403 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

//Java：Reconstruct Itinerary
public class P332ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new P332ReconstructItinerary().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        // Hierholzer 算法 欧路回路
        Map<String, PriorityQueue<String>> ticketMap = new HashMap<>();
        List<String> itinerary = new LinkedList<>();

        public List<String> findItinerary2(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                String src = ticket.get(0);
                String dst = ticket.get(1);
                if (!ticketMap.containsKey(src)) {
                    ticketMap.put(src, new PriorityQueue<>());
                }
                ticketMap.get(src).offer(dst);
            }
            dfs("JFK");
            Collections.reverse(itinerary);
            return itinerary;
        }

        public void dfs(String curr){
            while (ticketMap.containsKey(curr) && ticketMap.get(curr).size() > 0){
                String tmp = ticketMap.get(curr).poll();
                dfs(tmp);
            }
            itinerary.add(curr);
        }

        // 回溯算法
        private Deque<String> res;

        // <出发点 -> <达到点 -> 机票数量>>
        private Map<String, Map<String, Integer>> map;
        public List<String> findItinerary(List<List<String>> tickets) {
            map = new HashMap<>();
            res = new LinkedList<>();
            for(List<String> t : tickets){
                Map<String, Integer> temp;
                if(map.containsKey(t.get(0))){
                    temp = map.get(t.get(0));
                    temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
                }else{
                    temp = new TreeMap<>();//升序Map
                    temp.put(t.get(1), 1);
                }
                map.put(t.get(0), temp);

            }
            res.add("JFK");
            backTracking(tickets.size());
            return new ArrayList<>(res);
        }

        private boolean backTracking(int ticketNum){
            if(res.size() == ticketNum + 1){
                return true;
            }
            String last = res.getLast();
            if(map.containsKey(last)){//防止出现null
                for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                    int count = target.getValue();
                    if(count > 0){
                        res.add(target.getKey());
                        target.setValue(count - 1);
                        if(backTracking(ticketNum)) {
                            return true;
                        }
                        res.removeLast();
                        target.setValue(count);
                    }
                }
            }
            return false;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



