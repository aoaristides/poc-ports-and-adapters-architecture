package br.com.makersweb.hexagonal.architecture.application.core.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author aaristides
 */
@Setter
@Getter
public class PageInfo {

    private int pageNumber;
    private int pageSize;

}
