package gra.gao.gra.exception;

/**
 * @author:gao
 * @date:2020/3/13
 * @time:23:04
 * @version:0.0.1
 * @description:none
 */

public class DataBaseException extends RuntimeException {

    public DataBaseException(String reason){
        super(reason);
    }
}
