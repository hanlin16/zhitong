package com.etai.yto.page;

import java.io.Serializable;

/**
 * RPC Reslut
 * @param <T>
 */
public class RemoteResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
     * 真实结果
     */
    private T data;
    /**
     * 请求成功为true，异常为false
     */
    private boolean success = false;
    /**
     * 异常编码
     */
    private String errorCode ="";
    /**
     * 异常信息
     */
    private String errorMsg ="";

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RemoteResult<?> that = (RemoteResult<?>) o;

        if (success != that.success) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (errorCode != null ? !errorCode.equals(that.errorCode) : that.errorCode != null) return false;
        return errorMsg != null ? errorMsg.equals(that.errorMsg) : that.errorMsg == null;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (success ? 1 : 0);
        result = 31 * result + (errorCode != null ? errorCode.hashCode() : 0);
        result = 31 * result + (errorMsg != null ? errorMsg.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RemoteResult{" +
                "data=" + data +
                ", success=" + success +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
