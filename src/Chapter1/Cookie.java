package Chapter1;

/**
 * Created by shuoshu on 2018/1/1.
 */
public class Cookie {
    public static void main(String[] args) {
        Cookie solution = new Cookie();
        int[] p_CakeArray = {3, 2, 1, 6, 5, 4, 9, 8, 7, 0};
        int p_nCake = p_CakeArray.length;
        solution.run(p_CakeArray, p_nCake);
    }

    int m_nCake = 0; //烙饼的个数
    int[] m_CakeArray; //烙饼的初始数组
    int[] m_ReverseCakeArray; //排序的中间结果
    int[] m_ReverseCakeArrayIndex; //交换过程记录
    int[] m_SwapIndex; //最终交换记录
    int m_nMaxSwap = 0, m_nMinSwap = 0; //翻转的上下界


    public void run(int[] p_CakeArray, int p_nCake) {
        init(p_CakeArray, p_nCake);
        sortCake(0);

        for (int i = 0; i < m_nMaxSwap; i++) {
            System.out.print(m_SwapIndex[i] + " ");
        }
    }

    /**
     * 搜索排序
     * @param step
     */
    private void sortCake(int step) {
        m_nMinSwap = getMinSwap(m_ReverseCakeArray);
        if (step + m_nMinSwap > m_nMaxSwap) {
            return;
        }

        if (isSorted(m_ReverseCakeArray)) {
            if (step < m_nMaxSwap) {
                m_nMaxSwap = step;
                for (int i = 0; i < m_nMaxSwap; i++) {
                    m_SwapIndex[i] = m_ReverseCakeArrayIndex[i];
                }
            }
            return;
        }

        for (int i = 1; i < m_nCake; i++) {
            reverse(0, i);
            m_ReverseCakeArrayIndex[step] = i;
            sortCake(step + 1);
            reverse(0, i);
        }
    }

    /**
     * 计算最少的交换次数
     * @param m_reverseCakeArray
     * @return
     */
    private int getMinSwap(int[] m_reverseCakeArray) {
        int steps = 0;

        for (int i = 1; i < m_nCake; i++) {
            if (Math.abs(m_reverseCakeArray[i] - m_reverseCakeArray[i - 1]) > 1) {
                steps++;
            }
         }
        return steps;
    }

    /**
     * 翻转烙饼信息
     * @param i
     * @param j
     */
    private void reverse(int i, int j) {
        while (i < j) {
            int temp = m_ReverseCakeArray[i];
            m_ReverseCakeArray[i] = m_ReverseCakeArray[j];
            m_ReverseCakeArray[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * 判断是否已排好序
     * @param m_reverseCakeArray
     * @return
     */
    private boolean isSorted(int[] m_reverseCakeArray) {
        for (int i = 1; i < m_nCake; i++) {
            if (m_reverseCakeArray[i] < m_reverseCakeArray[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 初始化数组信息
     * @param p_cakeArray
     * @param p_nCake
     */
    private void init(int[] p_cakeArray, int p_nCake) {
        //初始化烙饼数组信息
        m_nCake = p_nCake;
        m_CakeArray = new int[m_nCake];
        m_ReverseCakeArray = new int[m_nCake];
        for (int i = 0; i < p_nCake; i++) {
            m_CakeArray[i] = p_cakeArray[i];
            m_ReverseCakeArray[i] = p_cakeArray[i];
        }

        m_nMaxSwap = 2 * (m_nCake - 1);
        m_nMinSwap = 0;

        m_ReverseCakeArrayIndex = new int[m_nMaxSwap + 1];
        m_SwapIndex = new int[m_nMaxSwap + 1];
    }
}
