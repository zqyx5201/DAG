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


        /* 第一条线: a->b->d->f*/
        a.connect(b).connect(d).connect(f);
        /* 第二条线: a->c->f*/
        a.connect(c).connect(f);
        /* 第三条线: a->b->e->f*/
        a.connect(b).connect(e).connect(f);
        /* 第四条线: a->b->c->d->f*/
        a.connect(b).connect(c).connect(d).connect(f);

        //把所有线条都打印出来
        a.getLines().forEach(Line::print);

        /**
         * 输出结果为：
         * a->b->d->f
         * a->b->e->f
         * a->b->c->f
         * a->b->c->d->f
         * a->c->f
         * a->c->d->f
         */
    }
}
