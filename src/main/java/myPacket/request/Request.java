package myPacket.request;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "one")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String symbol;
    private String result;

    public Request() {}
    public Request(String symbol, String result) {
        this.symbol = symbol;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
