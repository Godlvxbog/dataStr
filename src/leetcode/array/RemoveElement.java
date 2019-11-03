package leetcode.array;


/**
 * 1、move zeros：移除数组中为0的元素:: 283  https://leetcode-cn.com/problems/move-zeroes/
 * 2、移除数组中重复元素，保留重复元素一个：：26，  https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 3、移除数组中重复元素，不保留重复元素
 * 4、移除数组中重复元素，保留重复元素最多两个 ：：80  https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * 5、移除val=target的元素：：27  https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElement {


    public static void main(String[] args) {
        int[] nums = new int[]{
                1
        };

//        removeZeros3(nums);
//        int res =  removeElement2(nums,2);
        int res = removeDuplicate31(nums);
        System.out.println(res);


    }


    /**
     * 使用辅助空间记录非零的数字的数组：nonzeros  []
     * 空间复杂度为 O(N)
     * 如果想要替换和这个O（N），那么需要在原来的数组中 用k [0,k）表示这些已经是done掉的。(i,length)是未处理的。
     *
     * @param nums
     */
    public static void removeZeros(int[] nums) {
        int[] nonzeros = new int[nums.length];
        int k = 0;//记录非零数组的index

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonzeros[k++] = nums[i];
            }
        }

        //复制值到原始数组中
        for (int i = 0; i < nonzeros.length; i++) {
            nums[i] = nonzeros[i];
        }

        //复制0元素到元素数组中 i [nonzeros.length,nums.length）
        for (int i = nonzeros.length; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 如果想要替换和这个O（N），那么需要在原来的数组中 用k [0,k）表示这些已经是done掉的。(i,length)是未处理的。
     * 定义[0,k)为已经处理了的，初始化k=0，也就是说 [0,0)没有元素是已经处理了的。
     * nums[i] == 0 ,当前值为 0
     *
     * @param nums
     */
    public static void removeZeros2(int[] nums) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, k, i);
                k++;
            }
        }

    }

    /**
     * 如果说大部分元素都是非零元素，为了防止原地交换因此做减支处理
     *
     * @param nums
     */
    public static void removeZeros3(int[] nums) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (k != i) {
                    swap(nums, k, i);
                    k++;
                } else {
                    k++;
                }

            }
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * 和removezeros类似，用k去记录已经处理了的元素[0,k)表示已经对非target元素进行了保留
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int k = 0;//记录已经done的数据

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                swap(nums, k, i);
                k++;
            }
        }

        return k;

    }

    /**
     * 不用交换，直接赋值:删除=其实就是赋值、就是覆盖、就是交换
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        int k = 0;//记录已经done的数据

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;

    }


    /**
     * 删除有序数组的重复元素，最多保留一个
     * 这里使用了一个O（N）的空间
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int k = 0;
        int[] nonDup = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nonDup[k++] = nums[i];
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        for (int i = 0; i < k; i++) {
            nums[i] = nonDup[i];
        }

        return k;
    }

    public static int removeDuplicate2(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[k++] = nums[i];
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return k;
    }

    /**
     * 双指针发
     *
     * @param nums
     * @return
     */
    public static int removeDuplicate3(int[] nums) {
        int k = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                k++;
                nums[k] = nums[i];
            }
        }

        return k + 1;
    }


    public static int removeDuplicate20(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[k++] = nums[i];
            while (i < nums.length - 2 && nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
                i++;
            }
        }
        return k;
    }

    /**
     * 有点难以理解
     *
     * @param nums
     * @return
     */
    public static int removeDuplicate21(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
//            nums[i] > nums[k-2],在有序数组中可以通过>表示不同。i 元素 一定不能与k-2相等，相等则表示已经重复了。
            if (k < 2 || nums[i] > nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }

    /**
     * 不保留元素：最简单的就是用一个map去保留个数，统计每个数字的个数，如果不为1，就执行删除。
     * 但是这个有O(N),需要不用空间，此题还未做出来。？？
     *
     * @param nums
     * @return
     */
    public static int removeDuplicate31(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[k]){
                while (i < nums.length-1 && nums[i] == nums[i+1]){
                    i++;
                }
                k++;
                nums[k] = nums[i];
            }

        }
        return k;
    }


}
