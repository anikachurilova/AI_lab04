import java.util.Objects;

public class Pair<T,S>{
    private T f;
    private S s;

    public  Pair( T f, S s ) {
        this.f = f;
        this.s = s;
    }


    public T getF() {
        return f;
    }

    public void setF(T f) {
        this.f = f;
    }

    public S getS() {
        return s;
    }

    public void setS(S s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "f=" + f +
                ", s=" + s +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(f, pair.f) &&
                Objects.equals(s, pair.s);
    }

}