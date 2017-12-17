package net.runningcoder.domain;

import lombok.Data;

import java.util.List;

/**
 * Created by machine on 2017/12/17.
 */
@Data
public class User {
    private Long id;
    private String name;

    private List<String> others;
}
