package zhangq.github.dag;

/**
 * 入口
 */
public class DagApplication {

    public static void main(String[] args) {
        EndPoint a = new EndPoint("a");
        EndPoint b = new EndPoint("b");
        EndPoint c = new EndPoint("c");
        EndPoint d = new EndPoint("d");
        EndPoint e = new EndPoint("e");
        EndPoint f = new EndPoint("f");


        a.connect(b).connect(d).connect(f);
        a.connect(c).connect(f);
        a.connect(b).connect(e).connect(f);
        a.connect(b).connect(c).connect(d).connect(f);

        b.connect(f);
        c.connect(e).connect(f);

        //把所有线条都打印出来
        a.getLines().forEach(Line::print);

        /**
         * 输出结果为：
         * a->b->d->f
         * a->b->e->f
         * a->b->c->f
         * a->b->c->d->f
         * a->b->c->e->f
         * a->b->f
         * a->c->f
         * a->c->d->f
         * a->c->e->f
         */
    }
}
