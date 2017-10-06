function makePostCall(url, data, successHandler, failureHandler) {
    makeAjaxCall(url, 'POST', data, successHandler, failureHandler);
}

function makePutCall(url, data, successHandler, failureHandler) {
    makeAjaxCall(url, 'PUT', data, successHandler, failureHandler);
}

function makeGetCall(url, successHandler, failureHandler) {
    makeAjaxCall(url, 'GET', {}, successHandler, failureHandler);
}

function makeAjaxCall(url, method, data, successHandler, failureHandler){
    jQuery.ajax({
        url: url,
        data: data,
        type: method,
        success: successHandler,
        failure: failureHandler
    });
}
