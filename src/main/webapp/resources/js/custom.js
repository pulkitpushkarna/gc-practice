$('.input-group.date.pickup').datepicker({
  todayHighlight: true,
  autoclose:true,
  startDate: new Date()
});

$('.reportStartDate').datepicker({
  todayHighlight: true,
  autoclose:true
});

$('.reportEndDate').datepicker({
  todayHighlight: true,
  autoclose:true
});

$('.clockpicker').clockpicker({
  placement: 'bottom',
  align: 'left',
  autoclose: true,
  'default': 'now'
});

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