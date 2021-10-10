package com.qm.cleanmodule.base.network

import com.qm.cleanmodule.base.network.Status.*

//MARK:- HandleResponseData@Docs
data class HandleResponseData<out T>(
    val status: Status = SUCCESS,
    val data: T? = null,
    val message: String? = null,
    val throwable: Throwable? = null,
) {
    companion object {
        fun <T> success(data: T? = null, msg: String? = null): HandleResponseData<T> {
            return HandleResponseData(SUCCESS, data, message = msg)
        }

        fun <T> error(
            msg: String?,
            throwable: Throwable? = null,
            data: T? = null
        ): HandleResponseData<T> {
            return HandleResponseData(MESSAGE, data, msg, throwable)
        }

        fun <T> loading(): HandleResponseData<T> {
            return HandleResponseData(LOADING)
        }
    }
}

enum class Status {
    SUCCESS,
    MESSAGE,
    LOADING
}