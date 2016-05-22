/**
 * Created by Анатолий on 12.05.2016.
 */
$(document).ready(function(){


    $("#userstable").DataTable({
        "ajax":{
            "url":ajaxAdminUrl+"users",
            "dataSrc":""
        },
        "columns":[
            {"data":"id"},
            {"data":"name"},
            {"data":"email"},
            {"data":"password"},
            {"data":"registered",
             "render": function(data){
                    return new Date(data)
                }
            },
            {
                "orderable":false,
                "defaultContent":"",
                "render":renderEditBtn
            },
            {
                "orderable":false,
                "defaultContent":"",
                "render":renderDeleteBtn
            }
        ]
        ,
        "initComplete": function(){makeEditable("users")}
    })
});