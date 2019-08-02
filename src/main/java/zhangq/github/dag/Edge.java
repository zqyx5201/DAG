package zhangq.github.dag;


import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * @author zhangqiuyang
 * <p>
 * 边
 * Created on 2019/7/31.
 */
public class Edge {
    @Getter
    private EndPoint start;
    @Getter
    private EndPoint end;

    /**
     * 构造函数
     *
     * @param start
     * @param end
     */
    public Edge(EndPoint start, EndPoint end) {
        this.start = start;
        this.end = end;
    }

    /* 重写equals方法 */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Edge) {
            Edge target = (Edge) o;
            return this.start.equals(target.getStart()) && this.end.equals(target.getEnd());
        }
        return false;
    }

    /* 重写hashCode方法 */
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    /* 重写toString方法 */
    @Override
    public String toString() {
        return this.start.getName() + "->" + this.end.getName();
    }

    /**
     * 获取路径
     *
     * @return
     */
    public List<StringBuilder> getPath() {
        StringBuilder sb = new StringBuilder("->" + this.end.getName());
        List<StringBuilder> result = new ArrayList<>();
        if (!this.end.getEdgeList().isEmpty()) {
            result = this.getEnd().getPath(new StringBuilder(sb.toString()));
        } else {
            result.add(sb);
        }
        return result;
    }
}
