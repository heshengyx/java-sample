package com.hsheng.core.netty.message;

import com.hsheng.core.netty.message.auth.AuthOperation;
import com.hsheng.core.netty.message.auth.AuthOperationResult;

/**
 * @description 操作枚举
 * @author hesheng
 * @date 2020/4/22 10:32
 * @since TODO
 */
public enum OperationEnum {

    AUTH(0, AuthOperation.class, AuthOperationResult.class),

    ;

    private int code;
    private Class<? extends Operation> operationClazz;
    private Class<? extends OperationResult> operationResultClazz;

    OperationEnum(int code, Class<? extends Operation> operationClazz, Class<? extends OperationResult> operationResultClazz) {
        this.code = code;
        this.operationClazz = operationClazz;
        this.operationResultClazz = operationResultClazz;
    }

    public int getCode() {
        return code;
    }

    public Class<? extends Operation> getOperationClazz() {
        return operationClazz;
    }

    public Class<? extends OperationResult> getOperationResultClazz() {
        return operationResultClazz;
    }

    public static OperationEnum fromOperation(Operation operation) {
        return AUTH;
    }

    public static OperationEnum fromCode(int code) {
        return AUTH;
    }
}
