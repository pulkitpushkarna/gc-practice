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



$('.routeName').typeahead({
  source: [
    {"name": "Afghanistan", "code": "AF", "ccn0": "040"},
    {"name": "Land Islands", "code": "AX", "ccn0": "050"},
    {"name": "Albania", "code": "AL","ccn0": "060"},
    {"name": "Algeria", "code": "DZ","ccn0": "070"}
  ]
});

$('.dataTables-example').DataTable({
    pageLength: 25,
    responsive: true,
    dom: '<"html5buttons"B>lTfgitp',
    buttons: []

});