package LeetCode.A501v2000.A638ShoppingOffers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        //统计不使用大礼包的总价
        int noSpecial = 0;
        for (int i = 0; i < needs.size(); i++) {
            noSpecial += price.get(i) * needs.get(i);
        }
        int res = noSpecial;
        //遍历每一个大礼包
        for (List<Integer> sp : special) {
            //当前大礼包超过购买数量，跳过
            if (check(sp, needs)) {
                //使用当前大礼包后，还有多少剩下的
                List<Integer> newNeeds = new ArrayList<>();
                for (Integer i = 0; i < sp.size() - 1; i++) {
                    newNeeds.add(needs.get(i) - sp.get(i));
                }
                //剩下的购买数量递归调用本方法，获取最低价格
                int left = shoppingOffers(price, special, newNeeds);
                //使用当前大礼包和不使用相比，选价格最低的
                res = Math.min(res, left + sp.get(sp.size() - 1));
            }
        }
        return res;
    }

    private boolean check(List<Integer> special, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (special.get(i) > needs.get(i)) {
                return false;
            }
        }
        return true;
    }
}