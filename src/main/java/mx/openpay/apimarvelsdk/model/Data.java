package mx.openpay.apimarvelsdk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class Data {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<Result> results;
}
