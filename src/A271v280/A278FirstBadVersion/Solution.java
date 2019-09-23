package A271v280.A278FirstBadVersion;

//interface VersionControl{
//    boolean isBadVersion(int version);
//}
//
//
//public class Solution extends VersionControl {
//    public int firstBadVersion(int n) {
//        int left = 0;
//        int right = n -1;
//        while (left<right){
//            int mid = (left+right)/2;
//            if (isBadVersion(mid)){
//                left = mid + 1;
//            }else {
//                right = mid;
//            }
//        }
//        return left;
//    }
//
//
//    @Override
//    public boolean isBadVersion(int version) {
//        return true;
//    }
//}