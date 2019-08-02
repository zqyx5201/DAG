package zhangq.github.dag;


import lombok.AllArgsConstructor;

/**
 * @author zhangqiuyang
 * <p>
 * DAG线结果
 * Created on 2019/7/31.
 */
@AllArgsConstructor
public class Line {
    private String path;

    /**
     * 输出
     */
    public void print() {
        System.out.println(path);
    }
}
