$(document).ready(function() 
{
    var table = $('#dataTable').DataTable();
 
    $('#dataTable tbody').on( 'click', 'tr', function () 
    {
    	if ( $(this).hasClass('selected') ) 
    	{
            $(this).removeClass('selected');
            $('#btnStore').attr("disabled", true);
        }
        else 
        {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
            var data = $(this).data ();
            var rowData = table.fnGetData (this);
            $('#selctedRows').val(rowData);
            $('#btnStore').attr("disabled", false);
        }
    });
 
} );