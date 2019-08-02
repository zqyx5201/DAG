package zhangq.github.dag;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

/**
 * @author zhangqiuyang
 * <p>
 * 节点
 * Created on 2019/7/31.
 */
public class EndPoint {
    @Getter
    private String name;//节点名
    @Getter
    private List<Edge> edgeList;//连接节点的边列表

    /**
     * 构造函数
     *
     * @param name
     */
    public EndPoint(String name) {
        this.name = name;
        this.edgeList = new ArrayList<>();
    }

    /**
     * 连接下一个点
     *
     * @param next
     * @return
     */
    public EndPoint connect(EndPoint next) {
        Edge edge = new Edge(this, next);
        if (!edgeList.contains(edge)) {
            edgeList.add(edge);
        }
        return edge.getEnd();
    }

    /* 重写equals方法 */
    @Override
    public boolean equals(Object o) {
        if (o instanceof EndPoint) {
            EndPoint target = (EndPoint) o;
            return this.getName().equals(target.getName());
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
        return name;
    }

    /**
     * 获取所有的线
     *
     * @return
     */
    public List<Line> getLines() {
        StringBuilder sb = new StringBuilder(name);
        return getPath(sb).stream().map(s -> new Line(s.toString())).collect(Collectors.toList());
    }

    /**
     * 获取路径
     *
     * @param sb
     * @return
     */
    public List<StringBuilder> getPath(StringBuilder sb) {
        return edgeList.stream()
                .flatMap(edge -> edge.getPath().stream())
                .map(path -> new StringBuilder(sb.toString()).append(path.toString()))
                .collect(Collectors.toList());
    }
}
